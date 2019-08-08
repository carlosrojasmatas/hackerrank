package interviewKit.search;

import java.util.Arrays;
import java.util.Scanner;

public class TripleSum {


    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {

        //remove duplicates
        a = deduplicateAndSort(a);
        b = deduplicateAndSort(b);
        c = deduplicateAndSort(c);


        long count = 0;

        int i = 0;
        while (i < b.length) {

            long aidx = findFirstMin(a, 0, a.length - 1, b[i]) + 1;
            long cidx = findFirstMin(c, 0, c.length - 1, b[i]) + 1;

            count += (aidx * cidx);
            i++;

        }

        return count;

    }

    private static int findFirstMin(int[] a, int start, int end, int target) {


        if (start > end) {
            return -1;

        }
        if (a[end] <= target) {
            return end;
        }


        int mid = (start + end) / 2;

        if (a[mid] == target) {
            return mid;
        }

        if (mid > 0 && a[mid - 1] <= target && target < a[mid]) {
            return mid - 1;
        }

        if (target < a[mid]) {
            return findFirstMin(a, start, mid - 1, target);
        }

        return findFirstMin(a, mid + 1, end, target);
    }


    private static int[] deduplicateAndSort(int[] a) {
        int[] r = Arrays.stream(a).boxed().distinct().sorted().mapToInt(x -> x).toArray();
        return r;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        System.out.println(String.valueOf(ans));

        scanner.close();
    }
}
