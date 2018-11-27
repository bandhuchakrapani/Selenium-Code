package chakriprog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test93 {

	public static void main(String[] args) 
	{
		String x="gshshNSWID DJWDUDksks 455Ddf";
		Pattern p=Pattern.compile("[0-9]+");
		Matcher m=p.matcher(x);
		while(m.find())
		{
			System.out.println(m.group());
		}

	}

}
