package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.TestAutomationGlobalInit;

public class Authentication extends TestAgent {

	
		
	public Authentication() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean Login(WebDriver driver,String testname){
		try{
		this.driver=driver;
		driver.get(init.GetSignInUrl());
		WebElement login=GetLoginElement();
		WebElement password=GetPasswordElement();
		Actions builder = new Actions(driver);
        Actions seriesOfActions = builder.sendKeys(login, init.GetEmail()).sendKeys(password,init.GetPassword()).sendKeys(Keys.ENTER);
        seriesOfActions.perform();
        Sleep(3000);
		}catch(WebDriverException e){
			e.printStackTrace();
		}
		return RegisterResult(!driver.getCurrentUrl().contains("signin"),testname);
		
	}
	
	private WebElement GetLoginElement(){
		return this.driver.findElement(By.cssSelector(".email.ember-view.gh-input"));
		
	}
	private WebElement GetPasswordElement(){
		return this.driver.findElement(By.cssSelector(".password.ember-view.gh-input"));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
