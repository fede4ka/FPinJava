package Chapter2;

//Write a method to partially apply a curried function of two arguments to its second
//argument.

public class Chapter2_Exercise_2_8 {
    public static <A, B, C> Function<A, C> partialB(B b, Function<A, Function<B, C>> f) {
        return a-> f.apply(a).apply(b);
    }
}