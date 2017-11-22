package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import utilities.TestAutomationGlobalInit;

public class DeletePost extends TestAgent {

	WebDriver driver;
	TestAutomationGlobalInit init= TestAutomationGlobalInit.getInstance();
	
	public DeletePost() {
		// TODO Auto-generated constructor stub
	}
	
	public void Delete(WebDriver driver,String testname){
		this.driver=driver;
		try{
			this.driver.findElement(By.cssSelector("a[href='/ghost/editor/']")).click();
			this.driver.findElement(By.id("entry-title")).click();
			this.driver.findElement(By.id("entry-title")).sendKeys(init.GetHeader());
			this.driver.findElement(By.cssSelector("textarea")).click();
			this.driver.findElement(By.cssSelector("textarea")).sendKeys(init.GetPost());
			this.driver.findElement(By.cssSelector(".btn.btn-sm.btn-blue.dropdown-toggle.up.ember-view.closed")).click();
			this.driver.findElement(By.className("post-save-publish ")).click();
			
			this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-red.ember-view")).click();
			//btn btn-sm js-publish-button btn-blue  ember-view
			Sleep(2000);
			RegisterResult(this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).getText().equals("UPDATE POST"),testname);
			Sleep(2000);
			
		}catch(WebDriverException e){
				e.printStackTrace();
			}
	}

}
