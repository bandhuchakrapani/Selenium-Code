package chakriprog;

import java.util.HashMap;
import java.util.Map;

public class Test100 {

	public static void main(String[] args)
	{
		// create a hashmap
		HashMap<Integer,String> hm=new HashMap<Integer, String>();
		// insert pair of data into hashmap
		hm.put(101,"kalam");
		hm.put(102,"chakrapani");
		// get data from hashmap
		for(Map.Entry e:hm.entrySet())
		{
			//System.out.println(e.getKey());
			System.out.print(e.getKey());
			System.out.println(" "+e.getValue());
		}
	}
}
