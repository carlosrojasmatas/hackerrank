package challenges.sorting;

import java.util.Scanner;

public class JCountInversions {

    private static long count;
    static long insertionSort(int[] arr) {
        // Complete this function
        count = 0;
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        return count;
    }

    private static void mergeSort(int[] arr, int left, int right, int[] helper) {
        if (left == right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, helper);
        mergeSort(arr, mid + 1, right, helper);
        merge(arr, left, right, mid, helper);
    }

    private static void merge(int[] arr, int left, int right, int mid, int[] helper) {
        for (int i = left; i <= right; i++) {
            helper[i] = arr[i];
        }
        int leftInd = left, rightInd = mid + 1;
        while (leftInd <= mid && rightInd <= right) {
            if (helper[leftInd] <= helper[rightInd]) {
                arr[left++] = helper[leftInd++];
                count += left - leftInd;
            }else {
                arr[left++] = helper[rightInd++];
            }
        }

        while (leftInd <= mid) {
            arr[left++] = helper[leftInd++];
            count += left - leftInd;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = insertionSort(arr);
            System.out.println(result);
        }
        in.close();
    }
}
