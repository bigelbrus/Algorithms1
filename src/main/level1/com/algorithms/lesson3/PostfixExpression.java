package com.algorithms.lesson3;

import java.util.NoSuchElementException;

public class PostfixExpression {
    private String expr;

    public PostfixExpression(String expr) {
        this.expr = expr;
    }

    public int calcExpression() {
        MyArrayStack<Integer> st = new MyArrayStack<>();
        String[] s = expr.split(" ");

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("+") || s[i].equals("-") || s[i].equals("*") || s[i].equals("/")) {
                if (st.size() < 2) {
                    throw new NoSuchElementException();
                }
                int a = st.pop();
                int b = st.pop();
                switch (s[i]) {
                    case "+":
                        st.push(a + b);
                        break;
                    case "-":
                        st.push(b - a);
                        break;
                    case "*":
                        st.push(a * b);
                        break;
                    case "/":
                        st.push(b / a);
                        break;
                }
            } else {
                st.push((Integer.parseInt(s[i])));
            }
        }
        if (st.size() == 1) {
            return st.pop();
        }
        else {
            throw new NoSuchElementException();
        }
    }

}
