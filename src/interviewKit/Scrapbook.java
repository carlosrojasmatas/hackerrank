package interviewKit;

import java.util.ArrayList;
import java.util.List;

public class Scrapbook {

    void some(List<?> l){
        swapHelper(l,1,2);
    }

    private <E> void swapHelper(List<E> l, int i, int j){
        l.set(i,l.set(j,l.get(i)));
    }
}
