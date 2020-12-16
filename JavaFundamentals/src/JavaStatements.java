public class JavaStatements {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++)                    // a simple loop 'for'
            System.out.println("i = " + i);

        for (int a = 1, b = 4; a < b; a++, b--) {      // loop 'for' with two variables
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }

        int y = 0;
        boolean done = false;
        for ( ; !done; ) {                              // some part of loop conditions is missing
            System.out.println("y = " + y);
            if (y == 10) done = true;
            y++;
        }

        //for ( ; ; ) {   }                            // infinite loop 'for'

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        for (int х : nums) sum += х;                  // for each loop

        int x = 0;
        while (x < 100)                               // 'while' loop with break
        {
            if (x == 10) break;
            System.out.println("x = " + x);
            x++;
        }

        x = 10;
        do {                                         // 'do - while' loop
            System.out.println("x = " + x);
            x--;
        }
        while (x > 0);

        for (int i = 0; i < 6; i++)
            switch (i) {                           // 'switch - case' operator
                case 0:
                    System.out.println("i=0");
                    break;
                case 1:
                    System.out.println("i=1");
                    break;
                case 2:
                    System.out.println("i=2");
                    break;
                case 3:
                    System.out.println("i=3");
                    break;
                default:
                    System.out.println("i>3");
            }
    }
}
