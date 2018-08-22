package blockprint;

import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

/*
 * TODO: Handle spaces
 * */

public class BaseRequest implements Requestable {
	private String baseURL = "http://artii.herokuapp.com/";
	private URL requestURL;
	private HttpURLConnection conn;
	private String defaultFont;
	
	public BaseRequest() {
		defaultFont = "";
		this.requestURL = null;
		conn = null;
	}
	
	@Override
	public String request(String str) throws IOException{
		
		baseURL += "make?text=";
		baseURL += str;
		baseURL += this.defaultFont;
		
		try {
			this.requestURL = new URL(this.baseURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn = (HttpURLConnection) this.requestURL.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int status = conn.getResponseCode();
		// TODO check status
		
		BufferedReader input = new BufferedReader(
				new InputStreamReader(conn.getInputStream()));
		
		String line;
		StringBuilder sb = new StringBuilder();
		int longest_line = 0;
		while ((line = input.readLine()) != null)
		{
			line += '\n';
			
			sb.append(line);
		}
		
		conn.disconnect();
		
		
		return sb.toString();
	}
}
