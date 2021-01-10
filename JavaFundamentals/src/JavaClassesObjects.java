public class JavaClassesObjects {

    public static class Hellower {
        // write overloaded methods with one parameter: one method of primitive type and another method of reference type

        public void sayHi(int num) {
            System.out.println("Добрый вечер, посетитель № " + num + ", как дела?");
        }

        public void sayHi(Integer num) {
            System.out.println("Добрый вечер, ссылочный посетитель № " + num + ", как дела?");
        }

        // write overloaded methods with one parameter: of different reference types

        //  -----

        // write overloaded methods with one parameter: of different reference types (when one type is a subtype of another)

        //  -----

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
        //  show that’s impossible to have methods that differ only by thrown checked exceptions (screenshot)

        // ----------

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
        }

    public static void main(String[] args) {

        Hellower hello = new Hellower();
        hello.sayHi(7);                          //  outputs 'Добрый вечер, посетитель № 7, как дела?'
        hello.sayHi("Alex");                    //  outputs 'Добрый вечер, Alex, как ваши дела?'
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



    }
}
