package interviewKit.arrays;

import java.util.Scanner;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        boolean chaos = false;
        int[] bribes = new int[q.length];
        int total = 0;
        for (int i = 0; i <= q.length - 1; i++) {

            if(chaos  == true) break;

            if (i != q[i] - 1) {
                for (int j = i; j <= q.length - 1; j++) {
                    if (q[i] > q[j]) {
                        int curr = bribes[q[i] - 1];
                        if(curr == 2){
                            chaos = true;
                            break;
                        }
                        bribes[q[i] - 1] = curr  +  1;
                        total = total + 1;

                        int aux = q[i];
                        q[i] = q[j];
                        q[j] = aux;

                        if(i == q[i] - 1) break;
                    }
                }
            }
        }

        if (chaos)
            System.out.println("Too chaotic");
        else
            System.out.println(total);


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }

}
