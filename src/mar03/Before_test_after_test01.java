package mar03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.helpers.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Before_test_after_test01 {
	WebDriver driver;
	@BeforeTest
	public void setup() 
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		org.testng.Reporter.log("running in before test",true);
		}
	@Test
	public void pbanking()
	{
		driver.findElement(By.xpath("(//img)[4]"));
		org.testng.Reporter.log("executing p banking",true);
	}
	@Test
	public void cbanking()
	{
		driver.findElement(By.xpath("(//img)[5]"));
		org.testng.Reporter.log("executing c banking",true);
	}
	@Test
	public void ibanking()
	{
		driver.findElement(By.xpath("(//img)[6]"));
		org.testng.Reporter.log("executing i banking",true);
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
		org.testng.Reporter.log("running in before test");
	}


}
