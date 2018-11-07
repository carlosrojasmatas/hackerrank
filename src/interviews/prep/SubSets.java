package interviews.prep;

import java.util.HashMap;
import java.util.Map;

public class SubSets {

    static int count(int[] nrs,int amount){

        return loop(nrs,0,amount,new HashMap<>());
    }

    static int loop(int[] nrs, int i, int amount, Map<String,Integer> mem){

        if(amount == 0) return 1;
        if(amount < 0) return 0;
        if(i > nrs.length - 1) return 0;

        String key = keyFor(i,amount);

        if(mem.containsKey(keyFor(i,amount))){
            System.out.println("Using the cache for key " + key);
            return mem.get(key);
        }
        else{

            int curr = nrs[i];
            if(amount < curr){
                int val = loop(nrs,i + 1,amount,mem);
                mem.put(key,val);
                return val;
            }
            else{
                int val = loop(nrs,i + 1,amount - curr, mem) +
                        loop(nrs,i + 1,amount ,mem);
                mem.put(key,val);
                return val;
            }
        }
    }

    static String keyFor(int it,int am ){
        return it + ":" + am;
    }

    public static void main(String[] args) {
        int[] nrs = new int[]{2,6,4,10};
        System.out.println(count(nrs,16));
    }
}
