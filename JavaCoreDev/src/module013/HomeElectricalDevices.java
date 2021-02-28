package module013;

//  необходимо реализовать классы пользовательских исключений и организовать обработку возможных исключительных ситуаций,
//  например, если элемент отсутствует в коллекции, если мы не можем удалить текущий элемент и т.д. Комментарии оставлять
//  в классах исключений. Создать минимум 3 пользовательских исключения и использовать минимум 5 встроенных исключений.

import module012.*;

import java.util.ArrayList;
import java.util.Collections;

public class HomeElectricalDevices {

    public static void main(String[] args) throws NoElementException, NoDeleteException, NegativePowerException {

        ArrayList devices = new ArrayList<ElectricalDevice>();

        ElectricalDevice mixer = new Mixer("Tornado","blue", 1500);
        ElectricalDevice iron = new Flatiron("Aresa", "green", 2300);
        ElectricalDevice radio = new Radio("Rocks", "black", 15);
        ElectricalDevice tvset = new Television("Samsung", "white", 60);
        ElectricalDevice microwave = new Microwave("LG", "gray", 2000);
        ElectricalDevice foodproc = new FoodProcessor("Indesit", "white", 1200);
        ElectricalDevice torchere = new Torchere("Flatter", "brown", 25);

        devices.add(mixer);
        devices.add(iron);
        devices.add(radio);
        devices.add(tvset);
        devices.add(microwave);
        devices.add(foodproc);
        devices.add(torchere);

        ElectricalDevice searchObject = new Torchere("Flower", "black", 15);

        // if(!devices.contains(searchObject)) throw new NoElementException("Element is absent in collection!");

        ElectricalDevice removeObject = new Radio("Raspberry", "red", 45);

        // if(!devices.remove(removeObject)) throw new NoDeleteException("The element cannot be deleted from the collection!");

        ElectricalDevice iron2 = new Flatiron("Aresa", "green", -100);

        // if( iron2.getPower() < 0 ) throw new NegativePowerException();

        try {
            devices.remove(10);
        }   catch (IndexOutOfBoundsException ex) {
            System.out.println("Alarm! IndexOutOfBoundsException!");
        }

        int pow = 0;
        try {
            pow = microwave.getPower() ;
            // pow = 1 / 0;
        } catch (ArithmeticException ex) {
            System.out.println("Division by zero!");
        } finally {
            System.out.println("Microwave power = " + pow);
        }

        for (Object device : devices) {
            System.out.println(device);
        }

    }
}
