package metatests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import tests.Authentication;
import tests.LogoutOfBlog;
import utilities.TestAutomationGlobalInit;

public class MyTest {

	WebDriver driver;
	TestAutomationGlobalInit init= TestAutomationGlobalInit.getInstance();
	Authentication auth = new Authentication();
	LogoutOfBlog logout= new LogoutOfBlog();
	public MyTest() {
		System.setProperty("webdriver.chrome.driver", "..\\GhostTestAutomation\\driver\\chromedriver.exe");
		driver =  new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	public void run(){
		GoToSignInPage();
		/*CreatePost();
		EditPost();
		AddHtmlToPost();
		AddImageToPost();
		AddMarkupsToPost();
		DeletePost();*/
		LogoutOfBlog();
		driver.close();
	}
	
	
	private void GoToSignInPage(){
		auth.Login(this.driver,"GoToSignInPage()");			
	}
	
	private void CreatePost(){
		
	}
	
	private void EditPost(){
		
	}
	
	private void DeletePost(){
		
	}
	
	private void AddHtmlToPost(){
		
	}
	
	private void AddImageToPost(){
		
	}
	
	private void AddMarkupsToPost(){
		
	}
	
	private void LogoutOfBlog(){
		logout.Logout(driver,"LogoutOfBlog()");
	}
	

	public static void main(String[] args) {
		MyTest test = new MyTest();
		test.run();

	}

}
