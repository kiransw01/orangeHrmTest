package com.orangeHrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.orangeHrm.util.TestUtil;
import com.orangeHrm.util.WebEventListener;

public class BaseClass {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public BaseClass()
	{
		String filePath="G:\\Selenium\\Selenium Workspace\\OrangeHrmTest\\"
				+ "src\\main\\java\\com\\orangeHrm\\config\\config.properties";
		prop=new Properties();
		
		try {
		FileInputStream inputStream = new FileInputStream(filePath);;
		prop.load(inputStream);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "G:\\Selenium\\drivers\\geckodriver.exe");
		}
		
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TiemOut, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		}

}
