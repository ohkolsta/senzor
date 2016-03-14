
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

/**
 * DistanceMonitor class to monitor distance measured by sensor
 *
 */
public class DistanceMonitor {

    private final static float SOUND_SPEED = 340.29f;  // speed of sound in m/s

    private final static int TRIG_DURATION_IN_MICROS = 10; // trigger duration of 10 micro s
    public final static int WAIT_DURATION_IN_MILLIS = 60; // wait 60 milli s

    private final static int TIMEOUT = 2100;

    private final static GpioController gpio = GpioFactory.getInstance();

    private final GpioPinDigitalInput echoPin;
    private final GpioPinDigitalOutput trigPin;

    private final Pin echoPin = RaspiPin.GPIO_02; // PI4J custom numbering (pin 13)
    private final Pin trigPin = RaspiPin.GPIO_00; // PI4J custom numbering (pin 11)

    public DistanceMonitor( Pin echoPin, Pin trigPin ) {
        this.echoPin = gpio.provisionDigitalInputPin( echoPin );
        this.trigPin = gpio.provisionDigitalOutputPin( trigPin );
        this.trigPin.low();
        try {
            Thread.sleep(300);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
        }
    }

    /*
     * This method returns the distance measured by the sensor in cm
     *
     * @throws TimeoutException if a timeout occurs
     */
    public float measureDistance() throws TimeoutException {
        this.triggerSensor();
        this.waitForSignal();
        double duration = this.measureSignal();

        return duration * SOUND_SPEED / ( 2 * 1000 ); //was 2*10000, changed to 2*1000 for converting to metres"
    }

    /**
     * Put a high on the trig pin for TRIG_DURATION_IN_MICROS
     */
    private void triggerSensor() {
        try {
            this.trigPin.high();
            Thread.sleep( 0, TRIG_DURATION_IN_MICROS * 1000 );
            this.trigPin.low();
        } catch (InterruptedException ex) {
            System.err.println( "Interrupt during trigger" );
        }
    }

    /**
     * Wait for a high on the echo pin
     *
     * @throws DistanceMonitor.TimeoutException if no high appears in time
     */
    private void waitForSignal() throws TimeoutException {
        int countdown = TIMEOUT;

        while( this.echoPin.isLow() && countdown > 0 ) {
            countdown--;
        }

        if( countdown <= 0 ) {
            throw new TimeoutException( "Timeout waiting for signal start" );
        }
    }

    /**
     * @return the duration of the signal in micro seconds
     * @throws DistanceMonitor.TimeoutException if no low appears in time
     */
    private long measureSignal() throws TimeoutException {
        int countdown = TIMEOUT;
        long start = System.nanoTime();
        while( this.echoPin.isHigh() && countdown > 0 ) {
            countdown--;
        }
        long end = System.nanoTime();

        if( countdown <= 0 ) {
            throw new TimeoutException( "Timeout waiting for signal end" );
        }

        return (double)Math.ceil( ( end - start ) / 1000.0 );  // Return micro seconds
    }

    /**
     * Exception thrown when timeout occurs
     */
    public static class TimeoutException extends Exception {

        private final String reason;

        public TimeoutException( String reason ) {
            this.reason = reason;
        }

        @Override
        public String toString() {
            return this.reason;
        }
    }

    public double void returnDistance(){
    	while( true ) {
            try {
                measureDistance();
            }
            catch( Exception e ) {
                System.err.println( e );
            }

            try {
                Thread.sleep( 500 );
            } catch (InterruptedException ex) {
                System.err.println( "Interrupt during trigger" );
            }
        }
    }

    //class for simulating data stream
    public double read(String filename) {

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
					double dist = Double.valueOf(sCurrentLine);
					return dist;
					}

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void main(String[] args){
    	DistanceMonitor dist = new DistanceMonitor();
    	System.out.println(dist.read("cardata/distSim.txt"));
    }





}
