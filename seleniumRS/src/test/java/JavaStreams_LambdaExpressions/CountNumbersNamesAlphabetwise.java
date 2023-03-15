package JavaStreams_LambdaExpressions;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class CountNumbersNamesAlphabetwise {
	/**Count the number of names which starting with alphabet A in a List?
	 * 
	 * 
	 */
	@Test
	public void regular()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Aaron");
		names.add("Aakash");
		names.add("Mohit");
		names.add("Tom");
		names.add("Charlie");
		int count=0;
		for (int i=0; i<names.size(); i++)
		{
			String actuals=names.get(i);
			if(actuals.startsWith("A"));
			{
				count++;
			}
		}
		System.out.println(count);
	}
	
	

}
