package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

public static WebDriver getDriver(String BrNm) {
		
		if(BrNm.equals("CRM"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\MyDrivers\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();
			
		}

		else if(BrNm.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\MyDrivers\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		
		else if(BrNm.equals("ff"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\MyDrivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			return new FirefoxDriver();
			
		}
		else
			return null;
	}

			
			
			
		

	}


