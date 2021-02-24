package module012;

//  Домашние электроприборы. Определить иерархию электроприборов. Включить некоторые в розетку.
//  Посчитать потребляемую мощность. Провести сортировку приборов в квартире на основе одного из параметров.
//  Найти прибор в квартире, соответствующий заданному диапазону параметров.

import java.util.ArrayList;
import java.util.Collections;

public class HomeElectricalDevices {

    public static void main(String[] args) {

        ArrayList devices = new ArrayList<ElectricalDevice>();

        ElectricalDevice mixer = new Mixer("Tornado","blue", 1500);
        ElectricalDevice iron = new Flatiron("Aresa", "green", 2300);
        ElectricalDevice radio = new Radio("Rocks", "black", 15);
        ElectricalDevice tvset = new Television("Samsung", "white", 60);
        ElectricalDevice microwave = new Microwave("LG", "gray", 2000);
        ElectricalDevice foodproc = new FoodProcessor("Indesit", "white", 1200);
        ElectricalDevice torchere = new Torchere("Flatter", "brown", 25);

        tvset.setInserted();
        microwave.setInserted();
        torchere.setInserted();

        devices.add(mixer);
        devices.add(iron);
        devices.add(radio);
        devices.add(tvset);
        devices.add(microwave);
        devices.add(foodproc);
        devices.add(torchere);

        Collections.sort(devices, new ElectricalDevice.Sortbypower());
        System.out.println("Devices sorted by power: ");

        for (Object device : devices) {
            System.out.println(device);
        }

        ElectricalDevice dev;
        int powerConsumption = 0;
        for (int i = 0; i < devices.size(); i++) {
            dev = (ElectricalDevice) devices.get(i);
            if(dev.isInserted()) powerConsumption += dev.getPower();
        }
        System.out.println("Power consumption = " + powerConsumption + " watt");

        String searchColor = "white";
        int searchPowerMin = 1000;
        int searchPowerMax = 2000;

        for (int i = 0; i < devices.size(); i++) {
            dev = (ElectricalDevice) devices.get(i);
            if(dev.getColor().equals(searchColor))
                if (dev.getPower() >= searchPowerMin & dev.getPower() <= searchPowerMax)
                    System.out.println("Searched device is: " + dev);
        }
    }
}
