package Chapter3;

import Chapter2.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionUtilities {

    //Write methods that create an empty list, a list with one element, and a list from a
    // collection of elements, as well as a vararg method that creates a list from a list of
    // arguments. All these lists will be immutable.

    public static <T> List<T> list() {
        return Collections.emptyList();
    }

    public static <T> List<T> list(T t) {
        return Collections.singletonList(t);
    }

    public static <T> List<T> list(List<T> ts) {
        return Collections.unmodifiableList(new ArrayList<>(ts));
    }

    @SafeVarargs
    public static <T> List<T> list(T... t) {
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(t, t.length)));
    }

    //Create two methods that return the head and the tail of a list, respectively. The list
    //passed as an argument must not be modified. Because you’ll need to make a copy of
    //the list, also define a copy method. The list returned by tail should be immutable.

    public static <T> T head(List<T> list) {

        if (list.isEmpty()) {
            throw new IllegalStateException("Empty list");
        } else return list.get(0);
    }

    private static <T> List<T> copy(List<T> ts) {
        return new ArrayList<>(ts);
    }

    public static <T> List<T> tail(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("Empty list");
        }
        List<T> result = copy(list);
        result.remove(0);
        return result;
    }

    //

    public static <T> List<T> append(List<T> list, T t) {
        List<T> ts = copy(list);
        ts.add(t);
        return Collections.unmodifiableList(ts);
    }

    public static <T> List<T> prepend(T t, List<T> list) {
        return foldLeft(list, list(t), acc -> elem -> append(acc, elem));

    }


    //Generalize the fold method to foldLeft so that it can be used to apply a left fold to a
    //list of elements of arbitrary types
    public static <T, U> U foldLeft(List<T> ts, U identity, Function<U, Function<T, U>> f) {
        U acc = identity;
        for (T elem : ts) {
            acc = f.apply(acc).apply(elem);
        }
        return acc;
    }

    //Write an imperative version of the foldRight method.

    public static <T, U> U foldRightImp(List<T> ts, U identity, Function<T, Function<U, U>> f) {
        U acc = identity;
        for (int i = ts.size(); i > 0; i--) {
            acc = f.apply(ts.get(i - 1)).apply(acc);
        }
        return acc;
    }

    // Write a recursive version of foldRight.

    public static <T, U> U foldRight(List<T> ts, U identity, Function<T, Function<U, U>> f) {
        return ts.isEmpty() ? identity : f.apply(head(ts)).apply(foldRight(tail(ts), identity, f));
    }

    // Define the reverse method without using a loop.
    public static <T> List<T> reverse(List<T> list) {
        return list.isEmpty() ? Collections.emptyList() : foldRight(list, list(), elem -> acc -> append(acc, elem));
    }

    //EXERCISE 3.10 Rewrite the map method in terms of foldLeft and foldRight
    public static <T, U> List<U> mapViaFoldLeft(List<T> list,
                                                Function<T, U> f) {
        return list.isEmpty() ? Collections.emptyList()
                : foldLeft(list, list(), acc -> elem -> append(acc, f.apply(elem)));
    }
    public static <T, U> List<U> mapViaFoldRight(List<T> list,
                                                 Function<T, U> f) {
        return list.isEmpty() ? Collections.emptyList()
                : foldRight(list, list(), elem -> acc -> prepend(f.apply(elem), acc));
    }
    //EXERCISE 3.11
    //Write a method to produce a list using a starting value, a limit, and the function x ->x + 1.
    public static List<Integer> range(int start, int end) {
        List<Integer> res =  new ArrayList<>();
        int cur = start;
       do {res = append(res,cur); cur ++;} while (cur < end);
       return res;
    }
    //EXERCISE 3.12
    //Write a generic range method
    public static <T> List<T> unfold(T seed, Function<T, T> f, Function<T, Boolean> p) {
        List<T> res =  new ArrayList<>();
        T cur = seed;
        while (p.apply(cur))
        {res = append(res,cur); cur = f.apply(cur);}
        return res;
    }
    //EXERCISE 3.13
    //Implement the range method in terms of unfold.
    public static List<Integer> rangeviaunfold(int start, int end) {
        return unfold(start, x->x+1, x->x<end);

    }
    //EXERCISE 3.14
   // Write a recursive version of range
    public static List<Integer> rangerecur(Integer start, Integer end) {
        return end<start ? list() : append(rangerecur (start, end-1), end);
    }
}