package Chapter2;

//Write the higherAndThen function that composes the functions the other way around,
// which means that higherCompose(f, g) is equivalent to higherAndThen(g, f).

public class Chapter2_Exercise_2_6 {
    static <T, U, V> Function<Function<T, U>, Function<Function<U, V>, Function<T, V>>> higherAndThen() {
        return    fTU->fUV->argT-> fUV.apply(fTU.apply(argT));
}
}