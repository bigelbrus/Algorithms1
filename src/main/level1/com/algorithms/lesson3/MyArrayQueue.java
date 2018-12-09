package com.algorithms.lesson3;

import java.util.NoSuchElementException;

public class MyArrayQueue<Item> {
    private Object[] queue = new Object[2];
    private int size = 0;
    private int start = 0;      //первый элемент в очереди
    private int end = 0;        //место для вставки последнего элемента

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[(start + i) % size];
        }
        queue = temp;
        start = 0;
        end = size;
    }

    public void enqueue(Item item) {
        if (size == queue.length) {
            resize(queue.length * 2);
        }
        queue[end++] = item;
        end %= queue.length;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = (Item) queue[start];
        queue[start] = null;
        size--;
        start++;
        start %= queue.length;
        if (size > 0 && size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;
    }

    public Item peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (Item) queue[start];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();  //почему используем просто String? Заметно тормозит при больших строках
        for (int i = 0; i < size; i++) {
            s.append(queue[(start + i) % queue.length] + ", ");
        }
        return s.toString();
    }


}
