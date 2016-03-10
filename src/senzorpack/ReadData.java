/**
 * Created by thomaskleiven on 09.03.2016.
 */

import com.sun.xml.internal.rngom.digested.DDataPattern;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class ReadData {

    ArrayList<Double> velocity = new ArrayList<Double>();



    public void read() {

		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.startsWith("{\"name\":\"vehicle_speed\",\"value\":")) {
					sCurrentLine = sCurrentLine.substring(32);
                    velocity.add(Double.valueOf(sCurrentLine.substring(0,
                            sCurrentLine.indexOf(','))));
                    /*for(double vel : velocity){
                        System.out.println(vel);                                   Kommenter bort denne om du vil printe
                    }*/
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		ReadData reader = new ReadData();
		reader.read();
	}

}
