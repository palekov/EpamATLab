package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

public class JavaIONIO {

    public static void main(String[] args) throws IOException {

        String pth = "/media/sashkus/Workshop/EpamATLab/JavaFundamentals/temp/";

        //  use RandomAccessFile
        String s = "I was here!\n";
        byte data[] = s.getBytes();
        ByteBuffer out = ByteBuffer.wrap(data);
        ByteBuffer copy = ByteBuffer.allocate(12);
        Path p1 = Paths.get(pth + "text.txt");

        //  use FileChannel to write and read files
        try (FileChannel fc = (FileChannel.open(p1, READ, WRITE))) {
            // Читаем первые 12 байт из файла
            int nread;
            do {
                nread = fc.read(copy);
            } while (nread != -1 && copy.hasRemaining());

            // Пишем "I was here!" в начало файла
            fc.position(0);
            while (out.hasRemaining())
                fc.write(out);
            out.rewind();

            // Перемещаемся в конец файла. Копируем первые 12 байт в
            // конец файла.  Пишем "I was here!" снова.
            long length = fc.size();
            fc.position(length - 1);
            copy.flip();
            while (copy.hasRemaining())
                fc.write(copy);
            while (out.hasRemaining())
                fc.write(out);
        } catch (IOException x) {
            System.out.println("I/O Exception: " + x);
        }

        //  create temporary File from File.createTempFile and use its methods getAbsolutePath, deleteOnExit
        try {
            File tmpFile = File.createTempFile("text", ".temp", new File(pth));
            System.out.println(tmpFile.getAbsolutePath());
            //  outputs '/media/sashkus/Workshop/EpamATLab/JavaFundamentals/temp/text6620071441901665926.temp'
            tmpFile.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  create temporary Path from Files.createTempFile use its methods toString, delete
        try {
            Path temp = Files.createTempFile("hello", ".file");
            System.out.println("Temp path : " + temp);
            //  outputs 'Temp path : /tmp/hello16341079600651510009.file'
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  use Files.newOutputStream and Files.newInputStream
        //  use Files.newBufferedWriter and Files.newBufferedReader (set Charset explicitly)

        Path filePath1 = Paths.get(pth + "a.txt");
        Path filePath2 = Paths.get(pth + "b.txt");

        OutputStream os = Files.newOutputStream(filePath1);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        BufferedWriter writer = Files.newBufferedWriter(filePath2, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        InputStream is = Files.newInputStream(filePath1);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        BufferedReader reader = Files.newBufferedReader(filePath2, StandardCharsets.UTF_8);

        //  use File.getPath, File.getAbsolutePath, File.getCanonicalPath
        File f = new File("temp/.././a.txt");
        System.out.println(f.getPath());                //  outputs 'temp/.././a.txt'
        System.out.println(f.getAbsolutePath());        //  outputs '/media/sashkus/Workshop/EpamATLab/JavaFundamentals/temp/.././a.txt'
        try {
            System.out.println(f.getCanonicalPath());   //  outputs '/media/sashkus/Workshop/EpamATLab/JavaFundamentals/a.txt'
        }
        catch(Exception e) {}

        //  use File.mkdir, File.mkdirs to create directory/directories
        File  fi = new File(pth + "non_existing_dir/someDir");
        System.out.println(fi.mkdir());     //  outputs 'false'
        System.out.println(fi.mkdirs());    //  outputs 'true'
        fi = new File("someDir");
        System.out.println(fi.mkdir());     //  outputs 'true'

        //  use Files.createDirectory, Files.createDirectories to create directory/directories
        //  use File.renameTo to rename file/directory
        //  use Files.move to rename file/directory

        //  use File.delete to delete file/directory (empty directory only)
        //  use Files.delete to delete file/directory (empty directory only)

        //  use File.exists, File.isDirectory to check existence of file/directory
        //  use Files.exists, Files.isDirectory to check existence of file/directory

        //  создание файла
        Path testFile1 = Files.createFile(Paths.get(pth +"testFile111.txt"));
        System.out.println("Был ли файл успешно создан?");
        System.out.println(Files.exists(Paths.get(pth +"testFile111.txt")));

        //  создание директории
        Path testDirectory = Files.createDirectory(Paths.get(pth + "/testDirectory"));
        System.out.println("Была ли директория успешно создана?");
        System.out.println(Files.exists(Paths.get(pth + "/testDirectory")));

        //  перемещаем файл в директорию testDirectory
        testFile1 = Files.move(testFile1, Paths.get(pth + "/testDirectory/testFile111.txt"), REPLACE_EXISTING);

        System.out.println("Остался ли наш файл на месте?");
        System.out.println(Files.exists(Paths.get(pth + "testFile111.txt")));

        System.out.println("Был ли наш файл перемещен в testDirectory?");
        System.out.println(Files.exists(Paths.get(pth + "/testDirectory/testFile111.txt")));

        //  удаление файла
        Files.delete(testFile1);
        System.out.println("Файл все еще существует?");
        System.out.println(Files.exists(Paths.get(pth + "/testDirectory/testFile111.txt")));

        //  use File.listFiles to list files/directories recursively
        File folder = new File(pth);
        for (File file : folder.listFiles())
        {
            System.out.println(file.getName());
        }

        //  use Files.walkFileTree to list files/directories recursively



        //  use Files.write to write a list of strings to file
        Path filePath = Paths.get(pth + "b.txt");
        List<String> lines = new ArrayList<>();
        lines.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        lines.add("Aliquam sit amet justo nec leo euismod porttitor.");
        lines.add("Vestibulum id sagittis nulla, eu posuere sem.");
        lines.add("Cras commodo, massa sed semper elementum, ligula orci malesuada tortor, sed iaculis ligula ligula et ipsum.");
        try {
            Files.write(filePath, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //  use Files.readAllLines to read a list of strings from file
        if (Files.exists(filePath)) {
            try {
                List<String> read_lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
                for (String line : read_lines) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
