package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.TestAutomationGlobalInit;

public class CreatePost extends TestAgent{

	WebDriver driver;
	TestAutomationGlobalInit init= TestAutomationGlobalInit.getInstance();
	public CreatePost() {
		// TODO Auto-generated constructor stub
	}
	///ghost/editor/
	public void Create(WebDriver driver,String testname){
		this.driver=driver;
		try{
			init.SetWorkingUrl(this.driver.getCurrentUrl());
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
