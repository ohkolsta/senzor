/**
 * Created by thomaskleiven on 10.03.2016.
 */

public class Car {


    /**
     * declaration of variables
     */
    public double distance;
    public double speed;
    public ReadData reader;
    public SimDist distReader;
    public boolean useSensor;

    public Car(String carString, String distFileName) throws InterruptedException{
    	useSensor = true;
        reader = new ReadData();
        reader.read(carString);
        distReader = new SimDist();
        distReader.read(distFileName);
    }


    /**
     * Calculates warning every half second using the speed from file
     */
   /* protected void CalculateWarningEveryHalfSecond(){
        while (reader.velocity.size() != 0) {
            checkSpeed(this.speed);
            checkDistance(this.distance);
            setSpeed();
            //setDistance();
            warning(this.getDistance(), this.getSpeed());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                System.out.println("Thread error");
            }
        }
    }*/

    /**
     * checks if speed is over 20kph, converts speed to m/s and sets value
     * @param speed speed the car holds
     * @throws IllegalArgumentException if speed is below 20kph
     */
    protected void checkSpeed(double speed){
        if (speed >= 0){
            this.speed = convertSpeedToMsFromMilesPerHour(speed);
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

    protected void checkDistance(double distance){
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
    protected void setSpeed(){
        this.speed = reader.velocity.remove(0);
    }



    /**
     * returns speed
     * @return speed
     */
    protected double getSpeed(){
        return this.speed;
    }
    
    protected void setDistance(){
    	if(useSensor == false){
    		if(distReader.distance.size() > 0){
            	this.distance = distReader.distance.remove(0);
    		}else{
    			distReader.read("cardata/distSim.txt");
                this.distance = distReader.distance.remove(0);
    		}
    	}
    }
    
    protected double getDistance(){
    	return this.distance;
    }


    /**
     * converts speed form kph to m/s
     * @param speedInMilesPerHour speed in Kph
     * @return speed in m/s
     */
    public double convertSpeedToMsFromMilesPerHour(double speedInMilesPerHour){
        return speedInMilesPerHour/0.44704;
    }

    public double getSeconds(){
        checkSpeed(this.speed);
        checkDistance(this.distance);
        setSpeed();
        return (distance/speed);
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
}

