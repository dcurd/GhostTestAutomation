package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestAutomationGlobalInit {
	
	String propertieslocation= "/testautomation.properties";
	String url="";
	String blogposturl="";
	String signinurl="";
	String signedinurl="";
	String samplehtml="";
	String header="";
	String post="";
	String email="";
	String password="";
	String workingurl="";
	String html="";
	String image="";
	String edit="";
	String markdown="";
	String htmlname="";
	Properties props = new Properties();
	private static TestAutomationGlobalInit instance =null;
	DBUtils dbUtils=DBUtils.getInstance();
	Map<String,Boolean> testResults=new HashMap<String,Boolean>();
	
	private TestAutomationGlobalInit() {
		InputStream inputprop=null;
		try {
			inputprop= Properties.class.getResourceAsStream(propertieslocation);
			 if(inputprop != null) {
				 props.load(inputprop);
			 }			
			LoadDatabaseResources();
			LoadSeleniumResources();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 if(inputprop != null) {
				 try {
					inputprop.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		
		}
		
	}
	
	static public TestAutomationGlobalInit getInstance(){
		if(instance == null){
			instance = new TestAutomationGlobalInit();
		}
		return instance;
	}
	
	private void LoadDatabaseResources(){
		dbUtils.setDatabaseName(props.getProperty("Database-Name"));
		dbUtils.setHost(props.getProperty("Database-Host"));
		dbUtils.setPort(Integer.parseInt(props.getProperty("Database-Port")));
		dbUtils.setUserName(props.getProperty("Database-UserName"));
		dbUtils.setPassword( props.getProperty("Database-Password"));
	}
	
	private void LoadSeleniumResources(){
		SetSignInUrl(props.getProperty("Selenium-SignInUrl"));
		SetSignedInUrl(props.getProperty("Selenium-SignedInUrl"));
		SetRegularUrl(props.getProperty("Selenium-Url"));
		SetEmail(props.getProperty("Selenium-Email"));
		SetPassword(props.getProperty("Selenium-Password"));
		SetHeader(props.getProperty("Selenium-SampleHeader")+System.currentTimeMillis());
		SetPost(props.getProperty("Selenium-SamplePost"));
		SetHtml(props.getProperty("Selenium-SampleHtml"));
		SetImage(props.getProperty("Selenium-Image"));
		SetEdit(props.getProperty("Selenium-SampleEditPost"));
		SetMarkdown(props.getProperty("Selenium-Markup"));
		SetHtmlName(props.getProperty("Selenium-SampleHtmlName"));
	}
	
	public Map<String,Boolean> GetTestResults(){
		return this.testResults;
	}
	
	public boolean SetResult(String key, Boolean value){
		testResults.put(key, value);
		return value;
	}
	
	public void AddToResults(String key, Boolean value){
		testResults.put(key, value);
	}
	
	public String GetMarkdown(){
		return this.markdown;
	}
	
	public void SetMarkdown(String markdown){
		this.markdown=markdown;
	}
	
	public String GetEdit(){
		return this.edit;
	}
	
	public void SetEdit(String edit){
		this.edit=edit;
	}
	
	public String GetImage(){
		return this.image;
	}
	
	public void SetImage(String image){
		this.image=image;
	}
	
	public String GetHtmlName(){
		return this.htmlname;
	}
	
	public void SetHtmlName(String htmlnaem){
		this.htmlname=htmlname;
	}
	
	public String GetHtml(){
		return this.html;
	}
	
	public void SetHtml(String html){
		this.html=html;
	}
	
	public String GetBlogPostUrl(){
		return this.blogposturl;
	}
	
	public void SetBlogPostUrl(String blogposturl){
		this.blogposturl=blogposturl;
	}
	
	public String GetWorkingUrl(){
		return this.workingurl;
	}
	
	public void SetWorkingUrl(String workingurl){
		this.workingurl=workingurl;
	}
	public String GetHeader(){
		return this.header;
	}
	
	private void SetHeader(String header){
		this.header=header;
	}
	public String GetPost(){
		return this.post;
	}
	
	private void SetPost(String post){
		this.post=post;
	}
	public String GetEmail(){
		return this.email;
	}
	
	private void SetEmail(String email){
		this.email=email;
	}
	
	public String GetPassword(){
		return this.password;
	}
	
	private void SetPassword(String password){
		this.password=password;
	}
	
	public String GetSignInUrl(){
		return this.signinurl;
	}
	
	private void SetSignInUrl(String signin){
		this.signinurl=signin;
	}
	
	public String GetSignedInUrl(){
		return this.signedinurl;
	}
	
	private void SetSignedInUrl(String signedin){
		this.signedinurl=signedin;
	}
	
	public String GetRegularUrl(){
		return this.url;
	}
	
	private void SetRegularUrl(String url){
		this.url=url;
	}
	
	public static void main(String[] args){
		TestAutomationGlobalInit test=TestAutomationGlobalInit.getInstance();
	}

}
