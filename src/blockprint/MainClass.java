package blockprint;

public class MainClass {

	public static void main(String[] args) {
		Requester<BaseRequest> req = new Requester<BaseRequest>(new BaseRequest());
		
		String str = req.request("Charlie");
		System.out.println(str);
	}

}
