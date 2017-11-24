package tests;

import org.openqa.selenium.WebDriver;

import utilities.TestAutomationGlobalInit;

public class TestAgent {

	WebDriver driver;
	TestAutomationGlobalInit init= TestAutomationGlobalInit.getInstance();
	public TestAgent() {
	}
	
	
	public void Sleep(long value){
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean RegisterResult(Boolean result, String testname){
		System.out.println(result);
		return init.SetResult(testname, result);		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
