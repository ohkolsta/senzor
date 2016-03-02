package senzorpack;

public class CalculateSeconds {
	
	public double distance;
	public double speed;
	
	public CalculateSeconds(double distance, double speed){
		this.distance = distance;
		this.speed = speed;
	}
	
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
	
	private void setDistance(double distance){
		this.distance = distance;
	}
	
	private void setSpeed(double speed){
		this.speed = speed;
	}
	
	private double getDistance(){
		return this.distance;
	}
	
	private double getSpeed(){
		return this.speed;
	}
	
	public double convertSpeedToMs(double speedInKph){
		return speedInKph/3.6;
	}

	public static void main(String [] args){
		CalculateSeconds c = new CalculateSeconds(50,10);
		c.warning(c.getDistance(), c.getSpeed());
	}
	
}