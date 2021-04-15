package interviewKit.snq;

import java.util.*;

public class BSF {

    private static List<List<Integer>> buildAdj(String[] grid) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = grid.length;
        for (int i = 0; i < n * n; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int pos = 0; pos < n * n; pos++) {

            int relRow = pos / n;
            int relCol = pos % n;


            char[] row = grid[relRow].toCharArray();

            if (row[relCol] != 'X') {
                // add the adj rows
                int il = relCol - 1;
                int ir = relCol + 1;
                while (il >= 0 || ir < n) {

                    if (il >= 0 && row[il] == 'X') {
                        il = -1;
                    }

                    if (ir < n && row[ir] == 'X') {
                        ir = n;
                    }

                    int adjIdx;
                    if (il >= 0) {
                        adjIdx = (relRow * n) + il;
                        adj.get(pos).add(adjIdx);
                        il--;
                    }

                    if (ir < n) {
                        adjIdx = (relRow * n) + ir;
                        adj.get(pos).add(adjIdx);
                        ir++;
                    }
                }

                //add the adj cols
                int jn = relRow - 1;
                int js = relRow + 1;
                while (jn >= 0 || js < n) {

                    if (jn >= 0 && grid[jn].toCharArray()[relCol] == 'X') {
                        jn = -1;
                    }

                    if (js < n && grid[js].toCharArray()[relCol] == 'X') {
                        js = n;
                    }

                    int adjIdx;
                    if (jn >= 0) {
                        adjIdx = (jn * n) + relCol;
                        adj.get(pos).add(adjIdx);
                        jn--;
                    }

                    if (js < n) {
                        adjIdx = (js * n) + relCol;
                        adj.get(pos).add(adjIdx);
                        js++;
                    }
                }

            }
        }

        return adj;
    }

    static int minimumMoves(String[] grid, int startRow, int startCol, int endRow, int endCol) {
        //same row, try to reach
        if (startRow == endRow && !grid[startRow].contains("X")) {
            return 1;
        }

        //same column, try to reach
        if (startCol == endCol) {
            boolean reachable = true;
            int i = startRow;
            while (i < endRow && reachable) {
                reachable = grid[i].toCharArray()[endCol] != 'X';
                i++;
            }

            if (reachable) {
                return 1;
            }
        }

        //initialize adj list
        int n = grid.length;
        long current = System.currentTimeMillis();
        List<List<Integer>> adj = buildAdj(grid);
        System.out.println((System.currentTimeMillis() - current));
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n * n];
        int[] lastVisited = new int[n * n];
        Arrays.fill(lastVisited, -1);
        boolean found = false;
        int startNode = (startRow * n) + startCol;
        int endNode = (endRow * n) + endCol;
        visited[startNode] = 1;
        int prevNode = startNode;
        List<Integer> adjacentNodes = adj.get(startNode);

        while (!found /*|| !q.isEmpty()*/) {
            for (int child : adjacentNodes) {
                if (visited[child] != 1) {
                    if (child == endNode) {
                        found = !found;
                    } else {
                        visited[child] = 1;
                        q.add(child);
                    }
                    lastVisited[child] = prevNode;
                }
            }
            if (!q.isEmpty()) {
                int next = q.poll();
                prevNode = next;
                adjacentNodes = adj.get(prevNode);
            }
        }

        int steps = 0;
        int currNode = lastVisited[endNode];
        while (currNode >= 0) {
            steps++;
            currNode = lastVisited[currNode];
        }

        return steps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        scanner.close();

        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        System.out.println(result);

    }

}
