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
		//need to check for the ones below
		EditPost();
		AddHtmlToPost();
		AddImageToPost();
		/*AddMarkupsToPost();*/
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
		edit.Edit(this.driver, "EditPost()");
	}
	
		
	private void AddHtmlToPost(){
		edit.EditHtml(this.driver, "AddHtmlToPost()");
	}
	
	private void AddImageToPost(){
		edit.EditImage(this.driver, "AddImageToPost()");
	}
	
	private void AddMarkupsToPost(){
		
	}
	
	private void DeletePost(){
		delete.Delete(this.driver, "DeletePost()");
	}
	
	private void LogoutOfBlog(){
		logout.Logout(driver,"LogoutOfBlog()");
	}
	

	public static void main(String[] args) {
		MyTest test = new MyTest();
		test.run();

	}

}
