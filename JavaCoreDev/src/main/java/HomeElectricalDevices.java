
package main.java;

//  Module 1.2

//  Домашние электроприборы. Определить иерархию электроприборов. Включить некоторые в розетку.
//  Посчитать потребляемую мощность. Провести сортировку приборов в квартире на основе одного из параметров.
//  Найти прибор в квартире, соответствующий заданному диапазону параметров.

//  Module 1.3

//  необходимо реализовать классы пользовательских исключений и организовать обработку возможных исключительных ситуаций,
//  например, если элемент отсутствует в коллекции, если мы не можем удалить текущий элемент и т.д. Комментарии оставлять
//  в классах исключений. Создать минимум 3 пользовательских исключения и использовать минимум 5 встроенных исключений.

//  добавить чтение и запись данных из следующих источников:
//    1. из текстового файла
//    2. из бинарного файла (используя сериализацию и десериализацию)

//  Module 1.4

//  Add data reading from the following sources (choose one of the alternatives below):
//    1. XML File using de\serialization
//    2. JSON File using de\serialization.

//  Add data reading from a database. Process different kinds of requests as SELECT, DELETE, UPDATE, INSERT.
//  Preparation:
//  • You can use MySQL or SQLSERVER database.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import main.java.classes.*;
import main.java.exceptions.NoDeleteException;

public class HomeElectricalDevices {

    public static boolean addDevice(List<ElectricalDevice> list) {

        ElectricalDevice dev;
        Scanner scan = new Scanner(System.in);

        System.out.println("--- Добавление прибора ---");

        String devType = "";

        while (!devType.equals("q")) {

            System.out.println("Введите тип прибора:");
            System.out.println("[mixer, radio, tele, torch, microwave, foodproc, iron]  или 'q' для выхода: ");

            devType = scan.nextLine();

            if (devType.equals("q")) break;

            System.out.println("Введите марку цвет мощность: ");
            String devParam;
            devParam = scan.nextLine();

            if (devParam.equals("q")) break;

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
                case "mixer":
                    dev = new Mixer(param[0], param[1], devPower);
                    break;
                case "radio":
                    dev = new Radio(param[0], param[1], devPower);
                    break;
                case "television":
                    dev = new Television(param[0], param[1], devPower);
                    break;
                case "torch":
                    dev = new Torchere(param[0], param[1], devPower);
                    ;
                    break;
                case "microwave":
                    dev = new Microwave(param[0], param[1], devPower);
                    break;
                case "foodproc":
                    dev = new FoodProcessor(param[0], param[1], devPower);
                    break;
                case "iron":
                    dev = new Flatiron(param[0], param[1], devPower);
                    break;
                default:
                    System.out.println("incorrect input! try again!");
                    return false;
            }
            list.add(dev);
            System.out.println("Добавлено: " + dev);
            System.out.println();
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

        Scanner scan = new Scanner(System.in);
        String str = "";

        while (!str.equals("q")) {

            System.out.println("--- Домашние электроприборы ---");
            System.out.println("1 - добавить прибор");
            System.out.println("2 - найти прибор");
            System.out.println("3 - удалить прибор");
            System.out.println("q - выход");
            System.out.println();
            System.out.println("Ваш выбор: ");

            str = scan.nextLine();
            if (str.equals("q")) break;

            switch (str) {
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
