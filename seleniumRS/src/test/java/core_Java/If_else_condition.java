package core_Java;

import org.hamcrest.core.Is;

public class If_else_condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		//let say you want to print the numbers which are multiply by 2 from this array
		//we are able to do it by writing simple for loop by using if condition
		//for loop only give access to iterate each number
		//even you can while loop
		for(int i=0; i<arr1.length; i++)
		{
			if (arr1[i]%2 == 0)//In java if you want compare two integers or strings or other data types  you have to put double == operator
			{	
				System.out.println(arr1[i]);
				break;//break is the keyword which helps to stop program after condition meet
				//we can save our time and optimize our scripting by introducing the break word whenever you are for and if condition together
			}
			else {
				System.out.println(arr1[i] + "is not multiple by 2.");
			}
			
		}
		
		//Check if you any value which is multiple of 2
		
	}

}
