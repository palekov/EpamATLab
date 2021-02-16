package classes;

public class JavaClassesStatic {

    public static final int FINAL_INT = 100;
    public static final String FINAL_WORD = "This is a final!";

    public static void main(String[] args) {

        // show, that’s impossible to change the value of a public static final field of primitive type (screenshot)
        // show, that’s impossible to change a reference to a public static final field of a reference type (screenshot),
        // but it’s possible to change the value of a non-immutable object itself

//        FINAL_INT = 125;
//        FINAL_WORD = "New final!";

        final int[] array = { 1,2,3,4,5 };
        array[0] = 9;

        //  show difference in using static and instance initialization blocks
        //  show difference in using static and instance fields
        //  show difference in using static and instance methods

        JavaClassesCar orangeCar = new JavaClassesCar();
        JavaClassesCar blueCar = new JavaClassesCar();
        //  using non-static fields
        orangeCar.km = 100;
        blueCar.km = 85;

        System.out.println("Orange car - " + orangeCar.km);        //  outputs  '100'
        System.out.println("Blue car - " + blueCar.km);            //  outputs  '85'
        //classes.JavaClassesCar.carCounter();          // Non-static method 'carCounter()' cannot be referenced from a static context
        System.out.println();

        //  using static fields
        System.out.println("Orange car static init - " + orangeCar.miles);     //  outputs '40'
        System.out.println("Blue car static init - " + blueCar.miles);         //  outputs '40'

        orangeCar.miles = 100;
        blueCar.miles = 85;

        System.out.println("Orange car static miles- " + orangeCar.miles);     //  outputs '85'
        JavaClassesCar.staticCarCounter();                                     //  outputs 'Статических машин: 1'
        System.out.println("Blue car static miles - " + blueCar.miles);        //  outputs '85'
        JavaClassesCar.staticCarCounter();                                     //  outputs 'Статических машин: 2'
    }
}
