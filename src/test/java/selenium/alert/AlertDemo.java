package selenium.alert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo {
	
	WebDriver driver;
	
	@BeforeMethod
	void setput() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins");
		this.driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}

	@Test
	void JSAlert() throws InterruptedException {
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Info: "+alert.getText());
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		if(driver.getPageSource().contains("You successfully clicked an alert")) {
			System.out.println("You successfully clicked an alert");
		}
	}
	@Test
	void JSAlertConfirm() throws InterruptedException {
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Info: "+alert.getText());
		Thread.sleep(2000);
		alert.dismiss();
		Thread.sleep(2000);
		if(driver.getPageSource().contains("You clicked: Cancel")) {
			System.out.println("You clicked: Cancel");
		}
	}
	
	@Test
	void JSAlertPrompt() throws InterruptedException {
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Info: "+alert.getText());
		Thread.sleep(2000);
		alert.sendKeys("Rashed Karim");
		alert.accept();
		Thread.sleep(2000);
		if(driver.getPageSource().contains("You entered: Rashed Karim")) {
			System.out.println("You entered: Rashed Karim");
		}
	}
	
	@AfterMethod
	void teardown() {
		this.driver.quit();
	}

}
