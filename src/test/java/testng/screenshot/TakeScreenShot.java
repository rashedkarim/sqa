package testng.screenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {

	public static void screenShotCapture(WebDriver driver) {
		Date currentDate = new Date();
		String filename = currentDate.toString().replace(":", "_").replace(" ", "_");
		
		File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File("./screenshot/"+filename+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
