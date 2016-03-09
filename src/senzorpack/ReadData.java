/**
 * Created by thomaskleiven on 09.03.2016.
 */

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;


public class ReadData {

    public void read() {

        int[] tall = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("data.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                if(sCurrentLine.startsWith("{\"name\":\"vehicle_speed\",\"value\":")) {
                    for (int q = 0; q < sCurrentLine.length(); q++) {
                        System.out.println(sCurrentLine);

                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws Exception  {
        ReadData reader = new ReadData();
        reader.read();
    }


}
