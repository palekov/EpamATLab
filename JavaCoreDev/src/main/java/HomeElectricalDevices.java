
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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.classes.*;
import main.java.exceptions.NegativePowerException;
import main.java.exceptions.NoDeleteException;
import main.java.exceptions.NoElementException;

public class HomeElectricalDevices {

    // JDBC driver name and database URL
    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    // Database credentials
    final static String USER = "root";
    final static String PASS = "pass";

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

    private static void searchDevice(House house) throws NegativePowerException, NoElementException {

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

    private static void sortDevices(House house) {

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

    private static void sumDevices(House house) {

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

    public static void saveToTxt(String path, House house) {
        String outputFileName = path + "devices.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Object device : house.devices) {
                writer.write(device + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Successfully saved to text file!");
        System.out.println();
    }

    public static void loadFromTxt(String path, House house) {
        String inputFileName = path + "devices.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Successfully loaded from text file!");
        System.out.println();
    }

    public static void saveToBinary(String path, House house) throws IOException {

        FileOutputStream outputStream = new FileOutputStream(path + "devices.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(house.devices);
        objectOutputStream.close();
        outputStream.close();
    }

    public static void loadFromBinary(String path, House house) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path + "devices.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        house.devices = (ArrayList<ElectricalDevice>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        for (Object device : house.devices) {
            System.out.println(device);
        }
        System.out.println();
    }

    public static void saveToJson(String path, House house) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path + "devices.json"))) {
            // StringWriter writer = new StringWriter();
            ObjectMapper mapper = new ObjectMapper();
            try {
                writer.write(mapper.writeValueAsString(house));
                //mapper.writeValue(writer, house);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully saved to JSON file!");
        System.out.println();
    }

    public static void loadFromJson(String path, House house) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path + "devices.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode parser = objectMapper.readTree(reader);

            for (JsonNode pm : parser.path("devices")) {
                System.out.print(pm.path("model").asText() + " ");
                System.out.print(pm.path("color").asText() + " ");
                System.out.println(pm.path("power").asInt());
            }
            System.out.println();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToBase(House house) throws ClassNotFoundException {

        Connection conn = null;
        Statement stmt = null;
        try  {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            createDevicesTable(conn, stmt, house);

            conn.close();
        } catch(SQLException se)
        {
            se.printStackTrace();
        }
    }

    public static void createDevicesTable (Connection conn, Statement stmt, House house) throws SQLException {
        System.out.println("Creating table in given database...");
        stmt = conn.createStatement();
        String sql;
        sql = "DROP TABLE Devices";
        stmt.executeUpdate(sql);
        sql = "CREATE TABLE Devices " +
                "(id INTEGER not NULL, " +
                " type VARCHAR(255), " +
                " model VARCHAR(255), " +
                " color VARCHAR(255), " +
                " power INTEGER, " +
                " PRIMARY KEY ( id ))";
        stmt.executeUpdate(sql);
        System.out.println("Created table in given database...");
        System.out.println("Inserting records into the table...");
        stmt =conn.createStatement();
        ElectricalDevice dev;
        int i = 0;
        for (Object device : house.devices) {
            dev = (ElectricalDevice) device;
            sql ="INSERT INTO Devices VALUES (" + i + ", '" + device.getClass().getSimpleName() + "', '" + dev.getModel() + "', '"
                    + dev.getColor() + "', " + dev.getPower() + ")";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            i++;
        }
        System.out.println("Successfully Inserted records into the table...");
    }

    public static void loadFromBase(House house) throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        try  {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            loadDevicesTable(conn, stmt, house);

            conn.close();
        } catch(SQLException se)
        {
            se.printStackTrace();
        }
    }

    public static void loadDevicesTable (Connection conn, Statement stmt, House house) throws SQLException {
        System.out.println("Loading devices from database...");
        stmt = conn.createStatement();
        String sql;

        sql = "SELECT * FROM Devices";
        ResultSet rs = stmt.executeQuery(sql);
        ElectricalDevice dev;
        int id;
        String type;
        // Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            id = rs.getInt("id");
            type = rs.getString("type");
            dev = new ElectricalDevice();
            dev.setModel(rs.getString("model"));
            dev.setColor(rs.getString("color"));
            dev.setPower(rs.getInt("power"));
            house.devices.add(dev);
            System.out.print("Loading data from base: " + id + " ");
            System.out.println(dev);
        }
    }

// ---------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) throws NoDeleteException, NegativePowerException, NoElementException, IOException, ClassNotFoundException {

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
                    addDevice(house);
                    break;
                case "2":
                    searchDevice(house);
                    break;
                case "3":
                    removeDevice(house);
                    break;
                case "4":
                    sortDevices(house);
                    break;
                case "5":
                    sumDevices(house);
                    break;
                case "6":
                    saveToTxt(pth, house);
                    break;
                case "7":
                    loadFromTxt(pth, house);
                    break;
                case "8":
                    saveToBinary(pth, house);
                    break;
                case "9":
                    loadFromBinary(pth, house);
                    break;
                case "10":
                    saveToJson(pth, house);
                    break;
                case "11":
                    loadFromJson(pth, house);
                    break;
                case "12":
                    saveToBase(house);
                    break;
                case "13":
                    loadFromBase(house);
                    break;
                default:
                    System.out.println("incorrect input! try again!");
            }
        }

        System.out.println("Good bye!");

    }
}
