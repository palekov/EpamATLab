
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

import java.io.*;
import java.sql.*;
import java.util.Scanner;

import main.java.classes.*;
import main.java.exceptions.NegativePowerException;
import main.java.exceptions.NoDeleteException;
import main.java.exceptions.NoElementException;

import main.java.utilclass.Database;
import main.java.utilclass.Devices;
import main.java.utilclass.Filework;

public class HomeElectricalDevices {

    public static void main(String[] args) throws NoDeleteException, NegativePowerException,
            NoElementException, IOException, ClassNotFoundException, SQLException {

        final String pth = "src/main/resources/";

        House house = new House();

        Scanner scan = new Scanner(System.in);
        String str = "";

        while (!str.equals("q")) {
            System.out.println("--- Домашние электроприборы ---");
            System.out.println("    1 - добавить прибор");
            System.out.println("    2 - найти прибор");
            System.out.println("    3 - удалить прибор");
            System.out.println("    4 - сортировка");
            System.out.println("    5 - подсчет мощности");
            System.out.println("    6 - сохранить в txt файл");
            System.out.println("    7 - загрузить из txt файла");
            System.out.println("    8 - сохранить в bin файл");
            System.out.println("    9 - загрузить из bin файла");
            System.out.println("    10 - сохранить в Json");
            System.out.println("    11 - загрузить из Json");
            System.out.println("    12 - сохранить в Базу данных");
            System.out.println("    13 - загрузить из Базы данных");
            System.out.println("    q - выход");
            System.out.println();
            System.out.println("Ваш выбор: ");

            str = scan.nextLine();
            if (str.equals("q")) break;

            switch (str) {
                case "1":
                    Devices.addDevice(house);
                    break;
                case "2":
                    Devices.searchDevice(house);
                    break;
                case "3":
                    Devices.removeDevice(house);
                    break;
                case "4":
                    Devices.sortDevices(house);
                    break;
                case "5":
                    Devices.sumDevices(house);
                    break;
                case "6":
                    Filework.saveToTxt(pth, house);
                    break;
                case "7":
                    Filework.loadFromTxt(pth, house);
                    break;
                case "8":
                    Filework.saveToBinary(pth, house);
                    break;
                case "9":
                    Filework.loadFromBinary(pth, house);
                    break;
                case "10":
                    Filework.saveToJson(pth, house);
                    break;
                case "11":
                    Filework.loadFromJson(pth);
                    break;
                case "12":
                    Database.saveToBase(house);
                    break;
                case "13":
                    Database.loadFromBase(house);
                    break;
                default:
                    System.out.println("incorrect input! try again!");
            }
        }
        System.out.println("Good bye!");
    }
}
