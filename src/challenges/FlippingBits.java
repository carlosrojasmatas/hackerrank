package challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by carlosrojasmatas on 10/5/16.
 */
public class FlippingBits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer t = sc.nextInt();

        List<String> rs = new ArrayList<>();

        for(int i = 0 ; i <t ; i++){
            Long v = sc.nextLong();
            String paddingPattern ="00000000000000000000000000000000";
            String ls = Long.toBinaryString(v);
            String padded = paddingPattern.substring(ls.length()) + ls;

            StringBuffer bf = new StringBuffer();
            for (char c : padded.toCharArray()) {
                if(c =='0') bf.append('1');
                else bf.append("0");
            }

            rs.add(bf.toString());
        }


        rs.forEach(l -> System.out.println(Long.parseUnsignedLong(l,2)));


    }
}
