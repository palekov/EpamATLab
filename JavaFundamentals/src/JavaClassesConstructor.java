import java.util.Objects;

public class JavaClassesConstructor
{
    //  write a class with no-arg constructor
    static class Animal {
        public Animal() {
        }
    }

    //  show that no-arg constructor is created implicitly if a class contains no constructor declarations
    static class Human {
    }

    // ---
    static class Robot {
        private int id;
        private char type;
        private String model;

        //  call from one constructor another constructor of the same class
        Robot() {
            this(1, 'A', "BASE");
        }

        Robot(int id) {
            this.id = id;
        }

        //   write overloaded constructors

        Robot(int id, char type) {
            this.id = id;
            this.type = type;
        }

        Robot(int id, char type, String model) {
            this.id = id;
            this.type = type;
            this.model = model;
        }

        //  generate the equals and hashCode methods in IntelliJ IDEA by Alt-Insert shortcut (screenshots)
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Robot robot = (Robot) o;
            return id == robot.id && type == robot.type && model.equals(robot.model);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, type, model);
        }
    }

    //  show that no-arg constructor of subclass implicitly calls no-arg constructor of superclass
    static class A
    {
        A()
        {
            System.out.println("Inside A constructor.");
        }
    }

    static class B extends A
    {
        B()
        {
            System.out.println("Inside B constructor.");
        }
    }

    // write a class with a copy constructor
    static class Employee {
        private int id;
        private String name;

        Employee(Employee employee) {
            this.id = employee.id;
            this.name = employee.name;
        }
    }

    // create an object that writes messages to console in a constructor, instance and static initialization blocks;
    // create the object twice and show the object initialization order
    static class Initialization
    {
        int i = 10;
        float z = 100;
        {
            System.out.println("This is a instance block:");
            System.out.println("i=" + i);
            System.out.println("z=" + z);
        }
        static int num = 1;
        static int x;
        static float y;
        static
        {
            x = 2000;
            y = 3.141f;
            System.out.println("This is a static block:");
            System.out.println("x=" + x);
            System.out.println("y=" + y);
        }

        Initialization() {
           System.out.println("This is constructor № " + num);
           System.out.println();
           num++;
        }
    }

    public static void main(String[] args) {
        Animal cat = new Animal();
        //  show that no-arg constructor is created implicitly if a class contains no constructor declarations
        Human men = new Human();

        Robot rob = new Robot(44);

        //  show that no-arg constructor of subclass implicitly calls no-arg constructor of superclass
        B be = new B();             //  outputs 'Inside A constructor.'
                                    //          'Inside B constructor.'
        Initialization init1 = new Initialization();
        Initialization init2 = new Initialization();
    }
}
