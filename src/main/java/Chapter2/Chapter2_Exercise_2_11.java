package Chapter2;

//Write a method to swap the arguments of a curried function.

public class Chapter2_Exercise_2_11 {
    public static <T, U, V> Function<U, Function<T, V>> reverseArgs(Function<T, Function<U, V>> f) {
     return u->t->f.apply(t).apply(u)   ;
    }
}