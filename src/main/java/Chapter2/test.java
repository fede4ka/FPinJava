package Chapter2;

import static Chapter2.Chapter2_Exercise_2_1.compose;
import static Chapter2.Chapter2_Exercise_2_1.square;

public class test {
    public static void main(String[] args) {
        System.out.println("Hello");

int test = compose(square,square).apply(3);

        System.out.println(test);
        System.out.println(testStr1);



    }

  static   <A, B, C, D> String func(A a, B b, C c, D d) { return String.format("%s, %s, %s, %s", a, b, c, d);}

    static String testStr1 = func(1,2,3,4);

}
