package interviewKit.misc;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumXor {

    private static class Node {
        int value = -1;
        Node left;
        Node right;

    }

    // Complete the maxXor function below.
    static int[] maxXor(int[] arr, int[] queries) {

        int[] rs = new int[queries.length];
        Node n = new Node();
        //build the trie
        for (int el : arr) {
            n = addToTrie(n, el);
        }

        int i = 0;
        for (int q : queries) {

            int[] queryAsBits = asBits(q);

            //get the maximum complement of the query
            int[] bits = Arrays.stream(queryAsBits).map(e -> {
                if (e == 0) return 1;
                else return 0;
            }).toArray();

            int[] best = findMatching(bits, n);

            int queryAsInt = binaryToInt(queryAsBits);
            int r = binaryToInt(best);

            rs[i++] = queryAsInt ^ r;

        }

        return rs;

    }


    private static int[] findMatching(int[] target, Node trie) {
        int[] rs = new int[target.length];

        int i = 0;

        for (int t : target) {

            if (t == 0) {
                if (trie.left != null) trie = trie.left;
                else trie = trie.right;
            } else {
                if (trie.right != null) trie = trie.right;
                else trie = trie.left;
            }


            rs[i++] = trie.value;

        }

        while (i < target.length - 1) {

            //check if the trie node is the root node
            if (trie.value != -1) {
                rs[i++] = trie.value;
            }

            if (i == 0) {
                if (trie.left != null)
                    trie = trie.left;
                else
                    trie = trie.right;
            } else {
                if (trie.right != null)
                    trie = trie.right;
                else
                    trie = trie.left;
            }
        }

        return rs;

    }

    private static int[] asBits(int v) {
        int[] bits = new int[32];

        for (int i = 31; i >= 0; i--) {

            if (v % 2 == 0)
                bits[i] = 0;
            else bits[i] = 1;

            v = v / 2;
        }

        return bits;
    }


    private static Node addToTrie(Node node, int v) {

        int[] bits = asBits(v);

        Node current = node;

        for (int el : bits) {
            if (el == 0) {
                if (current.left == null) {
                    current.left = new Node();
                    current.left.value = el;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node();
                    current.right.value = el;
                }
                current = current.right;
            }
        }

        return node;
    }


    private static int binaryToInt(int[] binary) {
        int rs = 0;
        for (int i = 31; i >= 0; i--) {
            if (binary[i] == 1) {
                rs += Math.pow(2, 32 - i - 1);
            }
        }

        return rs;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[m];

        for (int i = 0; i < m; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = maxXor(arr, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));

        }

        System.out.println();

        scanner.close();
    }
}
