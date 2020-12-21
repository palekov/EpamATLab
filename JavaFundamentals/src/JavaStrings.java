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

        byte ascii[] = { 65, 66, 67, 68, 69, 70 };
        String str_byt = new String(ascii);               //  creates string 'ABCDEF' from byte[]
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

        int i = 1024;
        str_num = String.valueOf(i);                      //  converts int to String
        str_num = Integer.toString(i);

        char ch;
        ch = "abc".charAt(1);                            //  ch = 'b'

        String s = "London is a capital of Great Britain";
        int len = s.length();                           //  len = 36
        String s1 = s.substring(12,19);                 //  s1 = 'capital'
        System.out.println(len);
        System.out.println(s1);

        String[] s2 = s.split(" ");              // splits String literal into String array
        for (String word:s2)
            System.out.println(word);
        System.out.println(s1.toUpperCase(Locale.ROOT));                // outputs 'CAPITAL'

        System.out.println(s1.indexOf('p'));                            // returns 2

        System.out.println(s1.compareToIgnoreCase("CAPITal"));      // returns 0

        float flo = 3.14f;
        boolean bol = true;
        String form = String.format("String %s, integer %d, float %f, boolean %b, char %c"
                , str_lit, num, flo, bol, ch);
        System.out.println(form);           // outputs 'String Hello, integer 314, float 3,140000, boolean true, char b'

        DemotoString demo = new DemotoString(55, 2.545f);
        System.out.println(demo);           //  outputs 'DemotoString: varA = 55, varB = 2.545'

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
    }
}
