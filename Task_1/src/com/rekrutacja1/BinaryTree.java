package com.rekrutacja1;

import java.util.List;

public class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean add(Node newNode){

        if(getRoot()==null){
            setRoot(newNode);
            return true;
        }

        Node current = getRoot();

        while(current != null) {

            if(current.getValue() == newNode.getValue()) {
                return false;
            }

            if(newNode.getValue().hashCode() < current.getValue().hashCode()) {
                if(current.getLeft()==null){
                    current.setLeft(newNode);
                }
                current = current.getLeft();
            }

            else if(newNode.getValue().hashCode() > current.getValue().hashCode()) {
                if(current.getRight()==null){
                    current.setRight(newNode);
                }
                current = current.getRight();
            }
        }

        return true;
    }

    public void fillBinaryTree(List<Node> nodeCollection){
        for(Node node:nodeCollection){
            add(node);
        }
    }
}
