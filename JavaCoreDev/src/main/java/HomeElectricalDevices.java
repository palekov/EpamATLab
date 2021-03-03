package main.java;

//  Домашние электроприборы. Определить иерархию электроприборов. Включить некоторые в розетку.
//  Посчитать потребляемую мощность. Провести сортировку приборов в квартире на основе одного из параметров.
//  Найти прибор в квартире, соответствующий заданному диапазону параметров.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import main.java.classes.*;
import main.java.exceptions.NoDeleteException;

public class HomeElectricalDevices {

    public static boolean addDevice(List<ElectricalDevice> list) {

        ElectricalDevice dev;

        System.out.println("--- Добавление прибора ---");
        System.out.println("Введите тип прибора:");
        System.out.println("[Mixer, Radio, Television, Torchere, Microwave, FoodProcessor, Flatiron]: ");

        Scanner scan = new Scanner(System.in);
        String devType = "";
        devType = scan.nextLine();

        System.out.println("Введите марку цвет мощность: ");
        String devParam;
        devParam = scan.nextLine();
        String[] param = devParam.split(" ");

        if (param.length != 3) {
            System.out.println("Некорректный ввод!");
            return false;
        }

        int devPower;

        try {
            devPower = Integer.parseInt(param[2]);
        } catch (NumberFormatException e) {
            System.out.println("Введена некорректная мощность прибора!");
            return false;
        }

        switch (devType) {
            case "Mixer":
                dev = new Mixer(param[0], param[1], devPower);
                break;
            case "Radio":
                dev = new Radio(param[0], param[1], devPower);
                break;
            case "Television":
                dev = new Television(param[0], param[1], devPower);
                break;
            case "Torchere":
                dev = new Torchere(param[0], param[1], devPower);
                ;
                break;
            case "Microwave":
                dev = new Microwave(param[0], param[1], devPower);
                break;
            case "FoodProcessor":
                dev = new FoodProcessor(param[0], param[1], devPower);
                break;
            case "Flatiron":
                dev = new Flatiron(param[0], param[1], devPower);
                break;
            default:
                System.out.println("incorrect input! try again!");
                return false;
        }
        return true;
    }


    private static void searchDevice(ArrayList devices) {
    }

    private static void removeDevice(ArrayList devices) {
    }

    public static Object searchByModel(List<ElectricalDevice> devlist, String devmodel) {

        ElectricalDevice dev;

        for (int i = 0; i < devlist.size(); i++) {
            dev = devlist.get(i);
            if (dev.getModel().equals(devmodel))
                return dev;
        }
        return null;
    }

    public static boolean removeDevice(List<ElectricalDevice> devlist, ElectricalDevice device) throws NoDeleteException {

        if(!devlist.remove(device))
            throw new NoDeleteException("The element cannot be deleted from the collection!");
        return true;
    }

    public static void main(String[] args) {

        ArrayList devices = new ArrayList<ElectricalDevice>();

        System.out.println("--- Домашние электроприборы ---");
        System.out.println("1 - добавить прибор");
        System.out.println("2 - найти прибор");
        System.out.println("3 - удалить прибор");
        System.out.println("q - выход");
        System.out.println();
        System.out.println("Ваш выбор: ");
        Scanner scan = new Scanner(System.in);
        String str = "";
        String oper = "";

        while (!str.equals("q")) {
            str = scan.nextLine();
            if (str.equals("q")) break;

            switch (oper) {
                case "1":
                    addDevice(devices);
                    break;
                case "2":
                    searchDevice(devices);
                    break;
                case "3":
                    removeDevice(devices);
                    break;
                default:
                    System.out.println("incorrect input! try again!");
            }
        }

//        ElectricalDevice mixer = new Mixer("Tornado","blue", 1500);

//        tvset.setInserted();
//        microwave.setInserted();
//        torchere.setInserted();

        Collections.sort(devices, new ElectricalDevice.SortByPower());
        System.out.println("Devices sorted by power: ");

        for (Object device : devices) {
            System.out.println(device);
        }

        ElectricalDevice dev;
        int powerConsumption = 0;

        for (int i = 0; i < devices.size(); i++) {
            dev = (ElectricalDevice) devices.get(i);
            if (dev.isInserted()) powerConsumption += dev.getPower();
        }

        System.out.println("Power consumption = " + powerConsumption + " watt");

        String searchColor = "white";
        int searchPowerMin = 1000;
        int searchPowerMax = 2000;

        for (int i = 0; i < devices.size(); i++) {
            dev = (ElectricalDevice) devices.get(i);
            if (dev.getColor().equals(searchColor))
                if (dev.getPower() >= searchPowerMin & dev.getPower() <= searchPowerMax)
                    System.out.println("Searched device is: " + dev);
        }
    }

}
