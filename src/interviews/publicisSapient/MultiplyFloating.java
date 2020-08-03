package interviews.publicisSapient;

import java.math.BigDecimal;
//What will this statement return 3*0.1 == 0.3? true or false?
public class MultiplyFloating {

        public static void main(String[] args) {
            double d1 = 3 * 0.1;
            double d2 = 0.3;
            System.out.println("d1 = "+d1);
            System.out.println("d2 = "+d2);
            //Some floating-point numbers cannot be represented exactly so i will print false.
            System.out.println(d1==d2);

            double d3 = 100.0;
            double d4 = 100.0;
            System.out.println("d3 = "+d3);
            System.out.println("d4 = "+d4);
            //This will return true
            System.out.println(d3==d4);

            BigDecimal d11 = new BigDecimal(3* 0.1);
            BigDecimal d22 = new BigDecimal(0.3);

            System.out.println("BigDecimal : " +(d11==d22));


        }

}
