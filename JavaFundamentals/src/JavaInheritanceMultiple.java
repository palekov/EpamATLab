public class JavaInheritanceMultiple {

    //   show multiple inheritance of type in a subclass by extending
    //   from one superclass and implementing multiple interfaces

    //   show multiple inheritance of implementation (Java 8+) in a subclass by implementing multiple interfaces

    interface Suzuki
    {
        public abstract void body();
    }

    interface Ford
    {
        public abstract void engine();
    }

    public static class Car {
    }

    public static class MotorCar extends Car implements Suzuki, Ford
    {
        public void body()
        {
            System.out.println("Fit Suzuki body");
        }
        public void engine()
        {
            System.out.println("Fit Ford engine");
        }
        public static void main(String args[])
        {
            MotorCar mc1 = new MotorCar();
            mc1.body();                     //  outputs 'Fit Suzuki body'
            mc1.engine();                   //  outputs 'Fit Ford engine'
        }
    }
}
