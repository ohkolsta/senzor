import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;


//this class makes it easy for GUI to get the data
//commented code is used with RPi
//this class should be able to return speed, distance, seconds and warning (double, double, double, boolean)


public class GUIService {
	
	//Pin echoPin = RaspiPin.GPIO_02; // PI4J custom numbering (pin 13)
    //Pin trigPin = RaspiPin.GPIO_00; // PI4J custom numbering (pin 11)
	
	public double getDistanceSim() throws InterruptedException{ //this is just for simulation
		SimDist sim = new SimDist();
    	return sim.read("cardata/distSim.txt");
	}
    	
    /*public double getDistanceFromSensor(){
        DistanceMonitor monitor = new DistanceMonitor( echoPin, trigPin );

        while( true ) {
            try {
                return monitor.measureDistance();
            }
            catch( Exception e ) {
                System.err.println( e );
            }

            try {
                Thread.sleep( 1000 );
            } catch (InterruptedException ex) {
                System.err.println( "Interrupt during trigger" );
            }
        }
    }
    */
	
	
	
	public boolean displayWarning() throws InterruptedException{
		if(getDistanceSim()/getSpeed() > 3){ //change to getDistanceFromSensor() if using RPi + sensor
			return true;
		}
		return false;
		
	}
	
	public double getSeconds() throws InterruptedException{
		return getSpeed()/getDistanceSim(); //might want to check speed so we don't divide by zero 
    }
	
	//CalculateWarningEveryHalfSecond loops forever. should return speed in m/s
	public double getSpeed(){
		Car_1 car = new Car_1();
	    car.CalculateWarningEveryHalfSecond(); //
		return 0; //should return the speed in m/s: return car.calculateWarningEveryHalfSecond();
	}
	
	public static void main(String[] args) throws InterruptedException{
		GUIService toGUI = new GUIService();
		System.out.println(toGUI.getDistanceSim() + " metres");
		System.out.println(toGUI.getSpeed() + " m/s");
		System.out.println(toGUI.getSeconds() + " seconds");
		System.out.println(toGUI.displayWarning() + " Displays warning");
	}
}
