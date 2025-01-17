package testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 

{
static public  WebDriver driver;
public Logger logger;
public Properties p;

	@BeforeClass(groups= {"Sanity", "Regression"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException 
	{
	
		//loading config.properties
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		
		switch(br.toLowerCase())
				{
		case "chrome" : driver=new ChromeDriver(); break;
		case "safari" : driver=new SafariDriver(); break;
		default : System.out.println("Invalid Browser"); return;
			
				}
		
		
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("website"));
		//driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		
	}
	@AfterClass(groups= {"Sanity"," Regression"})
	public void Close() 
	{
		driver.close();
	}
	
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatednum=RandomStringUtils.randomNumeric(10);
		return generatednum;
	}
	 
	public String randomAlphaNum() 
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		String generatednum=RandomStringUtils.randomNumeric(2);
		return (generatedString+"@"+ generatednum);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	
	    
}
	}
