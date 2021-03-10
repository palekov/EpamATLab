package main.java.utilclass;

import main.java.ElectricalDevice;
import main.java.classes.House;

import java.sql.*;

public class Database {
    // JDBC driver name and database URL
    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    // Database credentials
    final static String USER = "root";
    final static String PASS = "pass";

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

    public static void loadDevicesTable(Connection conn, House house) throws SQLException {
        System.out.println("Loading devices from database...");
        Statement stmt = conn.createStatement();
        String sql;
        sql = "SELECT id, type, model, color, power FROM Devices";
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
}
