import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.pi4j.io.gpio.RaspiPin;


//class for simulating distance data

public class SimDist {

	ArrayList<Double> distance = new ArrayList<Double>();
	

	public void read(String filename) throws InterruptedException {

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				double dist = Double.valueOf(sCurrentLine);
				distance.add(dist);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void main(String[] args) throws InterruptedException{
    	SimDist sim = new SimDist();
        sim.read("cardata/distSim.txt");
	}

}
