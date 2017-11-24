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
		case "ConfirmBlog": return ConfirmBlog(testname);
		case "GoToSignInPage": return GoToSignInPage(testname);
		case "CreatePost": return CreatePost(testname);
		case "EditPost": EditPost(testname); return true;
		case "AddHtmlToPost": AddHtmlToPost(testname); return true;
		case "AddImageToPost": AddImageToPost(testname); return true;
		case "AddMarkupsToPost": AddMarkupsToPost(testname);return true;
		case "DeletePost": return DeletePost(testname) ;
		case "LogoutOfBlog": LogoutOfBlog(testname);
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
	
	private boolean ConfirmBlog(String testname){
		return confirm.Confirm(this.driver,testname);			
	}
	
	
	private boolean GoToSignInPage(String testname){
		return auth.Login(this.driver,testname);			
	}
	
	private boolean CreatePost(String testname){
		return create.Create(this.driver, testname);
	}
	
	private boolean EditPost(String testname){
		return edit.Edit(this.driver, testname);
	}
	
		
	private boolean AddHtmlToPost(String testname){
		return edit.EditHtml(this.driver, testname);
	}
	
	private boolean AddImageToPost(String testname){
		return edit.EditImage(this.driver, testname);
	}
	
	private boolean AddMarkupsToPost(String testname){
		return edit.EditMarkup(this.driver, testname);
		
	}
	
	private boolean DeletePost(String testname){
		return delete.Delete(this.driver, testname);
	}
	
	private boolean LogoutOfBlog(String testname){
		return logout.Logout(driver,testname);
	}
	

	public static void main(String[] args) {
		MyTest test = new MyTest();
		test.run();

	}

}
