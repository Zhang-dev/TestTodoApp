package pageobjects.todos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationFrameWork.AutomationFramework;

public class TodoList {
	private AutomationFramework framework;

	public TodoList(WebDriver driver){
		framework = new AutomationFramework(driver);
	}
	
	public String getTodo(int i){
		return framework.getTextByIndex(By.xpath("//*[@class='todo__item']"), i);
	}
	
	public void deletTodo(int i){
		framework.clickByIndex(By.xpath("//*[@class='todo__item']//span"), i);
	}
	
	public void toggleTodo(int i){
		framework.clickByIndex(By.xpath("//*[@class='todo__item']"), i);
	}
	
	
	public String getCssValueofTodo(String css, int i){
		return framework.getCssValueByIndex(By.xpath("//*[@class='todo__item deleteLi']"),css, i);
	}
	
}
