import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

/*import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
*/

//this class makes it easy for GUI to get the data
//commented code is used with RPi
//this class should be able to return speed, distance, seconds and warning (double, double, double, boolean)


public class GUIService {

	DistanceMonitor monitor;
	Car car;
	SimDist sim;
	public double distance;
	public double seconds;
	public double speed;
	public boolean warning;

	public GUIService() throws InterruptedException {
		car = new Car("cardata/velocity_car_1.txt", "cardata/distSim.txt");
		//monitor = new DistanceMonitor();
	}
	
	
	public double getDistanceSim(){ //this is just for simulation
		car.setDistance();
    	return car.getDistance();
	}
    	
	
    /*public double getDistanceFromSensor(){
        while( true ) {
            try {
                return monitor.measureDistance();
            }
            catch( Exception e ) {
                System.err.println( e );
            }
        }
    }
    */
	
	
	
	public boolean displayWarning() throws InterruptedException{
		if(getSeconds() < 3){ //change to getDistanceFromSensor() if using RPi + sensor
			return true;
		}
		return false;
		
	}
	
	public double getSeconds() throws InterruptedException{
		return car.distance/getSpeed(); //might want to check speed so we don't divide by zero
    }
	
	//CalculateWarningEveryHalfSecond loops forever. should return speed in m/s
	public double getSpeed(){
	    car.setSpeed();
		return car.getSpeed();
		 //should return the speed in m/s: return car.calculateWarningEveryHalfSecond();
	}

	public double getSpeedInKph(){
		return getSpeed()*3.6;
	}

	public void interval(){
		try {
			while(car.reader.velocity.size() != 0 && sim.distance.size() != 0) {
				this.distance = getDistanceSim();
				this.speed = getSpeedInKph();
				this.seconds = getSeconds();
				this.warning = displayWarning();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}


	}

	public void sleep(long milli) throws  InterruptedException{
		Thread.sleep(milli);
	}
	
	public static void main(String[] args) throws InterruptedException{
		GUIService toGUI = new GUIService();

		while(toGUI.car.reader.velocity.size()!=0) {
			System.out.println(toGUI.getDistanceSim() + " metres behind");
			System.out.println(toGUI.getSpeedInKph() + " km/h");
			System.out.println(toGUI.getSeconds() + " seconds behind");
			System.out.println(toGUI.displayWarning() + " Displays warning");
			toGUI.sleep(1000);
		}
	}
}
