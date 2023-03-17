package JavaStreams_LambdaExpressions;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Streams;

public class CountNumbersNamesAlphabetwise_withStreamsFilter {
	
	/**Count the number of names which starting with alphabet A in a List?
	 * Streams is nothing collection of Strings 
	 * 
	 */
	//@Test
	public void regular()
	{
		ArrayList<String> names=new ArrayList<String>();//this is common syntax of create arralist object for the strings and if you want int youhave to give int
		names.add("Aaron");
		names.add("Aakash");
		names.add("Mohit");
		names.add("Tom");
		names.add("Charlie");
		int count=0;
		for (int i=0; i<names.size(); i++)
		{
			String actuals=names.get(i);//get method basically use to pull the elements present in the list
			if(actuals.startsWith("A"));
			{
				count++;
			}
		}
		System.out.println(count);
	}
	
	//print the name which starts with letter A
	//@Test
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
		names.stream().filter(s->s.length()>2).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>2).limit(1).forEach(s->System.out.println(s));//this will print only one name starts from letter A
		
		/**From the main stream this created one more substream filter of having characters only >4 from that stream if you give .forEach if you
		 * want to grab each and every item we use .forEach this also takes Lambda Expression, so it will pull each and every item from new stream 
		 * which is created by .filter for that names.length>4, each name will come to s variable and action will perform need to print it 
		 * ans this will give you length >4
		 * 
		 */
		
		
		
		
	}
	
	//@Test
	public void streamMap()
	{
		/**Print the names which have last letter "a" & convert them into Uppercase and print them
		 * Map - this will help us to modify stream filter result
		 * .forEach - help us to print in output 
		 * Remember - whenever you need to modify chose map method after the filter method
		 * if you do this without stream, you have to go for for loop, if condition and more lines of code
		 */
		//Print the names which have last letter "a" & convert them into Uppercase and print them
		Stream.of("Alshaya", "Aakash", "Mohit", "Rama", "Charlie").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		
		//Print he name which have first letter as "a" with uppercase and sorted way
		/**There is one terminal operation just like"limit" and count
		 * similarly there is one more terminal operation "sort"
		 * here we will conver arrays into aslist
		 */
		List<String> names1=Arrays.asList("Azlshaya", "Aakash", "Mohit", "Rama", "Charlie");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
	
	@Test
	public void streamMergeArrayList()
	{
		ArrayList<String> names2=new ArrayList<String>();
		names2.add("Aaron");
		names2.add("Aaditya");
		names2.add("Rohit");
		names2.add("Tommy");
		names2.add("Jack");
		
		
		List<String> names1=Arrays.asList("Azlshaya", "Aakash", "Mohit", "Rama", "Charlie");
		
		/**first we need to convert these two arraylist into stream, and then used "concat" method to concatinate two streams
		 * so this will create one new stream by combining stream1 and stream2 and save into newstream and then .forEach to print the newstream
		 * We can use this anyMatch to do validation in selenium
		 */
		//Merging two different arrays
		Stream<String> newStream=Stream.concat(names2.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		
		//now we will see if "Mohit" is present in list or not (.anyMatch) return boolean expression(if its is True return true and if false return false)
		//boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Moh678it"));
		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Mohit"));//out testcase is failed bec there is no name presemt in stream which we passed as an argument
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		
	}
		@Test
		public void streamCollect()
		{
			List<String>ls=Stream.of("Alshaya", "Aakash", "Mohit", "Rama", "Charlie").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
			.collect(Collectors.toList());//you can list, map, set others method also present in collector (we can use "limit" as well)
			System.out.println(ls.get(0));//if you want to print first index in output
			
		}
		/**Collect - this collect basically use to collect your results and convert back to arraylist
		 * in real time we dont need output in console but we have to send them in backend or frontend
		 * Coolect will results from its previous method 
		 */
		
		//Assignment - print unique numbers from this array and sort the array and only give me third index
		
		@Test
		public void streamUniqueNumber()
		{
			
			List<Integer>values=Arrays.asList(0, 2, 5, 4, 4, 5, 8, 9, 6, 8, 7);//output = 
			values.stream().distinct().forEach(s->System.out.println(s));//this for(.distinct) uniue number
			List<Integer>li=values.stream().distinct().sorted().collect(Collectors.toList());
			System.out.println(li.get(2));//if you need thirdindex in output
			
		}
		
	
	
}


