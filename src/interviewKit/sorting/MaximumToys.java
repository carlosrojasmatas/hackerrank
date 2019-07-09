package interviewKit.sorting;

import java.io.IOException;
import java.util.Scanner;

public class MaximumToys {


    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
      sort(prices);

      if(prices[0] > k) return 0;
      if(prices[0] == k ) return 1;

      int nr = 0;
      for(int i = 0 ; i <= prices.length - 1; i++){

          if(prices[i] <= k){
              k = k - prices[i];
              nr++;
          }
      }

      return nr;
    }

    static void sort(int[] prices) {
        qSort(prices,0, prices.length - 1 );
    }

    private static void qSort(int[] prices, int start, int end) {
        if (start < end) {
            int pivot = partition(prices, start, end);
            qSort(prices, start, pivot - 1);
            qSort(prices, pivot + 1, end);
        }
    }

    private static int partition(int[] prices, int start, int end) {
        int pivot = prices[end];
        int i = start;

        for (int j = i; j <= end - 1; j++) {
            if (prices[j] < pivot) {
                if(i != j){
                    int aux = prices[i];
                    prices[i] = prices[j];
                    prices[j] = aux;
                }
                i++;
            }
        }

        int aux = prices[i];
        prices[i] = prices[end];
        prices[end] = aux;

        return i;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
