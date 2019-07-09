package interviewKit.dictionaries;

import scala.Char;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        int[] freqs = new int[26];
        String rs = "NO";
        for (char c : s1.toCharArray()) {
            freqs[c - 97] = freqs[c - 97] + 1;
        }

        for (char c : s2.toCharArray()) {
            if (freqs[c - 97] > 0) {
                rs = "YES";
                break;
            }
        }

        return rs;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }

        scanner.close();
    }
}
