public class JavaInheritancePolymorph {

    //   show example of runtime polymorphism: use reference of superclass type,
    //   an object of subclass type and call overridden method

    static class Vehicle{
        public void drive(){
            System.out.println("Driving vehicle ...");
        }
    }

    static class Car extends Vehicle{
        @Override
        public void drive(){
            System.out.println("Driving car...");
        }
    }

    static class Truck extends Vehicle{
        @Override
        public void drive(){
            System.out.println("Driving truck...");
        }

        public void load(){
            System.out.println("Loading truck...");
        }
    }

        public static void main(String[] args) {
            Vehicle vehicle = new Vehicle();
            vehicle.drive();                        //  outputs 'Driving vehicle ...'

            Vehicle carVehicle = new Car();
            carVehicle.drive();                     //  outputs 'Driving car...'

            Vehicle truckVehicle = new Truck();
            truckVehicle.drive();                   //  outputs 'Driving truck...'

            //Compile time error
            //truckVehicle.load();

            Truck truck = new Truck();
            truck.load();                           //  outputs 'Loading truck...'
        }
}
