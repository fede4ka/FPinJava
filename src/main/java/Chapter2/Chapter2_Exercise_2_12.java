package Chapter2;

//Write a recursive factorial function.

public class Chapter2_Exercise_2_12 {

    public static final Function<Integer, Integer> factorial0 =
            n -> n <= 1 ? n : n * Chapter2_Exercise_2_12.factorial0.apply(n - 1);

    public static Function<Integer, Integer> factorial1;
    static {
        factorial1 = n -> n <= 1 ? n : n * factorial1.apply(n - 1);
    }

    public final Function<Integer, Integer> factorial2 = n -> n <= 1 ? n : n * this.factorial2.apply(n - 1);

    public Function<Integer, Integer> factorial3;
    {
        factorial3 = n -> n <= 1 ? n : n * factorial3.apply(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial0.apply(10));
        System.out.println(factorial1.apply(10));
        Chapter2_Exercise_2_12 x = new Chapter2_Exercise_2_12();
        System.out.println(x.factorial2.apply(10));
        System.out.println(x.factorial3.apply(10));
    }
}