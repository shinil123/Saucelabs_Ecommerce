package AddToCart;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ecom.genericUtilities.FileUtility;
import pomrepository.HomePage;
import pomrepository.LoginPage;

public class AddToCart1 
{
	@Test(enabled=false)
	public void AddToCart() throws IOException
	{
			FileUtility fLib=new FileUtility();
			WebDriver driver=new ChromeDriver();
			LoginPage ll=new LoginPage(driver);
			HomePage hp=new HomePage(driver);
			driver.manage().window().maximize();
			driver.get(fLib.getDataFromProperties("url"));
//			driver.findElement(By.id("user-name")).sendKeys(fLib.getDataFromProperties("user1"),Keys.TAB,fLib.getDataFromProperties("password"),Keys.ENTER);
			ll.loginToApp(fLib.getDataFromProperties("user1"), fLib.getDataFromProperties("password"));
//			driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']/../../following-sibling::div/button[text()='Add to cart']")).click();
			hp.getProduct_four();
			//div[@class='inventory_list']/div[@class='inventory_item'][position()=4]
//			String actual=driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).getText();
//			driver.findElement(By.id("shopping_cart_container")).click();
//			String expected=driver.findElement(By.xpath("//div[contains(text(),'Fleece Jacket')]")).getText();
//			hp.getProduct_four();
//			Assert.assertTrue(actual.contains(expected));
//			System.out.println("pass");
	}
	
	@Test
	public void AddToCart1() throws IOException
	{
		WebDriver driver=new ChromeDriver();
		FileUtility fLib=new FileUtility();
		LoginPage ll=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(fLib.getDataFromProperties("url"));
		ll.loginToApp(fLib.getDataFromProperties("user3"), fLib.getDataFromProperties("password"));
		driver.findElement(By.xpath("(//div[@class='inventory_item']/div/div/following-sibling::div/button[text()='Add to cart'])[position()=4]")).click();
		hp.getProduct_four();
		String expected=driver.findElement(By.xpath("(//div[@class='inventory_item']/div[@class='inventory_item_description']/div/a)[position()=4]")).getText();
		hp.addToCartbutton();
		String actual=driver.findElement(By.xpath("//div[@class='cart_list']/div[@class='cart_item']/div[@class='cart_item_label']/a[position()=1]")).getText();
		Assert.assertEquals(expected,actual);
		System.out.println("PASS");
		
	}
}
