package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static <E extends Comparable<E>> E max(ArrayList<E> list)
    {
        if (list.isEmpty())
        {
            System.out.println("No element in the list!");
            System.exit(1);
        }
        E maxValue = list.get(0);
        for (int i = 1; i < list.size(); i++)
            if (list.get(i).compareTo(maxValue) > 0)
                maxValue = list.get(i);
        return maxValue;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        System.out.println("The max element: " + max(list));
    }
}
