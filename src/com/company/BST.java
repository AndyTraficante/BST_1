package com.company;import java.util.LinkedList;import java.util.PriorityQueue;import java.util.Queue;public class BST {    Node root = null;        public void add(Object itemToAdd) {            Node addNode = new Node((int) itemToAdd);            if (root == null) {                root = addNode;                System.out.println("Successfully added root of value " + (int) itemToAdd);            } else {                Node tempRoot = root;                System.out.println(addNode.val);                boolean continue2 = true;                while (continue2) {                    if (addNode.val < tempRoot.val) {                        if (tempRoot.left == null) {                            tempRoot.left = addNode;                            addNode.upRight = tempRoot;                            System.out.println("Node added to the left");                            continue2 = false;                        } else {                            tempRoot = tempRoot.left;                            //add(addNode.val);                        }                    }else if (addNode.val > tempRoot.val) {                        if (tempRoot.right == null) {                                tempRoot.right = addNode;                                addNode.upLeft = tempRoot;                                System.out.println("Node added to the right");                                continue2 = false;                        } else {                            tempRoot = tempRoot.right;                            //add(addNode.val);                        }                    }else if (addNode.val == tempRoot.val) {                        continue2 = false;                        System.out.println("loop ended");                    }                }            }        }        public void remove(Object itemToRemove) {            boolean removing = true;            boolean finding = true;            int topval = 0;            Node checkNode = root;            while (finding) {                if ((int) itemToRemove > checkNode.val) {                    checkNode = checkNode.right;                } else if ((int) itemToRemove < checkNode.val) {                    checkNode = checkNode.left;                } else {                    //if (checkNode.right == null && checkNode.left == null) {;                    System.out.println("Node found");                    Node removeNode = checkNode;                    //checkNode = null;                    finding = false;                    int childCount;                    if (removeNode.left != null && removeNode.right != null) {                        childCount = 2;                    } else if (removeNode.left == null && removeNode.right == null) {                        childCount = 0;                    } else {                        childCount = 1;                    }                        switch (childCount) {                            case 2:                                while (removing) {                                    if (removeNode.right != null) { //two children case                                        removeNode = removeNode.right;                                    } else {                                        removing = false;                                        topval = removeNode.val;                                        removeNode.upLeft.right = null;                                        checkNode.val = topval;                                    }                                }                                break;                            case 1:                                if (removeNode.left != null) {                                    Node childNode = removeNode.left;                                    Node parentNode = removeNode.upRight;                                    parentNode.left = childNode;                                    childNode.upRight = parentNode;                                    removeNode = null;                                }else {                                    Node childNode = removeNode.right;                                    Node parentNode = removeNode.upLeft;                                    parentNode.right = childNode;                                    childNode.upLeft = parentNode;                                    removeNode = null;                                }                                break;                            case 0:                                if(removeNode.upRight != null){                                    removeNode.upRight.left = null;                                }else{                                    removeNode.upLeft.right = null;                                }                                break;                        }                        } //parse all down right until it reaches the last node                    }                }/*            while(removing) {                if ((int)itemToRemove >checkNode.val){                    checkNode = checkNode.right;                }else if((int)itemToRemove<checkNode.val){                    checkNode= checkNode.left;                }else{                    if(checkNode.right == null && checkNode.left == null){                        checkNode = null;                    }else if(checkNode.left == null && checkNode.right != null){                        int lowNum = 0 = checkNode.val;                        Node parseNode = checkNode;                        while(parseNode.right != null){                            if(parseNode.val>lowNum){                                lowNum = parseNode.val;                            }else{                                parseNode = parseNode.right;                            }                        }                        checkNode.val = lowNum;                    }                } */        public void preOrderTraversal(Node checkNode) {            if(!checkNode.hasGoneLeft && !checkNode.hasGoneRight) {                System.out.println(checkNode.val);            }            if (checkNode.left != null && !checkNode.hasGoneLeft) {                checkNode.hasGoneLeft = true;                preOrderTraversal(checkNode.left);            } else if (checkNode.right != null && !checkNode.hasGoneRight) {                checkNode.hasGoneRight = true;                preOrderTraversal(checkNode.right);            } else {                if (checkNode.upRight != null) {                    preOrderTraversal(checkNode.upRight);                } else if (checkNode.upLeft != null) {                    preOrderTraversal(checkNode.upLeft);                }            }        }        public Object find(Object objectToFind) {            boolean finding = true;            Node checkNode = root;            while (finding) {                if ((int) objectToFind > checkNode.val) {                    checkNode = checkNode.right;                } else if ((int) objectToFind < checkNode.val) {                    checkNode = checkNode.left;                } else {                    System.out.println("Node found");                    finding = false;                }            }            return checkNode;        }        public void inOrderTraversal(Node checkNode) {            if (checkNode.left != null && !checkNode.hasGoneLeft) {                checkNode.hasGoneLeft = true;                inOrderTraversal(checkNode.left);            }            if ((checkNode.left == null && !checkNode.hasGoneRight) || checkNode.hasGoneLeft && !checkNode.hasGoneRight) {                System.out.println(checkNode.val);            }            if (checkNode.right != null && !checkNode.hasGoneRight) {                checkNode.hasGoneRight = true;                inOrderTraversal(checkNode.right);            } else if ((checkNode.hasGoneRight && checkNode.hasGoneLeft) || (checkNode.left == null && checkNode.right == null) || (checkNode.right == null && checkNode.hasGoneLeft)) {                if (checkNode.upRight != null) {                    checkNode.hasGoneRight = true;                    inOrderTraversal(checkNode.upRight);                } else if (checkNode.upLeft != null) {                    inOrderTraversal(checkNode.upLeft);                }            }        }        public void postOrderTraversal(Node checkNode) {            if (checkNode.left != null && !checkNode.hasGoneLeft) {                checkNode.hasGoneLeft = true;                postOrderTraversal(checkNode.left);            }            if (checkNode.right != null && !checkNode.hasGoneRight) {                checkNode.hasGoneRight = true;                postOrderTraversal(checkNode.right);            }            System.out.println(checkNode.val);            //if ((checkNode.hasGoneRight && checkNode.hasGoneLeft) || (checkNode.left == null && checkNode.right == null) || (checkNode.right == null && checkNode.hasGoneLeft || (checkNode.left == null && checkNode.hasGoneRight))) {            if (checkNode.upRight != null) {                checkNode.hasGoneRight = true;                //checkNode.hasGoneLeft = true;                         /* postOrderTraversal(checkNode.upRight);                } else if (checkNode.upLeft != null) {                        checkNode.hasGoneLeft = true;                        //checkNode.hasGoneRight = true;                        postOrderTraversal(checkNode.upLeft);                } */            }        }       // }/*        public void breadthFirstSearch(Node checkNode) {            PriorityQueue<Integer> searchQ = new PriorityQueue<Integer>();            checkNode = root;            int level = 1;            if(!checkNode.hasGoneLeft && !checkNode.hasGoneRight) {                searchQ.insert(checkNode.val);            }            if (checkNode.left != null && !checkNode.hasGoneLeft) {                level++;                checkNode.hasGoneLeft = true;                preOrderTraversal(checkNode.left);            } else if (checkNode.right != null && !checkNode.hasGoneRight) {                checkNode.hasGoneRight = true;                level++;                preOrderTraversal(checkNode.right);            } else {                if (checkNode.upRight != null) {                    level--;                    preOrderTraversal(checkNode.upRight);                } else if (checkNode.upLeft != null) {                    level--;                    preOrderTraversal(checkNode.upLeft);                }            }        } */        public void clear() {            root = null;        }        public int size() {return 0;        }        public class Node {            int val;            Node left;            Node right;            Node upRight;            Node upLeft;            boolean hasGoneLeft;            boolean hasGoneRight;            public Node(int val){                this.val = val;                left = null;                right = null;                upRight = null;                upLeft = null;            }        }    }