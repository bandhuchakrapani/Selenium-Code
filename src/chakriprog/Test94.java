package chakriprog;

import java.util.Scanner;

public class Test94 
{
   
	public static void main(String[] args)
	{
		// declare static array in ascending order
		int [] x=new int[5];
		// fill array with data
		Scanner sc=new Scanner(System.in);
		System.out.println("Fill array");
		for(int i=0;i<5;i++)
		{
			x[i]=sc.nextInt();	
		}
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(x[j]>x[j+1])
				{
					int temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
				}
			}
		}
		// access data in array
		for(int i=0;i<5;i++)
		{
			System.out.println(x[i]);
		}
	}
}
