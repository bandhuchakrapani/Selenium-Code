package chakriprog;
import org.openqa.selenium.By;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
public class Test3 {

	public static void main(String[] args) throws Exception
	{
		OperaOptions oo=new OperaOptions();
		oo.setBinary("C:\\Users\\Chakri Mittu\\AppData\\Local\\Programs\\Opera\\55.0.2994.37\\opera.exe");
	    System.setProperty("webdriver.opera.driver", "D:\\softwaretesting\\operadriver_win64\\operadriver.exe");
	    OperaDriver chakri=new OperaDriver(oo);
	    chakri.get("http://www.google.co.in");
		Thread.sleep(5000);
		chakri.findElement(By.name("q")).sendKeys("gmail");
	}
}
