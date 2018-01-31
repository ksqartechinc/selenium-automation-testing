package main.java.com.infolob.container.common.utilities;

public class StringExtraction {
	
	public static void main(String...strings )
	{
		
		 String lastName = "Baker,";
		int length = lastName.length();
		lastName = lastName.substring(0, length-1);
		System.out.println(lastName);
	}

}
