package com.algorithms.lesson5;

public class Main {
    public static void main(String[] args) {
        HanoiGame game = new HanoiGame();
        System.out.println(game.game(4));
    }

    public static int phiboRec(int n) {
        System.out.println("f(" + n + ")");
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return phiboRec(n - 1) + phiboRec(n - 2);
        }
    }

    public static int factRec (int n) {
        if (n == 1) {
            return 1;
        } else {
            return factRec(n - 1) * n;
        }
    }

    public static int powRec(int base, int power) {
        int sqr = base * base;
        if (power < 0) {
            throw new IllegalArgumentException();
        }
        if (power == 1) {
            return base;
        }
        if (power == 0) {
            return 1;
        }
        if (power % 2 == 0) {
            return sqr * powRec(base, power - 2);
        }
        return base * powRec(base, power - 1);
    }
}
