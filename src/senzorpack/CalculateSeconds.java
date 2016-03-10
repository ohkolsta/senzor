import java.util.List;

public class CalculateSeconds {
	
	/**
	 * declaration of variables
	 */
	public double distance;
	public double speed;
	public ReadData reader;

	/**
	 * sets distance and speed variables
	 * @param distance distance to car in front
	 * @param speed of the vehicle
	 */
	public CalculateSeconds(double distance, double speed){
		checkSpeed(speed); 
		checkDistance(distance);
		reader = new ReadData();
        reader.read("data.txt");
	}


	/**
	 * tells if warning should be displayed
	 * @param distance distance to car in front
	 * @param speed speed the car holds
	 * @return if warning should be displayed
	 */
	public boolean warning(double distance, double speed){
		System.out.println(distance/speed + " seconds");
		if(distance/speed < 3){
			System.out.println("Warning!");
			return true;
		} else {
			System.out.println("No warning");
			return false;
		}
	}
	
	/**
	 * sets distance variable
	 * @param distance distance to car in front
	 */
	private void setDistance(double distance){
		this.distance = distance;
	}
	
	/**
	 * checks if speed is over 20kph, converts speed to m/s and sets value
	 * @param speed speed the car holds
	 * @throws IllegalArgumentException if speed is below 20kph
	 */
	private void checkSpeed(double speed){
		if (speed > 20){
			this.speed = convertSpeedToMs(speed);
		}else{
			System.out.println("For lav hastighet");
			throw new IllegalArgumentException();
		}
	}


	
	/**
	 * checks if distance is positive, sets distance or throws argument
	 * @param distance distance to car in front
	 * @throws IllegalArgumentException if distance is negative
	 */
	private void checkDistance(double distance){
		if (distance > 0){
		this.distance = distance;
		}else{
			System.out.println("Ikke negativ distanse");
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * sets speed from file
	 */
	private void setSpeed(){
        this.speed = reader.velocity.remove(0);
    }
	
	/**
	 * returns distance
	 * @return distance
	 */

	private double getDistance(){
		return this.distance;
	}
	
	/**
	 * returns speed
	 * @return speed
	 */
	private double getSpeed(){
		return this.speed;
	}

    /**
     * Calculates warning every half second using the speed from file
     */

    private void CalculateWarningEveryHalfSecond(){
        while (reader.velocity.size() != 0) {
            setSpeed();
            warning(getDistance(), getSpeed());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                System.out.println("Thread error");
            }
        }
    }
	
	/**
	 * converts speed form kph to m/s
	 * @param speedInKph speed in Kph
	 * @return speed in m/s
	 */
	public double convertSpeedToMs(double speedInKph){
		return speedInKph/3.6;
	}


	/**
	 * runs the code
	 */
	public static void main(String [] args) throws InterruptedException{
        CalculateSeconds c = new CalculateSeconds(100,40);
        c.CalculateWarningEveryHalfSecond();
	}
	
}