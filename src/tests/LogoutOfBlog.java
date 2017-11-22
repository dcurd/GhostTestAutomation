package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utilities.TestAutomationGlobalInit;

public class LogoutOfBlog extends TestAgent {

	WebDriver driver;
	WebElement logout;
	TestAutomationGlobalInit init= TestAutomationGlobalInit.getInstance();
	
	public LogoutOfBlog() {
		// TODO Auto-generated constructor stub
	}
	
	public void Logout(WebDriver driver,String testname){
		List<WebElement>listOfElements=this.driver.findElements(By.cssSelector("header"));
		
		for(WebElement e : listOfElements){
			if(e.getAttribute("role")!=null && e.getAttribute("role").contains("button")){
				this.logout=e;
				e.click();
				Sleep(2000);
				this.driver.findElement(By.xpath("//a[@href='/ghost/signout/']")).click();
				break;
			}
		}
		if(driver.getCurrentUrl().contains(init.GetSignInUrl())){
			init.AddToResults(testname, true);
			System.out.println("Hi");
		}else{
			init.AddToResults(testname, false);
			System.out.println("Bye");
		}
		
		
	}

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
