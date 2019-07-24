package ds.trees;

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
                    n.val = root.val;
                    n.ht = root.ht + 1;
                    root.right = n;

                } else {

                    root = insert(root.right, val);

                }

            } else {

                if (root.left == null) {

                    Node n = new Node();
                    n.val = root.val;
                    n.ht = root.ht + 1;
                    root.left = n;

                } else {

                    root = insert(root.left, val);

                }

            }
        }

        int leftHt = height(root.left);
        int rightHt = height(root.right);

        int factor = (leftHt - rightHt);

        if (factor < -1) { //right unbalanced
            rotateLeft(root);
        } else if (factor > 1) { //left unbalanced
            rotateRight(root);
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
        if (height(node.right) > height(node.left)) { //left right case
            node.left = rotateLeft(node.left);
        }

        //left left case
        Node temp = node;
        temp.left = node.left.right;
        node.left.right = temp;

        return node;
    }

    static Node rotateLeft(Node node) {
        if (height(node.right) < height(node.left)) {
            node.right = rotateRight(node.right);
        }

        Node tmp = node;
        tmp.right = node.right.left;
        node.right.left = tmp;

        return node;
    }
}
