package chakriprog;

import java.util.Scanner;

public class Test75 
{
	public static void main(String[] args) 
	{
		// Fibonacci series
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter limit number");
	    int l=sc.nextInt();
	    int x=0;
	    int y=1;
	    System.out.println(x+" "+y+" ");
	    do 
	    {
	    	int z=x+y;
	    	System.out.println(z+" ");
	    	x=y;
	    	y=z;
	    }while((x+y)<l);
	}

}
