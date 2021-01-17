import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaClassesObjects {

    public static class Hellower {

        // write overloaded methods with one parameter: one method of primitive type and another method of reference type
        public void sayHi(int num) {
            System.out.println("Добрый вечер, посетитель № " + num + ", как дела?");
        }

        // write overloaded methods with one parameter: of different reference types
        public void sayHi(Integer num) {
            System.out.println("Добрый вечер, ссылочный посетитель № " + num + ", как дела?");
        }

        public void sayHi(Cat cat) {
            System.out.println("Добрый вечер, котик " + cat);
        }

        // write overloaded methods with one parameter: of different reference types (when one type is a subtype of another)

        public void sayHi(BlackCat cat) {
            System.out.println("Добрый вечер, черный котик " + cat);
        }

        // write overloaded methods with a different number (1,2,3) of parameters of the same type

        public void sayHi(String name) {
            System.out.println("Добрый вечер, " + name + ", как ваши дела?");
        }

        public void sayHi(String name1, String name2) {
            System.out.println("Добрый вечер, " + name1 + ", " + name2 + ", как ваши дела?");
        }

        public void sayHi(String name1, String name2, String name3) {
            System.out.println("Добрый вечер, " + name1 + ", " + name2 + ", " + name3 + ", как ваши дела?");
        }

        //  write method with var-args parameter

        public void sayHi(String... names) {
            for (String name : names) {
                System.out.println("Добрый вечер, " + name + ", как ваши дела?");
            }
        }

        //  show that’s impossible to have methods that differ only by return type (screenshot)

//        public int Sum(int s1, int s2) {
//            return s1 + s2;
//        }
//
//        public long Sum(int s1, int s2) {
//            return s1 + s2;
//        }
//
//        //  show that’s impossible to have methods that differ only by thrown checked exceptions (screenshot)

//        public void textFile(String path) throws IOException {
//            String filePath = "hello.txt";
//            String text = "Hello World";
//
//            try {
//                FileWriter writer = new FileWriter(path, true);
//                writer.write(text);
//                writer.close();
//            } catch (IOException ex) {
//                System.err.println("Error creating file: " + ex);
//            }
//        }
//
//        public void textFile(String path) throws IOException, NumberFormatException {
//            String filePath = "hello.txt";
//            char[] buf = new char[255];
//            int i;
//            FileReader reader = new FileReader(path);
//
//            try {
//                reader.read(buf);
//                reader.close();
//            } catch (IOException ex) {
//                System.err.println("Error reading file: " + ex);
//            }
//
//            try {
//                i = Integer.parseInt(String.valueOf(buf[1]));
//            } catch (NumberFormatException ex){
//                System.out.println("Error converting file!");
//            }
//
//        }

        public double Div(double x1, double x2) throws FileNotFoundException {
            double y;
            try {
                y = x1 / x2;
            }
            catch (NumberFormatException e) {
                throw new FileNotFoundException("Divide by zero!");
            }
            return y;
        }

    }

        public static class TimeMachine {

            public void goToFuture(int currentYear) {
                currentYear = currentYear + 10;
            }

            public void goToPast(int currentYear) {
                currentYear = currentYear - 10;
            }

            public void goToFuture(Cat cat) {
                cat.age += 10;
            }

            public void goToPast(Cat cat) {
                cat.age -= 10;
            }
        }

        public static class Cat {
            int age;
            public Cat(int age) {
                this.age = age;
            }

            public Cat() {

            }
        }

        public static class BlackCat extends Cat {
            private final String color = "BLACK";

            public BlackCat(int age) {
                super(age);
            }

            public BlackCat() {
                super();
            }
        }

    public static void main(String[] args) {

        Hellower hello = new Hellower();
        hello.sayHi(7);                          //  outputs 'Добрый вечер, посетитель № 7, как дела?'
        hello.sayHi("Alex");                          //  outputs 'Добрый вечер, Alex, как ваши дела?'
        hello.sayHi((Integer) null);                  //  outputs 'Добрый вечер, null, как ваши дела?'
        hello.sayHi("Valera", "Petya");               //  outputs 'Добрый вечер, Valera, Petya, как ваши дела?'
        hello.sayHi("Fedor", "Vasilii","Denis");      //  outputs 'Добрый вечер, Fedor, Vasilii, Denis, как ваши дела?'

        //  show that primitive method arguments are passed by value

        TimeMachine timeMachine = new TimeMachine();
        int currentYear = 2021;

        System.out.println("Какой сейчас год?");
        System.out.println(currentYear);              //  outputs '2021'
        timeMachine.goToPast(currentYear);
        System.out.println("А сейчас?");
        System.out.println(currentYear);             //  outputs '2021'
        timeMachine.goToFuture(currentYear);
        System.out.println("А сейчас?");
        System.out.println(currentYear);             //  outputs '2021'

        //  show that reference method arguments are passed by references that are passed by value

        Cat barsik = new Cat(5);

        System.out.println("Сколько лет Барсику?");
        System.out.println(barsik.age);                         //  outputs '5'

        timeMachine.goToFuture(barsik);
        System.out.println("А теперь?");
        System.out.println(barsik.age);                        //  outputs '15'

        System.out.println("Барсик постарел на 10 лет!");
        timeMachine.goToPast(barsik);
        System.out.println("Вернули изначальный возраст:");
        System.out.println(barsik.age);                        //  outputs '5'

        Cat cat = new BlackCat();
        hello.sayHi(cat);              //   outputs 'Добрый вечер, котик JavaClassesObjects$BlackCat@179d3b25'


    }
}
