package com.algorithms.lesson5;

import com.algorithms.lesson3.MyArrayStack;

import java.util.NoSuchElementException;

public class HanoiGame {
    public int move = 0;
    public int numberOfDiscs;
    MyArrayStack<Integer> rod1 = new MyArrayStack<>();
    MyArrayStack<Integer> rod2 = new MyArrayStack<>();
    MyArrayStack<Integer> rod3 = new MyArrayStack<>();


    public int game(int n) {
        numberOfDiscs = n;
        for (int i = numberOfDiscs; i > 0; i--) {
            rod1.push(i);
        }
        recMethod(rod1, rod3, rod2, numberOfDiscs);
        return move;

//        for (int i = numberOfDiscs; i > 0; i--) {
//            rod1.push(i);
//        }
//        while (!checkRod(rod2) & !checkRod(rod3)) {
//            shiftDisc(rod1, rod2);
//            shiftDisc(rod1, rod3);
//            shiftDisc(rod2, rod3);
//        }
//        return move;
    }

    public void shiftDisc(MyArrayStack<Integer> from, MyArrayStack<Integer> to) {
        int diskFrom;
        int diskTo;
        try {
            diskFrom = from.peek();
        } catch (NoSuchElementException e) {
            diskFrom = numberOfDiscs + 1;
        }
        try {
            diskTo = to.peek();
        } catch (NoSuchElementException e) {
            diskTo = numberOfDiscs + 1;
        }

        if (from.isEmpty() || diskFrom > diskTo) {
            shiftDisc(to, from);
            return;
        }
        if (to.isEmpty() || diskTo > diskFrom) {
            to.push(diskFrom);
            from.pop();
            move++;
        }
    }

    public boolean checkRod(MyArrayStack<Integer> rod) {
        return rod.size() == numberOfDiscs;
    }

    public void recMethod(MyArrayStack<Integer> from, MyArrayStack<Integer> buf, MyArrayStack<Integer> to, int n) {
        if (n > 0) {
            recMethod(from, to, buf, n - 1);
            to.push(from.pop());
            move++;
            recMethod(buf, from, to, n - 1);
        }
    }
}
