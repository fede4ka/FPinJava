package Chapter2;

import static Chapter2.Chapter2_Exercise_2_2.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Chapter2_Exercise_2_2Test {
    @Test
    public void testCompose() {
        assertEquals(Integer.valueOf(6), triple.apply(2));
        assertEquals(Integer.valueOf(4), square.apply(2));
        assertEquals(Integer.valueOf(36), square.apply(triple.apply(2)));
        assertEquals(Integer.valueOf(27), compose(triple, square).apply(3));
    }
}


