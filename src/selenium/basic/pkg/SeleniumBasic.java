package selenium.basic.pkg;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.checkerframework.common.reflection.qual.Invoke;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBasic {
	WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeleniumBasic sel = new SeleniumBasic();
		sel.invokeBrowser();
		sel.loginValidation_withoutCaptcha();
		//sel.userRegister();
		sel.quitBrowser();
	}
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get("https://phptravels.com/demo/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void userRegister() {
		try {
			driver.get("https://phptravels.org/register.php");
			driver.findElement(By.id("inputFirstName")).sendKeys("Test-Firstname");
			driver.findElement(By.id("inputLastName")).sendKeys("Test-Lastname");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void loginValidation_withoutCaptcha() {
		try {
			driver.get("https://phptravels.org/login");
			driver.findElement(By.id("inputEmail")).sendKeys("invalid@gmail.com");
			driver.findElement(By.id("inputPassword")).sendKeys("invalidpassword");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			//driver.findElement(By.className("recaptcha-checkbox-checkmark")).click();
			driver.findElement(By.id("login")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			System.out.println(driver.findElement(By.xpath("/html/body/section/div/div[1]/div/form/div/div[1]/div[2]")).getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
