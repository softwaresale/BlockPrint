package blockprint;

import java.io.IOException;

public class Requester<T extends Requestable> {

	private T request;
	
	public Requester(T t)
	{
		this.request = t;
	}
	
	public String request(String str)
	{
		String req = null;
		try {
			req = request.request(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return req;
	}
}
