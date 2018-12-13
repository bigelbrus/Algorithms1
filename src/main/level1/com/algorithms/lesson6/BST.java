package com.algorithms.lesson6;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    private Node root = null;

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return this.size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    public Value get(Key key) {
        return get(root,key);
    }

    private Value get(Node node, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Не верное значение ключа");
        }
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public boolean contains(Key key) {
        return get(root, key) != null;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Не верное значение ключа");
        }
        root = put(root, key, value);
    }

    private Node min(Node node) {
        if (node.left == null) {
            return  node;
        } else {
            return min(node.left);
        }
    }

    private Node max(Node node) {
        if (node.right == null) {
            return  node;
        } else {
            return max(node.right);
        }
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        return node;
    }

    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMax(root);
    }
//
//    private Node delete(Node node, Key key) {
//        if (node == null) {
//            return null;
//        }
//        int cmp = key.compareTo(node.key);
////        if (cmp == )
//    }
}
