package numbers;

public class JavaNumbers {
    public static void main(String[] args) {
        boolean boo;    //  true/false
        byte byt;       //  8-bit signed integer
        char cha;       //  single 16-bit Unicode character
        short sho;      //  16-bit signed integer
        int num;        //  32-bit signed integer
        long lon;       //  64-bit two's complement integer.
        float flo;      //  single-precision 32-bit IEEE 754 floating point
        double dou;     //  double-precision 64-bit IEEE 754 floating point

        Boolean boo_wrapper;        // using wrapper classes for primitive types
        Byte byt_wrapper;
        Short sho_wrapper;
        Integer int_wrapper;
        Long lon_wrapper;
        Float flo_wrapper;
        Double dou_wrapper;

        byte myByte = 127;
        int myInt = myByte;         //  widening conversion  byte > int
        float myFloat = myInt;      //  widening conversion   int > float
        long myLong = myInt;        //  widening conversion   int > long
        double myDouble = myLong;   //  widening conversion  long > double

        int myInt2 = (int) myDouble;     //  narrowing conversion double > int
        byte myByte2 = (byte) myInt;     //  narrowing conversion int > byte

        boo = false;
        String str = Boolean.toString(boo);             //   converts boolean > String

        String str1 = "true";                           //   converts String > boolean
        String str2 = "FALSE";
        String str3 = "Something";
        boolean bool1=Boolean.parseBoolean(str1);
        boolean bool2=Boolean.parseBoolean(str2);
        boolean bool3=Boolean.parseBoolean(str3);

        //  If the value of the string is “true”
        //  (in any case uppercase, lowercase or mixed)
        //  then this method returns true, else it returns false.

        System.out.println(bool1);    //  prints "true"
        System.out.println(bool2);    //  prints "false"
        System.out.println(bool3);    //  prints "false"

        boo_wrapper = boo;            // initializing primitive types and their wrappers
        byt = 127;
        byt_wrapper = byt;
        cha = 'c';
        sho = 1024;
        sho_wrapper = sho;
        num = 345;
        int_wrapper = num;
        lon = 414233556;
        lon_wrapper = lon;
        flo = 3.1454f;
        flo_wrapper = flo;
        dou = 3.14455623767648846763;
        dou_wrapper = dou;
        // outputs wrapper classes and their MIN / MAX values and NaN
        System.out.println("Boolean = " + boo_wrapper);
        System.out.println("Byte = " + byt_wrapper + " MIN = " + byt_wrapper.MIN_VALUE + " MAX = " + byt_wrapper.MAX_VALUE);
        System.out.println("Short = " + sho_wrapper + " MIN = " + sho_wrapper.MIN_VALUE + " MAX = " + sho_wrapper.MAX_VALUE);
        System.out.println("Integer = " + int_wrapper + " MIN = " + int_wrapper.MIN_VALUE + " MAX = " + int_wrapper.MAX_VALUE);
        System.out.println("Long = " + lon_wrapper + " MIN = " + lon_wrapper.MIN_VALUE + " MAX = " + lon_wrapper.MAX_VALUE);
        System.out.println("Float = " + flo_wrapper + " MIN = " + flo_wrapper.MIN_VALUE + " MAX = " + flo_wrapper.MAX_VALUE);
        System.out.println("POS = " + flo_wrapper.POSITIVE_INFINITY + " NEG = " + flo_wrapper.NEGATIVE_INFINITY
                + " NaN = " + ( flo_wrapper.NEGATIVE_INFINITY - flo_wrapper.NEGATIVE_INFINITY ));
        System.out.println("Double = " + dou_wrapper + " MIN = " + dou_wrapper.MIN_VALUE + " MAX = " + dou_wrapper.MAX_VALUE);
        System.out.println("POS = " + dou_wrapper.POSITIVE_INFINITY + " NEG = " + dou_wrapper.NEGATIVE_INFINITY
                + " NaN = " + ( dou_wrapper.POSITIVE_INFINITY + dou_wrapper.NEGATIVE_INFINITY ));

    }
}
