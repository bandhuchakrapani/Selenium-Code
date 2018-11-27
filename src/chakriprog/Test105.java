package chakriprog;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Test105 {

	public static void main(String[] args) throws Exception
	{
		// open .xls file for test data reading
		File f=new File("w2smstestdata.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0); // 0 means sheet 1
		int nour=rsh.getRows(); // count no of used rows
		// open same excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0); // 0 means sheet 1
		// create result column which is next to last column
		int nouc=rsh.getColumns();
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		Date d=new Date();
		String colname=sf.format(d);
		Label l=new Label(nouc,0,colname);
		wsh.addCell(l);
		// data driven testing
		//1st row (index is 0) have names of columns
		ChromeDriver chakri=null;
		WritableFont wf=null;
		WritableCellFormat cf=null;
		wf=new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
		wf.setColour(Colour.GREEN);
		cf=new WritableCellFormat(wf);
		cf.setAlignment(Alignment.JUSTIFY);
		cf.setWrap(true);
		for(int i=1;i<nour;i++)
		{
		String mbno=rsh.getCell(0,i).getContents();	
		String mbnoc=rsh.getCell(1,i).getContents();	
		String pwd=rsh.getCell(2,i).getContents();	
		String pwdc=rsh.getCell(3,i).getContents();	
		try
		{
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\softwaretesting\\chromedriver.exe");
	    chakri=new ChromeDriver();
		chakri.get("http://www.way2sms.com");
		WebDriverWait w=new WebDriverWait(chakri,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		// do login
		chakri.findElement(By.name("mobileNo")).sendKeys(mbno);
		chakri.findElement(By.name("password")).sendKeys(pwd);
		chakri.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
		Thread.sleep(5000);
		// validations
		if(mbno.length()==0 && chakri.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
		{
			Label l1=new Label(nouc,i,"Blank mobile no: Test passed");
			l1.setCellFormat(cf);
			wsh.addCell(l1);
		}
		else if(mbno.length()<10 && chakri.findElement(By.xpath("(//*[contains(text(),'Enter valid mobile number')])[1]")).isDisplayed())
				{
			Label l2=new Label(nouc,i,"wrong size mobile no: Test passed");
			l2.setCellFormat(cf);
			wsh.addCell(l2);
	            }
		else if(pwd.length()==0 && chakri.findElement(By.xpath("(//*[text()='Enter password'])[2]")).isDisplayed())
				{
			Label l3=new Label(nouc,i,"blank password test passed");
			l3.setCellFormat(cf);
			wsh.addCell(l3);
				}
		else if(mbnoc.equalsIgnoreCase("invalid") && chakri.findElement(By.xpath("(//*[contains(text(),'not register with us')])[1]")).isDisplayed())
         {
			Label l4=new Label(nouc,i,"Invalid mbno: test passed");
			l4.setCellFormat(cf);
			wsh.addCell(l4);
		}
		else if(mbnoc.equalsIgnoreCase("invalid") && chakri.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
		{
			Label l5=new Label(nouc,i,"invalid pwd test passed");
			l5.setCellFormat(cf);
			wsh.addCell(l5);
		}
		else if(mbnoc.equals("valid") && pwdc.equalsIgnoreCase("valid") && chakri.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
		{
			Label l6=new Label(nouc,i,"valid data test passed");
			l6.setCellFormat(cf);
			wsh.addCell(l6);
		}
		else
		{
			// get screenshot
			String fname=sf.format(d)+".png";
			File src=chakri.getScreenshotAs(OutputType.FILE);
			File dest=new File(fname);
			FileHandler.copy(src,dest);
			Label l7=new Label(nouc,i,"Login Test Failed"+fname);
			wf=new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
			wf.setColour(Colour.RED);
			cf=new WritableCellFormat(wf);
			cf.setAlignment(Alignment.JUSTIFY);
			cf.setWrap(true);
		    l7.setCellFormat(cf);
			wsh.addCell(l7);
		}
		// close site
		chakri.quit();
		}
	catch(Exception ex)
	{
		chakri.quit();
		Label l8=new Label(nouc,i,ex.getMessage());
		l8.setCellFormat(cf);
		wsh.addCell(l8);
	}
}
// save results and close text files
wwb.write();
rwb.close();
wwb.close();
}
}
		
