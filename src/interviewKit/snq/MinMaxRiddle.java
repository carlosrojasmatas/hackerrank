package interviewKit.snq;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MinMaxRiddle {

    private static int[] nextSmallest(long[] array) {

        Stack<Integer> s = new Stack<>();
        int[] rs = new int[array.length];
        int i = 0;
        while (i < array.length) {
            long curr = array[i];
            if (s.isEmpty() || array[s.peek()] <= curr) {
                s.push(i++);
            } else {
                int min = s.pop();
                rs[min] = i;
            }
        }

        while (!s.isEmpty()) {
            int el = s.pop();
            rs[el] = array.length;
        }

        return rs;
    }

    private static int[] prevSmallest(long[] array) {
        Stack<Integer> s = new Stack<>();
        int[] rs = new int[array.length];
        int i = array.length - 1;
        while (i >= 0) {
            long curr = array[i];
            if (s.isEmpty() || array[s.peek()] <= curr) {
                s.push(i--);
            } else {
                int min = s.pop();
                rs[min] = i;
            }
        }

        while (!s.isEmpty()) {
            int el = s.pop();
            rs[el] = -1;
        }

        return rs;
    }

    static long[] riddle(long[] arr) {

        int[] prevSmall = prevSmallest(arr);
        int[] nextSmall = nextSmallest(arr);

        long[] res = new long[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            int l = nextSmall[i] - prevSmall[i] - 1;
            res[l] = Long.max(res[l], arr[i]);
        }

        for(int i = arr.length -1 ; i >0 ; i--){
            res[i] = Long.max(res[i],res[i + 1]);
        }
        return Arrays.copyOfRange(res,1,res.length);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);

            if (i != res.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
        scanner.close();
    }
}
