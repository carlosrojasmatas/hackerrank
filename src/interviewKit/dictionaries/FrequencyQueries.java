package interviewKit.dictionaries;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        Map<Integer, Integer> freqsByValue = new HashMap<>();
        Map<Integer, Integer> allFreqs = new HashMap<>();
        List<Integer> rs = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {


                List<Integer> qLine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                int op = qLine.get(0);
                int val = qLine.get(1);
                int curr = freqsByValue.getOrDefault(val, 0);

                if (op == 1) {
                    int newFreq = curr + 1;
                    freqsByValue.put(val, newFreq);

                    allFreqs.put(newFreq, allFreqs.getOrDefault(newFreq, 0) + 1);
                    allFreqs.put(curr, allFreqs.getOrDefault(curr, 0) - 1);

                } else if (op == 2) {
                    if (curr > 0) {
                        int newFreq = curr - 1;
                        freqsByValue.put(val, newFreq);
                        allFreqs.put(curr, allFreqs.get(curr) - 1);
                        allFreqs.put(newFreq, allFreqs.get(newFreq) + 1);
                    }
                } else {
                    if (allFreqs.containsKey(val) && allFreqs.get(val) > 0) {
                        rs.add(1);
                    } else
                        rs.add(0);
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        System.out.println(
                rs.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );


        bufferedReader.close();
    }
}
