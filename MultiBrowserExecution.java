package multibrowsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiBrowserExecution 
{    RemoteWebDriver driver;
     @Parameters({"Browser"})
     @Test
	 public void multi(String Browser)
	 {      String browser = Browser;
	        if(browser.equalsIgnoreCase("chrome"))
	        {
	        	WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver();
	        }
	        else if(browser.equalsIgnoreCase("firefox"))
	        {
	        	WebDriverManager.firefoxdriver().setup();
			    driver = new FirefoxDriver();
	        }
	        else if(browser.equalsIgnoreCase("edge"))
	        {
	        	WebDriverManager.edgedriver().setup();
			    driver = new EdgeDriver();
	        }
	        else
	        {
	        	System.out.println("Unsupported Browser");
	        }
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElementById("username").sendKeys("demosalesmanager");
			driver.findElementById("password").sendKeys("crmsfa");
			driver.findElementByClassName("decorativeSubmit").click();
			driver.findElementByLinkText("CRM/SFA").click();
			driver.findElementByLinkText("Leads").click();
			driver.close();
		  
	 }
    /* @AfterMethod
     public void postcondition()
     {
    	 driver.close();
     } */
	}


