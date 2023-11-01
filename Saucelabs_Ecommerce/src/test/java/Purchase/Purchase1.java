package Purchase;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ecom.genericUtilities.ExcelUtility;
import ecom.genericUtilities.FileUtility;

public class Purchase1 
{
	@Test
	public void Purchase1() throws IOException 
	{
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(fLib.getDataFromProperties("url"));
		driver.findElement(By.id("user-name")).sendKeys(fLib.getDataFromProperties("user1"),Keys.TAB,fLib.getDataFromProperties("password"),Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']/../../following-sibling::div/button[text()='Add to cart']")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys(eLib.getDataFromExcel("excelpath","Sheet1", 2, 0),Keys.TAB,eLib.getDataFromExcel("excelpath","Sheet1", 2, 1),Keys.TAB,eLib.getDataFromExcel("excelpath","Sheet1", 2, 2));
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		String actual=driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText();
		String expected="Thank you for your order!";
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actual, expected);
		System.out.println("pass");
		sa.assertAll();	
	}
}
