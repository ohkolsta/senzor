import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

    Car_1 seconds = new Car_1();

    @Test
    public void CalculateSpeed1(){
        assertTrue(seconds.warning(80, 100));
        assertFalse(seconds.warning(100, 21));
    }
}