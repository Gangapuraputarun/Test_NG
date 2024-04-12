package apr04;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Invocation {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.name("Submit")).click();
		Reporter.log("running in before method");
		
	}
	@Test(priority=2,invocationCount=5)
	public void admin() 
	{
		driver.findElement(By.xpath("//b[normalize-space()=\"Admin\"]")).click();
		Reporter.log("exectind admin test",true);
	}
	@Test
	public void pim() 
	{
		driver.findElement(By.xpath("//b[normalize-space()=\"PIM\"]")).click();
		Reporter.log("exectind pim test",true);
	}
	@Test
	public void leave() 
	{
		driver.findElement(By.xpath("//b[normalize-space()=\"Leave\"]")).click();
		Reporter.log("exectind leave test",true);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
		Reporter.log("running in after method",true);
	}
}



