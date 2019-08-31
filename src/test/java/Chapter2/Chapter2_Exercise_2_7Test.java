package Chapter2;

import static org.junit.Assert.*;
import org.junit.Test;
import static Chapter2.Chapter2_Exercise_2_7.*;

public class Chapter2_Exercise_2_7Test {

    @Test
    public void testPartialA() {
        Function<Integer, Function<Double, Double>> f = a -> b -> a * (1 + b / 100);
        Function<Double, Double> g = Chapter2_Exercise_2_7.partialA(89, f);

        assertEquals(f.apply(89).apply(7.0), g.apply(7.0));
        assertEquals(f.apply(89).apply(0.0), g.apply(0.0));
        assertEquals(f.apply(89).apply(16.65), g.apply(16.65));
    }

}