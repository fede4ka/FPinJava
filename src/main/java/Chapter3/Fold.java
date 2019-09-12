package Chapter3;

import Chapter2.Function;
import java.util.List;
import static Chapter3.CollectionUtilities.*;


public class Fold {

    //Create a method to fold a list of integers that can be used, for example, to sum the
    //elements of a list. This method will take a list of integers, an integer starting value, and a
    //function as its parameters.

    public static Integer fold(List<Integer> is, Integer identity,
                               Function<Integer, Function<Integer, Integer>> f) {
        Integer acc = identity;
                for (Integer elem:is) { acc = f.apply(acc).apply(elem); }
         return acc;
    }
}
