package com.algorithms.lesson3;

import java.util.NoSuchElementException;

public class MyArrayDeque<Item> {
    private int size;
    private Object[] deq = new Object[2];
    private int left = 0;
    private int right = 0;

    //      l
    //    r
    //0 1 3 4
    //1 2
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void InsertLeft(Item item) {
        if (size == 0) {
            right++;
            right %= deq.length;        //??maybe must delete
        }
        if (size == deq.length - 1) {
            deq[left] = item;
            size++;
            resize(deq.length * 2);

        } else {
            deq[left--] = item;
            if (left < 0) {
                left = deq.length - 1;
            }
            size++;
        }
    }

    public void InsertRight(Item item) {
        if (size == 0) {
            left = deq.length - 1;
        }
        if (size == deq.length - 1) {
            deq[right] = item;
            size++;
            resize(deq.length * 2);

        } else {
            deq[right++] = item;
            if (right > deq.length) {
                right = 0;
            }
            size++;
        }
    }

    public Item GetLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Item temp = (Item) deq[++left % deq.length];
            left %= deq.length;
            deq[left] = null;
            size--;
            if (size == deq.length / 4) {
                resize(deq.length / 2);
            }
            return temp;
        }
    }

    public Item GetRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            if (right==0) {
                right = deq.length - 1;
            } else {
                right--;
            }
            Item temp = (Item) deq[right];
            deq[right] = null;
            size--;
            if (size == deq.length / 4) {
                resize(deq.length / 2);
            }
            return temp;
        }
    }

    public void RemoveLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            left++;
            left %= deq.length;
            deq[left] = null;
            size--;
            if (size == deq.length / 4) {
                resize(deq.length / 2);
            }
        }
    }

    public void RemoveRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            if (right==0) {
                right = deq.length - 1;
            } else {
                right--;
            }
            deq[right] = null;
            size--;
            if (size == deq.length / 4) {
                resize(deq.length / 2);
            }
        }
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = deq[(left + 1 + i) % deq.length];
        }
        left = temp.length - 1;
        right = deq.length;
        deq = temp;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(deq[(left + 1 + i) % deq.length] + ", ");
        }
        return s.toString();
    }
}
