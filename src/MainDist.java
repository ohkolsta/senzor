import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

//Denne klassen er kun for backup i tilfelle mod av DistanceMonitor ikke funker


public class MainDist {

    public static void main( String[] args ) {
        Pin echoPin = RaspiPin.GPIO_02; // PI4J custom numbering (pin 13)
        Pin trigPin = RaspiPin.GPIO_00; // PI4J custom numbering (pin 11)
        DistanceMonitor monitor = new DistanceMonitor( echoPin, trigPin );

        while( true ) {
            try {
                System.out.println(monitor.measureDistance());
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
}
