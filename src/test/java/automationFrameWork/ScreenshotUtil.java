package automationFrameWork;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public void saveScreenshot(WebDriver driver) {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File("C:\\JavaScript_Project\\TodosApp\\test\\screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
