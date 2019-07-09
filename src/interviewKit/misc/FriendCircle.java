package interviewKit.misc;

import scala.Int;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FriendCircle {

    // Complete the maxCircle function below.
    static int[] maxCircle(int[][] queries) {
        int[] rs = new int[queries.length];
        Map<Integer, Set<Integer>> groups = new HashMap<>();
        Map<Integer, Integer> members = new HashMap<>();

        int groupIdx = 1;
        int i = 0;
        int max = 0;
        for (int[] q : queries) {

            int a = q[0];
            int b = q[1];

            //both news
            if (!members.containsKey(a) && !members.containsKey(b)) {
                Set<Integer> newGroup = new HashSet<>();
                newGroup.add(a);
                newGroup.add(b);
                groups.put(groupIdx, newGroup);
                members.put(a, groupIdx);
                members.put(b, groupIdx);
                groupIdx++;
            }
            //left side is there but not right side
            else if (members.containsKey(a) && !members.containsKey(b)) {
                groups.compute(members.get(a), (k, v) -> {
                    v.add(b);
                    return v;
                });
                members.put(b, members.get(a));
            }
            //right side is there but not left side
            else if (!members.containsKey(a) && members.containsKey(b)) {
                groups.compute(members.get(b), (k, v) -> {
                    v.add(a);
                    return v;
                });
                members.put(a, members.get(b));
            }
            //both sides have data
            else {
                    int ga = members.get(a);
                    int gb = members.get(b);
                    if(ga != gb){
                        Set<Integer> groupa = groups.get(ga);
                        Set<Integer> groupb = groups.get(gb);

                        if(groupb.size() < groupa.size()){

                            for(int m:groupb){
                                members.put(m, ga);
                                groupa.add(m);
                            }
                            groupb = null;
                            groups.remove(gb);

                        }else{

                            for(int m:groupa){
                                members.put(m, gb);
                                groupb.add(m);
                            }
                            groupa = null;
                            groups.remove(ga);
                        }

                    }

            }

            if (groups.get(members.get(a)).size() > max) {
                max = groups.get(members.get(a)).size();
            }
            if (groups.get(members.get(b)).size() > max) {
                max = groups.get(members.get(b)).size();
            }
            rs[i++] = max;

        }

        return rs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        int[] ans = maxCircle(queries);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(String.valueOf(ans[i]));

            if (i != ans.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }
}
