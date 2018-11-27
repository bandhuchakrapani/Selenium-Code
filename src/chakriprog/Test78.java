package chakriprog;

import java.util.Scanner;

public class Test78 {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int x=sc.nextInt();
		int flag=0;
		for(int i=2;i<x;i++)
		{
				if(x%i==0)
				{
			    flag=1;
			    break;
				}
			}
	if(flag==0)
	{
		System.out.println(x+"is a prime");
	}
	else
	{
		System.out.println(x+"is not prime");
	}
   }
  }


