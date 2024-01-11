package selenium.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragNDrop {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("https://jqueryui.com/droppable/");
	}

	@AfterMethod
	public void close() {
		this.driver.quit();
	}
	
	@Test
	public void dragNDropTest() throws InterruptedException {
		WebElement frame = this.driver.findElement(By.xpath("//iframe"));
		this.driver.switchTo().frame(frame);
		
		WebElement drag = this.driver.findElement(By.id("draggable"));
		WebElement drop = this.driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(this.driver);
		Thread.sleep(2000);
		act.dragAndDrop(drag, drop).perform();
		Thread.sleep(2000);
	}
}
