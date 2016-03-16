import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {
	
	   Car car1 = new Car("cardata/velocity_car_1.txt", "cardata/distSim.txt");
	   GUIService gs = new GUIService();
		
	
	public CarTest() throws InterruptedException{

	
	}
    @Test
    public void CalculateDistance(){
    	
        Double expectedDouble = (double) 100;

        Double resultDouble =  gs.getDistanceSim();

        assertEquals(expectedDouble, resultDouble);
    }

    @Test
    public void CalculateSpeed(){
    	
    	Double expectedDouble = (double) 20.039999;

        Double resultDouble =  gs.getSpeed();

        assertEquals(expectedDouble, resultDouble);
    }
    
    @Test
    public void DIsplayWarning() throws InterruptedException{
    	
    	gs.getSpeed();
    	
    	gs.getDistanceSim();
        
    	assertFalse(gs.displayWarning());
    }
}