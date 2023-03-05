package core_Java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Arrays - Arrays can store multiple values in single variable
		//we can create Arrays in two different ways
		//"int []" this syntax tells us that this variable saves muliple values of integers
		//"new" is actually creating memory for those who stored in this "arr" variable
		
		//these are Static Array which are fixed size
		//One way to create an array and assign the value
		//sometimes you might get values from your web browser you might Selenium and
		//from selenium you can extract the values from web browser and 
		//you don't know what values will in what aarays that time you can use this array syntax but both are valid syntax 
		//and this is you can declare Array in Java
		int[] arr= new int[5];//this is syntax to create an array which can hold 5 values in one variable
		arr[0]=1;//this is we are assigning 1 value for the 0 index of an array and so on 
		arr[1]=2;
		arr[2]=3;
		arr[3]=4;
		arr[4]=5;
	
		//Another way to create an array and assign the value
		//sometime early in the program only you need to push values that time you can use this type of array
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};//here we are directly assigning the values to variable
		System.out.println(arr1[3]);//this is how you can access the array
		//Instead of printing array one by one we can access all by using forloop print in console
		
		//we will see how to print array present in string by using "for loop"
		//this for loop can iterate the each and every element of this array and can print values of it	
		
		//for loop for arr
		/*for (int i=0; i<arr.length; i++)//in this for loop there is one variable which is starting with 0 and 
			//its iterating until its reaches the size of that array and every iteration this array will increment by 1
			//1st iteration i=0, 2nd i=1, 3rd i=2, 4th i=3, 5th i=4, 6th i=5 and now i<5 here the condition is satisfied 
			//then the for loop will break or complete
		{
			
			System.out.println(arr[i]);
			
		}*/
		
		//for loop for arr1. no matter how many values are there 
		//this is how you can run an "int" array for multiple values
		for (int i=0; i<arr1.length; i++)
		{
			System.out.println(arr1[i]);
			
			
		}
		
		//let see how to declare "string" array for multiple values
		String[] name = {"Rahul", "Shetty", "Selenium"};
		for (int i=0; i<name.length; i++)
		{
			System.out.println(name[i]);
			
		}
			
		//Enhanced for loop declaration and conditional statements inside the for loop
		//this is simple for loop syntax where it will automatically do all condition you just need to write array on right side
		//and put a : and create one variable so that it will iterate everytime and pick 
		//this loop work same like above loop 
		for(String s:name)
		{
			System.out.println(s);
			
		}
		//now see "if else condition for java"
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
						//Check if you any value which is multiple of 2
					}
					else {
						System.out.println(arr1[i] + " is not multiple by 2.");
					}
					
				}
				
				//ArrayList - Here you can dynamically grow the size of an Array
				//ArrayList is one of the class in Java
				//if you want to access any Methods present in the Class you have to create Object of that Class
				//to access the methods present in the class for that we have to create object
				//Interview - On ArrayList to get the length of array you have to use "size" not"length" in for loop
				ArrayList<String> a=new ArrayList<String>();//here you can dynamically create or increase the size of array
				a.add("Rahul");//this is how you can add string value
				a.add("Shetty");//also you can remove the value by using "remove" method
				a.add("Academy");
				a.add("Selenium");
				System.out.println(a.get(3));//this is how you can call or print the value in console
				
				for(int i=0; i<a.size(); i++)//this normal or simple for loop
				{
				System.out.println(a.get(i));//this is how you can retrieve the array	
				}
				System.out.println("************");//this is only to see the results of two different forloop
				for(String val:a)//this is Enhanced for loop	
				{
					System.out.println(val);
				}
				//if you want to know ant item present in ArrayList, if Selenium word is present in ArrayList
				System.out.println(a.contains("Selenium"));//this contains method return boolean value
				//if the value present in arraylist it will return true and if nor return false
				String[] name1 = {"Rahul", "Shetty", "Selenium"};
				//if you want use this contains method in Arrays then you can convert that Arrays into ArrayList
				//List<String> name1=new ArrayList<String>();//somehow this is showing error
				//List<String>nameArrayList=Arrays.asList(name1);//this is how you convert string array into arraylist
				//this is shortcut if you want to see any word present in normal array
				//nameArrayList.contains("Selenium");
				
				
	}


	



	
}

	
	
	


