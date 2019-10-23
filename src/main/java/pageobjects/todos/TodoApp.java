package pageobjects.todos;

import org.openqa.selenium.WebDriver;

public class TodoApp {
	private WebDriver driver;
	
	private TodoList todolist;
	private Input input;
	
	public TodoApp(WebDriver driver){
		this.driver = driver;
		
		todolist = new TodoList(driver);
		input = new Input(driver);
	}
	
	public void openTodoApp(){
		driver.get("https://zhang-dev.github.io/TodoApp/");
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public Input input(){
		return input;
	}
	
	public TodoList todolist(){
		return todolist;
	}

}
