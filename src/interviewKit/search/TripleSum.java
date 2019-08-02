package interviewKit.search;

import java.util.Arrays;
import java.util.Scanner;

public class TripleSum {



    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        //remove duplicates
        a = removeDuplicates(a);
        b = removeDuplicates(b);
        c = removeDuplicates(c);

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        long count = 0;

        int i = 0;
        while (i < b.length) {

            int aidx = findFirstMin(a,0,a.length - 1,b[i]) + 1;
            int cidx = findFirstMin(c,0,c.length - 1,b[i]) + 1;

            if(aidx >= 0 && cidx >=0 ){
                count += (aidx * cidx );
            }
            i++;

        }

        return count;

    }

    private static int findFirstMin(int[] a, int start, int end, int target){


        if(start > end){
            return -1;

        }
        if(a[end]<=target){
            return end;
        }


        int mid = (start + end) / 2;

        if(a[mid] == target){
            return mid;
        }

        if(mid > 0 && a[mid -1] <= target && target < a[mid]){
            return mid -1;
        }

        if(target< a[mid]){
            return findFirstMin(a,start,mid - 1,target);
        }

        return findFirstMin(a,mid + 1,end,target);
    }


    private static int[] removeDuplicates(int[] a) {
        int[] r = new int[a.length];
        r[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) {
                r[i] = a[i];
            }
        }
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
