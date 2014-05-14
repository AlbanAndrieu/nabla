/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
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
        this.paymentsDataModel = paymentsDataModel;

        if (null == this.paymentsDataModel)
        {
            throw new IllegalArgumentException("Payments data model cannot be null");
        }
    }

    public PaymentSchedule(final Map<Integer, List<BigDecimal>> aPayments)
    {
        this.setPayments(aPayments);
    }

    public PaymentSchedule(final Payment[] aPayments)
    {
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

        final StringBuilder str = new StringBuilder();

        str.append("paymentsDataModel:").append(this.getPayments().toString());

        return str.toString();

    }
}
