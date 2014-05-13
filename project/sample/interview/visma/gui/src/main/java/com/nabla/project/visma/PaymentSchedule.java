package com.nabla.project.visma;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

import org.apache.log4j.Logger;

public class PaymentSchedule implements Serializable
{

    private static final long             serialVersionUID  = 1L;

    private static final transient Logger LOGGER            = Logger.getLogger(PaymentSchedule.class);

    private DataModel<Payment>            paymentsDataModel = null;

    @SuppressWarnings("unused")
    private PaymentSchedule(final DataModel<Payment> paymentsDataModel)
    {
        super();
        this.paymentsDataModel = paymentsDataModel;

        if (null == this.paymentsDataModel)
        {
            throw new IllegalArgumentException("Payments data model cannot be null");
        }
    }

    public PaymentSchedule(final Map<Integer, List<BigDecimal>> aPayments)
    {
        super();
        this.setPayments(aPayments);
    }

    public PaymentSchedule(final Payment[] aPayments)
    {
        super();
        this.setPayments(aPayments);
    }

    private void setPayments(final Payment[] aPayments)
    {
        this.paymentsDataModel = new ArrayDataModel<Payment>(aPayments);

        if ((null == this.paymentsDataModel) || (this.paymentsDataModel.getRowCount() <= 0))
        {
            throw new IllegalArgumentException("Schedule cannot be null");
        }

    }

    private void setPayments(final Map<Integer, List<BigDecimal>> aPayments)
    {

        if (null == aPayments)
        {
            throw new IllegalArgumentException("Payments schedule cannot be null");
        }

        final Payment[] targetPayments = new Payment[aPayments.size()];

        aPayments.size();
        final Iterator<Entry<Integer, List<BigDecimal>>> it = aPayments.entrySet().iterator();
        while (it.hasNext())
        {
            final Entry<Integer, List<BigDecimal>> pairs = it.next();
            final Integer month = pairs.getKey();

            if (PaymentSchedule.LOGGER.isDebugEnabled())
            {
                PaymentSchedule.LOGGER.debug("Data is : " + month + " = " + pairs.getValue());
            }
            final List<BigDecimal> data = pairs.getValue();

            if (PaymentSchedule.LOGGER.isDebugEnabled())
            {
                PaymentSchedule.LOGGER.debug("Data size : " + data.size());
            }

            for (final BigDecimal bigDecimal : data)
            {
                final BigDecimal amount = bigDecimal;
                final Payment payment = new Payment(amount);
                targetPayments[month] = payment;
            }

            it.remove(); // avoids a ConcurrentModificationException
        }

        this.setPayments(targetPayments);
    }

    public DataModel<Payment> getPayments()
    {
        return this.paymentsDataModel;
    }

    public int getRowIndex()
    {
        return this.paymentsDataModel.getRowIndex();
    }

    public int size()
    {
        return this.getPayments().getRowCount();
    }

    @Override
    public String toString()
    {

        final StringBuffer str = new StringBuffer();

        str.append("paymentsDataModel:").append(this.getPayments().toString());

        return str.toString();

    }
}
