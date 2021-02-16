package exceptions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class JavaException {

    //        get a list of 5 errors, show that they are errors by definition

    //      Error – класс, который предназначен для описания исключений (ошибок) возникающих в самой среде Java.
    //      Такие исключения не оговариваются во время нормального выполнения прикладной программы.

    //      StackOverflowError
    //      OutOfMemoryError
    //      IOError
    //      LinkageError
    //      VirtualMachineError

//        get a list of 5 runtime exceptions, show that they are runtime exceptions by definition

    //        java.lang.RuntimeException;  ( unchecked exception )

    //        ArithmeticException – арифметическая ошибка (например, деление на ноль);
    //        ArrayIndexOutOfBoundsException – индекс за пределами массива;
    //        ArrayStoreException – присваивание элементу массива объекта несовместимого типа;
    //        ClassCastException – неправильное приведение типов;
    //        IllegalArgumentException – недопустимый аргумент при вызове метода;

//        get a list of 5 checked exceptions, show that they are checked exceptions by definition

    //        checked исключения не являются подклассом стандартного класса RuntimeException,
    //        В случае генерирования такого типа исключения, его обязательно нужно включать в оператор throws метода.

    //        ClassNotFoundException – класс не найден;
    //        IllegalAccessException – запрещен доступ к классу;
    //        InterruptedException – один поток выполнения прерван другим потоком;
    //        NoSuchFieldException – запрашиваемое поле не существует;
    //        NoSuchMethodException – запрашиваемый метод не существует;


//        show that unchecked exception can be thrown from a method without declaration the throws clause

    public static void testException1() {
        throw new ArithmeticException("Number range must be from 0 to 10!");
    }

//        show that checked exception cannot be thrown from a method without declaration the throws clause

    public static void testException2() throws IOException {
        throw new IOException("Number range must be from 0 to 10!");
    }
//        show that unchecked exception can be thrown and caught inside a method without declaration the throws clause

    public static void testException3() {
        try {
            int i = 5/0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    public static void testException(int i) throws IOException {
        if (i < 0) {
            ArithmeticException myException = new ArithmeticException("Number less then zero: " + i);
            throw myException;
        } else if (i > 10) {
            throw new IOException("Number range must be from 0 to 10!");
        }
    }

    public static void testNestedException(double value) throws Exception {
        Exception myException = new Exception(new NegativeNumberException(value));
        throw myException;
    }

    static class NegativeNumberException extends Exception {
        private double value;

        NegativeNumberException(double value) {
            this.value = value;
        }

        public String toString() {
            String msg = "Exception: " + value + " is a negative number!!!";
            return msg;
        }
    }

    //  ----------  main block ----------

    public static void main(String[] args) throws IOException {

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

        String path = "C:/null.txt";
        try(FileOutputStream output = new FileOutputStream(path))       // try-with-resources statement
        {
            output.write(1);
        }

        int j = 100/0;                                  //  thread is terminated if an exception is not caught
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

        //  throw one exception with another exception as the cause constructor argument
        //  and use the getCause method in the catch block
        try {
            testNestedException(-78.05);
        }
        catch (Exception e) {
            System.out.println("NestedExceptionCause = " + e.getCause());
            // outputs NestedExceptionCause = Exception: -78.05 is a negative number!!!
        }

        //  show behavior of finally block if there is one value return from try block
        //  and another value return from finally block

        showFinally();       //  outputs 'This is Finally block'

        // show behavior of finally block if there is one thrown exception from try block
        // and another thrown exception from finally block

        try {
            testException(-15);
        } catch (ArithmeticException e2) {
            e2.printStackTrace();
        } finally {
 //           int num = 10/0;                     //  Exception: java.lang.ArithmeticException: / by zero
            System.out.println("Finally will be executed in any case!");  // this is not executed
        }

        //  show behavior of finally block if there is thrown exception from try block
        //  and value return from finally block

        showFinallyReturnValue();       //  outputs 'This is Finally block return value'

        //  show behavior of finally block after executing the System.exit method in a try block

        try {
            System.out.println("Inside try block");
            System.exit(0);
        }
        catch(Exception exp) {
            System.out.println(exp);
        }
        finally {
            System.out.println("Java finally block");       // this is not executed
        }
    }

    //  ----------  end of main block ----------

    public static String showFinally()
    {
        try {
            return "try block!";
        }
        finally {
            System.out.println("This is Finally block");
            return "finally block!";
        }
    }

    public static String showFinallyReturnValue()
    {
        try {
            int num = 10/0;
        }
        finally {
            System.out.println("This is Finally block return value");
            return "finally block!";
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

