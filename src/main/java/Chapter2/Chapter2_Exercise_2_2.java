package Chapter2;

//Write a new version of the compose method by using lambdas.

public class Chapter2_Exercise_2_2  {

    public static final Function<Integer, Integer> triple = x -> x * 3;

    public static final Function<Integer, Integer> square = x -> x * x;

    public static final Function<Integer, Integer> compose(final Function<Integer, Integer> f1,
                                                           final Function<Integer, Integer> f2) {
    return x -> f1.apply(f2.apply(x));
    }
}