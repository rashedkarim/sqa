package testng.screenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotDemo {
	
	WebDriver driver;
	
	public static void main(String[] args) {
		Date currentDate = new Date();
		System.out.println(currentDate);
		String filename = currentDate.toString().replace(":", "_").replace(" ", "_");
		System.out.println(filename);
	}

	@BeforeMethod
	void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("https://www.saucedemo.com/");
	}
	
	@AfterMethod
	void close() {
		this.driver.quit();
	}
	
	@Test
	void screenShotCapture() throws IOException {
		Date currentDate = new Date();
		String filename = currentDate.toString().replace(":", "_").replace(" ", "_");
		
		File screenShotFile = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File("./screenshot/"+filename+".jpg"));
	}
}
