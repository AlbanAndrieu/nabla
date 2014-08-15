package com.nabla.project.application.core.spring;

/**
 * Author : $author$ Date : $Date: 2010-06-22 14:58:07 +0200 (Fri, 22 Jun 2010) $ Revision : $revision$
 */
public class MessageConfig extends AbstractMessageConfig
{
    public static String beanParametersName                       = "extractService.parameters.data";
    public static String beanPerimeterName                        = "tradePerimeterBean";
    public static String beanDataExtractorTradeName               = "dataExtractorTrade";
    public static String beanDataTransformerTradeEventMessageName = "TradeEventMessageTransformer";
    public static String beanDataTransformerProductMessageName    = "ProductSetMessageTransformer";
    public static String beanDataTransformerTradeName             = "dataTransformerTrade";
    public static String beanDataWriterContainerTradeName         = "dataWriterContainerTrade";
    public static String beanDataWriterContainerProductName       = "dataWriterContainerProduct";
    public static String beanExtractServiceTradeName              = "extractServiceTrade";
    public static String beanComparison                           = "comparison";

    public static String beanConfig                               = "defaultConfigurationMessage";
    /**
     * Class manage by spring
     */
    protected boolean    validationXmlOutput;

    /**
     * Singleton
     */
    private MessageConfig()
    {
        super();
    } // end MessageConfig()

    public static MessageConfig getInstance()
    {
        // defaultConfiguration bean must be declare as a singleton in spring
        return (MessageConfig) ApplicationContextMessageFactory.getInstance().getApplicationContext().getBean(beanConfig);
    } // end getInstance()

    public boolean isValidationXmlOutput()
    {
        return validationXmlOutput;
    } // end isValidationXmlOutput()

    public void setValidationXmlOutput(final boolean validationXmlOutput)
    {
        this.validationXmlOutput = validationXmlOutput;
    } // end setValidationXmlOutput()
} // end MessageConfig
