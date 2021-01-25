public class JavaInheritanceMultiple {

    //   show multiple inheritance of type in a subclass by extending
    //   from one superclass and implementing multiple interfaces (use the instanceof operator)

    interface Backend1 {
        public void connectServer();
    }

    interface Backend2 {
        public void disconnectServer();
    }

    static class Frontend {

        public void responsive(String str) {
            System.out.println(str + " can also be used as frontend.");
        }
    }

    static class Language extends Frontend implements Backend1, Backend2 {

        String language = "Java";

        @Override
        public void connectServer() {
            System.out.println("Connected to " + language + " server.");
        }

        @Override
        public void disconnectServer() {
            System.out.println("Disconnected from " + language + " server.");
        }
    }

    //   show multiple inheritance of implementation (Java 8+) in a subclass by implementing
    //   multiple interfaces (use default methods)

    interface PI1 {
        default void show() {
            System.out.println("Default PI1");
        }
    }

    interface PI2 {
        default void show() {
            System.out.println("Default PI2");
        }
    }

    // Implementation class code
    static class TestClass implements PI1, PI2 {
        // Overriding default show method
        public void show() {
            // use super keyword to call the show
            // method of PI1 interface
            PI1.super.show();

            // use super keyword to call the show
            // method of PI2 interface
            PI2.super.show();
        }
    }

    public static void main(String args[]) {

        TestClass d = new TestClass();
        d.show();                           //   outputs:  Default PI1     Default PI2

        // create object of Language class
        Language java = new Language();
        java.connectServer();               //   outputs  'Connected to Java server.'
        java.disconnectServer();            //   outputs  'Disconnected from Java server.'
        // call the inherited method of Frontend class
        java.responsive(java.language);     //   outputs  'Java can also be used as frontend.'

        System.out.println(java instanceof Language);   //  outputs  'true'
        System.out.println(java instanceof Frontend);   //  outputs  'true'

    }
}

