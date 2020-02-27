package info.aspireAutomation.SeleniumTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest {
	// private static FirefoxDriver driver;

	private static WebDriver driver;

	public void wait(String element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
	}

	public void fillElement(String element, String value) {
		wait(element);
		driver.findElement(By.cssSelector(element)).sendKeys(value);
	}

	public void clickOnElement(String element) {
		wait(element);
		driver.findElement(By.cssSelector(element)).click();
	}

	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "webdrivers//chrome//mac//chromedriver");
		driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testWebsite() {
		System.out.println("Starting test ");
		driver.get("https://aspire.bamboohr.com/login.php?r=%2Femployees%2Femployee.php%3Fid%3D79%26page%3D2078");
		fillElement("#lemail", "ayousef@aspire-infotech.net");
		fillElement("[placeholder=\"Password\"]", "Afnanma7moud$$");
		clickOnElement(".login-actions > button[type=\"submit\"]");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), "Afnan Yousef - Job");
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
