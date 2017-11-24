package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;

import utilities.TestAutomationGlobalInit;

public class DeletePost extends TestAgent {

	
	public DeletePost() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean Delete(WebDriver driver,String testname){
		this.driver=driver;
		GoToWorkingUrl(this.driver);
		try{
			//dropdown-menu dropdown-triangle-bottom-right
			this.driver.findElement(By.cssSelector(".btn.btn-sm.btn-blue.dropdown-toggle.up.ember-view.closed")).click();
			this.driver.findElement(By.cssSelector("li[class='delete']")).click();
			Sleep(1000);
			this.driver.findElement(By.cssSelector(".btn.btn-red.ember-view")).click();
			Sleep(2000);
			//error-content error-404 js-error-container
			if(!this.driver.getCurrentUrl().contains("editor")){
				return GoToBlogPostPageCss(this.driver,".error-code","404",testname);
				
			}else{
				return false;
			}
			//return RegisterResult(!this.driver.getCurrentUrl().contains("editor"),testname);
			
			
		}catch(WebDriverException e){
				e.printStackTrace();
				return false;
			}
	}

}
