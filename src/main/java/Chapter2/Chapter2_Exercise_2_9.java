package Chapter2;

//Convert the following method into a curried function:
//<A, B, C, D> String func(A a, B b, C c, D d) {
//    return String.format("%s, %s, %s, %s", a, b, c, d);}


public class Chapter2_Exercise_2_9 {

    private static String format = "%s, %s, %s, %s";

    public static <A, B, C, D> Function<A, Function<B, Function<C, Function<D, String>>>> f() {
       return a->b->c->d-> String.format("%s, %s, %s, %s", a, b, c, d) ;
    }
}