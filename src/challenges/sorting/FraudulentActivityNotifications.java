package challenges.sorting;

import java.lang.*;
import java.util.*;

public class FraudulentActivityNotifications
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int d = in.nextInt();

        int[] expenditures = collectInput(in,n);
        int notifications = computeNotifications(expenditures,d);
        printResult(notifications);
    }

    public static int[] collectInput(Scanner in, int n)
    {
        int[] expenditures = new int[n];
        for(int i = 0; i < n; i++)
            expenditures[i] = in.nextInt();

        in.close();

        return expenditures;
    }

    public static int computeNotifications(int[] expenditures, int d)
    {
        int n = expenditures.length;
        int notifications = 0;

        Queue<Integer> medianArray = new LinkedList<Integer>();
        int[] countArray = new int[201];
        //Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();

        int i = 0;
        while(i < n)
        {
            if(medianArray.size() < d)
            {
                medianArray.add(expenditures[i]);
                countArray[expenditures[i]]++;
        /*
        if(countMap.containsKey(expenditures[i]))
          countMap.put(expenditures[i],countMap.get(expenditures[i]) + 1);
        else
          countMap.put(expenditures[i],1);*/
            }

            else
            {
                int[] medianSortedArray = sortMedianArray(countArray,d);
                //int[] medianSortedArray = sortMedianArray(countMap,d);
                double median = getMedian(medianSortedArray);

                boolean toNotify = check(expenditures[i],median);
                if(toNotify)
                    notifications++;

                int beginElem = (Integer) medianArray.remove();
                countArray[beginElem]--;
        /*countMap.put(beginElem,countMap.get(beginElem) - 1);
        if((Integer) countMap.get(beginElem) == 0)
          countMap.remove(beginElem);*/

                medianArray.add(expenditures[i]);
                countArray[expenditures[i]]++;
        /*if(countMap.containsKey(expenditures[i]))
          countMap.put(expenditures[i],countMap.get(expenditures[i] + 1));
        else
          countMap.put(expenditures[i],1);*/
            }

            i++;
        }

        return notifications;
    }

    public static void printResult(int notifications)
    {
        System.out.println(notifications);
    }

    private static int[] sortMedianArray(int[] countArray, int d)
    //private static int[] sortMedianArray(Map<Integer,Integer> countMap, int d)
    {
        int[] sortedMedianArray = new int[d];
        int index = 0;

        for(int i = 0; i < 201; i++)
        {
            int repeat = countArray[i];
            while(repeat > 0)
            {
                sortedMedianArray[index++] = i;
                repeat--;
            }
        }

    /*
    Set set = countMap.entrySet();
    Iterator iter = set.iterator();

    while(iter.hasNext())
    {
      Map.Entry m = (Map.Entry) iter.next();

      int expenditure = (Integer) m.getKey();
      int repeat = (Integer) m.getValue();

      while(repeat > 0)
			{
				sortedMedianArray[index++] = expenditure;
				repeat--;
			}
    }
    */
        return sortedMedianArray;
    }

    private static double getMedian(int[] medianArray)
    {
        int d = medianArray.length;
        double median;

        if(d % 2 == 1) // odd
        {
            int medianPosition = (d + 1) / 2;
            int medianIndex = medianPosition - 1;

            median = (double) medianArray[medianIndex];
        }
        else // even
        {
            int medianPosition1 = d/2;
            int medianPosition2 = d/2 + 1;

            int medianIndex1 = medianPosition1 - 1;
            int medianIndex2 = medianPosition2 - 1;

            median = computeAverage(medianArray[medianIndex1],medianArray[medianIndex2]);
        }
        return median;
    }

    private static double computeAverage(int num1, int num2)
    {
        return ((double)num1 + (double)num2) / 2;
    }

    private static boolean check(int expenditure, double median)
    {
        if(expenditure >= (2 * median))
            return true;

        return false;
    }
}