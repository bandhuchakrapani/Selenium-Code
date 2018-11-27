package chakriprog;

import java.util.HashMap;

public class Test103 {

	public static void main(String[] args)
	{
		// create a hashmap
				HashMap<Integer,String> hm=new HashMap<Integer,String>();
				// insert pair of data into hashmap
				hm.put(101,"Kalam");
				hm.put(102,"chakrapani");
				//change vale using key
				hm.replace(101,"Bandhu");
				// change key by key
				hm.put(101,hm.remove(101));
				System.out.println(hm);
	}

}
