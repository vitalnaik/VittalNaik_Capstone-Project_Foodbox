package com.sportyshoes.project;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.project.ProjectApplication;


@SpringBootTest(classes=ProjectApplication.class)
class ProjectApplicationTests {
   WebDriver driver;
  
  
   
  
@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","E:\\DOWNLOADS\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.get("http://localhost:8080");
         
        
	}
	
	@Test(priority = 1)
	void verifyPageTitleTest() {
		String title =	driver.getTitle();
		System.out.println("page tilte is :"+title);
	  Assert.assertEquals(title,"FullStack");
		
	}
	@Test(priority = 2)
	public void verifyLogoTest() {
		WebElement cart=driver.findElement(By.xpath("//img[@src='/images/logo.png']"));
		  cart.isDisplayed();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("After-Method is called");
	}
	
	
	
	
}
