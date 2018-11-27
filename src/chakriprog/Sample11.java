package chakriprog;

public class Sample11 
{
	public int x;
	public Sample11()
	{
		x=10;
	}
	public static Sample11 create()
	{
		Sample11 obj1=new Sample11();
		return(obj1);
	}
	public void display()
	{
		System.out.println(x);
	}
}
