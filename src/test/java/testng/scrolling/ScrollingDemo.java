package testng.scrolling;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingDemo {

	WebDriver driver;
	JavascriptExecutor jsExec;

	@BeforeMethod
	void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_area");
		this.jsExec = (JavascriptExecutor) this.driver;
	}
	
	@AfterMethod
	void close() {
		this.driver.quit();
	}
	
	@Test
	void scrollByPixel() throws InterruptedException {
		this.jsExec.executeScript("window.scrollBy(0, 700);", "");
		Thread.sleep(4000);
	}
	
	@Test
	void scrollByVisibleElement() throws InterruptedException {
		WebElement malaysia = this.driver.findElement(By.xpath("//a[@href='/wiki/Malaysia']"));
		this.jsExec.executeScript("arguments[0].scrollIntoView()", malaysia);
		Thread.sleep(4000);
	}
	
	@Test
	void scrollToBottomOfThePage() throws InterruptedException {
		this.jsExec.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		Thread.sleep(4000);
	}
}
