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
		
			if(testname.contains("Edit")){
				ListOfEditTests(testname);
			}else{
			switch(testname){
			case "ConfirmBlog": return ConfirmBlog(testname);
			case "GoToSignInPage": return GoToSignInPage(testname);
			case "CreatePost": return CreatePost(testname);
			case "DeletePost": return DeletePost(testname) ;
			case "LogoutOfBlog": LogoutOfBlog(testname);  return false;			
			}
			}
		
		return true;
	}
	
	private void ListOfEditTests(String testname){
		if(init.GetTestResults().get("CreatePost")){
		switch(testname){
		case "EditPost": EditPost(testname); break; 
		case "EditHtmlToPost": AddHtmlToPost(testname); break; 
		case "EditImageToPost": AddImageToPost(testname); break; 
		case "EditMarkupsToPost": AddMarkupsToPost(testname);break; 
		case "EditTagToPost": AddTagToPost(testname);break; 
		}
		}
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
		test.add("EditHtmlToPost");
		init.AddToResults("EditHtmlToPost", false);
		test.add("EditImageToPost");
		init.AddToResults("EditImageToPost", false);
		test.add("EditMarkupsToPost");
		init.AddToResults("EditMarkupsToPost", false);
		test.add("EditTagToPost");
		init.AddToResults("EditTagToPost", false);
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
	
	private boolean AddTagToPost(String testname){
		return edit.EditAddTag(this.driver, testname);
		
	}
	
	private boolean DeletePost(String testname){
		if(!init.GetTestResults().get("CreatePost")){
			return false;
		}else{
			return delete.Delete(this.driver, testname);
		}
	}
	
	private boolean LogoutOfBlog(String testname){
 		return logout.Logout(driver,testname);
	}
	

	public static void main(String[] args) {
		MyTest test = new MyTest();
		test.run();

	}

}
