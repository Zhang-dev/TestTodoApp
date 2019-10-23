package TodoAppTest.TodoAppTest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.todos.TodoApp;

public class TodosTest {
	private WebDriver driver;

	String item = "this is a to-do";

	@Before
	public void setUp() throws Exception {

		String exePath = "C:/Users/zhang.zhan/Downloads/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
																		

	}

	@Test
	public void testOpenApp() throws InterruptedException {

		TodoApp todoapp = new TodoApp(driver);
		// Launch the Todo App
		todoapp.openTodoApp();

		// Get the title of the page
		String title = todoapp.getTitle();
		// Check if the right title shows on the window
		Assert.assertTrue(title.contains("Document"));

	}

	@Test
	public void testAddTodo() throws InterruptedException {

		TodoApp todoapp = new TodoApp(driver);

		// Launch the Todo App
		todoapp.openTodoApp();
		
		// Add a to-do into the list
		todoapp.input().addTodo(item);

		// Get the first item of the to-do-list
		String firstitem = todoapp.todolist().getTodo(1);
		
//		Thread.sleep(3000);

		// Check if the to-do has been added
		Assert.assertTrue(firstitem.contains(item));

	}
	
	@Test
	public void testDeleteTodo() throws InterruptedException {

		TodoApp todoapp = new TodoApp(driver);

		// Launch the Todo App
		todoapp.openTodoApp();
		
		// Get the second item on the list
		String seconditem = todoapp.todolist().getTodo(2);
		
		// Delete the first to-do on the list
		todoapp.todolist().deletTodo(1);

		// Get the first item of the to-do-list
		String firstitem = todoapp.todolist().getTodo(1);

		// Check if the to-do has been added
		Assert.assertEquals(firstitem, seconditem);;

	}
	
	@Test
	public void testToggleTodo() throws InterruptedException {

		TodoApp todoapp = new TodoApp(driver);

		// Launch the Todo App
		todoapp.openTodoApp();
		
		// Toggle the first to-do on the list to be done
		todoapp.todolist().toggleTodo(1);

		String cssValue =todoapp.todolist().getCssValueofTodo("text-decoration-line", 1);
		
//		Thread.sleep(3000);

	    // Check if the to-do has been toggled
		Assert.assertEquals("text-decoration", "line-through", cssValue);
		

	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
