package interviewKit.search;

import java.util.*;

public class IceCream {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, List<Integer>> index = new HashMap<>();

        //load the original indexes
        for (int i = 0; i <= cost.length - 1; i++) {
            int id = i + 1;
            index.computeIfPresent(cost[i], (k, v) -> {
                v.add(id);
                return v;
            });

            index.computeIfAbsent(cost[i], k -> {
                List<Integer> l = new ArrayList<>();
                l.add(id);
                return l;
            });
        }

        //sort the costs
        Arrays.sort(cost);
        //look up for the first minor element
        int target = -1;
        int a = -1;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (cost[i] < money) {
                target = money - cost[i];
                if (!index.containsKey(target)) {
                    continue;
                }
                a = index.get(cost[i]).get(0);
                index.compute(cost[i], (k, v) -> {
                    v.remove(0);
                    return v;
                });
                break;
            }
        }

        //search for the other number
        int b = search(0, cost.length, target, cost);
        b = index.get(cost[b]).get(0);

        if (a > b)
            System.out.println( b + " " + a);
        else
            System.out.println(a + " " + b);
    }

    private static int search(int start, int end, int target, int[] arr) {
        int piv = start + (end - start) / 2;

        int curr = arr[piv];

        if (target == curr) {
            return piv;
        }

        if (start >= end)
            return -1;

        if (target < curr) {
            return search(start, piv - 1, target, arr);
        } else {
            return search(piv + 1, end, target, arr);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();

    }


}
