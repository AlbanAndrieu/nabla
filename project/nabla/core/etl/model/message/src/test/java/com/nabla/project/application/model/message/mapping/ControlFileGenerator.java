package com.nabla.project.application.model.message.mapping;

import com.nabla.project.application.core.time.Chronometer;
import com.nabla.project.application.model.message.domain.XMLTradeTest;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Author : $author$ Date : $Date: 2010-06-20 16:39:25 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$
 */
public class ControlFileGenerator
{
    private static Logger    logger  = Logger.getLogger(ControlFileGenerator.class);

    /* Output data file size in Mo */
    private static final int nbTrade = 1;

    public static void TradeGenerator(final String fileName, final String id) throws Exception
    {
        assert (fileName != null);

        if ( // Debug
        logger.isDebugEnabled())
        {
            // Debug
            logger.debug("TradeGenerator(" + fileName + ")");
        } // end if

        Chronometer chronometer = new Chronometer();
        chronometer.start();

        int count = 0;

        File f = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        Exception exception = null;

        try
        {
            f = new File(fileName);
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            fw.write(XMLTradeTest.xmlFragHeader);

            while (count < nbTrade)
            {
                fw.write(XMLTradeTest.getXMLTradeBody(id, true, true));
                count++;
            } // end while

            fw.write(XMLTradeTest.xmlFragFooter);
        } // end try
        catch (IOException ex)
        {
            logger.error(ex);
            exception = ex;
        } // end catch
        finally
        {
            if (bw != null)
            {
                try
                {
                    bw.close();
                } // end try
                finally
                {
                } // end finally
            } // end if

            ;

            if (fw != null)
            {
                try
                {
                    fw.close();
                } // end try
                finally
                {
                } // end finally
            } // end if

            ;
        } // end finally

        if (exception != null)
        {
            throw exception;
        } // end if

        logger.info(" Trade " + id + " extracted = " + count);

        chronometer.stop();
        logger.info("Total Time = " + chronometer);
    } // end TradeGenerator()
} // end ControlFileGenerator
