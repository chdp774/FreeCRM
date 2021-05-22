package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.until.Utility;
import com.crm.qa.until.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
		public static WebDriver driver;
		public static Properties prop;
		public static EventFiringWebDriver e_driver;
		public static WebEventListener eventListener;
		
		public base() {
			try {
				prop = new Properties();
				FileInputStream fis = new FileInputStream("C:\\Eclipse-Workspace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
				prop.load(fis);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		public static void initialization() {
			String Browser = prop.getProperty("browser");
			if(Browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}else if(Browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else  if(Browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			
			// initliazating WebEventLister to driver
			
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Utility.pageLoadTimeOut, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Utility.implicitlyTimeOut, TimeUnit.SECONDS);
			
			
		}
}
