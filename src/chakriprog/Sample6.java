package chakriprog;

public class Sample6
{
	// data members
		public int x;
		public float y;
		public char z;
		public String w;
		public boolean b;
		public Sample6()  // constructor method without parameter
		{
		x=10;
		w="chakri";
		}
		public Sample6(int a)   // constructor method with parameter
		{
		x=a;
		w="chakri";
		}
		public Sample6(float a)   // constructor method different type argument
		{
		y=a;
		w="chakri";
		}
		public Sample6(int a, String s)  // constructor method with different parameters and type
		{
		x=a;
		w=s;
		}
		// methods
		public void display()  // operational method
		{
			System.out.println(x);
			System.out.println(y);
			System.out.println(z);
			System.out.println(w);
			System.out.println(b);
		}
}
