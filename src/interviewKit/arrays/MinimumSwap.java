package interviewKit.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumSwap {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int total = 0;
        for (int i = 0; i <= arr.length - 1; i++) {

            if (i != arr[i] - 1) {
                for (int j = i + 1; j <= arr.length - 1; j++) {
                    if (arr[j] == i + 1) {
                        total = total + 1;

                        int aux = arr[i];
                        arr[i] = arr[j];
                        arr[j] = aux;

                        break;
                    }
                }
            }
        }

        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        System.out.println(String.valueOf(res));

        scanner.close();
    }
}
