package com.nabla.project.application.model.message.mapping;

import com.nabla.project.application.core.flow.helpers.Stream;
import com.nabla.project.application.model.message.helpers.FileDestinationHelper;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author : $author$ Date : $Date: 2010-06-20 18:06:01 +0200 (Wed, 20 Jun 2010) $ Revision : $revision$
 */
public class XMLComparison implements InitializingBean
{
    private Logger               logger = Logger.getLogger(this.getClass());
    public String                id;
    public FileDestinationHelper fileXMLControlName;
    public FileDestinationHelper fileXMLTestName;
    public String                contentXmlControl;
    public String                contentXmlTest;

    public XMLComparison(String id)
    {
        this.id = id;
        logger.info("XML Comparison started : " + id);
    } // end XMLComparison()

    public String getId()
    {
        return id;
    } // end getId()

    public void setId(final String id)
    {
        this.id = id;
    } // end setId()

    /**
     * @return the fileXMLControlName
     */
    public FileDestinationHelper getFileXMLControlName()
    {
        return fileXMLControlName;
    } // end getFileXMLControlName()

    /**
     * @param fileXMLControlName the fileXMLControlName to set
     */
    public void setFileXMLControlName(final FileDestinationHelper fileXMLControlName)
    {
        this.fileXMLControlName = fileXMLControlName;
    } // end setFileXMLControlName()

    /**
     * @return the fileXMLTestName
     */
    public FileDestinationHelper getFileXMLTestName()
    {
        return fileXMLTestName;
    } // end getFileXMLTestName()

    /**
     * @param fileXMLTestName the fileXMLTestName to set
     */
    public void setFileXMLTestName(final FileDestinationHelper fileXMLTestName)
    {
        this.fileXMLTestName = fileXMLTestName;
    } // end setFileXMLTestName()

    public String getContentXmlControl()
    {
        return contentXmlControl;
    } // end getContentXmlControl()

    public void setContentXmlControl(final String contentXmlControl)
    {
        this.contentXmlControl = contentXmlControl;
    } // end setContentXmlControl()

    public String getContentXmlTest() throws Exception
    {
        InputStream inputStream = fileXMLTestName.getInputStream();
        contentXmlTest = Stream.readStream(inputStream);
        inputStream.close();

        return contentXmlTest;
    } // end getContentXmlTest()

    public void setContentXmlTest(final String contentXmlTest)
    {
        this.contentXmlTest = contentXmlTest;
    } // end setContentXmlTest()

    public void afterPropertiesSet() throws Exception
    {
        InputStream inputStream;

        if (logger.isDebugEnabled())
        {
            logger.debug("afterPropertiesSet");
        } // end if

        // Create control file
        ControlFileGenerator.TradeGenerator(fileXMLControlName.getPath(), id);

        inputStream = fileXMLControlName.getInputStream();
        contentXmlControl = Stream.readStream(inputStream);
        inputStream.close();
    } // end afterPropertiesSet()

    public void close()
    {
        try
        {
            fileXMLControlName.close();
            fileXMLTestName.close();
        } // end try
        catch (IOException e)
        {
            logger.error(e);
            e.printStackTrace();
        } // end catch
    } // end close()
} // end XMLComparison
