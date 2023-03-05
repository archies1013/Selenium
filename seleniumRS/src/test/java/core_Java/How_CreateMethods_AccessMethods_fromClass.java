package core_Java;

public class How_CreateMethods_AccessMethods_fromClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*why Methods -we can write all methods in blog and for that we can give some name. Whenever you want to call those methods you
		have simply call that blog name then lines of code will get executed. so instead of repeating the line again and again there
		are some line of code reused in many places. then will create a methods for it and wrap the lines of code into that method*/
		
		//**Do remember that if you want to create any method in class you should not create method inside this main method
		//(public static void(), this reserve for execution
		//Java will not allow you to write any inside this main method
		
		//this is how you to create object of this class
		//this new memory will create new memory in Java space for object ob
		//and using this object ob you can access the class method
		How_CreateMethods_AccessMethods_fromClass ob= new How_CreateMethods_AccessMethods_fromClass();
		String name=ob.getData();
		System.out.println(name);
		
		Method_Access_demo md=new Method_Access_demo();
		md.getUserData();//this method is from another outside class we access here by creating object of that method
		
		getData1();//this method we are accessing by static keyword without creating any object for that method from their own class
		//NOTE: you cannot create method in main method class, you have to create method outside the main method
	}
	//this method you can access to any other classes outside this class
	//there are different modifier like public, private 
	//void means what this method returns, if this method return anything that you have to write in place of void like int, string
	//so void means this method returning nothing
	//Remember - if you want call any method you need to create first object of that class
	public String getData()//this method you can call above or somewhere else in main class method 
	{
		System.out.println("Hello World");
		return "Rahul Shetty";
		
	}
	public static String getData1()//this method we can access without creating a object in main method because we use "static" keyword
	//by using static keyword we can access method from their own class
	{
		System.out.println("Hello World");
		return "Rahul Shetty";
		
	}
}
