package Chapter2;

//Write a functional method to partially apply a curried function of two arguments to its
//first argument.

public class Chapter2_Exercise_2_7  {
    public static <A, B, C> Function<B, C> partialA(A a, Function<A, Function<B, C>> f) {
        return b-> f.apply(a).apply(b);
    }
}