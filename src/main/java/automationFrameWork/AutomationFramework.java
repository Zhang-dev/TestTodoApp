package automationFrameWork;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class AutomationFramework {
	
	WebDriver driver;
	
	public AutomationFramework(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sendKeys(By identifier, String text) {
		
		findElement(identifier).clear();
		findElement(identifier).sendKeys(text);
	}
	
	public void enter(By identifier){
		findElement(identifier).sendKeys(Keys.RETURN);
	}
	
	public void click(By identifier) {
		
			findElement(identifier).click();
		}
	
	public void clickByIndex(By identifier, int i){
		findElements(identifier).get(i-1).click();
	}
	
	public boolean isDisplayed(By identifier, int i){
		return findElements(identifier).get(i-1).isDisplayed();
	}
	
	public String getText(By identifier){
		return findElement(identifier).getText();
	}
	
	public String getTextByIndex(By identifier,int i){
		return findElements(identifier).get(i-1).getText();
	}
	
	public String getCssValueByIndex(By identifier,String css,int i){
		return findElements(identifier).get(i-1).getCssValue(css);
	}
	
	
	private WebElement findElement(By identifier) {
		
		try {
			
			return driver.findElement(identifier);
			
		} catch (NoSuchElementException e) {
			new ScreenshotUtil().saveScreenshot(driver);
			fail("Element " + identifier + " konnte nicht gefunden werden");
			return null;
			// throw e;
		}
		
	}

	private List<WebElement> findElements(By identifier) {

		try {
			return driver.findElements(identifier);

		} catch (NoSuchElementException e) {
			new ScreenshotUtil().saveScreenshot(driver);
			fail("Elements " + identifier + " konnte nicht gefunden werden");
			return null;
			// throw e;
		}

	}

}
