package interviewKit.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MinimumTimeRequired {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        //sort the main array
        Arrays.sort(machines);

        long minDays = 0L;
        long maxDays = machines[machines.length - 1] * goal;
        long count = 0;
        while(minDays < maxDays){

            long mid = (maxDays + minDays) / 2;

            long prod = 0 ;
            for(long m:machines){
                prod += mid / m;
            }

            if(prod < goal){
                minDays = mid + 1;
            }else{
                maxDays = mid;
                count = mid;
            }

        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        System.out.println(String.valueOf(ans));

        scanner.close();
    }

}
