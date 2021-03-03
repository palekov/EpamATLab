package main.java.othertasks;

//  Проверить скорость работы (добавление, поиск элемента, удаление) следующих коллекций.
//  NOTE: Для наглядности рекомендуется использовать от 10000+ элементов в коллекции
//        a. Листы (ArrayList vs LinkedList);
//        b. Списки (Stack vs Queue);
//        c. Словари (HashTable vs Dictionary)

import main.java.ElectricalDevice;
import main.java.classes.Mixer;

import java.util.*;

public class CollectionSpeed {

    public static void main(String[] args) {

        ArrayList arlist = new ArrayList();
        ElectricalDevice mixer = new Mixer("Tornado","blue", 1500);

        long before;
        long after;

        before = System.currentTimeMillis();
        for (int i = 0 ; i < 500000; i++) {
            arlist.add(mixer);
        }
        after = System.currentTimeMillis();
        System.out.println("Время добавления в ArrayList = " + (after - before) + " мс.");

        LinkedList linlist = new LinkedList();

        before = System.currentTimeMillis();
        for (int i = 0 ; i < 500000; i++) {
            linlist.add(mixer);
        }
        after = System.currentTimeMillis();
        System.out.println("Время добавления в LinkedList = " + (after - before) + " мс.");
        System.out.println();

        Object result = new Object();

        before = System.currentTimeMillis();
        result = arlist.get(77777);
        after = System.currentTimeMillis();
        System.out.println("Время поиска в ArrayList = " + (after - before) + " мс.");

        before = System.currentTimeMillis();
        result = linlist.get(77777);
        after = System.currentTimeMillis();
        System.out.println("Время поиска в LinkedList = " + (after - before) + " мс.");
        System.out.println();

        before = System.currentTimeMillis();
        arlist.remove(77777);
        after = System.currentTimeMillis();
        System.out.println("Время удаления из ArrayList = " + (after - before) + " мс.");

        before = System.currentTimeMillis();
        linlist.remove(77777);
        after = System.currentTimeMillis();
        System.out.println("Время удаления из LinkedList = " + (after - before) + " мс.");
        System.out.println();

        Stack<ElectricalDevice> stack = new Stack<>();

        before = System.currentTimeMillis();
        for (int i = 0 ; i < 500000; i++) {
            stack.push(mixer);
        }
        after = System.currentTimeMillis();
        System.out.println("Время добавления в Stack = " + (after - before) + " мс.");

        Queue<ElectricalDevice> queue = new LinkedList<>();

        before = System.currentTimeMillis();
        for (int i = 0 ; i < 500000; i++) {
            queue.add(mixer);
        }
        after = System.currentTimeMillis();
        System.out.println("Время добавления в Queue = " + (after - before) + " мс.");
        System.out.println();

        before = System.currentTimeMillis();
        result = stack.peek();
        after = System.currentTimeMillis();
        System.out.println("Время поиска в Stack = " + (after - before) + " мс.");

        before = System.currentTimeMillis();
        result = queue.peek();
        after = System.currentTimeMillis();
        System.out.println("Время поиска в Queue = " + (after - before) + " мс.");
        System.out.println();

        before = System.currentTimeMillis();
        result = stack.remove(77777);
        after = System.currentTimeMillis();
        System.out.println("Время удаления в Stack = " + (after - before) + " мс.");

        before = System.currentTimeMillis();
        result = queue.remove();
        after = System.currentTimeMillis();
        System.out.println("Время удаления в Queue = " + (after - before) + " мс.");
        System.out.println();

        Hashtable<Integer, ElectricalDevice> myHTable = new Hashtable<>();

        before = System.currentTimeMillis();
        for (int i = 0 ; i < 500000; i++) {
            myHTable.put(i, mixer);
        }
        after = System.currentTimeMillis();
        System.out.println("Время добавления в HashTable = " + (after - before) + " мс.");

        Dictionary<Integer, ElectricalDevice> myDictionary = new Hashtable<>() ;

        before = System.currentTimeMillis();
        for (int i = 0 ; i < 500000; i++) {
            myDictionary.put(i, mixer);
        }
        after = System.currentTimeMillis();
        System.out.println("Время добавления в Dictionary = " + (after - before) + " мс.");
        System.out.println();

        before = System.currentTimeMillis();
        result = myHTable.get(mixer);
        after = System.currentTimeMillis();
        System.out.println("Время поиска в HashTable = " + (after - before) + " мс.");

        before = System.currentTimeMillis();
        result = myDictionary.get(mixer);
        after = System.currentTimeMillis();
        System.out.println("Время поиска в Dictionary = " + (after - before) + " мс.");
        System.out.println();

        before = System.currentTimeMillis();
        result = myHTable.remove(77777);
        after = System.currentTimeMillis();
        System.out.println("Время удаления в HashTable = " + (after - before) + " мс.");

        before = System.currentTimeMillis();
        result = myDictionary.remove(mixer);
        after = System.currentTimeMillis();
        System.out.println("Время удаления в Dictionary = " + (after - before) + " мс.");
        System.out.println();


    }

}
