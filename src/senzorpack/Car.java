/**
 * Created by thomaskleiven on 10.03.2016.
 */

public abstract class Car {


    /**
     * declaration of variables
     */
    public double distance = 100;
    public double speed;
    public ReadData reader;

    public Car(){
        reader = new ReadData();
    }


    /**
     * Calculates warning every half second using the speed from file
     */

    protected void CalculateWarningEveryHalfSecond(){
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
    }

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
     * sets distance variable
     * @param distance distance to car in front
     */
    protected void setDistance(double distance){
        this.distance = distance;
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
     * returns distance
     * @return distance
     */

    protected double getDistance(){
        return this.distance;
    }

    /**
     * returns speed
     * @return speed
     */
    protected double getSpeed(){
        return this.speed;
    }


    /**
     * converts speed form kph to m/s
     * @param speedInMilesPerHour speed in Kph
     * @return speed in m/s
     */
    public double convertSpeedToMsFromMilesPerHour(double speedInMilesPerHour){
        return speedInMilesPerHour/0.44704;
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
    }

