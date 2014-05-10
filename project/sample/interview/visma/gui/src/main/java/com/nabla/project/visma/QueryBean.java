package com.nabla.project.visma;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.nabla.project.visma.api.ILoanService;

@ManagedBean(name = "input", eager = true)
@SessionScoped
public class QueryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public QueryBean() {
        System.out.println("QueryBean started!");
    }

    private BigDecimal     loanAmount       = new BigDecimal(200_000);

    private int            paybackTime      = 30;

    private BigDecimal     totalPayment     = BigDecimal.ZERO;

    private String         scheduledPayment = null;

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;

    // @Inject
    ILoanService           service          = new LoanService();

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

    public String getScheduledPayment() {
        return this.scheduledPayment;
    }

    public void setScheduledPayment(final String scheduledPayment) {
        this.scheduledPayment = scheduledPayment;
    }

    public void setNavigationBean(final NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    /**
     * Get scheduled payments.
     * @return
     */
    public String getPayments() {
        // Get payments from service
        this.setScheduledPayment(this.service.calcMonthlyPayment(this.getLoanAmount(), this.getPaybackTime()).toString());
        this.setTotalPayment(this.service.getTotalPayment(this.getLoanAmount(), this.getPaybackTime()));

        // Set computation ERROR
        final FacesMessage msg = new FacesMessage("Something went wrong!", "Please check your input");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage("loan", msg);

        // Go to payment page
        return this.navigationBean.redirectToPayment();

    }
}
