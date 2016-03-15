import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {
	
	public CarTest() throws InterruptedException{

	    Car car1 = new Car("../cardata/velocity_car_1.txt", "cardata/distSim.txt");

	    Car car2 = new Car("../cardata/velocity_car_2.txt", "cardata/distSim.txt");
		
	}
    @Test
    public void CalculateSpeed1(){
        assertTrue(car1.warning(80, 100));
        assertFalse(car1.warning(100, 21));
    }

    @Test
    public void CalculateSpeed2(){
        assertTrue(car2.warning(80, 100));
        assertFalse(car2.warning(100, 21));
    }
}