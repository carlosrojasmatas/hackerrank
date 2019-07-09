package interviewKit.string;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class CommonChild {


    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        if (s1.equals(s2)) {
            return s1.length();
        } else if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        } else {
            return lcs(s1, s2);
        }
    }

//    static int lcs(String s1, String s2, int r, int c, Map<String, Integer> mem) {
//
//        if (r == s1.length() || c == s2.length()) {
//            return mem.get(keyGenerator.apply(s1.length() - 1 , s2.length() - 1 ));
//        }
//
//        if (c == 0 || r == 0) {
//            mem.put(keyGenerator.apply(r, c), 0);
//        } else {
//
//            char rc = s1.charAt(r);
//            char cc = s2.charAt(c);
//
//            int curr = 0;
//            if (rc == cc) {
//                int xprev = mem.get(keyGenerator.apply(r - 1, c));
//                curr = xprev + 1;
//            } else {
//
//                int xprev = mem.get(keyGenerator.apply(r - 1, c));
//                int yprev = mem.get(keyGenerator.apply(r, c - 1));
//
//                if (xprev == yprev || xprev > yprev)
//                    curr = xprev;
//                else
//                    curr = yprev;
//            }
//
//            mem.put(keyGenerator.apply(r,c),curr);
//
//        }
//
//        int nextCol = c;
//        int nextRow = r;
//
//        if (c == s2.length() - 1 && r < s1.length()) {
//            nextCol = 0;
//            nextRow++;
//        } else {
//            nextCol++;
//        }
//
//        return lcs(s1, s2, nextRow, nextCol, mem);
//
//
//    }

    static int lcs(String s1, String s2) {
        int[][] mem = new int[s1.length() + 1][s2.length() + 1];

        for (int r = 0; r <= s1.length(); r++) {
            for (int c = 0; c <= s2.length(); c++) {
                if (c == 0 || r == 0) {
                    mem[r][c] = 0;
                } else {

                    char rc = s1.charAt(r - 1);
                    char cc = s2.charAt(c - 1);

                    int curr = 0;
                    if (rc == cc) {
                        int xprev = mem[r-1][c-1];
                        curr = xprev + 1;
                    } else {

                        int xprev = mem[r - 1][c];
                        int yprev = mem[r][c - 1];

                        if (xprev == yprev)
                            curr = xprev;
                        else {
                            if (xprev > yprev)
                                curr = xprev;
                            else
                                curr = yprev;
                        }
                    }

                    mem[r][c] =curr;
                }


            }
        }

        return mem[s1.length()][s2.length()];

    }

    static Map<String, List<String>> lcsStr(String s1, String s2) {
        BiFunction<Integer, Integer, String> keyGenerator = (r, c) -> String.valueOf(r) + ":" + String.valueOf(c);
        Map<String, List<String>> mem = new HashMap<>();

        for (int r = 0; r <= s1.length(); r++) {
            for (int c = 0; c <= s2.length(); c++) {
                if (c == 0 || r == 0) {
                    mem.put(keyGenerator.apply(r, c), new ArrayList<>());
                } else {

                    char rc = s1.charAt(r - 1);
                    char cc = s2.charAt(c - 1);

                    List<String> curr;
                    if (rc == cc) {

                        curr = mem.get(keyGenerator.apply(r - 1, c));
                        if (curr.isEmpty()) {
                            curr.add(String.valueOf(rc));
                        } else {
                            curr = curr.stream().map(e -> e.concat(String.valueOf(rc))).collect(Collectors.toList());
                        }

                    } else {

                        List<String> xprev = mem.get(keyGenerator.apply(r - 1, c));
                        List<String> yprev = mem.get(keyGenerator.apply(r, c - 1));

                        if (xprev.isEmpty()) {
                            curr = yprev;
                        } else if (yprev.isEmpty()) {
                            curr = xprev;
                        } else {
                            if (xprev.get(0).length() == yprev.get(0).length())
                                curr = xprev;
                            else {
                                if (xprev.get(0).length() > yprev.get(0).length())
                                    curr = xprev;
                                else
                                    curr = yprev;
                            }
                        }


                    }

                    mem.put(keyGenerator.apply(r, c), curr);

                }


            }
        }

        return mem;

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
