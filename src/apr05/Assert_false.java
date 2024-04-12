package apr05;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assert_false {
	WebDriver driver;
	@Test
	public void starTest() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String Expected = "Gmail";
		String actual=driver.getTitle();
		try {
		Assert.assertFalse(actual.equalsIgnoreCase(Expected),"tiltle is  matching");
		}catch (AssertionError e) {
			Reporter.log(e.getMessage(),true);
		}
		driver.quit();
	}

}
