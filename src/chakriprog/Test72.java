package chakriprog;

import java.util.Scanner;

public class Test72 {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter marital status(y/n):");
		String cc=sc.nextLine();
		
		switch(cc)
		{
		case "visa": System.out.println("valid card");
		             break;
		case "rupay": System.out.println("valid card");
                break;
		case "master": System.out.println("valid card");
                       break;       
        default: System.out.println("wrong day");
                 break;
		}
	}

}
