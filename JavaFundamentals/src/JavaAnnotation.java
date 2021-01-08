import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.time.YearMonth;
import java.util.Date;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class JavaAnnotation {

    // use the @Deprecated annotation in the correct way
    // (write an outdated method and a modern method, write appropriate JavaDoc with @deprecated JavaDoc tag)

    static class Bar {
        /**
         * @deprecated This method is no longer acceptable.
         * Use doSomethingWeird() method.
         */
        @Deprecated
        public static void doSomethingWeird() {
            // old method
        }

        public static void doSomethingCool() {
            // new, alternate method
        }

        // use the @Override annotation in the correct way (override method)
        // and in an incorrect way (overload method), screenshot

        @Override
        public String toString() {
            return "Bar{}";
        }

        @Override
        public String toString(String str) {            //  its incorrect
            return "Bar{}";
        }
    }

        //  use the @SafeVarargs annotation (use var-args with generics), screenshot

        @SafeVarargs
        static <T> void methodVarArgs(T... els) {
            for (T t : els) {
                System.out.println(t);
            }
        }

        // use the @FunctionalInterface annotation in the correct way (on an interface with 1 abstract method)
        // and in incorrect ways (on interfaces with 0 and 2 abstract methods), screenshot

        @FunctionalInterface
        interface MyPredicate {
            boolean test(Integer value);
        }

        @FunctionalInterface
        interface MyPredicate0 {                //  its incorrect
        }

        @FunctionalInterface
        interface MyPredicate2 {                //  its incorrect
            boolean test(Integer value);

            int sum(int s1, int s2);
        }

        // write an annotation with the meta-annotations @Retention(RetentionPolicy.RUNTIME),
        // @Target(FIELD) and the body String value();

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        @interface Person {
            String name() default "";
        }

        // write a class with fields and apply the annotation with different values to its fields

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.TYPE)
        @interface Person2 {
            String name() default "";
            int live();
            int strength();
            int magic() default 0;
            int attack() default 0;
            int defense();
        }

        @Person2(live = 100, strength = 10, magic = 5, attack = 20, defense = 20)
        class Elf {
        }

        @Person2(live = 1000, strength = 150, magic = 250, attack = 99, defense = 99)
        class EvilMaster {
        }

        // get the class literal, iterate over its fields with the method Class.getDeclaredFields
        // and get annotation values for its fields with the method Field.getAnnotation

        public static Set<Field> findFields(Class<?> cls, Class<? extends Annotation> ann) {
            Set<Field> set = new HashSet<>();
            Class<?> c = cls;
            while (c != null) {
                for (Field field : c.getDeclaredFields()) {
                    if (field.isAnnotationPresent(ann)) {
                        set.add(field);
                    }
                }
                c = c.getSuperclass();
            }
            return set;
        }

        public static void main(String[] args) {
            Date date = new Date();
            int year = date.getYear();               //   'getYear()' is deprecated from 'java.util.Date'
            YearMonth ym = YearMonth.now();          //   its good method from 'java.time' package
        }
    }

