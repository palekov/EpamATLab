package main.java.utilclass;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.ElectricalDevice;
import main.java.classes.House;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Filework {
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

    public static void loadFromJson(String path) {
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
}
