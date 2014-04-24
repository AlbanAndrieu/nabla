package com.nabla.project.application.model.message.main;

import com.nabla.project.application.api.ExtractService;
import com.nabla.project.application.api.ExtractServiceParameterWrapper;
import com.nabla.project.application.api.config.Condition;
import com.nabla.project.application.api.config.Condition.ConditionId;
import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.config.RequestId;
import com.nabla.project.application.core.configuration.Version;
import com.nabla.project.application.core.log.Log;
import com.nabla.project.application.core.spring.AbstractConfig;
import com.nabla.project.application.core.spring.AbstractMessageConfig;
import com.nabla.project.application.core.spring.ApplicationContextMessageFactory;
import com.nabla.project.application.core.spring.MessageConfig;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;

/**
 * Author : $author$ Date : $Date: 2010-06-22 15:16:14 +0200 (Fri, 22 Jun 2010) $ Revision : $revision$ To unable jmx management, use this VM parameter :
 * -Dcom.sun.management.jmxremote
 */
public class FullExtract
{
    public static Logger             logger       = Logger.getLogger(FullExtract.class);
    public static String             tagDatValMin = "datvalmin";
    public static String             tagDatValMax = "datvalmax";
    public static String             tagMaxRow    = "maxrow";
    public static Version            version;
    public static ApplicationContext applicationContext;

    public static void initialization()
    {
        Log.init();
        applicationContext = ApplicationContextMessageFactory.getInstance().getApplicationContext();
        version = (Version) applicationContext.getBean(AbstractMessageConfig.beanVersion);
    } // end initialization()

    protected static String getHeader()
    {
        return "DESCRIPTION : Allow extraction and transformation of data in an XML file with a gigen XSD schema (XML format)\n" + "\n";
    } // end getHeader()

    protected static String getFooter()
    {
        return "EXEMPLE : FullExtract -" + tagDatValMin + " \"2010-03-15\"\n" + "EXEMPLE : FullExtract -" + tagDatValMin + " \"2010-03-15\" -" + tagDatValMax + " \"2010-03-26\"\n" + "EXEMPLE : FullExtract -"
                + tagDatValMin + " \"2010-03-15\" -" + tagDatValMax + " \"2010-03-26\" -" + tagMaxRow + " \"200\"\n" + "AUTEUR : " + version.getCopyright() + "\n" + "DATE : " + version.getReleaseDateFormated() + "\n";
    } // end getFooter()

    public static void banner(final Options options)
    {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Extractor", getHeader(), options, getFooter());
    } // end banner()

    public static void main(final String[] args) throws Exception
    {
        // Initialization
        initialization();

        // Prepare reading arguments
        Options options = new Options();

        options.addOption(OptionBuilder.withArgName("date").hasArg().withDescription("maximum value date").create(tagDatValMax));
        options.addOption(OptionBuilder.withArgName("date").hasArg().isRequired().withDescription("minimum value date").create(tagDatValMin));
        options.addOption(OptionBuilder.withArgName("maxrow").hasArg().withDescription("maximum rows retreived (unlimited if omitted)").create(tagMaxRow));

        // Parse arguments
        CommandLineParser parser = new GnuParser();
        CommandLine cmd;

        try
        {
            cmd = parser.parse(options, args);
        } // end try
        catch (ParseException ex)
        {
            System.err.println(ex);
            banner(options);

            return;
        } // end catch

        // Read arguments
        Integer maxrow = (cmd.getOptionValue(tagMaxRow) != null) ? new Integer(cmd.getOptionValue(tagMaxRow)) : null;
        String datvalmax = cmd.getOptionValue(tagDatValMax, "2010-03-26");
        String datvalmin = cmd.getOptionValue(tagDatValMin, "2010-03-15");

        logger.info("datvalmin = " + datvalmin);
        logger.info("datvalmax = " + datvalmax);
        logger.info("maxrow = " + maxrow);

        extract(maxrow, datvalmin, datvalmax);

        logger.info("Extract Done");
    } // end main()

    protected static void extract(final Integer maxrow, final String datvalmin, final String datvalmax) throws Exception
    {
        ExtractServiceParameterWrapper parameters = (ExtractServiceParameterWrapper) applicationContext.getBean(MessageConfig.beanParametersName);
        RequestId requestId = (RequestId) applicationContext.getBean(AbstractConfig.beanRequestIdName);

        Perimeter perimeter = parameters.getPerimeter();

        if (maxrow != null)
        {
            perimeter.addCondition(new Condition(ConditionId.MAXROW, maxrow.toString()));
        } // end if

        perimeter.addCondition(new Condition(ConditionId.DATVALMIN, datvalmin));
        perimeter.addCondition(new Condition(ConditionId.DATVALMAX, datvalmax));

        ExtractService extractService = (ExtractService) applicationContext.getBean(MessageConfig.beanExtractServiceTradeName);
        extractService.extractPerimeter(parameters.getPerimeter(), requestId, parameters.getOutput(), parameters.getStatus(), parameters.getFormat(), parameters.getPackaging());
    } // end extract()
} // end FullExtract
