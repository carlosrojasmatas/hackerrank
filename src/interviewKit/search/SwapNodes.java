package interviewKit.search;

import java.util.*;

public class SwapNodes {

    private static class Node {
        private int value;
        Node left;
        Node right;
        int level;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private static Node tree = new Node(1);

    private static Queue<Node> q = new LinkedList<>();

    private static boolean mustSwap(int level, int[] queries) {
        for (int q : queries) {
            if (level % q == 0)
                return true;
        }

        return false;
    }

    private static void buildTree(int[][] indexes) {
        int i = 0;

        while (!q.isEmpty()) {
            Node curr = q.remove();

            Node l = new Node(indexes[i][0]);
            Node r = new Node(indexes[i][1]);

            l.level = curr.level + 1;
            r.level = curr.level + 1;

            curr.left = l;
            curr.right = r;
            if (l.getValue() != -1) {
                q.add(l);
            }

            if (r.getValue() != -1) {
                q.add(r);
            }

            i++;

        }

    }

    private static List<Integer> traverseInOrder(List<Integer> path, Node curr, int q) {

        if (curr.level % q == 0) {
            if (curr.right.value != -1 && curr.right != null) {
                traverseInOrder(path, curr.right, 1);
            }

            path.add(curr.value);

            if (curr.left.value != -1 && curr.left != null) {
                traverseInOrder(path, curr.left, 1);
            }

            Node tmp = curr.left;
            curr.left=curr.right;
            curr.right = tmp;

        } else {
            if (curr.left.value != -1 && curr.left != null) {
                traverseInOrder(path, curr.left, 1);
            }

            path.add(curr.value);

            if (curr.right.value != -1 && curr.right != null) {
                traverseInOrder(path, curr.right, 1);
            }
        }


        return path;
    }


    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int n, int[] queries) {
        tree.level = 1;
        q.add(tree);
        buildTree(indexes);
        int[][] rs = new int[queries.length][n * 2 + 1];
        int i = 0;
        for (int q : queries) {
            int[] r = traverseInOrder(new ArrayList<>(), tree, q)
                    .stream()
                    .filter(e -> e > 0)
                    .mapToInt(e -> e)
                    .toArray();

            rs[i++] = r;

        }
        return rs;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, n, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                System.out.print(result[resultRowItr][resultColumnItr]);

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    System.out.print(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

    }
}
