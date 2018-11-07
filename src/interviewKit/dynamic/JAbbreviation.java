package interviewKit.dynamic;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JAbbreviation {

    private static int aInt = 'a';
    private static int zInt = 'z';


    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        if (a.toUpperCase().equals(b)) return "YES";
        if (a.length() < b.length()) return "NO";

        boolean rs = loop(a.toCharArray(), b.toCharArray(),0, 0, new HashMap<>());
        if (rs) return "YES";
        else return "NO";
    }


    static boolean loop(char[]a, char[]b, int i, int j, Map<String,Boolean>mem){
        // all good, we are at the end
        if(i == a.length && j == b.length) return true;
        //exahusted, but still with chars to go
        if(i == a.length && j < b.length) {
            return false;
        }
        String key = i + ":" + j;
        if(mem.containsKey(key)) return mem.get(key);
        //characters in b exahusted, check if can loop
        char currA = a[i];
        if(i < a.length && j == b.length) {
            boolean result = isLower(currA) && loop(a,b,i+1,j,mem);
            mem.put(key,result);
            return  result;
        }

        // first char is uppercase, but either I have no more characters to compare with or they are different
        char currB = b[j];
        if(!isLower(currA) && (j == b.length ||  currA != currB)) return false;


        //if is lower, the can be changed
        boolean result = false;
        if(isLower(currA)){
            //same "absolute" character
            if(currA - 32 == currB){
                //check both cases, either using the char or not using it
                result = loop(a,b,i+1,j+1,mem) || loop(a,b,i+1,j,mem);
            }else{
                //I have to remove it
                result = loop(a,b,i+1,j,mem);
            }

            mem.put(key,result);
            return result;
        }else{ //not lower
            if(currA != currB) result = false;
            else {
                result = loop(a,b,i+1,j+1,mem);
            }

            mem.put(key,result);
            return result;
        }

    }

    static boolean isLower(char c) {
        return c >= aInt && c <= zInt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            System.out.println(result);
        }

        scanner.close();
    }
}
