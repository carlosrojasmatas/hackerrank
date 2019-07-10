package interviewKit.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pairs {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr, Map<Integer, Integer> freqs) {

        int count = 0;
        Arrays.sort(arr);


        for (int j = arr.length - 1; j >= 0; j--) {

            int diff = arr[j] - k;

            if (freqs.containsKey(diff)) {
                count += freqs.get(diff);
            }

        }

        return count;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Map<Integer, Integer> freqs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
            freqs.putIfAbsent(arrItem, 0);
            freqs.computeIfPresent(arrItem, (key, v) -> v + 1);
        }

        int result = pairs(k, arr, freqs);

        System.out.println(result);


        scanner.close();
    }
}
