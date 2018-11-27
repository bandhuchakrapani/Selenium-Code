package chakriprog;

import java.util.ArrayList;
import java.util.Scanner;

public class Test96 
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
    }
}
