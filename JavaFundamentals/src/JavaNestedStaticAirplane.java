
public class JavaNestedStaticAirplane {
    private String name, flight;
    private int id;
    long distance;
    static short num;

    JavaNestedStaticAirplane pl = new JavaNestedStaticAirplane();

    //   create an instance of static nested class
    private Wing leftWing = new Wing(pl, "Green", "Z"), rightWing = new Wing(pl, "Green", "Z");

    public JavaNestedStaticAirplane(String name, String flight, int id) {
        this.name = name;
        this.id = id;
        this.flight = flight;
    }

    public JavaNestedStaticAirplane() {
    }

    // write a static nested class
    // show that static nested class can have static and instance fields/methods

    static class Wing {
        private String color, model;
        static int id;
        int speed;

        JavaNestedStaticAirplane plane;

        //   show that static nested class has access to private fields/methods of the enclosing class
        //   show that static nested class has access only to static fields/methods of the enclosing class

        private Wing(JavaNestedStaticAirplane plane, String color, String model) {

            plane.name = "111C";
            plane.id = 999;
            plane.flight = "Airbus";
            plane.num = 57;

            this.plane = plane;
            this.color = color;
            this.model = model;
        }
    }

    //   show that static nested class can be private, package-private, protected, public

    private static class Rudder {
        private String type;
    }

    static class Chassis {
        String type;
    }

    protected static class PilotCabin {
    }

    public static class Fuselage {
        int id;
    }

    //   show that static nested class has access only to static fields/methods of the enclosing class


}

