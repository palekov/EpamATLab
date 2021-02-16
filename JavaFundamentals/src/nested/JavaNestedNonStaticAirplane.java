package nested;

public class JavaNestedNonStaticAirplane {
    private String name, flight;
    private int id;
    //   create an instance of non-static nested class
    JavaNestedNonStaticAirplane pl = new JavaNestedNonStaticAirplane();
    private Wing leftWing = new Wing(pl, "Red", "X"), rightWing = new Wing(pl, "Blue", "X");

    public JavaNestedNonStaticAirplane(String name, String flight, int id) {
        this.name = name;
        this.id = id;
        this.flight = flight;
    }

    public JavaNestedNonStaticAirplane() {
    }

    //   write a non-static nested class
    //   show that non-static nested class can have only instance fields/methods

    private class Wing {
        private String color, model;
        int col;
       // static int num;   //   error - inner classes cannot have static declarations

        JavaNestedNonStaticAirplane plane;

        //   show that non-static nested class has access to private fields/methods of the enclosing class
        private Wing(JavaNestedNonStaticAirplane plane, String color, String model) {
            this.plane = plane;
            plane.name = "365B";
            plane.id = 777;
            plane.flight = "Boeing";
            this.color = color;
            this.model = model;
        }
    }

    //   show that static nested class can be private, package-private, protected, public
    private class Rudder {
        private String type;
    }

    class Chassis {
        String type;
    }

    protected class PilotCabin {
    }

    public class Fuselage {
        int id;
    }
    //   show that non-static nested class can have only instance fields/methods


}


