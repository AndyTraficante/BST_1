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


    private void traverseLeft(Node traverseNode) {
      /*  while (traverseNode != null) {
            System.out.println(traverseNode.val);
            if (traverseNode.left != null) {
               traverseNode =  traverseNode.left;
            }else{
                System.out.println(traverseNode.val);
            }
            if (traverseNode.right != null);
        } */
    }
    private void traverseRight(Node traverseNode){
        while (traverseNode.left != null) {
            System.out.println(traverseNode.val);
            traverseNode = traverseNode.left;
        }
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
                    checkNode = checkNode.upLeft;
                }
                if (checkNode.upLeft != null) {
                    preOrderTraversal(checkNode.upRight);
                } else if (checkNode.upLeft != null) {
                    checkNode = checkNode.upLeft;
                }



/*
                if (checkNode.upRight != null) {
                    if (checkNode.upRight.right != null) {
                        System.out.println("hello!");
                        preOrderTraversal(checkNode.upRight.right);
                    }
                   // preOrderTraversal(upRight);
                }
                if (checkNode.upLeft != null) {
                    if (checkNode.upLeft.upRight != null) {
                        if (checkNode.upLeft.upRight.right != null) {
                            System.out.println("hello!");
                            preOrderTraversal(checkNode.upLeft.upRight.right);
                        }
                    }
                }
            }

                }if(checkNode.upRight.right == null) {

                        System.out.println("hello!");
                        preOrderTraversal(checkNode.upRight.right);

                }

 */


                //nLR
                // Node traverseNode = root;

                //traverseLeft(traverseNode);


            /*
            if(root != null){
              //  Node traverseNode = root;

                System.out.println(root);

                traverseNode = root.left;
                System.out.println(traverseNode);

                traverseLeft(traverseNode);

                if(traverseNode.left.left == null){
                    System.out.println(traverseNode);
                    if(traverseNode.left.right != null ){


                    }
                }

            }
            */


            }
        }

        public Object find(Object objectToFind) {
            return null;
        }


        public void inOrderTraversal() {

        }


        public void postOrderTraversal() {

        }

        public void breadthFirstSearch() {

        }

        public void clear() {

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
