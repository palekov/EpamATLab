package main.java.utilclass;

import main.java.ElectricalDevice;
import main.java.classes.*;
import main.java.exceptions.NegativePowerException;
import main.java.exceptions.NoDeleteException;
import main.java.exceptions.NoElementException;

import java.util.Collections;
import java.util.Scanner;

public class Devices {
    public static void addDevice(House house) throws NegativePowerException {

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
                return;
            }
            int devPower;
            try {
                devPower = Integer.parseInt(param[2]);
            } catch (NumberFormatException e) {
                System.out.println("Введена некорректная мощность прибора!");
                return;
            }
            if (devPower < 0) throw new NegativePowerException();

            switch (devType) {
                case "mixer":
                    dev = new Mixer(param[0], param[1], devPower);
                    break;
                case "radio":
                    dev = new Radio(param[0], param[1], devPower);
                    break;
                case "tele":
                    dev = new Television(param[0], param[1], devPower);
                    break;
                case "torch":
                    dev = new Torchere(param[0], param[1], devPower);
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
                    return;
            }
            house.devices.add(dev);
            System.out.println("Добавлено: " + dev);
            System.out.println();
        }
    }

    public static void searchDevice(House house) throws NegativePowerException, NoElementException {

        System.out.println("--- Поиск прибора ---");
        System.out.println("введите марку мин.мощность макс.мощность: ");

        ElectricalDevice dev;
        String searchModel;
        int searchPowerMin = 0;
        int searchPowerMax = 0;

        String devParam;
        Scanner scan = new Scanner(System.in);
        devParam = scan.nextLine();
        String[] param = devParam.split(" ");
        searchModel = param[0];

        try {
            searchPowerMin = Integer.parseInt(param[1]);
            searchPowerMax = Integer.parseInt(param[2]);
        } catch (NumberFormatException e) {
            System.out.println("Введена некорректная мощность прибора!");
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Некорректное количество параметров!");
        }

        if (searchPowerMin < 0 || searchPowerMax < 0) throw new NegativePowerException();

        for (int i = 0; i < house.devices.size(); i++) {
            dev = (ElectricalDevice) house.devices.get(i);
            if (dev.getModel().equals(searchModel))
                if (dev.getPower() >= searchPowerMin & dev.getPower() <= searchPowerMax)
                    System.out.println("Searched device is: " + dev);
                else throw new NoElementException("Device not found!");
        }
    }

    public static void removeDevice(House house) throws NoDeleteException {
        System.out.println("--- Удаление прибора ---");
        System.out.println("введите номер записи: ");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        try {
            house.devices.remove(i);
        } catch (Exception e) {
            throw new NoDeleteException("The element cannot be deleted from the collection!");
        }
    }

    public static void sortDevices(House house) {
        Collections.sort(house.devices, new ElectricalDevice.SortByPower());
        System.out.println("Devices sorted by power: ");
        for (Object device : house.devices) {
            System.out.println(device);
        }
    }

    private static void insertDevices(House house) {
        ElectricalDevice dev;
        int rand = (int) (Math.random() * house.devices.size());
        for (int i = 0; i <= rand; i++) {
            dev = (ElectricalDevice) house.devices.get(i);
            dev.setInserted();
            System.out.println(dev + " inserted");
        }
    }

    public static void sumDevices(House house) {
        insertDevices(house);
        ElectricalDevice dev;
        int powerConsumption = 0;
        for (int i = 0; i < house.devices.size(); i++) {
            dev = (ElectricalDevice) house.devices.get(i);
            if (dev.isInserted()) {
                powerConsumption += dev.getPower();
            }
        }
        System.out.println("Power consumption = " + powerConsumption + " watt");
        System.out.println();
    }
}
