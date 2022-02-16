package com.rekrutacja1;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        List<Node> nodeCollection = new ArrayList<Node>();
        BinaryTree binaryTree = new BinaryTree();

        Scanner scanner = new Scanner(System.in);

        int numberOfNodes;

        System.out.println("Enter the number of nodes");
        numberOfNodes = scanner.nextInt();

        for(int i=0;i<numberOfNodes;i++){
            nodeCollection.add(new Node(new Object()));
        }

        binaryTree.fillBinaryTree(nodeCollection);

        for(Node node:nodeCollection){
            System.out.println(node.getValue());
            System.out.println("Hashcode: "+node.getValue().hashCode());
        }

        System.out.println("From which node from the collection do u want to start searching?");
        DFS(nodeCollection.get(scanner.nextInt()));

    }



    public static void DFS(Node node) {
        if (node != null) {
            System.out.println(node.getValue()+", hashcode: "+node.getValue().hashCode());
            System.out.println(node.getValue()+", hashcode: "+node.getValue().hashCode()+" - Left: ");
            DFS(node.getLeft());
            System.out.println(node.getValue()+", hashcode: "+node.getValue().hashCode()+" - Right: ");
            DFS(node.getRight());
        }
    }
}
