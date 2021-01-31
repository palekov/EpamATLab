import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

public class JavaNestedLambdas {

    int num;
    String type;
    static int staticTest = 10;
    int instanceTest = 20;

    public JavaNestedLambdas(int num, String type) {
        this.num = num;
        this.type = type;
    }

    public JavaNestedLambdas() {
    }

    //  write functional interface, mark it with the @FunctionalInterface annotation and create lambda of its type
    @FunctionalInterface
    interface MyInterface {
        double getPiValue();
    }

    @FunctionalInterface
    interface MyFunc {
        int func(int n);
    }

    @FunctionalInterface
    public interface Predicate<T> {
        boolean test(T t);
    }

    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);
    }

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    @FunctionalInterface
    public interface Function<R,T> {
        R apply(T t);
    }

    private static void staticMethod(String s) {
        // do something
    }

    private void instanceMethod(String s) {
        // do something
    }

    public static void main(String[] args) {

        List<String> strings = new LinkedList<>();
        strings.add("мама");
        strings.add("мыла");
        strings.add("раму");

        //  write lambdas with and without parameters
        strings.forEach(x -> System.out.println(x));

        MyInterface ref = () -> 3.1415;

        Runnable runnable = () -> System.out.println("Я - лямбда!");
        runnable.run();

        //  show that lambda has access to static and instance fields/methods of the enclosing context
        Supplier<Integer> supplier = () -> staticTest++;
        JavaNestedLambdas instance1 = new JavaNestedLambdas();
        Supplier<Integer> supplier1 = () -> instance1.instanceTest++;

        //  show that lambda has access to final local variables
        final int j = 7;
        MyFunc myLambda1 = (n) -> {
            int z = j + 1;
            return z;
        };

        //  show that lambda has access to effectively final local variables
        int num = 10;
        MyFunc myLanbda2 = (n) -> {
            int v = num + n;
            //  num++;          error:  Variable used in lambda expression should be final or effectively final
            return v;
        };

        //  write lambdas that implement the functional interfaces: Consumer, Supplier, Function, Predicate
        //  using Predicate
        Predicate<Integer> isEvenNumber = x -> x % 2==0;
        System.out.println(isEvenNumber.test(4));       //  outputs 'true'
        System.out.println(isEvenNumber.test(3));       //  outputs 'false'

        //  using Consumer
        Consumer greetings = x -> System.out.println("Hello " + x + " !!!");  //  outputs 'Hello Elena !!!'
        greetings.accept("Elena");

        //  using Supplier
        ArrayList nameList = new ArrayList<>();
        nameList .add("Elena");
        nameList .add("John");
        nameList .add("Alex");
        nameList .add("Jim");
        nameList .add("Sara");
        Supplier randomName = () -> {
            int value = (int)(Math.random() * nameList.size());
            return nameList.get(value);
        };
        System.out.println(randomName.get());            //  outputs 'Sara'

        //  using Function
        String s = "678";
        Function valueConverter = x -> Integer.valueOf((String) x);
        System.out.println(valueConverter.apply(s));    //  outputs '678'

        //  write method reference to a static method
        strings.forEach(JavaNestedLambdas::staticMethod);

        //  write method reference to an instance method of a particular object
        JavaNestedLambdas instance = new JavaNestedLambdas();
        strings.forEach(instance::instanceMethod);

        //  write method reference to an instance method of an arbitrary object of a particular type
        List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);
        numbers.stream().sorted(Integer::compareTo);

        //  write method reference to a constructor
        BiFunction<Integer, String, JavaNestedLambdas> aNew = JavaNestedLambdas::new;

    }
}
