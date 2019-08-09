package interviewKit.search;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class MaxSubarraySum {

    static long maximumSum(long[] a, long m) {

        TreeSet<Long> sortedIdx = new TreeSet<>();

        long curr = 0;

        long rs = 0;
        for (int i = 0; i < a.length; i++) {

            curr = (a[i] % m + curr) % m;

            Iterator<Long> it = sortedIdx.tailSet(curr + 1).iterator();

            if(it.hasNext()){

                long e = it.next();
                rs = Math.max((curr - e + m) % m, rs);

            }

            rs = Math.max(curr, rs);
            sortedIdx.add(curr);
        }




        return rs;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            System.out.println(String.valueOf(result));
        }


        scanner.close();
    }
}
