package JavaStreams_LambdaExpressions;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class CountNumbersNamesAlphabetwise_withStreamsFilter {
	
	/**Count the number of names which starting with alphabet A in a List?
	 * Streams is nothing collection of Strings 
	 * 
	 */
	//@Test
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
	
	//print the name which starts with letter A
	@Test
	public void streamFilter()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Aaron");
		names.add("Aakash");
		names.add("Mohit");
		names.add("Tom");
		names.add("Charlie");
		long c=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);

		
		/**Instead of creating one collection and then apply stream and filter
		 * we can directly apply filter after stream
		 * Thre is no life of intermediate operation(.stream) if there is no terminal operation(.filter)
		 * Terminal operation will execute if only if intermediate operation(filter) returns True
		 * We can create stream with stream package
		 * This operation only come in to picture if it returns true, it it false count will not get executed
		 * we saw how to use filter in streamAPI
		 * In Lambda expression if right is whole one line you can actually open the braces and write the code inside the braces
		 */
		
		long d=Stream.of("Aaron", "Aakash", "Mohit", "Tom", "Charlie").filter(s->
		{
			s.startsWith("A");
			return true;//this will not work bec terminal operation will execute if it returns True
		}).count();
		System.out.println(d);
		
		/**We have done all logic in one single line instead of having for loop, if condition, any variable.
		 * Everytime arralylist first convert into stream by.stream(intermedant opration)and used .filter(terminal operation) method based upon the condition.
		 * Whatever you are passing in if condition now you can use Lambda Expression part 2 after you filter it you will get new stream on that new atream
		 * apply the count method and see how many it returns.
		 * .filter is something which will filter based upon your condition
		 * Datatype of count is "Long"
		 * We are using Java stream to optimized our code
		 */
		
		
		//Print all the names of ArrayList
		//names.stream().filter(s->s.length()>2).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>2).limit(1).forEach(s->System.out.println(s));//this will print only one name starts from letter A
		
		/**From the main stream this created one more substream filter of having characters only >4 from that stream if you give .forEach if you
		 * want to grab each and every item we use .forEach this also takes Lambda Expression, so it will pull each and every item from new stream 
		 * which is created by .filter for that names.length>4, each name will come to s variable and action will perform need to print it 
		 * ans this will give you length >4
		 * 
		 */
		
		
	}

}
