package com.algorithms.lesson3;

public class ReverseString {
    private String s;


    public ReverseString(String s) {
        this.s = s;
    }

    public void reverse() {
        MyArrayStack<Character> stack = new MyArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop());
        }
    }

}
