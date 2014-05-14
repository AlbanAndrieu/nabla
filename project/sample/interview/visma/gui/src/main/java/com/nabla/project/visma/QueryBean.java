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
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.nabla.project.visma.api.ILoanService;

@ManagedBean(name = "input", eager = true)
@SessionScoped
public class QueryBean implements Serializable
{

    private static final long             serialVersionUID = 1L;

    private static final transient Logger LOGGER           = Logger.getLogger(QueryBean.class);

    public QueryBean()
    {
        if (QueryBean.LOGGER.isDebugEnabled())
        {
            QueryBean.LOGGER.debug("QueryBean started!");
        }
    }

    private BigDecimal      loanAmount   = new BigDecimal(200_000);

    private int             paybackTime  = 30;

    private int             interestType = 1;

    private BigDecimal      totalPayment = BigDecimal.ZERO;

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean  navigationBean;

    private PaymentSchedule paymentSchedule;

    // @Inject
    ILoanService            service      = new LoanService();

    public BigDecimal getLoanAmount()
    {
        return this.loanAmount;
    }

    public void setLoanAmount(final BigDecimal loanAmount)
    {
        this.loanAmount = loanAmount;
    }

    public int getPaybackTime()
    {
        return this.paybackTime;
    }

    public int getInterestType()
    {
        return this.interestType;
    }

    public void setInterestType(final int aInterestType)
    {
        this.interestType = aInterestType;
    }

    public void setPaybackTime(final int paybackTime)
    {
        this.paybackTime = paybackTime;
    }

    public BigDecimal getTotalPayment()
    {
        return this.totalPayment;
    }

    public void setTotalPayment(final BigDecimal totalPayment)
    {
        this.totalPayment = totalPayment;
    }

    public int getScheduledPaymentNumber()
    {
        return this.paymentSchedule.size();
    }

    public void setNavigationBean(final NavigationBean navigationBean)
    {
        this.navigationBean = navigationBean;
    }

    public PaymentSchedule getPaymentSchedule()
    {
        return this.paymentSchedule;
    }

    public void setPaymentSchedule(final PaymentSchedule paymentSchedule)
    {
        this.paymentSchedule = paymentSchedule;
    }

    /**
     * Get scheduled payments.
     * @return
     */
    public String getPayments()
    {
        // Get payments from service
        final Map<Integer, List<BigDecimal>> myPaymentSchedule = this.service.calcMonthlyPayment(this.getLoanAmount(), this.getPaybackTime());

        System.out.println("PaymentSchedule is : " + myPaymentSchedule.toString());
        if (QueryBean.LOGGER.isDebugEnabled())
        {
            QueryBean.LOGGER.debug("PaymentSchedule is : " + myPaymentSchedule.toString());
        }

        this.setPaymentSchedule(new PaymentSchedule(myPaymentSchedule));
        this.setTotalPayment(this.service.getTotalPayment(this.getLoanAmount(), this.getPaybackTime()));

        // Set computation ERROR
        final FacesMessage msg = new FacesMessage("Something went wrong!", "Please check your input");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage("loan", msg);

        // Go to payment page
        return this.navigationBean.redirectToPayment();

    }
}
