package chakriprog;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test48 extends Thread
{
		public void run()
		{
			try
			{
				Thread.sleep(10000); // for pop-up activation
				// automate pop-up		
				Robot r=new Robot();
		Thread.sleep(5000);		
		StringSelection y=new StringSelection("mindq");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y,null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(5000);	
		StringSelection z=new StringSelection("mindqsys");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(z,null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
			}
			catch(Exception e)
			 {
			   }
			}
		public static void main(String[] args) throws Exception
		{
			Test48 o=new Test48();
			o.start();
			System.setProperty("webdriver.chrome.driver","D:\\softwaretesting\\chromedriver.exe");
			ChromeDriver chakri=new ChromeDriver();
			//Launch site
			chakri.get("https://eforms.agility.com");
			chakri.manage().window().maximize();
	}

}
