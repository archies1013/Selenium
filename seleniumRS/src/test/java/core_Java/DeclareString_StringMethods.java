package core_Java;

import org.checkerframework.checker.units.qual.s;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DeclareString_StringMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//string is an object//this one way of creating string called String Literal
		String s="Rahul Shetty Academy";//basically this will create one object in Java memory
		String s1= "Rahul Shetty Academy";//Here Java will not create another object because it already present in s object
		//if the text(value) is same no matter how many strings you create but Java will create one object in memory
		String s5="hello";//here new object and memory will create because the string value is different
		
		//This is another way of creating String in Java memory
		//when you create s2 string with new keyword everytime it will create new object with new memory
		String s2 = new String("Welcome");
		String s3 = new String("Welcome");
		
		//Generally we use string literal 
		String s4="Rahul Shetty Academy";//let say i want break this string with white space, you can use split method from Java
		//if you want access the methods of class first you need to create the object
		String[] splittedString=s4.split(" ");//we split the string with white space
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[2]);
		
		String[] splittedString1=s4.split("Shetty");//if we split here with shetty
		System.out.println(splittedString1[0]);
		System.out.println(splittedString1[1]);
		System.out.println(splittedString1[1].trim());//this method will remove white spaces(blank) between word
		//this all methods will come handy when we do automation
		
		//let say if you want print one by one character like R A H U L
		//for that you need to use for loop
		for(int i=0; i<s4.length(); i++)
		{
			System.out.println(s4.charAt(i));
		}
	//QUE-print the string in reverse order	
		for(int i=s.length()-1; i>=0; i--)//here in this loop will start from last character by using charAt method
		{
			System.out.println(s4.charAt(i));
		}
	}
	

}
