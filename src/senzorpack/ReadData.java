import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;



public class ReadData {
	String hvordan = "LINK TIL HVORDAN GJØRE DET: http://stackoverflow.com/questions/7467568/parsing-json-from-url";
	String UrlString = "";
//	List<String> Speed = [];

	private static String readUrl(String UrlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(UrlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
	
//	private static SpeedResults(URLString){
//		
//	}

	
	public static void Main(String[] args) throws Exception{
		ReadData rd = new ReadData();
		rd.readUrl("http://openxcplatform.com.s3.amazonaws.com/traces/nyc/uptown-west2.json");
		
//		String json = readUrl("http://openxcplatform.com.s3.amazonaws.com/traces/nyc/uptown-west2.json");
//		Gson gson = new Gson();
//		ReadData readdata = gson.fromJson(json, ReadData.class);
//		
//		System.out.println(ReadData.speed);
//		
		
	}

}
