package main.java.com.infolob.container.common.utilities;

import com.graphbuilder.struc.Stack;

public class StringExtraction {

	public static String getStringAtIndex(String str, String separator, int index)
	{

		String[] stringArray = str.split(separator);
		return stringArray[index];
	}

	static int getIntegerComplement(int n) {
		int result =0;
		int count = 0;
		while(n != 0)
		{
			int temp = ((n&1 ^1))<< count;
			result = result|temp;
			n = n>>1;
			count++;
		}
		return result;
	}
	public static void main(String...strings )
	{
		System.out.println(getIntegerComplement(50));


	}


	public static String[] braces(String[] values) {
		Stack charStack = new Stack();
		char c ;
		int k=0;
		String[] isBalanced = new String[values.length];
		if(values.length <= 0 || values.length >=15)
		{
			return null;
		}

		for(String str : values)
		{
			for(int i=0;i< str.length();i++)
			{
				c = str.charAt(i);

				if(c == '{' || c== '[' || c == '(')
						{
					charStack.push(c);
						}
				if(c == '}' || c== ']' || c == ')')
				{
					if(charStack.isEmpty())
					{
						isBalanced[k++] ="No";
						break;                        
					}
					char charAtTop = (char)charStack.peek();
					if(charAtTop == '{' && c =='}')
					{
						charStack.pop();
					}
					if(charAtTop == '[' && c ==']')
					{
						charStack.pop();
					}
					if(charAtTop == '(' && c ==')')
					{
						charStack.pop();
					}
				}
				if(str.length() > 0 && charStack.isEmpty())
				{
					isBalanced[k++] = "Yes";

				}
			}

			

		}
		return isBalanced;
	}

}
