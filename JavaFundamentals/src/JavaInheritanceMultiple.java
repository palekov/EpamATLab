public class JavaInheritanceMultiple {

    //   show multiple inheritance of type in a subclass by extending
    //   from one superclass and implementing multiple interfaces



    //   show multiple inheritance of implementation (Java 8+) in a subclass by implementing multiple interfaces (use default methods

    interface PI1
    {
        // default method
        default void show()
        {
            System.out.println("Default PI1");
        }
    }

    interface PI2
    {
        // default method
        default void show()
        {
            System.out.println("Default PI2");
        }
    }

    // Implementation class code
    static class TestClass implements PI1, PI2
    {
        // Overriding default show method
        public void show()
        {
            // use super keyword to call the show
            // method of PI1 interface
            PI1.super.show();

            // use super keyword to call the show
            // method of PI2 interface
            PI2.super.show();
        }
    }

    public static void main(String args[])
    {
        TestClass d = new TestClass();
        d.show();                       //   outputs:  Default PI1
                                        //             Default PI2
    }
}
