package chakriprog;

public class Sample18 extends Sample17 // is a relations "extends"
{
	public int x;
	public void display()
	{
		System.out.println(super.x); // parent class
		System.out.println(this.x); // child class
	}
}
