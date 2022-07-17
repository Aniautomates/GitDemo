import java.lang.reflect.Method;

public class CreatingDifferentTypesofMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CreatingDifferentTypesofMethods m = new CreatingDifferentTypesofMethods();
		String name = m.MethodDemo();
		System.out.println(name);
		
		System.out.println(DemoMethodwithstatic());
		//String name2 = m.DemoMethodwithstatic();
		//System.out.println(name2);
		
		
		
	}
	
	//creating a class outside the main block and calling the class in the main class
	//creating classes inside the main block will throw errors
	
	public String MethodDemo(){
		
		System.out.println("Creating First Method");
		
		return "Ani";
	}

	//on defining a class with static, when we call the class in the main block we donot need to create an 
	//object for that, we can directly call the class
	
	public static String DemoMethodwithstatic()
	{
		System.out.println("Test Class");
		return "Banjo";
		
	}
}
