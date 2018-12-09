package com.algorithms.lesson4;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insertFirst(5);
        list.insertFirst(6);
        list.insertFirst(7);
        list.insertFirst(8);
        list.insertFirst(9);
        System.out.println(list.toString());
        list.insert(3, 20);
        System.out.println(list.toString());
        list.insertLast(90);
        list.deleteFirst();
        System.out.println(list.toString());
        list.set(3, 54);
        System.out.println(list.getFirst());
        System.out.println(list.toString());
    }
}
