package metatests;

import java.util.ArrayList;

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
	ConfirmBlogIsUp confirm=new ConfirmBlogIsUp();
	boolean result=true;
	ArrayList<String> test=new ArrayList<String>();
	
	public MyTest() {
		LoadTests();
		System.setProperty("webdriver.chrome.driver", "..\\GhostTestAutomation\\driver\\chromedriver.exe");
		driver =  new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	public void run(){
		while(result){
			result= ListOfTests(test.remove(0));
		}
		
		driver.close();
	}
	
	private boolean ListOfTests(String testname){
		switch(testname){
		case "ConfirmBlog": return ConfirmBlog();
		case "GoToSignInPage": return GoToSignInPage();
		case "CreatePost": return CreatePost();
		case "EditPost": return EditPost();
		case "AddHtmlToPost": return AddHtmlToPost();
		case "AddImageToPost": return AddImageToPost();
		case "AddMarkupsToPost": return AddMarkupsToPost();
		case "DeletePost": return DeletePost() ;
		case "LogoutOfBlog": LogoutOfBlog();
		                     return false;
		
		}
		return false;
	}
	
	private void LoadTests(){
		test.add("ConfirmBlog");
		init.AddToResults("ConfirmBlog", false);
		test.add("GoToSignInPage");
		init.AddToResults("GoToSignInPage", false);
		test.add("CreatePost");
		init.AddToResults("CreatePost", false);
		test.add("EditPost");
		init.AddToResults("EditPost", false);
		test.add("AddHtmlToPost");
		init.AddToResults("AddHtmlToPost", false);
		test.add("AddImageToPost");
		init.AddToResults("AddImageToPost", false);
		test.add("AddMarkupsToPost");
		init.AddToResults("AddMarkupsToPost", false);
		test.add("DeletePost");
		init.AddToResults("DeletePost", false);
		test.add("LogoutOfBlog");
		init.AddToResults("LogoutOfBlog", false);
					
	}
	
	private boolean ConfirmBlog(){
		return confirm.Confirm(this.driver,"ConfirmBlog");			
	}
	
	
	private boolean GoToSignInPage(){
		return auth.Login(this.driver,"GoToSignInPage");			
	}
	
	private boolean CreatePost(){
		return create.Create(this.driver, "CreatePost");
	}
	
	private boolean EditPost(){
		return edit.Edit(this.driver, "EditPost");
	}
	
		
	private boolean AddHtmlToPost(){
		return edit.EditHtml(this.driver, "AddHtmlToPost");
	}
	
	private boolean AddImageToPost(){
		return edit.EditImage(this.driver, "AddImageToPost");
	}
	
	private boolean AddMarkupsToPost(){
		return false;
	}
	
	private boolean DeletePost(){
		return delete.Delete(this.driver, "DeletePost");
	}
	
	private boolean LogoutOfBlog(){
		return logout.Logout(driver,"LogoutOfBlog");
	}
	

	public static void main(String[] args) {
		MyTest test = new MyTest();
		test.run();

	}

}
