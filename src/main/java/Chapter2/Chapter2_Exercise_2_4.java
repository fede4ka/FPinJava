package Chapter2;

//Write a function to compose the two functions square and triple used in exercise 2.2.

public class Chapter2_Exercise_2_4 {

    public static final Function<Integer, Integer> triple = x -> x * 3;

    public static final Function<Integer, Integer> square = x -> x * x;

    public static final Function<Function<Integer, Integer>,
                        Function<Function<Integer, Integer>, Function<Integer, Integer>>> compose =
            f1 -> f2 -> arg ->  f1.apply(f2.apply(arg));

    public static final Function<Integer, Integer> f = compose.apply(square).apply(triple);
}