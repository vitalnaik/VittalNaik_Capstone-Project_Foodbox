package com.sportyshoes.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminHomeTest {
	  WebDriver driver;
	  
	  
	   
	  
	  @BeforeMethod
	  	public void setUp() {
	  		System.setProperty("webdriver.chrome.driver","E:\\DOWNLOADS\\chromedriver_win32\\chromedriver.exe");
	  		driver=new ChromeDriver();
	  		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	  		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  		driver.manage().window().maximize();
	           driver.manage().deleteAllCookies();
	           driver.get("http://localhost:8080");
	           
	           adminLoginTest("vital@gmail.com","vital");
	           driver.get("http://localhost:8080/admin");
	  	}
	  	
	  	
	
	  	@Test(priority = 1)
	  	void verifyAdminProductsTest() {
	  		WebElement products=driver.findElement(By.xpath("//a[@href='/admin/products']"));
	  		products.click();
	  		
	  	}
	  	
	 @Test(priority = 2)
	  	void verifyAdminFindAllUsersTest() {

	  		WebElement users=driver.findElement(By.xpath("//a[@href='/admin/users']"));
	  		users.click();
	  		
	  	}
	  	
	 @Test(priority = 3)
	  	void verifyAdminFindUserTest() {

	  		verifyAdminFindAllUsersTest();
	  		driver.findElement(By.xpath("//a[@href='/admin/findUser']")).click();
	  		driver.findElement(By.id("firstName")).sendKeys("Anitha");
	  		
	  		driver.findElement(By.xpath("//input[@value='Search']")).click();

	 }
	 @Test(priority = 4)
	  	public void adminCategoriesTest() {
		 WebElement categories=driver.findElement(By.xpath("//a[@href='/admin/categories']"));
		 categories.click();
	 }	  		
	
	 
	 @Test(priority = 5)
	 public void adminLogout() {
		 WebElement categories=driver.findElement(By.xpath("//a[@href='/logout']"));
		 categories.click();
	 }
	  		
	  		
	  		
	  /*	@Test
	  	void verifyAdminAddCatTest() {
	  		driver.findElement(By.xpath("//a[@href='/login']")).click();
	  		System.out.println(driver.getCurrentUrl());
	  		driver.findElement(By.id("email")).sendKeys("vital@gmail.com");
	  		driver.findElement(By.id("password")).sendKeys("vital");
	  		
	  		driver.findElement(By.xpath("//input[@value='Login']")).click();
	  		driver.get("http://localhost:8080/admin/categories/add");
	  		driver.findElement(By.id("name")).sendKeys("extraCat");
	  		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	  		
	  		driver.get("http://localhost:8080/admin/categories");
	  	}
	     
	  	@Test
	  	void verifyAdminUpdateCatTest() {
	  		driver.findElement(By.xpath("//a[@href='/login']")).click();
	  		System.out.println(driver.getCurrentUrl());
	  		driver.findElement(By.id("email")).sendKeys("vital@gmail.com");
	  		driver.findElement(By.id("password")).sendKeys("vital");
	  		
	  		driver.findElement(By.xpath("//input[@value='Login']")).click();
	  		driver.get("http://localhost:8080/admin/categories");
	  	
	  		driver.findElement(By.xpath("//a[@href='/admin/categories/update/28']")).click();
	  		driver.findElement(By.id("name")).sendKeys("Extra");
	  		driver.findElement(By.xpath("//button[@type='submit']")).click();
	  		
	  		driver.get("http://localhost:8080/admin/categories");
	  	}

	  	
	  	@Test
	  	void verifyAdminDeleteCatTest() {
	  		driver.findElement(By.xpath("//a[@href='/login']")).click();
	  		System.out.println(driver.getCurrentUrl());
	  		driver.findElement(By.id("email")).sendKeys("vital@gmail.com");
	  		driver.findElement(By.id("password")).sendKeys("vital");
	  		
	  		driver.findElement(By.xpath("//input[@value='Login']")).click();
	  		driver.get("http://localhost:8080/admin/categories");
	  		
	  		driver.findElement(By.xpath("//a[@href='/admin/categories/delete/26']")).click();
	  		
	  		driver.get("http://localhost:8080/admin/categories");
	  	}
	  	
	  	*/
	 
	 
	
  	
	  	@AfterMethod
	  	public void tearDown() {
	  		driver.quit();
	  		System.out.println("After-Method is called");
	  	}
	  	
	  	
	  	public void adminLoginTest(String username,String password) {
	  		driver.findElement(By.xpath("//a[@href='/login']")).click();
	  		driver.findElement(By.id("email")).sendKeys(username);
	  		driver.findElement(By.id("password")).sendKeys(password);
	  		
	  		driver.findElement(By.xpath("//input[@value='Login']")).click();
	  		
	  	}

}
