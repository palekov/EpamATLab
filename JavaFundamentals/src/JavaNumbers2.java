import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.sql.SQLOutput;

public class JavaNumbers2 {

    public static void methodInt (Integer i) {
        System.out.println(i);
    }

    public static void main(String[] args) {
        Integer im_obj = new Integer(8);      // manual boxing from int to Integer
        Integer i1_obj = 7, i2_obj = 3;             // autoboxing from int to Integer
        methodInt(45);                           // autoboxing from int to Integer

        int i_num = i1_obj;                         // autounboxing from Integer to int
        int o_num = i1_obj.intValue();              // manual unboxing

        System.out.println(i1_obj + i2_obj);        // autounboxing from Integer, sum and outputs int 10

        i1_obj = Integer.MIN_VALUE;
        i2_obj = Integer.MAX_VALUE;

        System.out.println("Integer.MIN_VALUE = " + i1_obj);    // outputs -2147483648
        System.out.println("Integer.MAX_VALUE = " + i2_obj);    // outputs  2147483647

        i1_obj -= 1;
        i2_obj += 1;
        //  If it overflows, it goes back to the minimum value and continues from there
        //  If it underflows, it goes back to the maximum value and continues from there

        System.out.println("Integer underflow = " + i1_obj);    // outputs  2147483647
        System.out.println("Integer overflow = " + i2_obj);     // outputs -2147483648

        // i_num = 255 / 0;            //  it causes java.lang.ArithmeticException
        // i_num = 128 % 0;            //  it causes java.lang.ArithmeticException

        i_num = -7;
        System.out.println(Math.abs(i_num));           // outputs 7
        int i_nam = 14;
        System.out.println(Math.min(i_nam, i_num));    // outputs -7
        System.out.println(Math.max(i_nam, i_num));    // outputs 14

        double d1 = 123.4;           // double in standard format
        double d2 = 1.234e2;         // double in scientific notation
        float f1  = 223.4f;          // float in standard format
        float f2  = 2.234e2f;        // float in scientific notation
        Float f3  = 1.115780f;

        String str_flo = String.valueOf(f1);   //  float to String
        String str_flo2 = f3.toString();       //  Float to String

        str_flo = "100.15";
        Float f4 = Float.parseFloat(str_flo);  // String to Float
        float f5 = Float.valueOf(str_flo);     // String to float

        float nan            = Float.NaN;      // Generate some NaNs.
        float zero_div_zero  = 0.0f / 0.0f;
        float sqrt_negative  = (float) Math.sqrt(-1.0);
        float log_negative   = (float) Math.log(-1.0);

        System.out.println("nan = " + nan);                         // outputs NaN
        System.out.println("zero_div_zero = " + zero_div_zero);     // outputs NaN
        System.out.println("sqrt_negative = " + sqrt_negative);     // outputs NaN
        System.out.println("log_negative = " + log_negative);       // outputs NaN
        System.out.println(Float.isNaN(nan));                       // outputs 'true'
        System.out.println(Float.NaN == Float.NaN);                 // outputs 'false'

        BigInteger firstValue = new BigInteger("37995453634");
        BigInteger secondValue = new BigInteger("13114457757");
        BigInteger resultValue =  firstValue.add(secondValue);
        System.out.println(resultValue);  //  outputs 51109911391
        resultValue =  firstValue.subtract(secondValue);
        System.out.println(resultValue);  //  outputs 24880995877
        resultValue =  firstValue.multiply(secondValue);
        System.out.println(resultValue);  //  outputs 498289771641145138938
        resultValue =  firstValue.remainder(secondValue);
        System.out.println(resultValue);  // outputs 11766538120

        BigDecimal firstBigDecValue = new BigDecimal("455656.545");   //  455656.545
        BigDecimal secondBigDecValue = new BigDecimal(3445.54);       //  3445.5399999999999636202119290828704833984375
        BigDecimal thirdBigDecValue = new BigDecimal(3445.554645675444, MathContext.DECIMAL32);   //  3445.555
        BigDecimal resultBigDec;
        resultBigDec = firstBigDecValue.add(secondBigDecValue);
        System.out.println(resultBigDec);   // 459102.0849999999999636202119290828704833984375
        resultBigDec = firstBigDecValue.subtract(secondBigDecValue);
        System.out.println(resultBigDec);   // 452211.0050000000000363797880709171295166015625
        resultBigDec = firstBigDecValue.multiply(secondBigDecValue);
        System.out.println(resultBigDec);   // 1569982852.0592999834233114597736857831478118896484375
        resultBigDec = thirdBigDecValue.subtract(secondBigDecValue);
        System.out.println(resultBigDec);   // 0.0150000000000363797880709171295166015625

        BigDecimal x = new BigDecimal("1.5");
        BigDecimal y = new BigDecimal("1.50");
        System.out.println(x.equals(y));             // outputs 'false' because different number scale

        BigDecimal x1 = new BigDecimal("1.5");
        BigDecimal y1 = new BigDecimal("1.50");
        System.out.println(x1.compareTo(y1));        // outputs '0' this means x1 = y1

    }
}
