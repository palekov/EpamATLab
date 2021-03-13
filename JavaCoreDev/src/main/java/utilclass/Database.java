package main.java.utilclass;

import main.java.ElectricalDevice;
import main.java.classes.*;

import java.lang.reflect.Field;
import java.sql.*;

public class Database {
    // JDBC driver name and database URL
    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    // Database credentials
    final static String USER = "root";
    final static String PASS = "9QZjFWKtPg-170_ol";

    public static void saveToBase(House house) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            createDevicesTable(conn, house);
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            assert conn != null;
            conn.close();
        }
    }

    public static void createDevicesTable(Connection conn, House house) throws SQLException {
        System.out.println("Creating table in given database...");
        Statement stmt = conn.createStatement();
        String sql;
        sql = "DROP TABLE Devices";
        stmt.executeUpdate(sql);
        sql = "CREATE TABLE Devices " +
                "(id INTEGER not NULL, " +
                " type VARCHAR(255), " +
                " model VARCHAR(255), " +
                " color VARCHAR(255), " +
                " power INTEGER, " +
                " mode INTEGER, " +
                " program VARCHAR(255), " +
                " time INTEGER, " +
                " volume INTEGER, " +
                " channel FLOAT, " +
                " PRIMARY KEY ( id ))";
        stmt.executeUpdate(sql);
        System.out.println("Creating table in given database...");
        System.out.println(sql);
        System.out.println("Inserting records into the table...");
        stmt = conn.createStatement();
        ElectricalDevice dev;
        int i = 0;
        for (Object device : house.devices) {
            dev = (ElectricalDevice) device;
            sql = "INSERT INTO Devices VALUES (" + i + ", '" + device.getClass().getSimpleName() + "', '" + dev.getModel()
                    + "', '" + dev.getColor() + "', " + dev.getPower() + " ," + dev.getMode() + " , '" + dev.getProgram()
                    + "' ," + dev.getTime() + " ," + dev.getVolume()  + " ," + dev.getChannel() + ")";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            i++;
        }
        System.out.println("Successfully Inserted records into the table...");
        System.out.println();
    }

    public static void loadFromBase(House house) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            loadDevicesTable(conn, house);
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            assert conn != null;
            conn.close();
        }
    }

    public static void loadDevicesTable(Connection conn, House house) throws SQLException, ClassNotFoundException {
        System.out.println("Loading devices from database...");
        Statement stmt = conn.createStatement();
        String sql;
        sql = "SELECT id, type, model, color, power, mode, program, time, volume, channel FROM Devices";
        ResultSet rs = stmt.executeQuery(sql);
        ElectricalDevice dev = null;
        int id, power, mode, volume, time;
        float channel;
        String type, model, color, program;
        // Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            id = rs.getInt("id");
            type = rs.getString("type");
            model = rs.getString("model");
            color = rs.getString("color");
            power = rs.getInt("power");
            mode = rs.getInt("mode");
            program = rs.getString("program");
            time = rs.getInt("time");
            volume = rs.getInt("volume");
            channel = rs.getFloat("channel");

            switch (type) {
                case "Mixer":
                    dev = new Mixer(model, color, power, mode);
                    break;
                case "Radio":
                    dev = new Radio(model, color, power, volume, channel);
                    break;
                case "Television":
                    dev = new Television(model, color, power, volume, channel);
                    break;
                case "Torchere":
                    dev = new Torchere(model, color, power);
                    break;
                case "Microwave":
                    dev = new Microwave(model, color, power, program, time);
                    break;
                case "FoodProcessor":
                    dev = new FoodProcessor(model, color, power, program, time);
                    break;
                case "Flatiron":
                    dev = new Flatiron(model, color, power, mode);
                    break;
                default:
                    System.out.println("incorrect data type: " + type);
                    return;
            }
            System.out.print("Loading data: " + id + " ");
            house.devices.add(dev);
            System.out.println(dev);
        }
        System.out.println();
    }
}
