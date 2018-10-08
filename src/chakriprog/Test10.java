package chakriprog;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test10 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
		ChromeDriver chakri=new ChromeDriver();	
		chakri.get("http://www.google.co.in");
		Thread.sleep(5000);
		// Find element and get x,y,width and height
		WebElement e=chakri.findElement(By.xpath("//*[@id='hplogo']/descendant::*[2]"));
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		int w=e.getSize().getWidth();
		int h=e.getSize().getHeight();
		// Get page Screenshot
		File ss=chakri.getScreenshotAs(OutputType.FILE);
		BufferedImage fullimg=ImageIO.read(ss);
		//Get only element screenshot from page screenshot
		BufferedImage elescreenshot=fullimg.getSubimage(x, y, w, h);
		ImageIO.write(elescreenshot, "png", ss);
		// save element screenshot
		File dest=new File("chakra.png");
		FileUtils.copyFile(ss, dest);
		// close site
		chakri.close();
		

	}

}
