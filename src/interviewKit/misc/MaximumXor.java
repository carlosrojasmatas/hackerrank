package interviewKit.misc;

import java.io.IOException;
import java.util.*;

public class MaximumXor {

    private static class Node {
        int value = -1;
        Node left;
        Node right;

    }

    // Complete the maxXor function below.
    static int[] maxXor(Node trie, int[] queries) {

        int[] rs = new int[queries.length];


        return rs;

    }

    private static int evaluate(int[] rem, int q, int max, Map<String, Integer> cache) {
        if (rem.length == 0) return max;

        int head = rem[0];

        int r = 0;

        String key = q + ":" + head;
        if (cache.containsKey(head)) {
            r = cache.get(key);
        } else {
            r = q ^ head;
            cache.put(key, r);
            cache.put(q + ":" + r, head);
        }

        if (r > max) {
            return evaluate(Arrays.copyOfRange(rem, 1, rem.length), q, r, cache);
        } else {
            return evaluate(Arrays.copyOfRange(rem, 1, rem.length), q, max, cache);
        }


    }

    private static final Scanner scanner = new Scanner(System.in);

    private static Node buildTrie(Node node, int v) {

        LinkedList<Integer> bits = new LinkedList<>();

        for (int i = 7; i >= 0; i--) {

            if (v % 2 == 0) bits.push(0);
            else bits.push(1);

            v = v / 2;
        }

        Node current = node;

        for (int el : bits) {
            if (current == null) {
                current = new Node();
                current.value = el;
            } else {
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
        }

        return node;
    }

    private static int binaryToInt(int[] binary) {
        int rs = 0;
        for (int i = 7; i >= 0; i--) {
            if (binary[i] == 1) {
                rs += Math.pow(2, 8 - i - 1);
            }
        }

        return rs;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(binaryToInt(new int[]{0,0,0,0,1,0,1,1}));
//        Node trie = buildTrie(new Node(), 2);
//        buildTrie(trie, 4);
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }
//
//        int m = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] queries = new int[m];
//
//        for (int i = 0; i < m; i++) {
//            int queriesItem = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//            queries[i] = queriesItem;
//        }
//
//        int[] result = maxXor(arr, queries);
//
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(String.valueOf(result[i]));
//
//        }
//
//        System.out.println();
//
//        scanner.close();
    }
}
