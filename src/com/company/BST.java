package com.company;

public class BST {
    Node root;

        public void add(Object itemToAdd) {
            Node addNode = new Node((int)itemToAdd);
            if(root == null){
                root =  addNode;
                System.out.println("Successfully added root of value "+ (int)itemToAdd);
            }


            Node tempRoot = root;
            System.out.println(addNode.val);

           boolean continue2 = true;
            while(continue2){
                if (addNode.val < tempRoot.val) {
                    if (tempRoot.left == null) {
                        tempRoot.left = addNode;
                       addNode.upRight = tempRoot;
                        System.out.println("Node added to the left");
                        continue2 = false;
                    } else {
                        tempRoot = tempRoot.left;
                        //add(addNode.val);
                    }
                }

                if (addNode.val > tempRoot.val) {
                    if (tempRoot.right == null) {
                        tempRoot.right = addNode;
                        addNode.upLeft = tempRoot;
                        System.out.println("Node added to the right");
                        continue2 = false;
                    } else {
                        tempRoot = tempRoot.right;
                        //add(addNode.val);
                    }


                }
                if (addNode.val == tempRoot.val){
                    continue2 = false;
                    System.out.println("loop ended");
                }
            }

        }

        public void remove(Object itemToRemove) {

        }



        public void preOrderTraversal(Node checkNode) {
            if(!checkNode.hasGoneLeft && !checkNode.hasGoneRight) {
                System.out.println(checkNode.val);
            }
            if (checkNode.left != null && !checkNode.hasGoneLeft) {
                checkNode.hasGoneLeft = true;
                preOrderTraversal(checkNode.left);
            } else if (checkNode.right != null && !checkNode.hasGoneRight) {
                checkNode.hasGoneRight = true;
                preOrderTraversal(checkNode.right);
            } else {
                if (checkNode.upRight != null) {
                    preOrderTraversal(checkNode.upRight);
                } else if (checkNode.upLeft != null) {
                    preOrderTraversal(checkNode.upLeft);
                }

            }
        }

        public Object find(Object objectToFind) {
            return null;
        }


        public void inOrderTraversal(Node checkNode) {
            if (checkNode.left != null && !checkNode.hasGoneLeft) {
                checkNode.hasGoneLeft = true;
                inOrderTraversal(checkNode.left);
            }

            if ((checkNode.left == null && !checkNode.hasGoneRight) || checkNode.hasGoneLeft && !checkNode.hasGoneRight) {
                System.out.println(checkNode.val);
            }
            if (checkNode.right != null && !checkNode.hasGoneRight) {
                checkNode.hasGoneRight = true;
                inOrderTraversal(checkNode.right);
            } else if ((checkNode.hasGoneRight && checkNode.hasGoneLeft) || (checkNode.left == null && checkNode.right == null) || (checkNode.right == null && checkNode.hasGoneLeft)) {
                if (checkNode.upRight != null) {
                    checkNode.hasGoneRight = true;
                    inOrderTraversal(checkNode.upRight);
                } else if (checkNode.upLeft != null) {
                    inOrderTraversal(checkNode.upLeft);
                }
            }
        }



        public void postOrderTraversal() {

        }

        public void breadthFirstSearch() {

        }

        public void clear() {
            root = null;

        }

        public int size() {
            return 0;
        }



        public class Node {
            int val;
            Node left;
            Node right;
            Node upRight;
            Node upLeft;
            boolean hasGoneLeft;
            boolean hasGoneRight;

            public Node(int val){
                this.val = val;
                left = null;
                right = null;


            }
        }

    }
