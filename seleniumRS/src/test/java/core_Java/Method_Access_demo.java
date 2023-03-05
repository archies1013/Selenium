package core_Java;

public class Method_Access_demo {
	
	public String getUserData()//you can call this method some other as well by creating object of this class in other class main method
	//when you say private(access modifier) you cannot access that method in other class if its a public then only you can access outside the this class
	{
		System.out.println("Hello World");
		return "Rahul Shetty";
		
	}

}
