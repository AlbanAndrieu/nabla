package com.nabla.project.visma;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.nabla.project.visma.api.ILoan;
import com.nabla.project.visma.api.IProduct;

public class HouseLoan implements ILoan {

    private static final transient Logger LOGGER         = Logger.getLogger(HouseLoan.class);
    
    public static final double DEFAULT_INTEREST = 5.5;
    
    // Fixed interest of 5.5% per year
	private double interest = DEFAULT_INTEREST;

    private IProduct product;

    public HouseLoan() {
        throw new AssertionError();
    }
    
	public HouseLoan(IProduct aProduct)
    {      
	    this.product = aProduct;
	    
        if (null == this.product )
        {
            throw new IllegalArgumentException("Product cannot be null");
        }
        
    }

    @Override
	public double getInterest() {

		return interest;
	}

    @Override
    public IProduct getProduct()
    {
        return product;
    }
    
	@Override
	public BigDecimal calculateMonthlyPayment() {
	    
	    LOGGER.debug("Start calculateMonthlyPayment");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {

		final StringBuffer str = new StringBuffer();

		str.append("product:{").append(this.getProduct()).append("} ");
		str.append("interest:").append(this.getInterest());

		return str.toString();

	}

}
