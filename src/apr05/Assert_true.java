package apr05;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assert_true {
	WebDriver driver;
	@Test
	public void starTest() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String Expected = "Google";
		String actual=driver.getTitle();
		try {
		Assert.assertTrue(actual.equalsIgnoreCase(Expected),"tiltle is not matching");
		}catch (AssertionError e) {
			Reporter.log(e.getMessage(),true);
		}
		driver.quit();
	}

}
