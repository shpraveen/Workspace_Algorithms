package interviews.publicisSapient;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalVsBigDecimal {

    public static void main(String args[]) throws IOException {

        //floating point calculation
        double amount1 = 2.15;
        double amount2 = 1.10;
        double amt = amount1 - amount2;
        String amt2 = new DecimalFormat("##").format(amt);
        System.out.println("difference between 2.15 and 1.0 using double is: " + amt2);

        //Use BigDecimal for financial calculation
        BigDecimal amount3 = new BigDecimal("2.15");
        BigDecimal amount4 = new BigDecimal("1.10") ;
        System.out.println("difference between 2.15 and 1.0 using BigDecimal is: " + (amount3.subtract(amount4)));
    }

}
