package chakriprog;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test17 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("http://www.mercurytravels.co.in");
		Thread.sleep(5000);
		// Find element and get x,y,width and height
		List<WebElement> l=chakri.findElements(By.xpath("//input[@type='text']"));
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).isDisplayed())
			{
		int x=l.get(i).getLocation().getX();
		int y=l.get(i).getLocation().getY();
		int w=l.get(i).getSize().getWidth();
		int h=l.get(i).getSize().getHeight();
		// Get page Screenshot
		File ss=chakri.getScreenshotAs(OutputType.FILE);
		BufferedImage fullimg=ImageIO.read(ss);
		//Get only element screenshot from page screenshot
		BufferedImage elescreenshot=fullimg.getSubimage(x, y, w, h);
		ImageIO.write(elescreenshot, "png", ss);
		// save element screenshot
		File dest=new File("chakra"+i+".png");
		FileUtils.copyFile(ss, dest);
			} //if condition closed
		} //for loop closed
		// close site
		chakri.close();
	}

}
