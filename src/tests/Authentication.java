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

	
	TestAutomationGlobalInit init= TestAutomationGlobalInit.getInstance();
	
	public Authentication() {
		// TODO Auto-generated constructor stub
	}
	
	public void Login(WebDriver driver,String testname){
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
		RegisterResult(driver.getCurrentUrl().contains(init.GetSignedInUrl()),testname);
		
	}
	
	private WebElement GetLoginElement(){
		List<WebElement>listOfElements=driver.findElements(By.cssSelector("input"));
		WebElement login = null;
		for(WebElement e : listOfElements){
			if(e.getAttribute("type")!=null && e.getAttribute("type").contains("email")){
				login=e;
				break;
			}
		}
		return login;
	}
	private WebElement GetPasswordElement(){
		List<WebElement>listOfElements=driver.findElements(By.cssSelector("input"));
		WebElement password = null;
		for(WebElement e : listOfElements){
			if(e.getAttribute("type")!=null && e.getAttribute("type").contains("password")){
				password=e;
				break;
			}
		}
		return password;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
