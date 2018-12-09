package com.algorithms.lesson2;

public class MyArrayList<Item extends Comparable<Item>> {
    private int size = 0;
    private Object[] list = new Object[1];

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = list[i];
        }
        list = temp;
    }

    public void insert(Item item) {
        if (list.length == size) {
            resize(2 * size);
        }
        list[size++] = item;
    }

    public boolean delete(Item item) {
        int i = 0;
        while (i < size && !list[i].equals(item)) {
            i++;
        }
        if (i == size) {
            return false;
        }
        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        list[size - 1] = null;
        size--;
        if (size == list.length / 4 && size > 0) {
            resize(list.length / 2);
        }
        return true;
    }

    public void set(int index, Item item) {
        if (0 > index || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = item;
    }

    public Item get(int index) {
        if (0 > index || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (Item) list[index];
    }

    public boolean find(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less(this.get(j), this.get(min))) {
                    min = j;
                }
            }
            exch(i, min);
        }
    }

    public void insertionSort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less(this.get(j), this.get(j - 1))) {
                    exch(j, j - 1);
                }
                else {
                    break;
                }
            }
        }
    }

    public void bubbleSort() {
        int n = 1;
        while (n!=0) {
            n = 0;
            for (int i = 0; i < size -1; i++) {
                if (less(this.get(i + 1), this.get(i))) {
                    exch(i, i + 1);
                    n++;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(list[i] + ", ");
        }
        return s.toString();
    }

    private boolean less(Item item1, Item item2) {
        return item1.compareTo(item2) < 0;
    }

    private void exch(int i, int j) {
        Item temp = this.get(i);
        list[i] = list[j];
        list[j] = temp;
    }
}
