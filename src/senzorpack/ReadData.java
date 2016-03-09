/**
 * Created by thomaskleiven on 09.03.2016.
 */

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadData {

	public void read() {

		

		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.startsWith("{\"name\":\"vehicle_speed\",\"value\":")) {
					sCurrentLine = sCurrentLine.substring(32);
					System.out.println(Double.valueOf(sCurrentLine.substring(0,
							sCurrentLine.indexOf(','))));
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
