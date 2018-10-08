package chakriprog;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test18 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("http://www.mercurytravels.co.in");
		Thread.sleep(5000);
		chakri.manage().window().maximize();
		Thread.sleep(5000);
		//Get size of browser window
		int w=chakri.manage().window().getSize().getWidth();
		int h=chakri.manage().window().getSize().getHeight();
		System.out.println(w+" "+h);
		// change size of browser window
		Dimension d=new Dimension(400,300);
		chakri.manage().window().setSize(d);
		Thread.sleep(5000);
		//Get position of browser window
		int x=chakri.manage().window().getPosition().getX();
		int y=chakri.manage().window().getPosition().getY();
		System.out.println(x+" "+y);
		// change position of browser window 
		Point p=new Point(300,200);
		chakri.manage().window().setPosition(p);
		Thread.sleep(5000);
		// close site
		chakri.close();
	}

}
