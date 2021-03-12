package interviewKit.snq;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] hist) {

        Stack<Integer> positions = new Stack<>();
        Stack<Integer> bars = new Stack<>();

        int maxArea = 0;

        int i = 0;
        int startPos = i;
        while (i < hist.length) {
            if (bars.isEmpty() || hist[i] >= bars.peek()) {
                bars.push(hist[i++]);
                positions.push(startPos);
                startPos = i;
            } else {
                int tip = bars.pop();
                int tipPos = positions.pop();

                if (bars.isEmpty() || tip > bars.peek()) {
                    int area = tip * (i - tipPos);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                    startPos = tipPos;
                }
            }
        }

        while (!bars.isEmpty()) {
            int tip = bars.pop();
            int tipPos = positions.pop();
            if (bars.isEmpty() || tip > bars.peek()) {
                int area = tip * (i - tipPos);
                if (area > maxArea) {
                    maxArea = area;
                }
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
