package com.nabla.project.application.model.message.main;

import com.nabla.project.application.api.ExtractService;
import com.nabla.project.application.api.ExtractServiceParameterWrapper;
import com.nabla.project.application.api.config.Condition;
import com.nabla.project.application.api.config.Condition.ConditionId;
import com.nabla.project.application.api.config.Perimeter;
import com.nabla.project.application.api.config.RequestId;

import org.apache.log4j.PropertyConfigurator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author : $author$ Date : $Date: 2010-06-14 11:52:07 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 *
 * @deprecated
 */
public class ParallelFullExtract
{
    private ApplicationContext context;

    public static void main(final String[] args)
    {
        PropertyConfigurator.configure("log4j.properties");
        new ParallelFullExtract().run();
    } // end main()

    private void run()
    {
        try
        {
            context = new ClassPathXmlApplicationContext(new String[] { "com/nabla/services/extract/eoleextract/ExtractServiceConfig.xml", "com/nabla/services/extract/eoleextract/ExtractServiceParametersConfig.xml",
                    "com/nabla/services/extract/eoleextract/ExtractServiceParametersConfig2.xml", "com/nabla/services/extract/eoleextract/dbExtractorConfig.xml" });

            Thread extract1 = new Thread()
            {
                @Override
                public void run()
                {
                    ExtractServiceParameterWrapper parameters = (ExtractServiceParameterWrapper) context.getBean("extractService.parameters.trade");

                    Perimeter perimeter = parameters.getPerimeter();
                    perimeter.addCondition(new Condition(ConditionId.MAXROW, "100"));
                    perimeter.addCondition(new Condition(ConditionId.DATVALMIN, "2010-03-15"));
                    perimeter.addCondition(new Condition(ConditionId.DATVALMAX, "2010-03-16"));

                    ExtractService extractService = (ExtractService) context.getBean("extractServiceTrade");
                    extractService.extractPerimeter(parameters.getPerimeter(), new RequestId("001"), parameters.getOutput(), parameters.getStatus(), parameters.getFormat(), parameters.getPackaging());
                } // end run()
            } // end new
            ;

            Thread extract2 = new Thread()
            {
                @Override
                public void run()
                {
                    ExtractServiceParameterWrapper parameters = (ExtractServiceParameterWrapper) context.getBean("extractService.parameters.trade2");

                    Perimeter perimeter = parameters.getPerimeter();
                    perimeter.addCondition(new Condition(ConditionId.MAXROW, "100"));
                    perimeter.addCondition(new Condition(ConditionId.DATVALMIN, "2010-03-15"));
                    perimeter.addCondition(new Condition(ConditionId.DATVALMAX, "2010-03-16"));

                    ExtractService extractService = (ExtractService) context.getBean("extractServiceTrade");
                    extractService.extractPerimeter(parameters.getPerimeter(), new RequestId("002"), parameters.getOutput(), parameters.getStatus(), parameters.getFormat(), parameters.getPackaging());
                } // end run()
            } // end new
            ;

            extract1.start();
            extract2.start();

            extract1.join();
            extract2.join();
        } // end try
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        } // end catch
    } // end run()
} // end ParallelFullExtract
