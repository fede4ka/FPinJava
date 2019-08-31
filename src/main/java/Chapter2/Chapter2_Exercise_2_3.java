package Chapter2;

//Write a function to add two Integers.

public class Chapter2_Exercise_2_3 {
    public static final Function<Integer, Function<Integer, Integer>> add = x->y->x+y;
    public static final BinaryOperator add2 = x -> y ->x+y;
    public static final BinaryOperator mult = x -> y -> x * y;
}