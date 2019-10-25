package pageobjects.todos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import automationFrameWork.AutomationFramework;

public class Input {
	private AutomationFramework framework;

	public Input(WebDriver driver) {
		framework = new AutomationFramework(driver);
	}

	public void addTodo(String todo) {

		framework.sendKeys(By.xpath("//input[@class='todo__input']"), todo);
		framework.enter(By.xpath("//input[@class='todo__input']"));
	}

}
