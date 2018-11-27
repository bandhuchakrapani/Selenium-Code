package chakriprog;

public class Test56 {

	public static void main(String[] args)
	{
		// create object to interface with help of concrete 
		Sampleinterface obj1=new Sample8();
		int r1=obj1.add(10, 20);
		System.out.println(r1);
		
		// create object to concrete class
		Sample8 obj2=new Sample8();
		int r2=obj2.add(20, 90);
		System.out.println(r2);
		
		Sample8 obj3=new Sample8();
		int r3=obj3.sub(20, 40);
		System.out.println(r3);		
		
		Sample8 obj4=new Sample8();
		int r4=obj4.mul(20, 90);
		System.out.println(r4);
		
		Sample8 obj5=new Sample8();
		int r5=obj5.div(20, 90);
		System.out.println(r5);
	}

}
