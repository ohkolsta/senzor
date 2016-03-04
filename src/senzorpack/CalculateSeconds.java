package test;

public class CalculateSeconds {
	
	/*
	 * declaration of variables
	 */
	public double distance;
	public double speed;
	
	/*
	 * sets distance and speed variables
	 * @param distance
	 * @param speed
	 */
	public CalculateSeconds(double distance, double speed){
		checkSpeed(speed); 
		checkDistance(distance);
	}
	
	/*
	 * tells if warning should be displayed
	 * @param distance
	 * @param speed
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
	
	/*
	 * sets distance variable
	 * @param distance
	 */
	private void setDistance(double distance){
		this.distance = distance;
	}
	
	/*
	 * checks if speed is over 20kph, converts speed to m/s and sets value
	 * @param speed
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
	
	/*
	 * checks if distance is positive, sets distance or throws argument
	 * @param distance
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
	
	/*
	 * sets speed
	 * @param speed
	 */
	private void setSpeed(double speed){
		this.speed = speed;
	}
	
	/*
	 * returns distance
	 * @param distance
	 * @return distance
	 */
	private double getDistance(){
		return this.distance;
	}
	
	/*
	 * returns speed
	 * @param speed
	 * @return speed
	 */
	private double getSpeed(){
		return this.speed;
	}
	
	/*
	 * converts speed form kph to m/s
	 * @param speedinKph
	 * @return speed in m/s
	 */
	public double convertSpeedToMs(double speedInKph){
		return speedInKph/3.6;
	}

	/*
	 * runs the code
	 */
	public static void main(String [] args){
		CalculateSeconds c = new CalculateSeconds(100,40);
		c.warning(c.getDistance(), c.getSpeed());
	}
	
}