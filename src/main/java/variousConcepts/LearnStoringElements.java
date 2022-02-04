package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnStoringElements {
	WebDriver driver;
	
	@Before
	public void init () {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=login/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void loginTest() {
		//type name = value
		// Storing element using WebElement
		
		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		
		// Storing element using By class
		By USERNAME_FIELD = By.xpath("//*[@id=\"username\"]");
		By PASSWORD_FIELD = By.xpath("//*[@id=\\\"password\\\"]");
		By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\\\"page-wrapper\\\"]/div[2]/div/h2");
		
		
		//perform login
		
		USERNAME_ELEMENT.clear();
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123123");
		SIGNIN_BUTTON_ELEMENT.click();
		
		
	//	driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
		boolean pageTitleDisplayStatus;
		try {
			WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
		
			pageTitleDisplayStatus = true;
		}catch(Exception e) {
			pageTitleDisplayStatus = true;
			e.printStackTrace();
		}
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));
		
		Assert.assertTrue("Wrong Page!", pageTitleDisplayStatus);
	//	Assert.assertTrue("Wrong Page!", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
		
	}
}
