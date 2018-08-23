package blockprint;

import java.io.IOException;

public interface Requestable {
	public String request(String str) throws IOException;
	public void   setFont(String font);
}
