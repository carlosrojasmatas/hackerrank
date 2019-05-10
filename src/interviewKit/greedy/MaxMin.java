package interviewKit.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int j = k - 1;
        for (int i = 0; i <= arr.length - k; i++) {
            int localMin = arr[j] - arr[i];
            if (localMin == 0) {
                min = localMin;
                break;
            }
            if(localMin < min){
                min = localMin;
            }

            j++;

        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        System.out.println(result);

        scanner.close();
    }
}
