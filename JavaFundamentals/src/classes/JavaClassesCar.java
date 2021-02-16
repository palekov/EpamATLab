package classes;

public class JavaClassesCar {

    int km;

    static int miles;

    static  {
        miles = 40;
    }

    int count;
    static int st_count;

    public void carCounter() {
        count++;
        System.out.println("НЕ статических машин: " + count);
    }

    public static void staticCarCounter() {
        st_count++;
        System.out.println("Статических машин: " + st_count);
    }
}
