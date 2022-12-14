package com.interview.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagement {
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public WebDriver getDriver(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Softwares\\workspace2\\com.interview\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			
			return driver;
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webDriver.gecko.driver", System.getProperty("user.dir"+"/geckodriver.exe"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;
		
	}
}
