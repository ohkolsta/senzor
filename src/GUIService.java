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

	private double warningTime = 3;

	public GUIService(){
		try{
			System.out.println("GUIService Constructor");
			car = new Car("cardata/velocity_car_1.txt", "cardata/distSim.txt");
			if(car.useSensor){
				monitor = new DistanceMonitor();
			}
			car.setDistance();
			car.setSpeed();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		//monitor = new DistanceMonitor();
	}
	
	
	public double getDistanceSim(){
		//DistanceMonitor monitor = new DistanceMonitor();
		if(car.useSensor == true){
			try{
				car.distance = monitor.measureDistance();
			}catch(Exception e){
				System.out.println(e + " in getDistanceSim");
			}
		}
		else{
			car.setDistance();
			car.distance = car.getDistance();
		}
		return car.distance;
	}
	
	
	
	public boolean displayWarning() {
		if(getSeconds() < warningTime){ //change to getDistanceFromSensor() if using RPi + sensor
			return true;
		}
		return false;
		
	}
	
	public double getSeconds(){
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

	public double getWarningTime() {
		return warningTime;
	}

	public void setWarningTime(double warningTime) {
		this.warningTime = warningTime;
	}

}
