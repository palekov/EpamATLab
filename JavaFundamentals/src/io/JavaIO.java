package io;

import java.io.*;
import java.util.Scanner;

public class JavaIO {

    public static void main(String[] args) throws IOException {

        String pth = "/media/sashkus/Workshop/EpamATLab/JavaFundamentals/temp/";

        File file = new File(pth + "test.txt");

        //  use FileOutputStream to write bytes to file
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String greetings = "Hello! This is a sample of test file for using with java io methods!";
        fileOutputStream.write(greetings.getBytes());
        fileOutputStream.close();

        //  use FileInputStream to read bytes from file
        FileInputStream fileInputStream = new FileInputStream(pth + "test.txt");
        int i;
        while ((i = fileInputStream.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println();

        //  use BufferedOutputStream and BufferedInputStream
        FileInputStream fileInputStream2 = new FileInputStream(pth + "test.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream2, 200);
        i = 0;
        while ((i = bufferedInputStream.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println();

        //  use try-catch-finally statement and try-with-resources statement with I/O streams
        String path = pth + "test.txt";
        FileOutputStream output = new FileOutputStream(path);
        try {
            output = new FileOutputStream(path);
            output.write(100);
            output.write(222);
            output.write(333);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null)
                output.close();
        }

        //  use FileWriter to write string to file
        //  use FileReader to read string from file

//        FileReader reader = new FileReader(pth + "test.txt");
//        FileWriter writer = new FileWriter(pth + "text.txt");

        File new_file = new File(pth + "text.txt");

        // Создание файла
        new_file.createNewFile();

        // Создание объекта FileWriter
        FileWriter writer = new FileWriter(new_file);

        // Запись содержимого в файл
        writer.write("Это простой пример,\n в котором мы осуществляем\n с помощью языка Java\n запись в файл\n и чтение из файла\n");
        writer.flush();
        writer.close();

        // Создание объекта FileReader
        FileReader fr = new FileReader(new_file);
        char [] v = new char[200];   // Количество символов, которое будем считывать
        fr.read(v);   // Чтение содержимого в массив

        for(char c : v)
            System.out.print(c);   // Вывод символов один за другими
        fr.close();

        //  use BufferedWriter and BufferedReader

        String outputFileName = pth + "buffile.txt";
        String[] array = {"one ", "two ", "three ", "four"};
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String value : array) {
                writter.write(value + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputFileName = pth + "buffile.txt";
        try (BufferedReader reader3 = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader3.readLine()) != null) {
                System.out.println(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  use System.out, System.err
        System.out.println("out");
        System.err.println("err");

        //  use System.in
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a and b:");
        int a = console.nextInt();
        int b = console.nextInt();
        System.out.println(a + b);

        //  use DataOutputStream and DataInputStream
        FileOutputStream fs = new FileOutputStream(pth + "data.bin");
        DataOutputStream ds = new DataOutputStream(fs);
        ds.writeDouble(5.85);
        ds.writeInt(2000);
        ds.writeChar('Z');
        fs.close();

        double doubleData;
        int intData;
        char charData;

        FileInputStream fs2 = new FileInputStream(pth + "data.bin");
        DataInputStream ds2 = new DataInputStream(fs2);
        doubleData = ds2.readDouble();
        intData = ds2.readInt();
        charData = ds2.readChar();
        ds2.close();
        System.out.println("doubleData = " + doubleData);
        System.out.println("intData = " + intData);
        System.out.println("charData = " + charData);

    }
}
