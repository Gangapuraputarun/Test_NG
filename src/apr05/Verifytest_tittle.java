package apr05;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Verifytest_tittle {
	WebDriver driver;
	@Test
	public void starTest() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String Expected = "Gmail";
		String actual=driver.getTitle();
		try {
		assertEquals(actual, Expected,"tiltle is not matching");
		}catch (AssertionError e) {
			Reporter.log(e.getMessage(),true);
		}
		driver.quit();
	}
	
	
}
