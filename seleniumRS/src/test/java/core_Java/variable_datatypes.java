package core_Java;

import java.net.CacheRequest;

public class variable_datatypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//any variable declaration without datatype meaningless in Java
		//Datatypes = int,string,char, double or float, boolean
		//you are getting warning because you declared the variable but you haven't use it anywhere if you start using the error will go away
		int myNum = 5;//primitive datatype
		String website = "Rahul Shetty Academy";//non primitive datatype
		char letter ='r';
		 double dec=5.99;//float or double datatype
		boolean mycard=true;
		
		//In Java if you want print anything you have to give System.our.println
		//this is how you can call the variable to print in console as an output
		//In java whenever you want print string you have to put that in double quotes
		//"+" (stands for concatenation) operator separates and identify your vaiable and string
		//if you don't + operator Java cannot Parse your String
		System.out.println(myNum + " is the value stored in myNum variable.");
		System.out.println(website);
		System.out.println(letter);
		System.out.println(dec);
		System.out.println(mycard);
		
	}

}
