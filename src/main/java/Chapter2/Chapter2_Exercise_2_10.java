package Chapter2;

//Write a method to curry a function of a Tuple<A, B> to C.

public class Chapter2_Exercise_2_10 {

    public static <A, B, C> Function<A, Function<B, C>> curry(Function<Tuple<A, B>, C> f) {
       return a->b->f.apply(new Tuple<>(a,b));
    }
}