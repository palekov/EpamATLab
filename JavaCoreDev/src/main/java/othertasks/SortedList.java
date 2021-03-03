package main.java.interfaces.othertasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//  Sort list or array by string length (Отсортировать список по длине строк)

public class SortedList implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s2.length() - s1.length();
    }

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("Tree");
        list.add("Car");
        list.add("Building");
        list.add("Grass");

        System.out.println("Unsorted list: " + list);   //  Unsorted list: [Tree, Car, Building, Grass]

        Comparator lencomparator = new SortedList();
        Collections.sort(list, lencomparator);
        System.out.println("Sorted list: " + list);     //  Sorted list: [Building, Grass, Tree, Car]

    }
}
