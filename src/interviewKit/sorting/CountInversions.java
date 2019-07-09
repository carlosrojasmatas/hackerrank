package interviewKit.sorting;

import java.io.IOException;
import java.util.Scanner;

public class CountInversions {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        long inv = sort(arr, new int[arr.length], 0, 0, arr.length - 1);
        return inv;
    }

    static long sort(int[] arr, int[] tmp, long inv, int start, int end) {
        if (end > start) {
            int m = (end + start) / 2;
            inv = sort(arr, tmp, inv, start, m) + sort(arr, tmp, inv, m + 1, end);
            return merge(arr, tmp, inv, start, end);
        }

        return inv;
    }

    static long merge(int[] arr, int[] temp, long inv, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int index = leftIndex;

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (arr[leftIndex] > arr[rightIndex]) {
                temp[index] = arr[rightIndex];
                rightIndex++;
                inv += (leftEnd - leftIndex) + 1;
            } else {
                temp[index] = arr[leftIndex];
                leftIndex++;
            }

            index++;
        }

        int leftRemaining = leftEnd - leftIndex + 1;
        int rightRemaining = rightEnd - rightIndex + 1;
        int size = rightEnd - leftStart + 1;
        System.arraycopy(arr, leftIndex, temp, index, leftRemaining);
        System.arraycopy(arr, rightIndex, temp, index, rightRemaining);
        System.arraycopy(temp, leftStart, arr, leftStart, size);

        return inv;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String items = scanner.nextLine();
            String[] arrItems = items.split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            System.out.println(String.valueOf(result));
        }


        scanner.close();
    }
}
