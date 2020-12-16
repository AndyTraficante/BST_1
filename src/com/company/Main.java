package com.company;

import javafx.scene.Node;

public class Main {

    public static void main(String[] args) {

        BST test = new BST();

        test.add(45);
        test.add(40);
        test.add(30);
        test.add(35);
        test.add(37);
        test.add(25);
        test.add(34);
        test.add(50);
        test.add(60);

        System.out.println("traversal:");
        System.out.println();
        //test.preOrderTraversal(test.root);

        //test.postOrderTraversal(test.root);
       // test.remove(34);
       // test.breadthFirstSearch(test.root);
        System.out.println(test.size(test.root));


        //System.out.println(test.root);

       // public void testMethod(){


        }

    }

