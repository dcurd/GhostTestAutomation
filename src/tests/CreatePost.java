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

	public CreatePost() {
		// TODO Auto-generated constructor stub
	}
	///ghost/editor/
	public boolean Create(WebDriver driver,String testname){
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
			this.driver.findElement(By.cssSelector(".post-settings")).click();
			//ember-view ghost-url-preview description
			this.driver.findElement(By.cssSelector(".ember-view.ghost-url-preview.description")).getText(); 
			this.driver.findElement(By.cssSelector("textarea")).sendKeys(Keys.ESCAPE);
			Sleep(2000);
			return RegisterResult(this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).getText().equals("UPDATE POST"),testname);
			
			
		}catch(WebDriverException e){
				e.printStackTrace();
				return false;
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
