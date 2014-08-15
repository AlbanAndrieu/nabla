// license-header java merge-point
package org.andromda.test.howto10.a;

import javax.jms.Message;

/**
 * @see PaymentProcessorMDBBean
 */
public class PaymentProcessorMDBBeanImpl extends PaymentProcessorMDBBean
{

    // --------- Default Constructor ----------

    public PaymentProcessorMDBBeanImpl()
    {
        super();
    }

    /**
     * MessageListener callback on arrival of a JMS message
     * 
     * @param message The inbound JMS message to process
     */
    public void onMessage(Message message)
    {
        // Implementation
    }

}
