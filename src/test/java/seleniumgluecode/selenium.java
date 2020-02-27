package seleniumgluecode;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class selenium {
	public static WebDriver driver;

	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "webdrivers//chrome//mac//chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("http://automationpractice.com/index.php");
	}


	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		driver.get("https://aspire.bamboohr.com/login.php?r=%2Femployees%2Femployee.php%3Fid%3D79%26page%3D2078");
	}

	 @When("^verify user in main page$")
	 public void loggedin() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 Assert.assertEquals(driver.getTitle(), "Afnan Yousef - Job");
	 driver.quit();
	 }


	@When("^user enters username and Password$")
	public void user_enters_username_and_Password() throws Throwable {
		driver.findElement(By.cssSelector("#lemail")).sendKeys("ayousef@aspire-infotech.net");
		driver.findElement(By.cssSelector("[placeholder=\"Password\"]")).sendKeys("Afnanma7moud$$");
		driver.findElement(By.cssSelector(".login-actions > button[type=\"submit\"]")).click();
	}

}