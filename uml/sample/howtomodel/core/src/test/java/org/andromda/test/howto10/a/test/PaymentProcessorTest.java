// license-header java merge-point
//
// Generated by: MessageDrivenTest.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto10.a.test;

import org.andromda.test.test.EJB3Container;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

/**
 * Message Driven test class PaymentProcessorTest for testing with TestNG
 * Check the testng.xml for initialisation of the EJB3Container before running any tests.
 */
public class PaymentProcessorTest
{
    private static final Log logger = LogFactory.getLog(PaymentProcessorTest.class);

    @Test
    public void testPaymentProcessor()
    {
        //        try
        //        {
        //              javax.jms.QueueConnection cnn = null;
        //              javax.jms.QueueSender sender = null;
        //              javax.jms.QueueSession session = null;
        //
        //              javax.jms.Queue queue = (javax.jms.Queue)EJB3Container.getInitialContext().lookup("queue/howtomodel/howto10a");
        //              javax.jms.QueueConnectionFactory factory = (javax.jms.QueueConnectionFactory)EJB3Container.getInitialContext().lookup("java:/ConnectionFactory");
        //              cnn = factory.createQueueConnection();
        //              session = cnn.createQueueSession(false, javax.jms.QueueSession.AUTO_ACKNOWLEDGE);
        //
        //              javax.jms.TextMessage msg = session.createTextMessage("Test Message");
        //
        //              sender = session.createSender(queue);
        //              sender.send(msg);
        //
        //              Thread.sleep(1000);
        //              session.close();
        //              cnn.close();
        //        }
        //        catch (Exception ex)
        //        {
        //            logger.warn("Failed test PaymentProcessorTest", ex);
        //        }
    }
}
