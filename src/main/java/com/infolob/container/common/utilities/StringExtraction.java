package main.java.com.infolob.container.common.utilities;

public class StringExtraction {
	
	public static String getStringAtIndex(String str, String separator, int index)
	{

		String[] stringArray = str.split(separator);
		return stringArray[index];
	}

}
