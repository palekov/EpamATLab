package io;

import java.io.*;
import java.util.Arrays;

//  write class that implements Serializable, use the serialVersionUID constant and the transient keyword
//  use ObjectOutputStream and ObjectInputStream

public class JavaIOSerial implements Serializable {
    private static final long serialVersionUID = 1001L;

    private String[] territoriesInfo;
    private String[] resourcesInfo;
    private transient String[] diplomacyInfo;

    public JavaIOSerial(String[] territoriesInfo, String[] resourcesInfo, String[] diplomacyInfo){
        this.territoriesInfo = territoriesInfo;
        this.resourcesInfo = resourcesInfo;
        this.diplomacyInfo = diplomacyInfo;
    }

    public String[] getTerritoriesInfo() {
        return territoriesInfo;
    }

    public void setTerritoriesInfo(String[] territoriesInfo) {
        this.territoriesInfo = territoriesInfo;
    }

    public String[] getResourcesInfo() {
        return resourcesInfo;
    }

    public void setResourcesInfo(String[] resourcesInfo) {
        this.resourcesInfo = resourcesInfo;
    }

    public String[] getDiplomacyInfo() {
        return diplomacyInfo;
    }

    public void setDiplomacyInfo(String[] diplomacyInfo) {
        this.diplomacyInfo = diplomacyInfo;
    }

    @Override
    public String toString() {
        return "SavedGame{" +
                "territoriesInfo=" + Arrays.toString(territoriesInfo) +
                ", resourcesInfo=" + Arrays.toString(resourcesInfo) +
                ", diplomacyInfo=" + Arrays.toString(diplomacyInfo) +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String pth = "/media/sashkus/Workshop/EpamATLab/JavaFundamentals/temp/";

        //  создаем наш объект
        String[] territoryInfo = {"У Испании 6 провинций", "У России 10 провинций", "У Франции 8 провинций"};
        String[] resourcesInfo = {"У Испании 100 золота", "У России 80 золота", "У Франции 90 золота"};
        String[] diplomacyInfo = {"Франция воюет с Россией, Испания заняла позицию нейтралитета"};

        JavaIOSerial savedGame = new JavaIOSerial(territoryInfo, resourcesInfo, diplomacyInfo);

        //  создаем 2 потока для сериализации объекта и сохранения его в файл
        FileOutputStream outputStream = new FileOutputStream(pth + "save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        //  сохраняем игру в файл
        objectOutputStream.writeObject(savedGame);

        //  закрываем поток и освобождаем ресурсы
        objectOutputStream.close();

        //  десериализуем объект
        FileInputStream fileInputStream = new FileInputStream(pth + "save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        JavaIOSerial savedGame1 = (JavaIOSerial) objectInputStream.readObject();

        System.out.println(savedGame);
        //  outputs 'SavedGame{territoriesInfo=[У Испании 6 провинций, У России 10 провинций, У Франции 8 провинций],
        //           resourcesInfo=[У Испании 100 золота, У России 80 золота, У Франции 90 золота],
        //           diplomacyInfo=[Франция воюет с Россией, Испания заняла позицию нейтралитета]}'

        objectInputStream.close();
    }
}
