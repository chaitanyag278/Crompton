package testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class testdata {
	WebDriver driver;
	WebDriverWait wait;
	String username;
	static ExtentReports reports;
	static ExtentTest test1;

	private void initializeDriver() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		reports = new ExtentReports("C:\\Users\\ganchait1\\Desktop\\crompton.html", false);
		test1 = reports.startTest("crompton");
		test1.log(LogStatus.INFO, "Test Started");

	}

	public void URL(String Username, String password) {

		if (driver == null) {
			initializeDriver();
		}
		driver.get("https://crompton-stg.esealcom.com/login");
		test1.log(LogStatus.PASS, "URL passed");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		username = Username;

	}

	void cookieslection() {

		if (driver == null) {
			initializeDriver();
		}
		driver.findElement(By.xpath("//input[@name='cookieCheck']")).click();

	}

	void submit() {

		if (driver == null) {
			initializeDriver();
		}

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Sign In']")));
		} catch (TimeoutException e)

		{
			System.out.println(e);
		}

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).submit();
		test1.log(LogStatus.PASS, "SUBMIT WORKING");

	}

	void checklogin() throws Exception {

		if (driver == null) {
			initializeDriver();
		}

		Thread.sleep(5000);
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']")).click();
		String name = driver.findElement(By.xpath("//span[@class='email-content']")).getText();

		if (name.equals(username)) {
			System.out.println("login success");
			test1.log(LogStatus.PASS, "login WORKING");

		} else
			System.out.println("failed login");

	}

	void Authorization() throws Exception {
		if (driver == null) {
			initializeDriver();
		}
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@class='nav']/li[2]")).click();
		test1.log(LogStatus.PASS, "Auth clickable WORKING");
	}

	void Manage() throws Exception {
		if (driver == null) {
			initializeDriver();
		}
		Thread.sleep(1000);
		driver.manage().window().fullscreen();
		driver.findElement(By.xpath("//*[@class='nav']/li[7]")).click();
		driver.findElement(By.xpath("//*[@class='nav']/li[7]/ul/li[3]")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Import Update Product Status']")))
				.click();

		driver.findElement(By.cssSelector("#files1"))
				.sendKeys("C:\\Users\\ganchait1\\Downloads\\Crompton-updateproductsstatus-sampletemplate (1).xls");

		Thread.sleep(800);
		test1.log(LogStatus.INFO, "Test ended");
		reports.endTest(test1);
		reports.flush();
	}
}