import java.util.ArrayList;

public class JavaNestedLambdas {

    //  write lambdas that implement the functional interfaces: Consumer, Supplier, Function, Predicate
    //  write lambdas with and without parameters
    //  write lambdas with and without body
    //  write lambdas that return values implicitly and explicitly
    //  write functional interface, mark it with the @FunctionalInterface annotation and create lambda of its type
    //  show that lambda has access to static and instance fields/methods of the enclosing context
    //  show that lambda has access to final local variables
    //  show that lambda has access to effectively final local variables

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


    public static void main(String[] args) {

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
    }
}
