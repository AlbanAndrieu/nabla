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
public class QueryBean implements Serializable {

    private static final long             serialVersionUID = 1L;

    private static final transient Logger LOGGER           = Logger.getLogger(QueryBean.class);

    public QueryBean() {
        if (QueryBean.LOGGER.isDebugEnabled()) {
            QueryBean.LOGGER.debug("QueryBean started!");
        }
    }

    private BigDecimal      loanAmount   = new BigDecimal(200_000);

    private int             paybackTime  = 30;

    private int             interestType = 1;

    private BigDecimal      totalPayment = BigDecimal.ZERO;

    // private Map<Integer, List<BigDecimal>> scheduledPayment = null;

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean  navigationBean;

    // @ManagedProperty(value = "#{paymentSchedule}")
    private PaymentSchedule paymentSchedule;

    // @Inject
    ILoanService            service      = new LoanService();

    public BigDecimal getLoanAmount() {
        return this.loanAmount;
    }

    public void setLoanAmount(final BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getPaybackTime() {
        return this.paybackTime;
    }

    public int getInterestType() {
        return this.interestType;
    }

    public void setInterestType(final int aInterestType) {
        this.interestType = aInterestType;
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
     * public Map<Integer, List<BigDecimal>> getScheduledPayment() {
     * return this.scheduledPayment;
     * }
     * public void setScheduledPayment(final Map<Integer, List<BigDecimal>> scheduledPayment) {
     * this.scheduledPayment = scheduledPayment;
     * }
     */
    public int getScheduledPaymentNumber() {
        return this.paymentSchedule.size();
    }

    public void setNavigationBean(final NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    public PaymentSchedule getPaymentSchedule() {
        return this.paymentSchedule;
    }

    public void setPaymentSchedule(final PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    /**
     * Get scheduled payments.
     * @return
     */
    public String getPayments() {
        // Get payments from service
        // this.setScheduledPayment(this.service.calcMonthlyPayment(this.getLoanAmount(), this.getPaybackTime()));

        final Map<Integer, List<BigDecimal>> myPaymentSchedule = this.service.calcMonthlyPayment(this.getLoanAmount(), this.getPaybackTime());

        System.out.println("PaymentSchedule is : " + myPaymentSchedule.toString());
        if (QueryBean.LOGGER.isDebugEnabled()) {
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
