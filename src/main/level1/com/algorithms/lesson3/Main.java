package com.algorithms.lesson3;

public class Main {
    public static void main(String[] args) {
        MyArrayDeque<Integer> deque = new MyArrayDeque<>();
        deque.InsertLeft(1);
        deque.InsertRight(2);
        System.out.println(deque.toString());
        deque.InsertRight(3);
        deque.InsertRight(5);
        deque.InsertRight(6);
        deque.InsertLeft(4);
        System.out.println(deque.toString());
        deque.RemoveLeft();
        deque.RemoveRight();
        deque.RemoveRight();
        System.out.println(deque.toString());
        System.out.println(deque.GetRight());
        System.out.println(deque.GetLeft());
        System.out.println(deque.size());
        System.out.println(deque.toString());
    }
}
