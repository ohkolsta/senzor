        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.URL;


public class ReadData {

    public void URLreader() throws Exception {



        URL oracle = new URL("http://openxcplatform.com.s3.amazonaws.com/traces/nyc/uptown-west2.json");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }



    public static void main(String[] args) throws Exception  {
        ReadData reader = new ReadData();
        reader.URLreader();
    }
}

