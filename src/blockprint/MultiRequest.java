package blockprint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiRequest extends BaseRequest {

	public MultiRequest() {
		super(null);
	}
	
	@Override
	public String request(String str) throws IOException
	{
		String newStr = str.replaceAll("\\s+", "%20");
		return super.request(newStr);
	}
}
