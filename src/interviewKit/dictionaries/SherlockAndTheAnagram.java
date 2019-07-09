package interviewKit.dictionaries;

import java.io.IOException;
import java.util.Scanner;

public class SherlockAndTheAnagram {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int total = 0;
        for (int width = 1; width <= s.length() - 1; width++) {

            for(int k = 0 ;k <= s.length() - width; k++){

                String sub = s.substring(k,  k + width);

                int[] subFreq = frequenciesOf(sub);
                for (int j = k + 1; j <= s.length() - width; j++) {
                    String target = s.substring(j, j + width);
                    if (areAnagrams(subFreq,frequenciesOf(target))) total = total + 1;
                }
            }
        }
        return total;
    }

    private static boolean areAnagrams(int[] f1,int[]f2){
        boolean rs = true;
        for(int i = 0 ; i < 26; i++){
            if(f1[i] != f2[i]){
                rs = false;
                break;
            }
        }

        return rs;
    }

    private static int[] frequenciesOf(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            int i = c - 97;
            f[i] = f[i] + 1;
        }

        return f;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(String.valueOf(result));
        }


        scanner.close();
    }
}
