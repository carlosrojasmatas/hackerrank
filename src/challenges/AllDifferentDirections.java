package challenges;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by carlosrojasmatas on 10/7/16.
 */
public class AllDifferentDirections {


    private static class Coordinate{
        Double x;
        Double y;

        public Coordinate(Double x, Double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(System.getProperty("line.separator"));
        int tc = sc.nextInt();

        while(tc > 0){
            int it = 0;
            Coordinate[] coords = new Coordinate[tc];

            while(it < tc){
                String line = sc.next();
                String[] terms = line.split(" ");
                String[] directions = Arrays.copyOfRange(terms,3,terms.length);
                Double currx =Double.valueOf(terms[0]); ;
                Double curry = Double.valueOf(terms[1]);
                Double alpha = Double.parseDouble(directions[0]);
                directions = Arrays.copyOfRange(directions,1,directions.length);
                int t = 0;
                while(directions.length > 0 ){
                    if(directions[t].equals("walk")){
                        Double h = Double.parseDouble(directions[t+1]);
                        Double corrx = Math.cos(Math.toRadians(alpha)) * h;
                        Double corry = Math.sin(Math.toRadians(alpha)) * h;
                        currx = currx + corrx;
                        curry = curry + corry;
                    }else if(directions[t].equals("turn")){
                        alpha = alpha + Double.parseDouble(directions[t+1]);
                    }
                    directions = Arrays.copyOfRange(directions,t+1,directions.length);
                }

                coords[it] = new Coordinate(currx,curry);
                System.out.println(String.format("%s - %s",currx.toString(),curry.toString()));
                it++;
            }

            Double avgx = 0d;
            Double avgy = 0d;
            for(Coordinate c:coords){
                avgx = (avgx + c.x);
                avgy = (avgy + c.y);
            }
            avgx = avgx / coords.length;
            avgy = avgy / coords.length;
            System.out.println("test result = " + avgx.toString()+ " , " + avgy.toString());
            tc = sc.nextInt();
        }

    }



    private static Integer relativeDegree(Integer deg) {
        return deg - 90 * (deg / 90);
    }
}
