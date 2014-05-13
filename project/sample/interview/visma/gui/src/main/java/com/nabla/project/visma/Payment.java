package com.nabla.project.visma;

import java.math.BigDecimal;

// TODO move this class to core module
public class Payment {

    private final BigDecimal loanAmount;

    // TODO add interest member

    public Payment(final BigDecimal aLoanAmount) {
        this.loanAmount = aLoanAmount;

        if (null == this.loanAmount) {
            throw new IllegalArgumentException("Loan amount cannot be null");
        }
    }

    public BigDecimal getLoanAmount() {
        return this.loanAmount;
    }

    @Override
    public String toString() {

        final StringBuffer str = new StringBuffer();

        str.append("loanAmount:").append(this.getLoanAmount());

        return str.toString();

    }

}
