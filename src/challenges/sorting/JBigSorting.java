package challenges.sorting;

import scala.math.BigInt;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JBigSorting {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<BigInteger> selectionSorter(List<BigInteger> toSort) {

        for (int i = 0; i < toSort.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < toSort.size(); j++) {
                if (toSort.get(min).compareTo(toSort.get(j)) > 0) {
                    min = j;
                }
            }
            BigInteger buff = toSort.get(i);
            toSort.set(i, toSort.get(min));
            toSort.set(min, buff);
        }
        return toSort;
    }

    public static void main(String[] args) {

//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//        List<BigInteger> unsorted = new ArrayList<>();
//
//        for (int unsortedItr = 0; unsortedItr < n; unsortedItr++) {
//            BigInteger unsortedItem = new BigInteger(scanner.nextLine());
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//            unsorted.add(unsortedItem);
//        }
//
//        List<BigInteger> result = selectionSorter(unsorted);
//
//       result.forEach(nr-> System.out.println(nr.toString()));

        String a = "2531882366050391355575974134566968043538613212060996149075948904530719392416580359757169745461988195";
        String b = "195294541694873319042720380485249001380825565396311663127260228626400961443707964165554187168383846";
    }
}
