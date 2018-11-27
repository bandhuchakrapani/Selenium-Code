package chakriprog;

import java.util.Scanner;

public class Test91 {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		if(x<18)
		{
		ArithmeticException ex=new ArithmeticException("invalid voter");
		throw ex;
		}
		else
		{
			System.out.println("not eligible");
		}
	}

}
