import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class JavaException {

    public static void testException(int i) throws IOException {
        if (i < 0) {
            ArithmeticException myException = new ArithmeticException("Number less then zero: " + i);
            throw myException;
        } else if (i > 10) {
            throw new IOException("Number range must be from 0 to 10!");
        }
    }

    public static void main(String[] args) throws IOException {

        //  get a list of 5 errors, show that they are errors by definition

        Class[] classes = Error.class.getClasses();
        System.out.println("classes.length = " + classes.length);
        for (int i = 0; i < classes.length; i++) {
            System.out.println("Class found = " + classes[i].getName());
        }

//        get a list of 5 runtime exceptions, show that they are runtime exceptions by definition
//        get a list of 5 checked exceptions, show that they are checked exceptions by definition

//        show that unchecked exception can be thrown from a method without declaration the throws clause
//        show that checked exception cannot be thrown from a method without declaration the throws clause
//        show that unchecked exception can be thrown and caught inside a method without declaration the throws clause

        try {                                           //  try-catch statement
            testException(-5);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        try {                                           //  try-catch statement with multi-catch block
            testException(-7);
            testException(5);
        } catch (ArithmeticException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {                                           //  try-catch-finally statement
            testException(-15);
        } catch (ArithmeticException e2) {
            e2.printStackTrace();
        } finally {
            System.out.println("it will be executed in any case!");
        }

        try {                                           //  try-finally statement
            int i = 7;
        }
        finally {
            System.out.println("This is Finally block");
        }

//        String path = "C:/null.txt";
//        try(FileOutputStream output = new FileOutputStream(path))       // try-with-resources statement
//        {
//            output.write(1);
//        }
//
//        int j = 100/0;                                  //  thread is terminated if an exception is not caught
                                                        //  Exception in thread "main" java.lang.ArithmeticException

        // using the interface Thread.UncaughtExceptionHandler
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
      //  int j1 = 1/0;

        // using the methods getCause, getMessage
        try {
            int jj = 1/0;
        } catch (ArithmeticException e3) {
            System.out.println("cause = " + e3.getCause());         // outputs 'cause = null'
            System.out.println("message = " + e3.getMessage());     // outputs 'message = / by zero'
        }

       // using the methods getStackTrace, printStackTrace
        try {
            Integer n = Integer.parseInt("xyz");
        }
        catch(Exception e)
        {
            StackTraceElement[] methods = e.getStackTrace();
            System.out.println(Arrays.toString(methods));
            e.printStackTrace();
        }



    }

    static class ExceptionHandler implements Thread.UncaughtExceptionHandler  // using the interface Thread.UncaughtExceptionHandler
    {
        public void uncaughtException(Thread t, Throwable e)
        {
            System.out.printf("An exception has been captured\n");
            System.out.printf("Thread: %s\n", t.getId());
            System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
            System.out.printf("Stack Trace: \n");
            e.printStackTrace(System.out);
            System.out.printf("Thread status: %s\n", t.getState());
            //new Thread(new Task()).start();
        }
    }
}

