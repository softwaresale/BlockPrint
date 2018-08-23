package blockprint;

public final class BlockPrinter {

	private static Requester<DefaultRequest> defReq = 
			new Requester<DefaultRequest>(new DefaultRequest());
	private static Requester<MultiRequest> spaces = 
			new Requester<MultiRequest>(new MultiRequest());
	private static Requester<FontRequest> font = null;
	private static Requester<FontMultiRequest> fontMulti = null;
	
	public static void print(String str)
	{	
		if (str.contains(" "))
		{
			if (fontMulti != null) System.out.println(fontMulti.request(str));
			else System.out.println(spaces.request(str));
		} else {
			if (font != null) System.out.println(font.request(str));
			else System.out.println(defReq.request(str));
		}
	}
	
	public static void setFont(String str)
	{
		font = new Requester<FontRequest>(new FontRequest(str));
	}
}
