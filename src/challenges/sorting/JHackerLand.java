package challenges.sorting;

import scala.io.StdIn;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class JHackerLand {


    private static final Scanner scanner = new Scanner(System.in);

    private static int m1 = 0;
    private static int m2 = 0;

    public static void main(String[] args) throws IOException {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            expenditure[i] = scanner.nextInt();
        }

        scanner.close();
        if (d % 2 == 0) {
            m2 = d / 2;
            m1 = m2 - 1;
        } else {
            m1 = d / 2;
            m2 = m1;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(String.valueOf(result));


    }

    private static int activityNotifications(int[] expenditures, int d) {

        int not = 0;
        //init freq array
        int[] frequencies = new int[201];

        for (int i = 0; i < d; i++) {
            int el = expenditures[i];
            frequencies[el]++;
        }

        for(int i = d; i < expenditures.length ; i ++){
            double m = median(frequencies);
            int in = expenditures[ i];
            int out = expenditures[i - d];
            if (in >=  m * 2) not++;
            frequencies[in]++;
            frequencies[out]--;
        }

        return not;
    }


    private static int[] shiftExpenditures(int[] expenditures, int start, int end, int d) {
        int[] newArray = new int[d];

        int k = 0;
        for (int i = start; i < end; i++) {
            newArray[k++] = expenditures[i];
        }
        return newArray;
    }


    private static double median(int[] freqs) {
        int n  = freqs.length;
        int[] cumulative = new int[n];

        for(int i =  0 ; i < n; i++){
            if(i == 0)
                cumulative[i] =  freqs[i];
            else{
                cumulative[i] = cumulative[ i - 1] + freqs[i];
            }
        }

        boolean go = true;
        double m = -1;
        double a = 0;
        double b = 0;
        for(int i = 0; i < n && go; i ++){
            if(m1 == m2){
                if(cumulative[i] > m1){
                    m = i;
                    go = false;
                }
            }else{
                if(cumulative[i] > m1 && a == 0){
                    a = i;
                }
                if(cumulative[i] > m2){
                    b = i;
                    m = (a * 1.0 + b * 1.0) / 2;
                    go = false;
                }
            }
        }

        return m;
    }

//    private static int[] sort(int[] target) {
//        int[] sorted = new int[target.length];
//        int k = 0;
//        for (int i = 0; i < 201 && k <= m2; i++) {
//            for (int j = 0; j < frequencies[i]; j++) {
//                sorted[k++] = i;
//            }
//        }
//        return sorted;
//    }
}
