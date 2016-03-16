/**
 * Created by thomaskleiven on 09.03.2016.
 */

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class ReadData {


    /**
     * list with all velocities
     */
    ArrayList<Double> velocity = new ArrayList<Double>();


	/**
	 * reads velocity from file and adds it velocity-list
	 * @param filename filename of the file read
	 */
    public void read(String filename) {

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.startsWith("{\"name\":\"vehicle_speed\",\"value\":")) {
					sCurrentLine = sCurrentLine.substring(32);
					double speed = Double.valueOf(sCurrentLine.substring(0,
							sCurrentLine.indexOf(',')));
					if(speed > 20){
						velocity.add(speed);
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
