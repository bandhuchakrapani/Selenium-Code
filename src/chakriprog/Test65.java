package chakriprog;

import java.util.Scanner;

public class Test65 {

	public static void main(String[] args)
	{
		// get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		// check even or odd
		if(x%2==0)
		{
			System.out.println(x+"is a even number");
		}
		else
		{
			System.out.println(x+"is a odd number");
		}
	}
}
