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
	private String defaultFont = "&font=";
	
	public BaseRequest(String font) {
		if (font == null) 
		{
			defaultFont = "";
		} else {
			defaultFont += font;
		}
		this.requestURL = null;
		conn = null;
	}
	
	@Override
	public String request(String str) throws IOException{
		
		String url = baseURL + "make?text=";
		url += str;
		url += this.defaultFont;
		
		try {
			this.requestURL = new URL(url);
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
		while ((line = input.readLine()) != null)
		{
			line += '\n';
			
			sb.append(line);
		}
		
		conn.disconnect();
		
		
		return sb.toString();
	}

	@Override
	public void setFont(String font) {
		this.defaultFont = "&font=";
		this.defaultFont += font;
	}
}
