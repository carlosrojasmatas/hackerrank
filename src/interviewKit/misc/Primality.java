package interviewKit.misc;

import java.io.IOException;
import java.util.Scanner;

public class Primality {

    // Complete the primality function below.
    static boolean primality(int n) {
        if (n <= 3) return n > 1;
        if (n % 2 == 0 || n % 3 == 0) return false;

        boolean rs = true;
        for (int i = 5; i * i <= n; i = i + 1) {
            if (n % i == 0) {
                rs = false;
                break;
            }
        }

        return rs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            boolean result = primality(n);

            if(result) System.out.println("Prime");
            else System.out.println("Not prime");
        }


        scanner.close();
    }
}
