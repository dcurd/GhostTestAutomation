package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import utilities.TestAutomationGlobalInit;

public class EditPost extends TestAgent {
	
	public EditPost() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean Edit(WebDriver driver, String testname){
		try{
		this.driver=driver;
		this.driver.findElement(By.cssSelector("textarea")).clear();
		this.driver.findElement(By.cssSelector("textarea")).click();
		this.driver.findElement(By.cssSelector("textarea")).sendKeys(init.GetEdit());		
		this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).click();
		return GoToBlogPostPageCss(this.driver,".post-content",init.GetEdit(),testname);
		}catch(WebDriverException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean EditHtml(WebDriver driver, String testname){
		try{
		this.driver=driver;
		GoToWorkingUrl(this.driver);
		this.driver.findElement(By.cssSelector("textarea")).clear();
		this.driver.findElement(By.cssSelector("textarea")).click();
		init.SetHtml(init.GetHtml().replace("%%%%", init.GetHtmlName()));
		this.driver.findElement(By.cssSelector("textarea")).sendKeys(init.GetHtml());		
		this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).click();
		Sleep(2000);
		return GoToBlogPostPageCssText(this.driver,".post-content","text",init.GetHtmlName(),testname);
	}catch(WebDriverException e){
		e.printStackTrace();
		return false;
	}
	}
	
	public boolean EditImage(WebDriver driver, String testname){
		try{
		//style="background-image: url(http://www.azquotes.com/picture-quotes/quote-the-place-god-calls-you-to-is-the-place-where-your-deep-gladness-and-the-world-s-deep-frederick-buechner-37-96-31.jpg)"
		this.driver=driver;
		GoToWorkingUrl(this.driver);
		this.driver.findElement(By.cssSelector("textarea")).clear();
		this.driver.findElement(By.cssSelector("textarea")).click();
		this.driver.findElement(By.cssSelector(".post-settings")).click();
		Sleep(1000);
		this.driver.findElement(By.cssSelector(".icon-link")).click();
		this.driver.findElement(By.cssSelector(".url.ember-view.gh-input")).sendKeys(init.GetImage());
		this.driver.findElement(By.cssSelector(".btn.btn-blue.gh-input")).click();
		this.driver.findElement(By.cssSelector("textarea")).sendKeys(Keys.ESCAPE);
		this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).click();
		return GoToBlogPostPageCss(this.driver,".main-header.post-head","background-image",init.GetImage(),testname);
		}catch(WebDriverException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean EditMarkup(WebDriver driver, String testname){
	try{
		//del tag
		this.driver=driver;
		GoToWorkingUrl(this.driver);
		this.driver.findElement(By.cssSelector("textarea")).clear();
		this.driver.findElement(By.cssSelector("textarea")).click();
		this.driver.findElement(By.cssSelector("textarea")).sendKeys(Keys.ESCAPE);
		this.driver.findElement(By.cssSelector("textarea")).sendKeys("~~"+init.GetMarkdown()+"~~");		
		this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).click();
		return GoToBlogPostPageTag(driver,"del",init.GetMarkdown(),testname);
	}catch(WebDriverException e){
		e.printStackTrace();
		return false;
	}
	}

	public boolean EditAddTag(WebDriver driver,String testname){
		try{
			//style="background-image: url(http://www.azquotes.com/picture-quotes/quote-the-place-god-calls-you-to-is-the-place-where-your-deep-gladness-and-the-world-s-deep-frederick-buechner-37-96-31.jpg)"
			this.driver=driver;
			GoToWorkingUrl(this.driver);
			this.driver.findElement(By.cssSelector("textarea")).clear();
			this.driver.findElement(By.cssSelector("textarea")).click();
			this.driver.findElement(By.cssSelector(".post-settings")).click();
			Sleep(1000);
			this.driver.findElement(By.id("tag-input-selectized")).click();
			this.driver.findElement(By.id("tag-input-selectized")).sendKeys(init.GetTag());
			this.driver.findElement(By.id("tag-input-selectized")).sendKeys(Keys.ENTER);
			this.driver.findElement(By.cssSelector("textarea")).sendKeys(Keys.ESCAPE);
			this.driver.findElement(By.cssSelector("textarea")).sendKeys(Keys.ESCAPE);
			this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).click();
			return GoToBlogPostPageCss(this.driver,".post-meta",init.GetTag(),testname);
			}catch(WebDriverException e){
				e.printStackTrace();
				return false;
			}
	}
	public boolean UnpublishPost(WebDriver driver,String testname){
		return true;
	}
	public boolean RepublishPost(WebDriver driver,String testname){
		return true;
	}
}
