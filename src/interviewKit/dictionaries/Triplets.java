package interviewKit.dictionaries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Triplets {

    static long countTriplets2(List<Long> arr, long r) {
        HashMap<Long, Long> map1 = new HashMap();
        HashMap<Long, Long> map2 = new HashMap();
        long count = 0;
        for(int i = arr.size() - 1; i >= 0; i--) {
            long a = arr.get(i);

            if(map2.containsKey(a*r))
                count += map2.get(a*r);

            if(map1.containsKey(a*r)) {
                long c = map1.get(a*r);
                map2.put(a, map2.getOrDefault(a, 0L) + c);
            }



            map1.put(a, map1.getOrDefault(a, 0L) + 1);
        }
        return count;
    }


    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        Map<Long, Long> singlets = new HashMap<>();
        Map<Long, Long> doublets = new HashMap<>();
        long total = 0;

        for (long el : arr) {

            if (doublets.containsKey(el))  //triplet found!
                total = total + doublets.get(el);

            if (singlets.containsKey(el)) { //promote to double
                long v = singlets.get(el);
                doublets.put(el * r, doublets.getOrDefault(el * r,0L) + v);
            }

            singlets.put(el * r, singlets.getOrDefault(el * r, 0L) + 1);

        }

        return total;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(String.valueOf(ans));

        bufferedReader.close();
    }
}
