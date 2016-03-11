/**
 * Created by thomaskleiven on 10.03.2016.
 */
public class Car_2 extends Car{

    public Car_2(){
        reader.read("velocity_car_2.txt");
    }

    /**
     * runs the code
     */
    public static void main(String [] args){
        Car_2 car = new Car_2();
        car.CalculateWarningEveryHalfSecond();
    }
}
