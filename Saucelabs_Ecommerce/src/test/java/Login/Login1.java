package Login;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ecom.genericUtilities.FileUtility;
import pomrepository.LoginPage;

public class Login1 
{
	@Test
	public void Login1() throws IOException
	{
		FileUtility fLib=new FileUtility();
		WebDriver driver=new ChromeDriver();
		LoginPage ll=new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(fLib.getDataFromProperties("url"));
//		driver.findElement(By.id("user-name")).sendKeys(fLib.getDataFromProperties("user1"),Keys.TAB,fLib.getDataFromProperties("password"),Keys.ENTER);
		ll.loginToApp(fLib.getDataFromProperties("user4"), fLib.getDataFromProperties("password"));
		System.out.println("PK");
	}
}
