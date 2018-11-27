package chakriprog;

import java.util.ArrayList;
import java.util.Scanner;

public class Test97
{
	public static void main(String[] args)
	{
		// fill array with data
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> x=new ArrayList<Integer>();
		System.out.println("enter size of array");
		int n=sc.nextInt();
		System.out.println("enter values");
		for(int i=0;i<n;i++)
		{
			x.add(sc.nextInt());	
		}
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(x.get(j)>x.get(j+1))
				{
					int temp=x.get(j);
					x.set(j,x.get(j+1));
					x.set(j+1,temp);
				}
			}
		}
		// access data in array
		for(int i=0;i<5;i++)
		{
			System.out.println(x.get(i));
		}
	}
}

