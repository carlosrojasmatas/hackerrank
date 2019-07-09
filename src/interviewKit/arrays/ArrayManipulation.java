package interviewKit.arrays;

import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n];


        // initilize the array
        for (int i = 0; i < n; i++) {
            array[i] = 0;
        }

        for (int[] coord : queries) {

            int val =  coord[2];
            int left = coord[0];

            int right = coord[1];

            if(right >= n){
                right -= 1;
            }


            int leftVal = val;
            int rightVal = val * -1;

            if(array[left - 1] == 0 ) array[left - 1] = leftVal;
            else array[left - 1] += leftVal;

            if(coord[1] < n){
                if(array[right] == 0 ) array[right] = rightVal;
                else array[right] += rightVal;
            }

        }


        long curr = array[0];
        long max = 0;
        for(int i = 1 ; i < n ; i++){

            if(array[i] == 0 ){
                array[i] = curr;
            }else {
                array[i] += curr;
                curr = array[i];
            }

            if(curr > max)
                max = curr;
        }

        return max;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//        int[] arr = {3,0,0,7,0,3,1,0,7,1};
//        int curr = arr[0];
//
//        for(int i = 1 ; i < arr.length ; i++){
//
//            if(arr[i] == 0 )
//                arr[i] = curr;
//            else{
//                arr[i] += curr;
//                curr = arr[i];
//            }
//
//        }

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
