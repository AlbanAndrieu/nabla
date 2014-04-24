package com.nabla.project.application.model.message;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.nabla.project.application.api.RequestStatus;
import com.nabla.project.application.api.UnsupportedRecoveryException;
import com.nabla.project.application.api.config.Destination;
import com.nabla.project.application.api.config.Format;
import com.nabla.project.application.api.config.Packaging;
import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.api.extractor.ExtractorThreadInterface;
import com.nabla.project.application.api.helpers.Pipe;
import com.nabla.project.application.api.helpers.PipePublisher;
import com.nabla.project.application.api.transformer.TransformerThreadInterface;
import com.nabla.project.application.api.writer.WriterThreadInterface;
import com.nabla.project.application.core.flow.NablaExtractServiceMBean;
import com.nabla.project.application.core.flow.service.ExtractServiceCommon;
import com.nabla.project.application.core.pipe.PipeBlockingQueueListener;
import com.nabla.project.application.core.pipe.PipeBlockingQueuePublisher;
import com.nabla.project.application.core.pipe.PipeBlockingQueueService;
import com.nabla.project.application.core.spring.MessageConfig;
import com.nabla.project.application.core.time.Chronometer;
import com.nabla.project.application.model.message.writer.FileDestination;

/**
 * Author : $author$ Date : $Date: 2010-06-19 17:32:20 +0200 (Tue, 19 Jun 2010) $ Revision : $Revision: 618 $
 */
public class PositionExtractServiceJaxb extends ExtractServiceCommon implements NablaExtractServiceMBean
{
    protected Logger logger = Logger.getLogger(getClass());

    public void extractPerimeter(final Perimeter perimeter, final RequestId id, final Destination output, final Destination status, final Format format, final Packaging packaging)
    {
        // identifier of the current extract
        logger.info("Extract starting");

        Chronometer chronometer = new Chronometer();
        chronometer.start();

        // Copy ids to spring object
        this.requestId.setId(id.getId());

        Set<Pipe<Object>> queues = new HashSet<Pipe<Object>>();
        String exceptionQueueName = "ExceptionQueue";

        try
        {
            if ( // Debug
            logger.isDebugEnabled())
            {
                // Debug
                logger.debug("isUsingWriterThread=" + isUsingWriterThread);
            } // end if

            // Initialization
            PipeBlockingQueueService.createPipeBlockingQueue(exceptionQueueName, this.requestId, MessageConfig.getInstance().getQueueSize());

            PipePublisher<Throwable> pipeOutException = new PipeBlockingQueuePublisher<Throwable>(exceptionQueueName, this.requestId);
            extractorsThreads = new ArrayList<Thread>();
            transformersThreads = new ArrayList<Thread>();
            writersThreads = new ArrayList<Thread>();

            // Initialize extractors
            int extractorThreadId = 0;

            for (ExtractorThreadInterface<Object> extractor : extractors)
            {
                // Initialization
                extractor.setId(new Integer(++extractorThreadId));
                extractor.setPerimeter(perimeter);
                extractor.setPipeException(pipeOutException);
                extractor.afterPropertiesSet();

                if (extractor.getPipe() != null)
                {
                    queues.add(extractor.getPipe());
                } // end if

                // Launch extractor
                Thread extractorThread = new Thread(extractor);
                extractorThread.start();

                extractorsThreads.add(extractorThread);
            } // end for

            // Initialize transformers
            // Warning: transformers must be launch after writers ! (func open called before)
            int transformerThreadId = 0;

            for (TransformerThreadInterface<Object, Object> transformer : transformers)
            {
                // Initialization
                transformer.setId(new Integer(++transformerThreadId));
                transformer.setPipeException(pipeOutException);
                transformer.afterPropertiesSet();

                if (transformer.getPipeIn() != null)
                {
                    queues.add(transformer.getPipeIn());
                } // end if

                if (transformer.getPipeOut() != null)
                {
                    queues.add(transformer.getPipeOut());
                } // end if

                // Launch extractor
                Thread transformerThread = new Thread(transformer);

                if ((!isUsingWriterThread) && (transformer.getWriterData() != null))
                {
                    transformer.getWriterData().open(output, packaging);
                } // end if

                transformersThreads.add(transformerThread);

                transformerThread.start();
            } // end for

            // Initialize writers
            if (isUsingWriterThread)
            {
                int writerThreadId = 0;

                for (WriterThreadInterface<Object> writer : writers)
                {
                    // Initialization
                    writer.setId(new Integer(++writerThreadId));
                    writer.setPipeException(pipeOutException);
                    writer.afterPropertiesSet();

                    if (writer.getPipeIn() != null)
                    {
                        queues.add(writer.getPipeIn());
                    } // end if

                    writer.open(output, packaging);

                    // Launch extractor
                    Thread writerThread = new Thread(writer);
                    writerThread.start();

                    writersThreads.add(writerThread);
                } // end for
            } // end if

            /*************** TRADES EXTRACTION **********************/

            // Wait end of extractions
            for (Thread extractorThread : extractorsThreads)
            {
                extractorThread.join();
            } // end for

            // Wait end of transformers
            for (Thread transformerThread : transformersThreads)
            {
                transformerThread.join();
            } // end for

            for (TransformerThreadInterface<Object, Object> transformer : transformers)
            {
                if ((!isUsingWriterThread) && (transformer.getWriterData() != null))
                {
                    transformer.getWriterData().close();
                } // end if
            } // end for

            if (isUsingWriterThread)
            {
                for (Thread writerThread : writersThreads)
                {
                    writerThread.join();
                } // end for
            } // end if

            // End
            logger.info("Extract done");

            pipeOutException.closeQueue();

            // Close writers
            if (isUsingWriterThread)
            {
                for (WriterThreadInterface<Object> writer : writers)
                {
                    writer.close();
                } // end for
            } // end if

            // TODO: Verify exceptions ...
            dumpException(exceptionQueueName, this.requestId);
        } // end try
        catch (Throwable ex)
        {
            logger.error("Exception :" + ex.getMessage());
            ex.printStackTrace();
        } // end catch
        finally
        {
            PipeBlockingQueueService.destroyQueues(queues);
        } // end finally

        chronometer.stop();
        logger.info("Total extract time=" + chronometer);
    } // end extractPerimeter()

    public void dumpException(final String exceptionQueueName, final RequestId requestId)
    {
        new PipeBlockingQueueListener<Throwable>(exceptionQueueName, requestId)
        {
            @Override
            public void onMessage(final Throwable throwable)
            {
                logger.error("Exception: " + throwable.getMessage());

                if (throwable instanceof Exception)
                {
                    ((Exception) throwable).printStackTrace();
                } // end if
            } // end onMessage()
        } // end new
        ;
    } // end dumpException()

    public void recoverRequest(final RequestStatus status)
    {
        throw new UnsupportedRecoveryException();
    } // end recoverRequest()

    public boolean supportsFormat(final Format f)
    {
        return Format.XML.equals(f);
    } // end supportsFormat()

    public boolean supportsOutputDestination(final Destination outputDestination)
    {
        return outputDestination instanceof FileDestination;
    } // end supportsOutputDestination()

    public boolean supportsPackaging(final Packaging p)
    {
        logger.error("supportsPackaging : pass");

        return Packaging.STANDARD.equals(p) || Packaging.COMPRESSED.equals(p);
    } // end supportsPackaging()

    public boolean supportsPerimeter(final Perimeter p)
    {
        return true;
    } // end supportsPerimeter()

    public boolean supportsStatusDestination(final Destination statusDestination)
    {
        return statusDestination instanceof FileDestination;
    } // end supportsStatusDestination()

    public String getExtractServiceId()
    {
        return "PositionExtractService";
    } // end getExtractServiceId()
} // end PositionExtractServiceJaxb
