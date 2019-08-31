package Chapter2;

//Write the compose method

public class Chapter2_Exercise_2_1 {
    public static void main(String[] args) {
        System.out.println();
    }
    public static final Function<Integer, Integer> triple = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer arg) {
            return arg * 3;
        }
    };

    public static final Function<Integer, Integer> square = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer arg) {
            return arg * arg;
        }
    };

    public static final Function<Integer, Integer> compose(final Function<Integer, Integer> f1,
                                                           final Function<Integer, Integer> f2) {
        return new Function <Integer, Integer>() {
            @Override
            public Integer apply (Integer x) {
               return f1.apply(f2.apply(x));
            }

        };
    }
}