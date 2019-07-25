package ds.trees;

import java.util.Scanner;

public class AVL {

    public static class Node {

        int val;
        Node left;
        Node right;
        int ht;
    }

    static Node insert(Node root, int val) {

        if (val != root.val) {

            if (val > root.val) {

                if (root.right == null) {

                    Node n = new Node();
                    n.val = val;
                    n.ht = 0;
                    root.right = n;

                } else {

                    root.right = insert(root.right, val);

                }

            } else {

                if (root.left == null) {

                    Node n = new Node();
                    n.val = val;
                    n.ht = 0;
                    root.left = n;

                } else {

                    root.left = insert(root.left, val);

                }

            }
        }

        int leftHt = height(root.left);
        int rightHt = height(root.right);

        int factor = (leftHt - rightHt);

        if (factor < -1) { //right unbalanced
            root = rotateLeft(root);
        } else if (factor > 1) { //left unbalanced
            root = rotateRight(root);
        }

        return root;
    }

    static int height(Node node) {
        if (node == null)
            return -1;
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }

    static Node rotateRight(Node node) {
        if (node.left.left == null) { //left right case
            Node temp = node.left.right;
            node.left.right = temp.left;
            temp.left = node.left;
            node.left = temp;
        }

        //left left case
        Node newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;

        int rh = height(newNode.right);
        int lh = height(newNode.left);
        newNode.right.ht = rh;
        newNode.left.ht = lh;

        return newNode;
    }

    static Node rotateLeft(Node node) {
        if (node.right.right == null) {
            Node temp = node.right.left;
            node.right.left = temp.right;
            temp.right = node.right;
            node.right = temp;
        }

        Node newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;

        int rh = height(newNode.right);
        int lh = height(newNode.left);
        newNode.right.ht = rh;
        newNode.left.ht = lh;

        newNode.ht = 1 + Math.max(rh, lh);

        return newNode;
    }

    static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print("-" + root.val);
        printInOrder(root.right);
}

    static void printPostOrder(Node root) {
        if (root == null) return;

        System.out.print("-" + root.val);
        printPostOrder(root.left);
        printPostOrder(root.right);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        23
//        190 108 143 144 111 51 17 90 184 172 196 83 20 117 7 188 114 173 62 112 70 12 55
//        99
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] nodes = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int nn = scanner.nextInt();

        Node root = new Node();
        root.val = Integer.parseInt(nodes[0]);
        for (int i = 1; i < nodes.length; i++) {
            root = insert(root, Integer.parseInt(nodes[i]));
        }

        Node r = insert(root, nn);
        printInOrder(r);
        System.out.println();
        printPostOrder(r);
//        Node root = new Node();
//        root.val = 3;
//
//        Node two = new Node();
//        two.val = 2;
//
//        Node four = new Node();
//        four.val = 4;
//
//        Node six = new Node();
//        six.val = 6;
//
//        root.left = two;
//        root.right = four;
//
//        four.right = six;
//
////        Node root = new Node();
////        Node fourteen = new Node();
////        Node ten = new Node();
////        Node seven = new Node();
////        Node twelve = new Node();
////        Node sixteen = new Node();
////        Node twentyFive = new Node();
////        Node twentyThree = new Node();
////        Node twentySix = new Node();
////        Node thirty = new Node();
////
////        root.val = 21;
////        root.ht = 3;
////        fourteen.val = 14;
////        fourteen.ht= 2;
////        ten.val = 10;
////        ten.ht=1;
////        seven.val = 7;
////        seven.ht = 0;
////        twelve.val = 12;
////        twelve.ht = 0;
////        sixteen.val = 16;
////        sixteen.ht=1;
////        twentyFive.val = 25;
////        twentyFive.ht=2;
////        twentyThree.val = 23;
////        twentyThree.ht = 0;
////        twentySix.val = 26;
////        twentySix.ht = 1;
////        thirty.val = 30;
////        thirty.ht = 0;
////
////        root.left = fourteen;
////        root.right = twentyFive;
////
////        fourteen.left = ten;
////        fourteen.right = sixteen;
////        ten.left = seven;
////        ten.right = twelve;
////
////        twentyFive.left = twentyThree;
////        twentyFive.right = twentySix;
////
////        twentySix.right = thirty;
//
//        Node r = insert(root,5);
//        System.out.println(r);
    }

}
