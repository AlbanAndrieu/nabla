import org.junit.Test

import com.nabla.project.visma.BasicPaymentMethod
import com.nabla.project.visma.House
import com.nabla.project.visma.HouseLoan
import com.nabla.project.visma.api.ILoan
import com.nabla.project.visma.api.IProduct
import static org.junit.Assert.assertEquals

class SampleTest extends GroovyTestCase {

    @Test
    void testVisma() {
        final IProduct product = new House(new BigDecimal(200_000));
        final ILoan loan = new HouseLoan(product, 30, 6.5);

        System.out.println("Payment schedule is :\n " + loan.calcMonthlyPayment() + "\n");

        assertEquals 360, loan.calcMonthlyPayment().size()
        
        final BigDecimal totalPayment = new BasicPaymentMethod(loan).getTotalPayment();

        assert "455088.976914933887072998806891835200" == totalPayment.toString();
    }

}