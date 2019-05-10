package interviewKit.string;

import java.io.IOException;
import java.util.Scanner;

public class Alternating {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        int count = 0 ;
        char[] array = s.toCharArray();

        for(int i = s.length() -  1; i >= 1 ; i--){
            if(array[i] == array[ i - 1])
                count++;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
