package interviewKit.queues;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] heights) {

        Stack<Integer> positions = new Stack<>();
        Stack<Integer> hs = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            int currH = heights[i];

            if (hs.isEmpty() || hs.peek() <= currH) {
                positions.push(i);
            } else {

                int j = positions.pop();
                int h = hs.pop();

                while (h >= currH) {

                    int factor = i - j;
                    long area = h * factor;
                    if (area > maxArea) {
                        maxArea = area;
                    }

                    if(hs.isEmpty()){
                       h= currH - 1;
                    }else{
                        if (hs.peek() >= currH) {
                            j = positions.pop();
                            h = hs.pop();
                        } else {
                            h = hs.peek();
                        }
                    }


                }
                positions.push(j);
            }

            hs.push(currH);
        }

        int k = heights.length;

        while (!hs.isEmpty()) {
            int curH = hs.pop();
            int j = positions.pop();
            long a = curH * (k - j);
            if (a > maxArea) {
                maxArea = a;
            }
        }

        return maxArea;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        System.out.println(result);

        scanner.close();
    }
}
