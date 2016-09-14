package com.hashtable.carlos;

import com.linkedlist.carlos.CarlosLinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CarlosLinkedList test = new CarlosLinkedList();
        test.insert(1);
        System.out.println(test.toString());

        CarlosHashTable<String, Integer> testHashTable = new CarlosHashTable<>();
        testHashTable.put("Carlos", 24);
        testHashTable.put("Alicia", 222);
        testHashTable.put("Sammy", 21);
        testHashTable.put("Matt", 44);
        testHashTable.put("megaman", 11);
        testHashTable.put("Jack", 121);
        testHashTable.put("wolverine", 191919);
        testHashTable.put("Ariel", 30);

        int carlosAge = testHashTable.get("Carlos");

        System.out.println(testHashTable.contains("Carlos"));

        testHashTable.remove("megaman");
        int x = 1;
    }
}
