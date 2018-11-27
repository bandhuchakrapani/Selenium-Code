package chakriprog;

import java.util.Scanner;

public class Test71 {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter marital status(y/n):");
		String s=sc.nextLine();
		char x=s.charAt(0);
		switch(x)
		{
		case 'y': System.out.println("Married");
		        break;
		case 'n': System.out.println("Unmarried");
                break;
                default: System.out.println("wrong day");
                break;
	}
	}
}
