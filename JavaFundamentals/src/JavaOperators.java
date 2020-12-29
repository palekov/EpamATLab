public class JavaOperators {
    public static void main(String[] args) {
        System.out.println("Integer arithmetic");
        int a = 2 + 3;
        int b = a * 3;
        int c = b / 5;
        int d = c - a;
        int e = -d;
        System.out.println("a = " + a);         // outputs a = 5
        System.out.println("b = " + b);         // outputs b = 15
        System.out.println("c = " + c);         // outputs c = 3
        System.out.println("d = " + d);         // outputs d = -2
        System.out.println("e = " + e);         // outputs e = 2

        System.out.println("\nFloating point arithmetic");
        double da = 2 + 3;
        double db = da * 3;
        double dc = db / 5;
        double dd = dc - da;
        double de = -dd;
        System.out.println("da = " + da);       // outputs da = 5.0
        System.out.println("db = " + db);       // outputs db = 15.0
        System.out.println("dc = " + dc);       // outputs dc = 3.0
        System.out.println("dd = " + dd);       // outputs dd = -2.0
        System.out.println("de = " + de);       // outputs de = 2.0

        int x = 42;
        double y = 42.25;
        System.out.println("\nDivision modulo 10");
        System.out.println("x mod 10 = " + x % 10);     // outputs 2
        System.out.println("y mod 10 = " + y % 10);     // outputs 2.25

        int var_a = 1;
        int var_b = 2;
        int var_c = 3;
        var_a += 5;
        var_b *= 4;
        var_c += var_a * var_b;
        var_c %= 6;
        System.out.println("\nCompound assignment operations");
        System.out.println("var_a = " + var_a);     // outputs 6
        System.out.println("var_b = " + var_b);     // outputs 8
        System.out.println("var_c = " + var_c);     // outputs 3
        String str1, str2, str3;
        str1 = "Hello ";
        str2 = "Vasya!";
        str3 = str1 + str2;  //  str3 = 'Hello Vasya!'

        int aa = 3;          //  0011b
        int bb = 6;          //  0110b
        int cc = aa | bb;    //  0111b
        int ddd = aa & bb;   //  0010b
        int eee = aa ^ bb;   //  0101b

        Integer num = new Integer(22);           // creating a link to the object 'Integer'
        System.out.println(num instanceof Integer);    // outputs 'true'

        int number = 24;
        String result = (number > 0) ? "Positive Number" : "Negative Number";  // ternary operator
        System.out.println(result);    //  outputs 'Positive Number'

        number = -5;
        result = (number > 0) ? "Positive Number" : "Negative Number";  // ternary operator
        System.out.println(result);    //  outputs 'Negative Number'
    }
}
