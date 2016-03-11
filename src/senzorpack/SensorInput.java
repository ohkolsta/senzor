
public class SensorInput {
	private final int pulse = 10000;         //pulse = 10 000 ns
	private final int speedOfSound = 34029;  //speed of sound = 34 029 cm/s
	
	private GPIOPin trigger = null;
	private GPIOPin echo = null;
	// http://www.oracle.com/technetwork/articles/java/cruz-gpio-2295970.html
	//
	public SensorInput(int _trigger, int _echo){
		
	}
	
	
	
	/*
	// klasse som skal m�le verdiene fra sensoren og gi avstanden.
	// getDistance skal v�re static og kunne kalles fra klassen CalculateSeconds
	
	private final static float SIGNAL_SPEED = 340.29f;  // speed of signal in m/s (speed of sound).

	
	public float measureDistance(){
		this.triggerSensor();
		this.waitForSignal();
		
		
	}
	
	
	
	private void triggerSensor() {
        
    }
	
	private void waitForSignal() throws TimeoutException {
       
    }
	
	
	public static double getDistance(){
		return distance;
	}
	
	
	
	public static void main(String[] args) {
		
		
		

	}
*/
}
