package WCG.ResourceDirectory;


import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.seleniumemulation.IsElementPresent;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.NoSuchElementException;

import org.junit.Assert;
import com.compro.automation.core.SetupDriver;
import com.compro.automation.core.TestAssertion;
import com.compro.automation.core.TestEnvironement;
import com.compro.automation.core.TestRun;
import com.compro.automation.utils.CSVHandler;
import com.compro.automation.utils.Screenshot;

//import com.saucelabs.saucerest.SauceREST;


@RunWith(Parameterized.class)
public class Test_SRD_WCG_TX_US4 { 
	
	private String testEnv;
	private RemoteWebDriver driver = null;
	
 	String classname =this.getClass().getSimpleName().toString();
 	Package pack = this.getClass().getPackage();
 	String component = pack.getName();
 	String folder ;
   	String screen_resolution;
   	String actual = "";
   	String baseScreenshotFolder;
	String category;
	String platform;

	

	private boolean isElementPresent(By by) {
	    try {
	        driver.findElement(by);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	
	//----------------------------------------------	
	
	String device;
	String student_tools;
	String srd_page_header;
	String home_dropdown;
	String srd_li;
	String home_li;
	String srd_i_icon;
	String abt_student_res;
	String srd_unit1;
	String srd_unit4;
	String srd_chapter1;
	String srd_ch1_guided_writing;
	String srd_resource_viewer;
   	String resourceId;
	
			
	
	   
	public Test_SRD_WCG_TX_US4(String testEnv){
		this.testEnv = testEnv;	
	  }
		 	
	 
	  @Parameters
	   public static Collection<Object[]> data() throws Exception {
		   return (new TestEnvironement()).getEnvironment();
  }
	
	CSVHandler ele_path=null;
	CSVHandler screenshot_folder=null;
	private String path;
	Process process=null;
	
	@Before
	public void setUp() throws Exception 
	{		driver = TestRun.init(testEnv);		
		category = SetupDriver.resolutionCategory;
		
platform = "test"; 
// SetupDriver.platform;
		
		if(category.equalsIgnoreCase("Large")) {driver.manage().window().maximize();}
		if(category.equalsIgnoreCase("Medium_landscape")){driver.manage().window().setSize(new Dimension(1050, 1280 ));}
		if(category.equalsIgnoreCase("Medium_portrait")){driver.manage().window().setSize(new Dimension(800, 1000 ));}
		if(category.equalsIgnoreCase("Small")){driver.manage().window().setSize(new Dimension(380, 700 ));}

String screen_resolution = SetupDriver.resolutionCategory;
String browserchoice = SetupDriver.browserName;
screenshot_folder = new CSVHandler("src/test/resources/screenshot_folder.csv");
baseScreenshotFolder = screenshot_folder.getElementXpath("baseScreenshotFolder");

System.out.println("screen_resolution"+ screen_resolution);
ele_path = new CSVHandler("src/test/resources/element_path.csv");
student_tools = ele_path.getElementXpath("student_tools");
srd_page_header = ele_path.getElementXpath("srd_page_header");
home_dropdown = ele_path.getElementXpath("home_dropdown");
srd_li = ele_path.getElementXpath("srd_li");
home_li = ele_path.getElementXpath("home_li");
srd_i_icon = ele_path.getElementXpath("srd_i_icon");
abt_student_res = ele_path.getElementXpath("abt_student_res");
srd_unit1 = ele_path.getElementXpath("srd_unit1");
srd_unit4 = ele_path.getElementXpath("srd_unit4");
srd_chapter1= ele_path.getElementXpath("srd_chapter1");
srd_ch1_guided_writing = ele_path.getElementXpath("srd_ch1_guided_writing");
srd_resource_viewer = ele_path.getElementXpath("srd_resource_viewer");
resourceId = ele_path.getElementXpath("resourceId");



//folder for screenshot
folder= baseScreenshotFolder + component + "/" + classname + "/" ;

//if ((SetupDriver.host).equalsIgnoreCase("real-device"))
//			folder= baseScreenshotFolder + component + "/" + classname + "/"+ SetupDriver.host + "/" + SetupDriver.deviceType + "/";
//
//	else
//			folder= baseScreenshotFolder + component + "/" + classname + "/" ;



	}
		
@After
public void tearDown() throws Exception 
{
	TestRun.stop(driver);
	}
			
  private String baseUrl;  
  
//  Click on a resource 

  //@Ignore
  @Test
  public void TC_SRD_US4_1_1() throws Exception {
 
		// For each test case
	   System.out.println("Simple Class name1: " + this.getClass().getSimpleName());
	   String tcname = new Exception().getStackTrace()[0].getMethodName();
	   System.out.println("current method: " +  new Exception().getStackTrace()[0].getMethodName());
	   Thread.sleep(10000);
	

	//Call launch component 
	Home hm = new Home(); 
	hm.wcg_login(driver);
	
	    synchronized (driver){driver.wait(12000);}		
	  
    driver.findElement(By.xpath(home_dropdown)).click();
    driver.findElement(By.xpath(srd_li + "//a")).click();

    synchronized (driver){driver.wait(6000);}		
    WebElement element1 = driver.findElement(By.xpath(srd_page_header));
    String strng1 = element1.getText();

    String expected = "Student Resources";
	TestAssertion.assertionEquals(driver, expected, strng1);
    
    System.out.println("Launched 'Student Resources' from home dropdown");
    
    synchronized (driver){driver.wait(8000);}
    driver.findElement(By.xpath(srd_unit1)).click();
    
    
    driver.findElement(By.xpath(srd_chapter1)).click();
    
    driver.findElement(By.xpath(srd_ch1_guided_writing)).click();
    String oldTab = driver.getWindowHandle();
    // capturing screenshot
    
//    StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
//    StackTraceElement e = stacktrace[1];//coz 0th will be getStackTrace so 1st
//    String methodName = e.getMethodName();
//    String filename = folder + "/" + methodName + "/" + SetupDriver.resolutionCategory + "/" + SetupDriver.browserName  + "_" + SetupDriver.host + "_-SampleTest" ;
//    System.out.println("Capturing screenshot...");
//    synchronized (driver){driver.wait(12000);}
//    Screenshot.takeScreenshot(driver,filename  + actual);  
    
//============================================= PDF Resource Viewer check
    
if ((SetupDriver.resolutionCategory.equalsIgnoreCase("Large")) == true){
    	  
    	  // step -1 on launch open in resource viewer
	  driver.findElement(By.id(resourceId)).click(); // Launching the resource
	  synchronized (driver)	{driver.wait(12000);}
    //================Resource Viewer
	
    //asserting presence of resource viewer
    System.out.println("Resource is launched in resource viewer");
	WebElement resViewer1 = driver.findElement(By.xpath(srd_resource_viewer)); 
	Boolean b1= resViewer1.isDisplayed();
	System.out.println("resViewer1 : " + b1.toString());
    TestAssertion.assertionEquals(driver, "true", b1.toString());
    System.out.println("Resource viewer launch asserted");
    
//    // step -2 on download click launch in new tab
//  	driver.findElement(By.cssSelector("button.btn.btn-download")).click(); // clicking download in resource viewer
//    synchronized (driver){driver.wait(12000);} 
//    
//    //===============New Tab
//    
//    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//  	driver.switchTo().window(newTab.get(1));
//  	Thread.sleep(5000);
//  	String title= driver.getTitle();
//  	Boolean b3 = title.contains("resourceContent.spr");
//  	System.out.println("check new tab" + b3.toString());
//  	TestAssertion.assertionEquals(driver,"true",b3.toString());
//  	Thread.sleep(5000);
//  	driver.switchTo().window(oldTab);
	
      }
      
if ((SetupDriver.resolutionCategory.equalsIgnoreCase("Large")) == false){
    	  
				if ((platform.equalsIgnoreCase("android")) == false){
	
	
					// step -1 on launch open in new tab
					
					  driver.findElement(By.id(resourceId)).click(); // Launching the resource
					  synchronized (driver)	{driver.wait(12000);} 
				    
				    //===============New Tab
				    
				    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
				  	driver.switchTo().window(newTab.get(1));
				  	Thread.sleep(5000);
				  	String title= driver.getTitle();
				  	System.out.println(title);
				  	Boolean b3 = title.contains("resourceContent.spr");
				  	System.out.println("check new tab" + b3.toString());
				  	TestAssertion.assertionEquals(driver,"true",b3.toString());
				  	Thread.sleep(5000);
				  	driver.switchTo().window(oldTab);
					
				}
				
				
				else if ((platform.equalsIgnoreCase("android")) == true){
					
					  driver.findElement(By.id(resourceId)).click(); // Launching the resource
					  synchronized (driver)	{driver.wait(12000);}
					  
					// step -1 resource get downloaded in downloads folder
					// apply check with absolute download path & resource clicked
					
				}
      }

      
  //===============================================    


  }
  
  
  //Click on a resource and then click on browser back button 

  
//@Ignore
  @Test
  public void TC_SRD_US4_2_1() throws Exception {
 
	  
	if(category.equalsIgnoreCase("Large") == true)
	{
		// For each test case
	   System.out.println("Simple Class name1: " + this.getClass().getSimpleName());
	   String tcname = new Exception().getStackTrace()[0].getMethodName();
	   System.out.println("current method: " +  new Exception().getStackTrace()[0].getMethodName());
	   Thread.sleep(10000);

	//Call launch component 
	Home hm = new Home(); 
	hm.wcg_login(driver);
	
	    synchronized (driver){driver.wait(12000);}		
	  
    driver.findElement(By.xpath(home_dropdown)).click();
    driver.findElement(By.xpath(srd_li + "//a")).click();

    synchronized (driver){driver.wait(6000);}
    WebElement element1 = driver.findElement(By.xpath(srd_page_header));
    String strng1 = element1.getText();
    
   
    String expected = "Student Resources";
	TestAssertion.assertionEquals(driver, expected, strng1);
    

    
    System.out.println("Launched 'Student Resources' from home dropdown");
    synchronized (driver){driver.wait(8000);}
    
    driver.findElement(By.xpath(srd_unit1)).click();
    
    
    driver.findElement(By.xpath(srd_chapter1)).click();
    
    driver.findElement(By.xpath(srd_ch1_guided_writing)).click();
    
   
  //============================================= PDF Resource Viewer check
        	  
        	  // step -1 on launch open in resource viewer
    	  driver.findElement(By.id(resourceId)).click(); // Launching the resource
    	  synchronized (driver)	{driver.wait(12000);}
        //================Resource Viewer
    	
        //asserting presence of resource viewer
        System.out.println("Resource is launched in resource viewer");
    	WebElement resViewer1 = driver.findElement(By.xpath(srd_resource_viewer)); 
    	Boolean b1= resViewer1.isDisplayed();
    	System.out.println("resViewer1 : " + b1.toString());
        TestAssertion.assertionEquals(driver, "true", b1.toString());
        System.out.println("Resource viewer launch asserted");
        

          
        synchronized (driver) 
  	{
  		driver.wait(6000);
  		
  	}
	  Thread.sleep(5000);
	  //  driver.navigate().back();	// browser back
	    
	    driver.executeScript("history.go(-1)");
		  Thread.sleep(5000);
		  
		//asserting absence of resource viewer
		  System.out.println("Checklist - Resource viewer should be closed");
		    synchronized (driver){driver.wait(8000);}
		 Boolean b9= isElementPresent(By.xpath(srd_resource_viewer));
		 System.out.println("isElementPresent 9 " + b9.toString());
		 TestAssertion.assertionEquals(driver, "false", b9.toString());
		 System.out.println("Resource viewer close asserted");
	}
}

}