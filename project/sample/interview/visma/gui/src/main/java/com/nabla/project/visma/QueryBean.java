package com.nabla.project.visma;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "input", eager = true)
@SessionScoped
public class QueryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public QueryBean() {
        System.out.println("QueryBean started!");
    }

    private BigDecimal loanAmount   = new BigDecimal(200_000);

    private int        paybackTime  = 30;

    private BigDecimal totalPayment = BigDecimal.ZERO;

    public BigDecimal getLoanAmount() {
        return this.loanAmount;
    }

    public void setLoanAmount(final BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getPaybackTime() {
        return this.paybackTime;
    }

    public void setPaybackTime(final int paybackTime) {
        this.paybackTime = paybackTime;
    }

    public BigDecimal getTotalPayment() {
        return this.totalPayment;
    }

    public void setTotalPayment(final BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    /*
     * @ManagedProperty(value = "#{message}")
     * private Message messageBean;
     * private String message;
     * public String getMessage() {
     * if (this.messageBean != null) {
     * this.message = this.messageBean.getMessage();
     * }
     * return this.message;
     * }
     * public void setMessageBean(final Message message) {
     * this.messageBean = message;
     * }
     */
}
