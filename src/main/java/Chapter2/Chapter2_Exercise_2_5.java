package Chapter2;

//Write a polymorphic version of the compose function.

public class Chapter2_Exercise_2_5  {
    static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T, V>>> higherCompose() {
     return    fUV->fTU->argT-> fUV.apply(fTU.apply(argT));
    }
}