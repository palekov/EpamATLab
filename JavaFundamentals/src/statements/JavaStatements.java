package statements;

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

        int operation = 2;
        int number = 10;

        switch (operation) {
            case 1:
                number = number + 10;
                break;
            case 2:
                number = number - 4;                    //  this statement will be executed
                                                        //  we forget to put a break statement
            case 3:
                number = number / 3;                    //  this statement will be executed
                                                        //  we forget to put a break statement
            case 4:
                number = number * 10;                   //  this statement will be executed
                break;
        }
        System.out.println("number = " + number);      //  outputs 'number = 20'  not  '6'

        int weeks = 3;
        int days = 7;
        int i = 1, j =0;
                                                        // Nested loops
        while (i <= weeks) {                            // outer loop
            System.out.println("Week: " + i);
            for (j = 1; j <= days; ++j) {           // inner loop
                System.out.println("  Days: " + j);
            }
            ++i;
        }

        for(i = 1; i <= weeks; ++i) {                   // outer loop
            System.out.println("Week: " + i);

            for(j = 1; j <= days; ++j) {            // inner loop

                if(i == 2) {
                    break;                              // break inside the inner loop
                }
                System.out.println("  Days: " + j);     // days for week 2 are not printed
            }
        }

        for(i = 1; i <= weeks; ++i) {                   // outer loop
            System.out.println("Week: " + i);

            for(j = 1; j <= days; ++j) {            // inner loop

                if(j % 2 != 0) {                        // continue inside the inner loop
                    continue;
                }
                System.out.println("  Days: " + j);     //  outputs only even days of the week
            }
        }

        label: for (i = 0; i < 10; i++)                 // using break with label
        {
            for (j = 0; j < 10; j++)
            {
                if (i == 5 && j == 5)
                {
                    break label;
                }
                System.out.println(i + " " + j);
            }
        }

        label: for (i = 0; i < 10; i++)                 // using continue with label
        {
            for (j = 0; j < 10; j++)
            {
                if(i == 5)
                    continue label;
            }
            System.out.println(i + " " + j);
        }
    }
}
