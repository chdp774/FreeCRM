package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.until.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.implicitlyTimeOut, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("prasadcankan@gmail.com");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("prasad123$");
		driver.findElement(By.xpath("//div[text() = 'Login']")).click();
		
		int f = driver.findElements(By.tagName("iframe")).size();
		System.out.println(f);
//		driver.findElement(By.xpath("//span[text() = 'Contacts']")).click();
//		driver.findElement(By.xpath("//div[@class= 'item']//a//button")).click();
	}

}
