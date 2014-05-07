package com.nabla.project.visma;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.nabla.project.visma.api.ILoan;

public class HouseLoan implements ILoan {

    private static final transient Logger LOGGER         = Logger.getLogger(HouseLoan.class);
    
	private BigDecimal interest = BigDecimal.ZERO;

	@Override
	public BigDecimal getInterest() {

		return interest;
	}

	@Override
	public BigDecimal calculateMonthlyPayment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {

		final StringBuffer str = new StringBuffer();

		str.append("interest=").append(this.getInterest()).append(' ');

		return str.toString();

	}

}
