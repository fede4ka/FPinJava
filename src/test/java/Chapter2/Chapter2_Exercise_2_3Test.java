package Chapter2;
import org.junit.Test;
import static org.junit.Assert.*;
import static Chapter2.Chapter2_Exercise_2_3.*;

public class Chapter2_Exercise_2_3Test {

    @Test
    public void test() {
        assertEquals(Integer.valueOf(8), add.apply(3).apply(5));
        assertEquals(Integer.valueOf(8), add2.apply(3).apply(5));
        assertEquals(Integer.valueOf(15), mult.apply(3).apply(5));
System.out.println("Ok.");
    }

}
