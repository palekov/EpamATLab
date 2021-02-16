package strings;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class JavaStrings {

    public static class DemotoString {
        int varA;
        float varB;

        DemotoString(int varA, float varB) {
            this.varA = varA;
            this.varB = varB;
        }

        @Override
        public String toString() {
            return "DemotoString: " + "varA = " + varA + ", varB = " + varB ;
        }
    }

    public static void main(String[] args) {

        String str_lit = "Hello";                         //  creates string literal
        String str_obj = new String(" world!");    //  creates string object

        char chars[] = { 'a', 'b', 'c' };
        String str_cha = new String(chars);               //  creates string from char[]

        byte utf16[] = { 0, 1, 2, 3, 4, 5, 6, 7 };
        String str_byt = new String(utf16, StandardCharsets.UTF_16);   // creates string from byte[]
        System.out.println(str_byt);

        String str = str_lit + str_obj;                   //  concatenate, using '+'
        str = str.concat(str_lit);                        //  concatenate, using 'concat' method
        System.out.println(str);

        String str_num = "314";
        Integer num = Integer.valueOf(str_num);           //  using 'valueOf(String)' method
        str_num = "three";
        //num = Integer.valueOf(str_num);                 //  this is causes NumberFormatException

        str_num = "256";
        int num_int = Integer.parseInt(str_num);          //  using 'parseInt(String)' method
        str_num = "four";
        //num_int = Integer.parseInt(str_num);            //  this is causes NumberFormatException

        Integer itr = new Integer(500), ntr = null;
        String strItr = "" + itr;                         //  converts Integer to String using '+' operator
        String ntrItr = "" + ntr;
        System.out.println(itr);                          //   outputs '500'
        System.out.println(ntr);                          //   outputs 'null'

        int i = 1024;
        str_num = String.valueOf(i);                      //  converts int to String
        str_num = Integer.toString(i);
        str_num = String.valueOf(null);

        char ch;
        ch = "abc".charAt(1);                           //  ch = 'b'

        String s = "LONDON is a capital of Great Britain";
        int len = s.length();                           //  len = 36

        String[] s2 = s.split(" ");               //  splits String literal into String array
        for (String word:s2)
            System.out.println(word);

        String s3 = "   Много лишних пробелов!  ";
        System.out.println(s3.trim());                  //  outputs 'Много лишних пробелов!'

        String s4 = s.substring(0,6);                       // s4 = 'LONDON'
        System.out.println(s4.toLowerCase(Locale.ROOT));    // outputs 'london'

        String s1 = s.substring(12,19);                                 // s1 = 'capital'
        System.out.println(s1.toUpperCase(Locale.ROOT));                // outputs 'CAPITAL'

        System.out.println(s.replace(' ', '*'));                   //  outputs 'LONDON*is*a*capital*of*Great*Britain'
        System.out.println(s.replaceFirst("LONDON", "NewYork"));  // outputs 'NewYork is a capital of Great Britain'
        System.out.println(s.replaceAll("it", "IT"));             // outputs 'LONDON is a capITal of Great BrITain'
                                                                        // s1 = 'capital'
        System.out.println(s1.indexOf('a'));                            // outputs '1'
        System.out.println(s1.lastIndexOf('a'));                    // outputs '5'
        System.out.println(s1.contains("pi"));                          // outputs 'true'
        System.out.println(s1.startsWith("ca"));                        // outputs 'true'
        System.out.println(s1.endsWith("al"));                          // outputs 'true'
        System.out.println(s1.endsWith("la"));                          // outputs 'false'

        System.out.println(s1.compareTo("CAPITAL"));                    // outputs '32'
        System.out.println(s1.compareToIgnoreCase("CAPITal"));      // outputs '0'
        System.out.println(s1.equals("CAPITAL"));                       // outputs 'false'
        System.out.println(s1.equalsIgnoreCase("CAPITAL")); // outputs 'true'

        float flo = 3.14f;
        boolean bol = true;
        String form = String.format("String %s, integer %d, float %f, boolean %b, char %c"  // using String.format
                , str_lit, num, flo, bol, ch);
        System.out.println(form);           // outputs 'String Hello, integer 314, float 3,140000, boolean true, char b'

        DemotoString demo = new DemotoString(55, 2.545f);
        System.out.println(demo);           //  outputs 'DemotoString: varA = 55, varB = 2.545' using override toString method

        String str_case = "five";

        switch (str_case) {                 // using String in 'switch - case' operator
            case "one":
                System.out.println("1");
                break;
            case "three":
                System.out.println("3");
                break;
            case "five":
                System.out.println("5");
                break;
            case "seven":
                System.out.println("7");
                break;
            default:
                System.out.println("not a number");
        }

        String ss1 = "Eleven";
        String ss2 = new String("Eleven");
        String ss3 = new String("Eleven");
        String ss4 = "Eleven";
        System.out.println(ss1 == ss2);             // false, because links to two different objects
        System.out.println(ss1 == ss4);             // true, because its one object from string pool
        System.out.println(ss1.equals(ss4));        // true, because the contents of the objects are identical
        System.out.println(ss1.intern() == ss4.intern());   // true, because ss1.equals(ss4) is true
                                                            // but this method is faster with frequent comparison
        System.out.println(ss1.equals(ss2));        // true, because equals compares the contents
        ss2 = ss1;
        System.out.println(ss1 == ss2);             // true, because its links to one object
        System.out.println(ss2 != ss3);             // true, because its two different objects
        System.out.println(ss2.equals(ss3));        // true, because the contents of the objects are identical
        System.out.println(ss2.intern() == ss3.intern());   //  true, because ss2.equals(ss3) is true

        StringBuffer sb = new StringBuffer("this is a string buff ");
        sb.append(new Integer(1));
        sb.append("; ");
        sb.append(true);
        sb.append(" it is synchronized!");
        System.out.println(sb);                     //  outputs 'this is a string buff 1; true it is synchronized!'
        String sbs = sb.toString();                 //  StringBuffer to String

        StringBuilder sb2 = new StringBuilder("this is s string build ");
        sb2.append(new Integer(101112));
        sb2.append("; ");
        sb2.append(false);
        sb2.append(" it is not synchronized!");      //  outputs 'this is s string build 101112; false it is not synchronized!'
        System.out.println(sb2);
        String sbb = sb2.toString();                 //  StringBuilder to String
    }
}
