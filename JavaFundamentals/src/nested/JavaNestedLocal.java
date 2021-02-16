package nested;

public class JavaNestedLocal {

    //  write and create an instance of local class
    //  show that local class has access to static and instance fields/methods of the enclosing context
    //  show that local class can have only instance fields/methods
    //  show that local class has access to final local variables
    //  show that local class has access to effectively final local variables (Java 8+)

    public static class Outerclass {
        static int st = 777;
        String word = " ### ";

        // instance method of the outer class
        void my_Method() {

            int num = 23;
            final int fin = 100;
            char sim = 'X';
            sim = 'Y';
            char sam = 'A';

            // method-local inner class
            class MethodInner_Demo {
                int i = 15;

                public void print() {
                    System.out.println("This is method inner class "+num + word + fin + st);

                    //  System.out.println(sim);
                    //  error: Variable 'sim' is accessed from within inner class, needs to be final or effectively final

                    System.out.println(sam);     //  outputs 'A'
                }
            }

            // Accessing the inner class
            MethodInner_Demo inner = new MethodInner_Demo();
            inner.print();
        }
    }

    public static void main(String args[]) {
        Outerclass outer = new Outerclass();
        outer.my_Method();      //   outputs 'This is method inner class 23 ### 100777'
    }
}
