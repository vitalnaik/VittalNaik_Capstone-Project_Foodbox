package com.sportyshoes.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserHomeTest {
	
		  WebDriver driver;
		   
		  void userLoginTest(String username,String password) {
			  driver.findElement(By.xpath("//a[@href='/login']")).click();
		  		driver.findElement(By.id("email")).sendKeys(username);
		  		driver.findElement(By.id("password")).sendKeys(password);
		  		
		  		driver.findElement(By.xpath("//input[@value='Login']")).click();
		  		
		  	}
		  
		  
		   
		  
		  @BeforeMethod
		  	public void setUp() {
		  		System.setProperty("webdriver.chrome.driver","E:\\DOWNLOADS\\chromedriver_win32\\chromedriver.exe");
		  		driver=new ChromeDriver();
		  		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  		driver.manage().window().maximize();
		           driver.manage().deleteAllCookies();
		           driver.get("http://localhost:8080");
		           
		           userLoginTest("Anitha@gmail.com","Anitha");
}
		  
		  @Test(priority = 1)
		  public void clickOnShopLinkTest() {
			  WebElement shop=driver.findElement(By.xpath("//a[@href='/shop']"));
			  shop.click();  
		  }
		 
		  @Test(priority = 2)
		  public void searchByCategoryVEGTest(){
			  clickOnShopLinkTest();
			  WebElement veg=driver.findElement(By.xpath("//a[@href='/shop/category/1']"));
			  veg.click();  
			  
		  }
		  @Test(priority = 3)
		  public void searchByCategoryNonVegTest(){
			  clickOnShopLinkTest();
			  WebElement nonveg=driver.findElement(By.xpath("//a[@href='/shop/category/2']"));
			  nonveg.click();  
			  
		  }
		  @Test(priority = 4)
		  public void searchByCategoryCooldrinksTest(){
			  clickOnShopLinkTest();
			  WebElement cooldrinks=driver.findElement(By.xpath("//a[@href='/shop/category/3']"));
			  cooldrinks.click();  
			  
		  }
		  @Test(priority = 5)
		  public void searchByCategoryTiffinsTest(){
			  clickOnShopLinkTest();
			  WebElement tiffins=driver.findElement(By.xpath("//a[@href='/shop/category/4']"));
			  tiffins.click();  
			  
		  }
		
		  
		  @Test(priority = 6)
		  public void addToCartTest() {
			 
			  clickOnShopLinkTest();
			 // <a href="/shop/viewproduct/10" class="btn btn-primary">View Product</a>
			  
			  WebElement view=driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
			  view.click();
			  WebElement add2Cart=driver.findElement(By.xpath("//a[@href='/addToCart/10']"));
			  add2Cart.click();
			 // <a href="/addToCart/10" class="btn btn-primary">Add to cart</a>
			  
		  }
		  
		  @Test(priority = 7)
		  public void navigateToCartTest() {
			  clickOnShopLinkTest();
			  addToCartTest();
			  WebElement cart=driver.findElement(By.xpath("//a[@href='/cart']"));
			  cart.click(); 
		  }
		  @Test(priority = 8)
		  public void checkoutTest() {
			  navigateToCartTest();
			  WebElement checkout=driver.findElement(By.xpath("//a[@href='/checkout']"));
			  checkout.click();
			
			  WebElement pay=driver.findElement(By.xpath("//button[@type='submit']"));
			  pay.click(); 
		  }
		  @Test(priority = 9)
		  public void userLogOutTest() {
			
			  WebElement logout=driver.findElement(By.xpath("//a[@href='/logout']"));
			  logout.click();  
		  }
		  
		  	@AfterMethod
		  	public void tearDown() {
		        driver.quit();
		  		System.out.println("After-Method is called");
		  	}	  
}
		  
		  