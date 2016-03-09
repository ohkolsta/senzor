
public class SensorInput {
	
	// klasse som skal måle verdiene fra sensoren og gi avstanden.
	// getDistance skal være static og kunne kalles fra klassen CalculateSeconds
	
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

}
