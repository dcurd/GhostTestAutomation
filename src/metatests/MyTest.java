package metatests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.*;
import utilities.TestAutomationGlobalInit;

public class MyTest {

	WebDriver driver;
	TestAutomationGlobalInit init= TestAutomationGlobalInit.getInstance();
	Authentication auth = new Authentication();
	LogoutOfBlog logout= new LogoutOfBlog();
	CreatePost create= new CreatePost();
	EditPost edit= new EditPost();
	DeletePost delete= new DeletePost();
	
	public MyTest() {
		System.setProperty("webdriver.chrome.driver", "..\\GhostTestAutomation\\driver\\chromedriver.exe");
		driver =  new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	public void run(){
		GoToSignInPage();
		CreatePost();
		/*EditPost();
		AddHtmlToPost();
		AddImageToPost();
		AddMarkupsToPost();*/
		DeletePost();
		LogoutOfBlog();
		driver.close();
	}
	
	
	private void GoToSignInPage(){
		auth.Login(this.driver,"GoToSignInPage()");			
	}
	
	private void CreatePost(){
		create.Create(this.driver, "CreatePost()");
	}
	
	private void EditPost(){
		
	}
	
	private void DeletePost(){
		delete.Delete(this.driver, "DeletePost()");
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
