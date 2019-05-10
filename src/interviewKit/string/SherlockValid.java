package interviewKit.string;

import java.io.IOException;
import java.util.Scanner;

public class SherlockValid {

    // Complete the isValid function below.
    static String isValid(String s) {

        long[] freqs = new long[26];
        String response = "NO";


        for (int i = 0; i < 25; i++) {
            freqs[i] = 0;
        }

        for (char c : s.toCharArray()) {
            int i = c - 97;
            freqs[i]++;

        }

        long min = Integer.MAX_VALUE;
        long max = 0;
        long countMax = 0;
        long countMin = 0;
        for (int i = 0; i < 25; i++) {

            if (freqs[i] == 0) continue;

            if (freqs[i] > max) {
                max = freqs[i];
                countMax = 1;
            } else if (freqs[i] == max) {
                countMax++;
            }

            if (freqs[i] < min) {
                min = freqs[i];
                countMin = 1;
            } else if (freqs[i] == min) {
                countMin++;
            }


        }

        String answer = "NO";

        if (max == min) answer = "YES";
        if (countMax <= 1 && (max - min) <= 1) answer = "YES";
        if (countMax > 1 && countMin == 1) answer = "YES";

        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);

        scanner.close();
    }
}
