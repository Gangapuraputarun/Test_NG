package apr05;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_browsering_testing {
	WebDriver driver;
	@Parameters({"Browser"})
	@BeforeTest
	public void setup(String brw)
	{
		switch (brw) {
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
			default:
				Reporter.log("Browser value not matching",true);
			break;
		}
		
		
	}
	@DataProvider
	public Object supplyData()
	{
		Object login[][] = {{"Admin","Qedge123!@#"},{"Admin","Qedge123!@"},{"Admin","Qedge123!@#"},{"taun","Qedge123!@#"},{"Admin","Qedge123!@#"}};
		return login;
		

}
	@Test(dataProvider ="supplyData")
	public void verify_login(String user,String pass) throws Throwable
	{
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("txtUsername")).sendKeys(user);
		driver.findElement(By.name("txtPassword")).sendKeys(pass);
		driver.findElement(By.name("Submit")).click();
		String Expercted ="dashboard";
		String actual = driver.getCurrentUrl();
		if (actual.contains(Expercted)) 
		{
			Reporter.log("login sucess::"+Expercted+"      "+actual,true);
			
		} 
		else {
			Reporter.log("login fail::"+Expercted+"      "+actual,true);

		}
		

}
	@AfterTest
	public void teardown() 
	{
		driver.quit();
		
		
	}
}
