package com.linkedlist.carlos;

public class Main {

    public static void main(String[] args) {

        CarlosLinkedList test = new CarlosLinkedList();
        test.insert(1);
        test.insert(2);
        test.insert(3);
        test.insert(4);
        test.insert(5);
//        test.insert(32);

        System.out.println("get data 0: " + test.get(0).getData());
        System.out.println("get data 1: " +test.get(1).getData());
        System.out.println("get data 2: " +test.get(2).getData());
        System.out.println("get data 3: " +test.get(3).getData());
        System.out.println("get data 4: " +test.get(4).getData());


        System.out.println(test.getSize());
        System.out.println(test.remove(4).getData());
        System.out.println(test.getSize());
        System.out.println(test.toString());

    }
}
