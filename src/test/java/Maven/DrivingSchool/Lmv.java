package Maven.DrivingSchool;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Lmv {

	public static void main(String[] args) {
		validSignIn();
	}
	
	public static WebDriver setupDriver() {

		// Create an instance of ChromeOptions & Add the incognito argument
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver(options);

		// Maximize the window and delete cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		return driver;
	}
	
	public static void validSignIn() {
		
		try {
			WebDriver driver = setupDriver();
			driver.get("https://driving-school.projects-codingbrains.com/signin");

// Find the correct input elements and fill them out
			driver.findElement(By.id("name")).sendKeys("Fresh");
			driver.findElement(By.id("lname")).sendKeys("Impro");
			WebElement selectElement  = driver.findElement(By.id("sel1"));
			Select select = new Select(selectElement );
			select.selectByVisibleText("January");
			WebElement dropdownElement = driver.findElement(By.id("sel2"));
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByVisibleText("1");
			WebElement dropdownElement2 = driver.findElement(By.id("sel3"));
			Select dropdown2 = new Select(dropdownElement2);
			dropdown2.selectByVisibleText("1990");
		
			// Find the submit button and click it
			driver.findElement(By.className("login-btn")).click();
			Thread.sleep(2000);
//			WebElement retakeLink = driver.findElement(By.xpath("(//a[@class='continue-btn'])[4]"));
//	        WebElement retakeLink = driver.findElement(By.className("continue-btn")).get(1);
			List<WebElement> elements = driver.findElements(By.className("continue-btn"));
			WebElement retakeLink = elements.get(3);
			retakeLink.click();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
