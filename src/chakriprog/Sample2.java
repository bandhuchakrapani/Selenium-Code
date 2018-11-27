package chakriprog;

	public class Sample2 implements Sample1
	{
		public int add(int x, int y)
		{
			int z;
			z=x+y;
			return(z);
		}

		
		public int sub(int x, int y) 
		{
			int z;
			z=x-y;
			return(z);
		}

		
		public int mul(int x, int y) 
		{
			int z;
			z=x*y;
			return(z);
		}

		
		public int div(int x, int y) {
			int z;
			z=x/y;
			return(z);
		}
}
