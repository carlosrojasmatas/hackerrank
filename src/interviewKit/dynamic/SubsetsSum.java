package interviewKit.dynamic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubsetsSum {


    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        return loop(arr,0,new HashMap<>(),Integer.MIN_VALUE);
    }

    private static int loop(int[]arr, int i, Map<Integer,Integer> maxs,int max){
        if(i >= arr.length) return max;
        int curr = arr[i];
        if(i <= 1 ) {
            if(curr > max){
                max = curr;
            }
            maxs.put(i,max);
        }else{

            int localMax = curr + maxs.get(i-2);

            if(curr >localMax && curr > max ){
                max = curr;
            }else if(localMax > curr && localMax > max){
                max = localMax;
            }

            maxs.put(i,max);

        }

        return loop(arr,i+1,maxs,max);

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
