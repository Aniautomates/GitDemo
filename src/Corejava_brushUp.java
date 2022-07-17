import java.util.ArrayList;

public class Corejava_brushUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] arr= new int[5];
		arr[0]=1;
		arr[1]=2;
		arr[2]=5;
		arr[3]=7;
		arr[4]=9;
	//	arr[5]=8;
		
		int[] arr2= {1,2,3,4,5,6,7,8};
		
		
		//i=0 as array index always starts from 0
		
		for ( int i = 0; i<arr2.length; i++)
		{
			
			System.out.println(arr2[i]);
		}
		
		String[] name= {"Ani", "SG"};
		
		for (int i= 0; i< name.length; i++)
		{
			System.out.println(name[i]);
		}
		
		// wanting to find only the first occurance of the multiples of 2, use a break; in the if statement after the condition is satisfied
		
		int[] arr3= {1,2,3,4,5,6,7,8};
		
		for (int i=0; i< arr3.length; i++)
		{
			if (arr3[i] % 2 == 0)
			{
				System.out.println(arr3[i]);
				break;
			}
			else 
			{
				System.out.println("The value is not a multiple of 2");
			}
			
		}
		
		ArrayList<String> a= new ArrayList<String>();
		a.add("Selenium");
		a.add("TestNG");
		a.add("NewTest");
		a.get(2);
		
		//string is an object in java
		
		//string literal
		String s= ("Anindita Sengupta Banerjee");
		String[] splittedString = s.split("Seng");
	//	System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[0].trim());
		
		//for printing the above string split at character
		
		for (int i=0; i<s.length(); i++)
		{
			System.out.println(s.charAt(i));
		}
		
		
		//now for printing the above string in the reverse order by splitted as character
		
		for (int i= s.length()-1; i>=0; i--)
		{
			System.out.println(s.charAt(i));
		}
		
		
		
		
		
		

	}

}
