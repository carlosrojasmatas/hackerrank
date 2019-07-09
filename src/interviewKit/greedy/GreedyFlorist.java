package interviewKit.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int[] currShops = new int[k];


        for (int i = 0; i < k; i++) {
            currShops[i] = 0;
        }

        int cf = c.length - 1;
        int total = 0;

        for(int i = 0 ; cf >= 0  ; i++){

            if(i == k) i -= k;
            int cs = currShops[i];
            total += (cs + 1) * c[cf];
            currShops[i]++;
            cf--;
        }

        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        System.out.println(String.valueOf(minimumCost));

        scanner.close();
    }
}
