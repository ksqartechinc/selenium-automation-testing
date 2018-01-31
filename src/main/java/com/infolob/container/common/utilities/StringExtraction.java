package main.java.com.infolob.container.common.utilities;

public class StringExtraction {
	
	public static String getStringAtIndex(String str, int index)
	{

		String[] stringArray = str.split(" ");
		return stringArray[index];
	}

}
