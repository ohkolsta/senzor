import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateSecondsTest {

    private double distance = 99999;
    private double speed = 99999;
    CalculateSeconds seconds = new CalculateSeconds(distance);

    @Test
    public void CalculateSpeed1(){
        assertTrue(seconds.warning(80, 100));
        assertFalse(seconds.warning(100, 21));
    }
}