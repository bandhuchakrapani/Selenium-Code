package chakriprog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test9 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();	
		driver.get("http://www.way2sms.com");
        Thread.sleep(5000);
        //Get attribute value
       WebElement e1=driver.findElement(By.name("mobileNo"));
        String x=e1.getAttribute("id");
        System.out.println(x);
       WebElement e2=driver.findElement(By.xpath("(//*[@href='forgot-password'])"));
        String y=e2.getText();
        System.out.println(y);
       String z=e2.getCssValue("color");
        System.out.println(z);
	}

}
