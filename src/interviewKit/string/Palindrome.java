package interviewKit.string;

import java.io.IOException;
import java.util.Scanner;

public class Palindrome {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

        int total = 0;

        int[] freqs = new int[n];

        int i = 0 ;
        while(i < n) {

            freqs[i] = 0;
            char curr = s.charAt(i);
            int count = 0;
            int j = i;

            while (j < n && curr == s.charAt(j)) {
                count++;
                j++;
            }

            total += count * (count + 1) / 2;
            int k = i;

            while (k < j) {
                freqs[k] = count;
                k++;
            }

            i = j;

        }

        for (int e = 1; e < n; e++) {

            boolean areEquals = e < (n - 1) && s.charAt(e - 1) == s.charAt(e + 1);
            boolean centerIsDifferent = s.charAt(e) != s.charAt( e -1 );

            if(areEquals && centerIsDifferent)
                total += Math.min(freqs[e-1],freqs[e+1]);

        }


        return total;

    }


    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
