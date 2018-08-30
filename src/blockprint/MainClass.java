package blockprint;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainClass {

	public static void runLoop()
	{
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			String req = null;
			while ((req = reader.readLine()) != null)
			{
				BlockPrinter.print(req);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/*
		 * Run interactive mode if no arguments are given
		 */
		if (args.length == 0)
		{
			runLoop();
		} else {
			String req = null;
			for (int i = 0; i < args.length; i++)
			{
				req += args[i];
				req += " ";
			}
		}
	}
}
