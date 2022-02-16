package com.rekrutacja1;

public class Node {
    private Object value;
     Node left;
     Node right;


    public Node(Object value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Object getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }



}
