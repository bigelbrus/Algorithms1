package com.algorithms.lesson3;

import java.util.NoSuchElementException;

public class MyArrayStack<Item> {
    private Object[] stack = new Object[1]; //почему бы не создать сразу на  например 10 элементов?
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public void push(Item item) {
        if (size == stack.length) {
            resize(size * 2);
        }
        stack[size++] = item;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = (Item) stack[size - 1];
        stack[size - 1] = null;
        size--;
        if (size > 0 && size == stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (Item) stack[size - 1];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();  //почему используем просто String? Заметно тормозит при больших строках
        for (int i = 0; i < size; i++) {
            s.append(stack[i] + ", ");
        }
        return s.toString();
    }

}
