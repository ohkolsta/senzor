/**
 * Created by thomaskleiven on 10.03.2016.
 */
public class Car_1 extends Car{

    public Car_1(){
        reader.read("cardata/velocity_car_1.txt");
    }

    /**
     * runs the code
     */
    public static void main(String [] args){
        Car_1 car = new Car_1();
        car.CalculateWarningEveryHalfSecond();
    }
}
