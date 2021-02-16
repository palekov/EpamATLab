package inheritance;

import java.io.FileNotFoundException;
import java.io.IOException;

public class JavaInheritanceSuper {

    int num = 220;

    private String flavour;

    public JavaInheritanceSuper(String flavour) {
            // super class constructor
            this.flavour = flavour;
        }

    public JavaInheritanceSuper() {
            //  default constructor
        System.out.println("this is a superclass constructor!");
    }

    public static void staticMethodSuper () {
        System.out.println("static method from superclass!");
    }

    public void instanceMethodSuper() {
        System.out.println("instance method from superclass!");
    }

    public void exceptionMethodSuper(String file) throws FileNotFoundException {
    }

    public void printNum () {
        System.out.println(this.num * 4);
    }
}

