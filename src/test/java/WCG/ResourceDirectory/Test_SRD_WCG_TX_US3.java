package WCG.ResourceDirectory;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


import com.compro.automation.core.SetupDriver;
import com.compro.automation.core.TestAssertion;
import com.compro.automation.core.TestEnvironement;
import com.compro.automation.core.TestRun;
import com.compro.automation.utils.CSVHandler;
import com.compro.automation.utils.Screenshot;
//import com.saucelabs.saucerest.SauceREST;


@RunWith(Parameterized.class)
public class Test_SRD_WCG_TX_US3 {
	
	private String testEnv;
	private RemoteWebDriver driver = null;
	String category ;
 	String classname =this.getClass().getSimpleName().toString();
 	Package pack = this.getClass().getPackage();
 	String component = pack.getName();
 	
   	String folder ;
   	String screen_resolution;
   	String actual = "";
	
	public Test_SRD_WCG_TX_US3(String testEnv){
		this.testEnv = testEnv;
	  }
	
//static int csvRow = 4;
static int csvCol = 10;
CSVHandler2 CSVnew = new CSVHandler2("src/test/resources/test_data_srd.csv");
String myData[][] = CSVnew.CsvToArray(csvCol);
	
// static String myData[][] = {
//	 						 {"2","Unit 2","2","Chapter 4","1","Charts and Infographics","","","",""},
//	 						 {"4","Unit 4","2","Chapter 8","1","Charts and Infographics","","","",""},
//	 						 {"6","Unit 5","1","Chapter 9","2","Guided Writing","","","",""},
//	 						 {"7","GeoJournal","","","","","","","",""},
//	 						 {"9","Graph Paper","","","","","","","",""}
//	 						};


String baseScreenshotFolder;
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
String srd_list_view;
String srd_grid_view;
String srd_list_enabled;	
String srd_root;
String brcm_size;
String srd_breadcrum;
String srd_resource_container;
String resource_tree_container;
String srd_back_btn;



  int rowCount = myData.length;
  int colCount = myData[0].length;


 	//-----------------------------------------

 	 String testNodeslevel1[][] = new String[rowCount-1][colCount];
	 String testNodeslevel2[][] = new String[rowCount-1][colCount];
	 String testNodeslevel3[][] = new String[rowCount-1][colCount];
	 String testNodeslevel4[][] = new String[rowCount-1][colCount];
	 String testNodeslevel5[][] = new String[rowCount-1][colCount];
	
	
	 String level1[][] = new String[rowCount-1][colCount];
	 String level2[][] = new String[rowCount-1][colCount];
	 String level3[][] = new String[rowCount-1][colCount];
	 String level4[][] = new String[rowCount-1][colCount];
	 String level5[][] = new String[rowCount-1][colCount];
	 
	 private boolean isElementPresent(By by) {
		    try {
		        driver.findElement(by);
		        return true;
		    } catch (NoSuchElementException e) {
		        return false;
		    }
		}
	
public void initializeArray(){
	int j1=0;
	for(int i=1; i<rowCount; i++){	

		while(j1<i){
		testNodeslevel1[j1][0] = myData[i][0];		// start mydata from [1][] & start testNodeslevel1 from [0][]
		// System.out.println("testNodeslevel1 " +j1+ " "+testNodeslevel1[j1][0]);
		j1++;
		}
	}

	int j2=0;
	for(int i=1; i<rowCount; i++){
		while(j2<i){
		
		testNodeslevel2[j2][0] = myData[i][2];  
		j2++;
		}
	}
	
	int j3=0;
	for(int i=1; i<rowCount; i++){	
		while(j3<i){
		
		testNodeslevel3[j3][0] = myData[i][4];
		j3++;
		}
	}
	
	int j4=0;
	for(int i=1; i<rowCount; i++){	
		while(j4<i){

		testNodeslevel4[j4][0] = myData[i][6];
		j4++;
		}
	}
	
	int j5=0;
	for(int i=1; i<rowCount; i++){	
		while(j5<i){

		testNodeslevel5[j5][0] = myData[i][8];
		j5++;
		}
	}
	

//--------------------------------------------------	
	int j11=0;
	for(int i=1; i<rowCount; i++){
		
		while(j11<i){
		level1[j11][0] = myData[i][1];
		j11++;
		}
	}
	
	int j22=0;
	for(int i=0; i<rowCount; i++){	
		
		while(j22<i){
		level2[j22][0] = myData[i][3];
		j22++;
		}
	}
	
	int j33=0;
	for(int i=0; i<rowCount; i++){	

		while(j33<i){
		level3[j33][0] = myData[i][5];
		j33++;
		}
	}
	
	int j44=0;
	for(int i=0; i<rowCount; i++){	
		
		while(j44<i){
		level4[j44][0] = myData[i][7];
		j44++;
		}
	}
	
	int j55=0;
	for(int i=0; i<rowCount; i++){	
		
		while(j55<i){
		level5[j55][0] = myData[i][9];
		j55++;
		}
	}

	
}

   	private String browserchoice;
	   

		 	
	 
@Parameters
	   public static Collection<Object[]> data() throws Exception{

		   return (new TestEnvironement()).getEnvironment();
   }

	   CSVHandler ele_path=null;
	   CSVHandler screenshot_folder=null;

	private String path;
	Process process=null;
	
@Before
	public void setUp() throws Exception 
	{	driver = TestRun.init(testEnv);		
	
		
		  this.initializeArray();

		  category = SetupDriver.resolutionCategory;
		
		if(category.equalsIgnoreCase("Large")) {driver.manage().window().maximize();}
		if(category.equalsIgnoreCase("Medium_landscape")){driver.manage().window().setSize(new Dimension(1050, 1280 ));}
		if(category.equalsIgnoreCase("Medium_portrait")){driver.manage().window().setSize(new Dimension(800, 1000 ));}
		if(category.equalsIgnoreCase("Small")){driver.manage().window().setSize(new Dimension(380, 700 ));}

String screen_resolution = SetupDriver.resolutionCategory;
String browserchoice = SetupDriver.browserName;
ele_path = new CSVHandler("src/test/resources/element_path.csv");
screenshot_folder = new CSVHandler("src/test/resources/screenshot_folder.csv");
baseScreenshotFolder = screenshot_folder.getElementXpath("baseScreenshotFolder");


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
srd_list_view = ele_path.getElementXpath("srd_list_view");
srd_grid_view = ele_path.getElementXpath("srd_grid_view");
srd_list_enabled = ele_path.getElementXpath("srd_list_enabled");
srd_root = ele_path.getElementXpath("srd_root");
brcm_size = ele_path.getElementXpath("brcm_size");
srd_breadcrum = ele_path.getElementXpath("srd_breadcrum");
srd_resource_container = ele_path.getElementXpath("srd_resource_container");
resource_tree_container = ele_path.getElementXpath("resource_tree_container");
srd_back_btn = ele_path.getElementXpath("srd_back_btn");


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
  
  
  // Child nodes should be displayed, breadcrumb should display the unit,unit should be highlighted


//@Ignore
@Test
public void TC_SRD_US3_1_1() throws Exception {			// TC_SRD_US3_2_1 is also covered

	if(category.equalsIgnoreCase("Small") == false)
	{
	System.out.println("Simple Class name1: " + this.getClass().getSimpleName());
	String tcname = new Exception().getStackTrace()[0].getMethodName();
	System.out.println("current method: " +  new Exception().getStackTrace()[0].getMethodName());
	Thread.sleep(10000);
 
	 
// ------------------------------------------------------Desktop---------------------------------------------------------------
		 
	//Call launch component 
	Home hm = new Home(); 
	hm.wcg_login(driver);
//	driver.switchTo().alert().dismiss();
//	driver.switchTo().alert().dismiss();


			    synchronized (driver){driver.wait(20000);}	
			    
   
//------------------------------------------------------------------------------------------------------
			// Launching SRD from Home Drop-down   
			driver.findElement(By.xpath(home_dropdown)).click();
		    driver.findElement(By.xpath(srd_li + "//a")).click();
		      
		    System.out.println("Launched 'Student Resources' from home dropdown");
		    synchronized (driver){driver.wait(20000);}
		     
		    // Counting nodes with children
		    
//------------------------------------------------------------------- for hierarchy Level 1		   
String rootXpath = srd_root;  // level 1 xpath

int testLength1 = testNodeslevel1.length;	// for level 1;
System.out.println("testNodeslevel1 length : " +testLength1);	

for (int inputNodes1=1; inputNodes1 <= testLength1; inputNodes1++)
{String level1Click = testNodeslevel1[inputNodes1-1][0];
System.out.println("level1Click : " +level1Click);


// assert level 1
	WebElement level1Text = driver.findElement(By.xpath(rootXpath+"["+ level1Click +"]/div"));
	String strngLevel1 = level1Text.getText();
	String expectedLevel1 = level1[inputNodes1-1][0];
	System.out.println("Level 1 Text: "+strngLevel1);
	TestAssertion.assertionEquals(driver, expectedLevel1, strngLevel1);
//----------

	
driver.findElement(By.xpath(rootXpath+"["+ level1Click +"]/div")).click();
synchronized (driver){driver.wait(20000);}
//-- checking font - clicked node is bold face
System.out.println("Getting font l1");
WebElement fontChk = driver.findElement(By.xpath(rootXpath+"["+ level1Click +"]/div"));
String fontWeight = fontChk.getCssValue("font-weight");
System.out.println("Font : " + fontWeight);
if (fontWeight.equalsIgnoreCase("bold")){fontWeight = "700";}
TestAssertion.assertionEquals(driver, "700", fontWeight);

// assert breadcrum
	WebElement level1bText = driver.findElement(By.xpath(srd_breadcrum));
	String strngLevel1b = level1bText.getText();
	System.out.println("l1 brcm : "+ strngLevel1b);
	TestAssertion.assertionEquals(driver, expectedLevel1, strngLevel1b);
	//----------

	 
synchronized (driver){driver.wait(2000);}		

// int level1haveChild = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"][@data-haschildren='true']")).size();

																				
		
		//for level 2
																															
			if (testNodeslevel2[inputNodes1-1][0]!= null && testNodeslevel2[inputNodes1-1][0]!=""){

				int	level2Size = driver.findElements(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li")).size();
    			System.out.println("level2Size: "+level2Size);
    			
    			
    			 if (level2Size !=0){

    				 {String level2Click =testNodeslevel2[inputNodes1-1][0];
    				
    			
    					// assert level 2
    						WebElement level2Text = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/div"));
    						String strngLevel2 = level2Text.getText();
    						String expectedLevel2 = level2[inputNodes1-1][0];
    						System.out.println("Level 2 Text: "+strngLevel2);
    						TestAssertion.assertionEquals(driver, expectedLevel2, strngLevel2);
    					//----------

	 	
    				  driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/div")).click();
    				//-- checking font 
    				  System.out.println("Getting font l2");
    				  WebElement fontChk2 = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/div"));
    				  String fontWeight2 = fontChk2.getCssValue("font-weight");
    				  System.out.println("Font : " + fontWeight2);
    				  if (fontWeight2.equalsIgnoreCase("bold")){fontWeight2 = "700";}
    				 TestAssertion.assertionEquals(driver, "700", fontWeight2);
    				  
						 // assert breadcrum
						WebElement level2bText = driver.findElement(By.xpath(srd_breadcrum));
						String strngLevel2b = level2bText.getText();
						System.out.println("l2 brcm : "+ strngLevel2b);
						TestAssertion.assertionEquals(driver, expectedLevel1+" > "+expectedLevel2, strngLevel2b);
						//----------

						 
    				  synchronized (driver){driver.wait(2000);}		
    				  
    				 // int level2haveChild = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"]/ol/li["+ level2Click +"][@data-haschildren='true']")).size(); 
    				
	
																													
    				// for level 3
    					 	if (testNodeslevel3[inputNodes1-1][0]!= null && testNodeslevel3[inputNodes1-1][0]!=""){
    				
    					 	int	level3Size = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li")).size();
			    			System.out.println("level3Size: "+level3Size);
			    			
			    			
			    			 if (level3Size !=0){

			    				 String level3Click =testNodeslevel3[inputNodes1-1][0];
			    					 
			    			 
			    					// assert level 3
			    						WebElement level3Text = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/div"));
			    						String strngLevel3 = level3Text.getText();
			    						String expectedLevel3 = level3[inputNodes1-1][0];
			    						System.out.println("Level 3 Text: "+strngLevel3);
			    						TestAssertion.assertionEquals(driver, expectedLevel3, strngLevel3);
			    					//----------
			   						
							driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/div")).click();
							synchronized (driver){driver.wait(20000);}
		    				//-- checking font 
		    				  System.out.println("Getting font l3");
		    				  WebElement fontChk3 = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/div"));
		    				  String fontWeight3 = fontChk3.getCssValue("font-weight");
		    				  System.out.println("Font : " + fontWeight3);
		    				  if (fontWeight3.equalsIgnoreCase("bold")){fontWeight3 = "700";}
		    				 TestAssertion.assertionEquals(driver, "700", fontWeight3);
							
							 // assert breadcrum
    						WebElement level3bText = driver.findElement(By.xpath(srd_breadcrum));
    						String strngLevel3b = level3bText.getText();
    						System.out.println("l3 brcm : "+ strngLevel3b);
    						TestAssertion.assertionEquals(driver,expectedLevel1+" > "+expectedLevel2+" > "+ expectedLevel3, strngLevel3b);
    						//----------

    		
							 synchronized (driver){driver.wait(2000);}		
							
 
			    			 //int level3haveChild = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"][@data-haschildren='true']")).size(); 
			    				
			    			  	// for level 4	  
	    					 	if (testNodeslevel4[inputNodes1-1][0]!= null && testNodeslevel4[inputNodes1-1][0]!=""){

	    					 		int	level4Size = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level2Click +"]/ol/li")).size();
	    			    			System.out.println("level4Size: "+level4Size);
	    			    			
	    			    			
	    			    			 if (level4Size !=0){

	    			    				 String level4Click =testNodeslevel4[inputNodes1-1][0];
	    			    					 
	    			    			 
	    			    					// assert level 4
	    			    						WebElement level4Text = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/div"));
	    			    						String strngLevel4 = level4Text.getText();
	    			    						String expectedLevel4 = level4[inputNodes1-1][0];
	    			    						System.out.println("Level 4 Text: "+strngLevel4);
	    			    						TestAssertion.assertionEquals(driver, expectedLevel4, strngLevel4);
	    			    					//----------
	    										
	    			    		
	    							driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/div")).click();
	    							synchronized (driver){driver.wait(20000);}
	    							
	    		    				//-- checking font 
	  		    				  System.out.println("Getting font l4");
	  		    				  WebElement fontChk4 = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/div"));
	  		    				  String fontWeight4 = fontChk3.getCssValue("font-weight");
	  		    				  System.out.println("Font : " + fontWeight4);
	  		    				if (fontWeight4.equalsIgnoreCase("bold")){fontWeight4 = "700";}
	  		    				 TestAssertion.assertionEquals(driver, "700", fontWeight4);
	    							
	    							 // assert breadcrum
		    						WebElement level4bText = driver.findElement(By.xpath(srd_breadcrum));
		    						String strngLevel4b = level4bText.getText();
		    						System.out.println("l4 brcm : "+ strngLevel4b);
		    						TestAssertion.assertionEquals(driver,expectedLevel1+" > "+expectedLevel2+" > "+ expectedLevel3+" > "+ expectedLevel4, strngLevel4b);
		    						//----------

	    							 synchronized (driver){driver.wait(2000);}		
	    							

	    							// int level4haveChild = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"][@data-haschildren='true']")).size();		
	    							
	    							 //for level 5			 	
	    							 if (testNodeslevel5[inputNodes1-1][0]!= null && testNodeslevel5[inputNodes1-1][0]!=""){
	
	    								 int	level5Size = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/ol/li")).size();
	    	    			    			System.out.println("level3Size: "+level3Size);
	    	    			    			
	    	    			    			
	    	    			    			 if (level5Size !=0){
	 
	    	    			    				 {String level5Click =testNodeslevel5[inputNodes1-1][0];
	    	    			    					 
	    	    			    			 
	    	    			    					// assert level 5
	    	    			    						WebElement level5Text = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/ol/li["+ level5Click +"]/div"));
	    	    			    						String strngLevel5 = level5Text.getText();
	    	    			    						String expectedLevel5 = level5[inputNodes1-1][0];
	    	    			    						System.out.println("Level 5 Text: "+strngLevel5);
	    	    			    						TestAssertion.assertionEquals(driver, expectedLevel5, strngLevel5);
	    	    			    					//----------
	    	    		    							
	    	    							driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/ol/li["+ level5Click +"]/div")).click();
	    	    							synchronized (driver){driver.wait(20000);}
	    	    		    				//-- checking font 
	    	  		    				  System.out.println("Getting font l5");
	    	  		    				  WebElement fontChk5 = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/ol/li["+ level5Click +"]/div"));
	    	  		    				  String fontWeight5 = fontChk5.getCssValue("font-weight");
	    	  		    				  System.out.println("Font : " + fontWeight5);
	    	  		    				if (fontWeight5.equalsIgnoreCase("bold")){fontWeight5 = "700";}
	    	  		    				 TestAssertion.assertionEquals(driver, "700", fontWeight5);
	    	    							
	    	    							 // assert breadcrum
    			    						WebElement level5bText = driver.findElement(By.xpath(srd_breadcrum));
    			    						String strngLevel5b = level5bText.getText();
    			    						System.out.println("l5 brcm : "+ strngLevel5b);
    			    						TestAssertion.assertionEquals(driver, expectedLevel1+" > "+expectedLevel2+" > "+ expectedLevel3+" > "+ expectedLevel4 +" > "+expectedLevel5, strngLevel5b);

    			    		
	    	    							
	    	    							 synchronized (driver){driver.wait(2000);}		
	    	    			    					}
	    	 			    			 	
	    	    			    			 }
	    	    						}// closing level 5
		    			    			 	
	    	    									}
	    	    			    			 	}// closing level 4
	    	    			    			 
	    	        					 
	    			    			 
	        					 }
			    			 
    					 }//closing level 3
    				}
    			 }
    			 
			 }//closing level 2

		}// closing level 1


	}
}



//Mobile -- Child nodes should be displayed, breadcrumb should display the unit,unit should be highlighted

//@Ignore
@Test
public void TC_SRD_US3_1_2() throws Exception {			// TC_SRD_US3_2_1 is also covered

	if(category.equalsIgnoreCase("Small") == true)
	{
	
	System.out.println("Simple Class name1: " + this.getClass().getSimpleName());
	String tcname = new Exception().getStackTrace()[0].getMethodName();
	System.out.println("current method: " +  new Exception().getStackTrace()[0].getMethodName());
	Thread.sleep(10000);

	//Call launch component 
	Home hm = new Home(); 
	hm.wcg_login(driver);
//	driver.switchTo().alert().dismiss();
//	driver.switchTo().alert().dismiss();


			    synchronized (driver){driver.wait(20000);}	
			    

//------------------------------------------------------------------------------------------------------
			// Launching SRD from Home Drop-down   
			driver.findElement(By.xpath(home_dropdown)).click();
		    driver.findElement(By.xpath(srd_li + "//a")).click();
		      
		    System.out.println("Launched 'Student Resources' from home dropdown");
		    synchronized (driver){driver.wait(20000);}
		     
		    // Counting nodes with children
		    
//------------------------------------------------------------------- for hierarchy Level 1		   
String rootXpath = srd_root;  // level 1 xpath

int testLength1 = testNodeslevel1.length;	// for level 1;
System.out.println("testNodeslevel1 length : " +testLength1);	

//------------------------------------------------------Mobile---------------------------------------------------------------

for (int inputNodes1=1; inputNodes1 <= testLength1; inputNodes1++)
{{String level1Click = testNodeslevel1[inputNodes1-1][0];
System.out.println("level1Click : " +level1Click);	

//assert level 1
	WebElement level1Text = driver.findElement(By.xpath(rootXpath+"["+ level1Click +"]/div"));
	String strngLevel1 = level1Text.getText();
	String expectedLevel1 = level1[inputNodes1-1][0];
	System.out.println("Level 1 Text: "+strngLevel1);
	TestAssertion.assertionEquals(driver, expectedLevel1, strngLevel1);
//----------

	
driver.findElement(By.xpath(rootXpath+"["+ level1Click +"]/div")).click();
synchronized (driver){driver.wait(20000);}

//assert breadcrum
	WebElement level1bText = driver.findElement(By.xpath(srd_breadcrum));
	String strngLevel1b = level1bText.getText();
	System.out.println("l1 brcm : "+ strngLevel1b);
	TestAssertion.assertionEquals(driver, expectedLevel1, strngLevel1b);
	//----------
		

//int level1haveChild = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"][@data-haschildren='true']")).size();

																										
		
		//for level 2
																															
			if (testNodeslevel2[inputNodes1-1][0]!= null && testNodeslevel2[inputNodes1-1][0]!=""){{
				
				int level2Size = driver.findElements(By.xpath(rootXpath)).size();	// size of level 2
			System.out.println("level2Size: "+level2Size);
			
			
			 if (level2Size !=0){

				 {String level2Click =testNodeslevel2[inputNodes1-1][0];
				
			
					// assert level 2
						WebElement level2Text = driver.findElement(By.xpath(rootXpath+"["+ level2Click +"]/div"));
						String strngLevel2 = level2Text.getText();
						String expectedLevel2 = level2[inputNodes1-1][0];
						System.out.println("Level 2 Text: "+strngLevel2);
						TestAssertion.assertionEquals(driver, expectedLevel2, strngLevel2);
					//----------
	 	
				  driver.findElement(By.xpath(rootXpath+"["+ level2Click +"]/div")).click();
				  synchronized (driver){driver.wait(20000);}		
				  
					 // assert breadcrum
					WebElement level2bText = driver.findElement(By.xpath(srd_breadcrum));
					String strngLevel2b = level2bText.getText();
					System.out.println("l2 brcm : "+ strngLevel2b);
					TestAssertion.assertionEquals(driver, expectedLevel1+" > "+expectedLevel2, strngLevel2b);
					//----------
				  
				  
				  //int level2haveChild = driver.findElements(By.xpath(rootXpath+"["+ level2Click +"][@data-haschildren='true']")).size(); 
				
	
																													
				// for level 3
					 	if (testNodeslevel3[inputNodes1-1][0]!= null && testNodeslevel3[inputNodes1-1][0]!=""){{
					 		int level3Size = driver.findElements(By.xpath(rootXpath)).size();	// size of level 3
			    			System.out.println("level3Size: "+level3Size);
			    			
			    			
			    			 if (level3Size !=0){

			    				 String level3Click =testNodeslevel3[inputNodes1-1][0];
			    					 
			    			 
			    					// assert level 3
			    					WebElement level3Text = driver.findElement(By.xpath(rootXpath+"["+ level3Click +"]/div"));
			    						String strngLevel3 = level3Text.getText();
			    						String expectedLevel3 = level3[inputNodes1-1][0];
			    						System.out.println("Level 3 Text: "+strngLevel3);
			    						TestAssertion.assertionEquals(driver, expectedLevel3, strngLevel3);
			    					//----------
			    		
			    						driver.findElement(By.xpath(rootXpath+"["+ level3Click +"]/div")).click();
							 synchronized (driver){driver.wait(20000);}		
							 
							 // assert breadcrum
	    						WebElement level3bText = driver.findElement(By.xpath(srd_breadcrum));
	    						String strngLevel3b = level3bText.getText();
	    						System.out.println("l3 brcm : "+ strngLevel3b);
	    						TestAssertion.assertionEquals(driver,expectedLevel1+" > "+expectedLevel2+" > "+ expectedLevel3, strngLevel3b);
	    						//----------
							 
							
			    			  	// for level 4	 
							 //int level3haveChild = driver.findElements(By.xpath(rootXpath+"["+ level3Click +"][@data-haschildren='true']")).size(); 
			    				
			  
	    					 	if (testNodeslevel4[inputNodes1-1][0]!= null && testNodeslevel4[inputNodes1-1][0]!=""){{
	    					 		int level4Size = driver.findElements(By.xpath(rootXpath)).size();	// size of level 4
	    			    			System.out.println("level4Size: "+level4Size);
	    			    			
	    			    			
	    			    			 if (level4Size !=0){

	    			    				 String level4Click =testNodeslevel4[inputNodes1-1][0];
	    			    					 
	    			    			 
	    			    					// assert level 4
	    			    					WebElement level4Text = driver.findElement(By.xpath(rootXpath+"["+ level4Click +"]/div"));
	    			    						String strngLevel4 = level4Text.getText();
	    			    						String expectedLevel4 = level4[inputNodes1-1][0];
	    			    						System.out.println("Level 4 Text: "+strngLevel4);
	    			    						TestAssertion.assertionEquals(driver, expectedLevel4, strngLevel4);
	    			    					//----------
	    		    							 synchronized (driver){driver.wait(20000);}		
	    			    						driver.findElement(By.xpath(rootXpath+"["+ level4Click +"]/div")).click();
	    			    						
	    		    							 // assert breadcrum
	    			    						WebElement level4bText = driver.findElement(By.xpath(srd_breadcrum));
	    			    						String strngLevel4b = level4bText.getText();
	    			    						System.out.println("l4 brcm : "+ strngLevel4b);
	    			    						TestAssertion.assertionEquals(driver,expectedLevel1+" > "+expectedLevel2+" > "+ expectedLevel3+" > "+ expectedLevel4, strngLevel4b);
	    			    						//----------

	    							
	    							 //for level 5
	    							 //int level4haveChild = driver.findElements(By.xpath(rootXpath+"["+ level4Click +"][@data-haschildren='true']")).size();		
	    	    					 	
	    							 if (testNodeslevel5[inputNodes1-1][0]!= null && testNodeslevel5[inputNodes1-1][0]!=""){{
	    								 int level5Size = driver.findElements(By.xpath(rootXpath)).size();	// size of level 5
	    	    			    			System.out.println("level3Size: "+level3Size);
	    	    			    			
	    	    			    			
	    	    			    			 if (level5Size !=0){
	 
	    	    			    				 {String level5Click =testNodeslevel5[inputNodes1-1][0];
	    	    			    					 
	    	    			    			 
	    	    			    					// assert level 5
	    	    			    					WebElement level5Text = driver.findElement(By.xpath(rootXpath+"["+ level5Click +"]/div"));
	    	    			    						String strngLevel5 = level5Text.getText();
	    	    			    						String expectedLevel5 = level5[inputNodes1-1][0];
	    	    			    						System.out.println("Level 5 Text: "+strngLevel5);
	    	    			    						TestAssertion.assertionEquals(driver, expectedLevel5, strngLevel5);
	    	    			    					//----------
	    	    			    		
	    	    			    						driver.findElement(By.xpath(rootXpath+"["+ level5Click +"]/div")).click();
	    		    	    							 // assert breadcrum
	    	    			    						WebElement level5bText = driver.findElement(By.xpath(srd_breadcrum));
	    	    			    						String strngLevel5b = level5bText.getText();
	    	    			    						System.out.println("l5 brcm : "+ strngLevel5b);
	    	    			    						TestAssertion.assertionEquals(driver, expectedLevel1+" > "+expectedLevel2+" > "+ expectedLevel3+" > "+ expectedLevel4 +" > "+expectedLevel5, strngLevel5b);

	    	    							 synchronized (driver){driver.wait(20000);}		
	    	    			    					}
	    	 			    			 	
	    	    			    			 }
	    	    						}		       
	    							 Boolean b8= isElementPresent(By.xpath(srd_back_btn));
				    				 TestAssertion.assertionEquals(driver,"true",b8.toString());
	    							 synchronized (driver){driver.wait(2000);} driver.findElement(By.xpath(srd_back_btn)).click(); }// closing level 5
	    							 
	    							 synchronized (driver){driver.wait(20000);}
	    	    									}
	    	    			    			 	}		     
	    					 	Boolean b8= isElementPresent(By.xpath(srd_back_btn));
			    				 TestAssertion.assertionEquals(driver,"true",b8.toString());
	    					 	synchronized (driver){driver.wait(2000);}   driver.findElement(By.xpath(srd_back_btn)).click();}// closing level 4
	    					 	synchronized (driver){driver.wait(20000);}
	    	    			    			 
	    	        					 
	    			    			 
	        					 }
			    			 
					 }		     synchronized (driver){driver.wait(2000);}   
					 
					 Boolean b8= isElementPresent(By.xpath(srd_back_btn));
    				 TestAssertion.assertionEquals(driver,"true",b8.toString());
					 driver.findElement(By.xpath(srd_back_btn)).click(); } //closing level 3
					 	synchronized (driver){driver.wait(20000);}
				}
			 }
			 
			 }		      synchronized (driver){driver.wait(2000);}  
			 
			 Boolean b8= isElementPresent(By.xpath(srd_back_btn));
			 TestAssertion.assertionEquals(driver,"true",b8.toString());
			 driver.findElement(By.xpath(srd_back_btn)).click();}//closing level 2
			synchronized (driver){driver.wait(20000);}

		} synchronized (driver){driver.wait(2000);}  
		
		Boolean b8= isElementPresent(By.xpath(srd_back_btn));
		 TestAssertion.assertionEquals(driver,"true",b8.toString());
		driver.findElement(By.xpath(srd_back_btn)).click();}// closing level 1
synchronized (driver){driver.wait(20000);}
	  }

	}// closing test



// Click on parent node, click on child node, click on leaf node 

//@Ignore
@Test
public void TC_SRD_US3_3_1() throws Exception {			// Assert the display of resources in the container if leaf node clicked

	if(category.equalsIgnoreCase("Small") == false)
	{
	
	System.out.println("Simple Class name1: " + this.getClass().getSimpleName());
	String tcname = new Exception().getStackTrace()[0].getMethodName();
//	ScreenshotElement cse = new ScreenshotElement();
//	Screenshot c = new Screenshot();
	System.out.println("current method: " +  new Exception().getStackTrace()[0].getMethodName());
	Thread.sleep(10000);

	 
//------------------------------------------------------Desktop---------------------------------------------------------------
		 
	//Call launch component 
	  synchronized (driver){driver.wait(30000);}
	Home hm = new Home(); 
	hm.wcg_login(driver);
//	driver.switchTo().alert().dismiss();
//	driver.switchTo().alert().dismiss();
//	driver.switchTo().alert().dismiss();
//	driver.switchTo().alert().dismiss();

			    synchronized (driver){driver.wait(12000);}	
			    
    
//------------------------------------------------------------------------------------------------------
			// Launching SRD from Home Drop-down   
				driver.findElement(By.xpath(home_dropdown)).click();
				synchronized (driver){driver.wait(12000);}
			    driver.findElement(By.xpath(srd_li + "//a")).click();
		    
		    System.out.println("Launched 'Student Resources' from home dropdown");
		    synchronized (driver){driver.wait(6000);}
		     
		    // Counting nodes with children
		    
//------------------------------------------------------------------- for hierarchy Level 1		   
String rootXpath = srd_root;  // level 1 xpath

int testLength1 = testNodeslevel1.length;	// for level 1;
System.out.println("testNodeslevel1 length : " +testLength1);	

//-----------------------------------------------------------------------Desktop || Tablet-----------------------------------------------------

for (int inputNodes1=1; inputNodes1 <= testLength1; inputNodes1++)
{String level1Click = testNodeslevel1[inputNodes1-1][0];
System.out.println("level1Click : " +level1Click);	


//assert level 1
	WebElement level1Text = driver.findElement(By.xpath(rootXpath+"["+ level1Click +"]/div"));
	String strngLevel1 = level1Text.getText();
	String expectedLevel1 = level1[inputNodes1-1][0];
	System.out.println("Level 1 Text: "+strngLevel1);
	TestAssertion.assertionEquals(driver, expectedLevel1, strngLevel1);
//----------

	
driver.findElement(By.xpath(rootXpath+"["+ level1Click +"]/div")).click();
//-- checking font 
System.out.println("Getting font l1");
WebElement fontChk = driver.findElement(By.xpath(rootXpath+"["+ level1Click +"]/div"));
String fontWeight = fontChk.getCssValue("font-weight");
System.out.println("Font : " + fontWeight);
if (fontWeight.equalsIgnoreCase("bold")){fontWeight = "700";}
TestAssertion.assertionEquals(driver, "700", fontWeight);

//assert breadcrum
	WebElement level1bText = driver.findElement(By.xpath(srd_breadcrum));
	String strngLevel1b = level1bText.getText();
	System.out.println("l1 brcm : "+ strngLevel1b);
	TestAssertion.assertionEquals(driver, expectedLevel1, strngLevel1b);
	//----------

synchronized (driver){driver.wait(2000);}		

// int level1haveChild = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"][@data-haschildren='true']")).size();

// Asserting for resource container displaying resources
if (testNodeslevel2[inputNodes1-1][0]== null || testNodeslevel2[inputNodes1-1][0]==""){
	WebElement resContainer1 = driver.findElement(By.xpath(srd_resource_container));
	Boolean b1= resContainer1.isDisplayed();
System.out.println("resContainer1 : " + b1.toString());
TestAssertion.assertionEquals(driver, "true", b1.toString());
	
}

		
		//for level 2
																															
			if (testNodeslevel2[inputNodes1-1][0]!= null || testNodeslevel2[inputNodes1-1][0]!=""){

				int	level2Size = driver.findElements(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li")).size();
  			System.out.println("level2Size: "+level2Size);
  			
  			
  			 if (level2Size !=0){

  				 {String level2Click =testNodeslevel2[inputNodes1-1][0];
  				
  			
  					// assert level 2
  						WebElement level2Text = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/div"));
  						String strngLevel2 = level2Text.getText();
  						String expectedLevel2 = level2[inputNodes1-1][0];
  						System.out.println("Level 2 Text: "+strngLevel2);
  						TestAssertion.assertionEquals(driver, expectedLevel2, strngLevel2);
  					//----------

	 	
  				  driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/div")).click();
  				//-- checking font 
  				  System.out.println("Getting font l2");
  				  WebElement fontChk2 = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/div"));
  				  String fontWeight2 = fontChk2.getCssValue("font-weight");
  				  System.out.println("Font : " + fontWeight2);
  				if (fontWeight2.equalsIgnoreCase("bold")){fontWeight2 = "700";}
  				 TestAssertion.assertionEquals(driver, "700", fontWeight2);
  				  

				 // assert breadcrum
				WebElement level2bText = driver.findElement(By.xpath(srd_breadcrum));
				String strngLevel2b = level2bText.getText();
				System.out.println("l2 brcm : "+ strngLevel2b);
				TestAssertion.assertionEquals(driver, expectedLevel1+" > "+expectedLevel2, strngLevel2b);
				//----------

						 
  				  synchronized (driver){driver.wait(2000);}		
  				  
  				 // int level2haveChild = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"]/ol/li["+ level2Click +"][@data-haschildren='true']")).size(); 
  				
  				// Asserting for resource container displaying resources
  				if (testNodeslevel3[inputNodes1-1][0]== null || testNodeslevel3[inputNodes1-1][0]==""){
  					WebElement resContainer2 = driver.findElement(By.xpath(srd_resource_container));
  					Boolean b2= resContainer2.isDisplayed();
  				System.out.println("resContainer2 : " + b2.toString());
  				TestAssertion.assertionEquals(driver, "true", b2.toString());
  					
  				}

	
																													
  				// for level 3
  					 	if (testNodeslevel3[inputNodes1-1][0]!= null || testNodeslevel3[inputNodes1-1][0]!=""){

  					 	int	level3Size = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li")).size();
			    			System.out.println("level3Size: "+level3Size);
			    			
			    			
			    			 if (level3Size !=0){

			    				 String level3Click =testNodeslevel3[inputNodes1-1][0];
			    					 
			    			 
			    					// assert level 3
			    						WebElement level3Text = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/div"));
			    						String strngLevel3 = level3Text.getText();
			    						String expectedLevel3 = level3[inputNodes1-1][0];
			    						System.out.println("Level 3 Text: "+strngLevel3);
			    						TestAssertion.assertionEquals(driver, expectedLevel3, strngLevel3);
			    					//----------
			   						
							driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/div")).click();
		    				//-- checking font 
		    				  System.out.println("Getting font l3");
		    				  WebElement fontChk3 = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/div"));
		    				  String fontWeight3 = fontChk3.getCssValue("font-weight");
		    				  System.out.println("Font : " + fontWeight3);
		    				  if (fontWeight3.equalsIgnoreCase("bold")){fontWeight3 = "700";}
		    				 TestAssertion.assertionEquals(driver, "700", fontWeight3);
							
							 // assert breadcrum
	    						WebElement level3bText = driver.findElement(By.xpath(srd_breadcrum));
	    						String strngLevel3b = level3bText.getText();
	    						System.out.println("l3 brcm : "+ strngLevel3b);
	    						TestAssertion.assertionEquals(driver,expectedLevel1+" > "+expectedLevel2+" > "+ expectedLevel3, strngLevel3b);
	    						//----------

  		
							 synchronized (driver){driver.wait(2000);}		
							

			    			// int level3haveChild = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"][@data-haschildren='true']")).size(); 
			    				
			   				// Asserting for resource container displaying resources
							 if (testNodeslevel4[inputNodes1-1][0]== null || testNodeslevel4[inputNodes1-1][0]==""){
			   					WebElement resContainer3 = driver.findElement(By.xpath(srd_resource_container));
			   					Boolean b3= resContainer3.isDisplayed();
			   				System.out.println("resContainer3 : " + b3.toString());
			   				TestAssertion.assertionEquals(driver, "true", b3.toString());
			   					
			   				}
			    			 
			    			  	// for level 4	  
	    					 	if (testNodeslevel4[inputNodes1-1][0]!= null || testNodeslevel4[inputNodes1-1][0]!=""){

	    					 		int	level4Size = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level2Click +"]/ol/li")).size();
	    			    			System.out.println("level4Size: "+level4Size);
	    			    			
	    			    			
	    			    			 if (level4Size !=0){

	    			    				 String level4Click =testNodeslevel4[inputNodes1-1][0];
	    			    					 
	    			    			 
	    			    					// assert level 4
	    			    						WebElement level4Text = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/div"));
	    			    						String strngLevel4 = level4Text.getText();
	    			    						String expectedLevel4 = level4[inputNodes1-1][0];
	    			    						System.out.println("Level 4 Text: "+strngLevel4);
	    			    						TestAssertion.assertionEquals(driver, expectedLevel4, strngLevel4);
	    			    					//----------
	    										
	    			    		
	    							driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/div")).click();
	    							
	    		    				//-- checking font 
	  		    				  System.out.println("Getting font l4");
	  		    				  WebElement fontChk4 = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/div"));
	  		    				  String fontWeight4 = fontChk3.getCssValue("font-weight");
	  		    				  System.out.println("Font : " + fontWeight4);
	  		    				if (fontWeight4.equalsIgnoreCase("bold")){fontWeight4 = "700";}
	  		    				 TestAssertion.assertionEquals(driver, "700", fontWeight4);
	    							
    							 // assert breadcrum
	    						WebElement level4bText = driver.findElement(By.xpath(srd_breadcrum));
	    						String strngLevel4b = level4bText.getText();
	    						System.out.println("l4 brcm : "+ strngLevel4b);
	    						TestAssertion.assertionEquals(driver,expectedLevel1+" > "+expectedLevel2+" > "+ expectedLevel3+" > "+ expectedLevel4, strngLevel4b);
	    						//----------

	    							 synchronized (driver){driver.wait(2000);}		
	    							

	    							// int level4haveChild = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"][@data-haschildren='true']")).size();		
	    							
	    				  				// Asserting for resource container displaying resources
	    							 if (testNodeslevel5[inputNodes1-1][0]== null || testNodeslevel5[inputNodes1-1][0]==""){
	    				  					WebElement resContainer4 = driver.findElement(By.xpath(srd_resource_container));
	    				  					Boolean b4= resContainer4.isDisplayed();
	    				  				System.out.println("resContainer4 : " + b4.toString());
	    				  				TestAssertion.assertionEquals(driver, "true", b4.toString());
	    				  					
	    				  				}
	    							 
	    							 //for level 5			 	
	    							 if (testNodeslevel5[inputNodes1-1][0]!= null || testNodeslevel5[inputNodes1-1][0]!=""){
	 	    					 
	    								 int	level5Size = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/ol/li")).size();
	    	    			    			System.out.println("level3Size: "+level3Size);
	    	    			    			
	    	    			    			
	    	    			    			 if (level5Size !=0){
	 
	    	    			    				 {String level5Click =testNodeslevel5[inputNodes1-1][0];
	    	    			    					 
	    	    			    			 
	    	    			    					// assert level 5
	    	    			    						WebElement level5Text = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/ol/li["+ level5Click +"]/div"));
	    	    			    						String strngLevel5 = level5Text.getText();
	    	    			    						String expectedLevel5 = level5[inputNodes1-1][0];
	    	    			    						System.out.println("Level 5 Text: "+strngLevel5);
	    	    			    						TestAssertion.assertionEquals(driver, expectedLevel5, strngLevel5);
	    	    			    					//----------
	    	    		    							
	    	    							driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/ol/li["+ level5Click +"]/div")).click();
	    	    		    				//-- checking font 
	    	  		    				  System.out.println("Getting font l5");
	    	  		    				  WebElement fontChk5 = driver.findElement(By.xpath(rootXpath+"[@data-haschildren='true']["+ level1Click +"]/ol/li["+ level2Click +"]/ol/li["+ level3Click +"]/ol/li["+ level4Click +"]/ol/li["+ level5Click +"]/div"));
	    	  		    				  String fontWeight5 = fontChk5.getCssValue("font-weight");
	    	  		    				  System.out.println("Font : " + fontWeight5);
	    	  		    				if (fontWeight5.equalsIgnoreCase("bold")){fontWeight5 = "700";}
	    	  		    				 TestAssertion.assertionEquals(driver, "700", fontWeight5);
	    	    							
    	    							 // assert breadcrum
			    						WebElement level5bText = driver.findElement(By.xpath(srd_breadcrum));
			    						String strngLevel5b = level5bText.getText();
			    						System.out.println("l5 brcm : "+ strngLevel5b);
			    						TestAssertion.assertionEquals(driver, expectedLevel1+" > "+expectedLevel2+" > "+ expectedLevel3+" > "+ expectedLevel4 +" > "+expectedLevel5, strngLevel5b);

  			    						//----------
			    						// Asserting for resource container displaying resources
			    						WebElement resContainer5 = driver.findElement(By.xpath(srd_resource_container));
					   					Boolean b5= resContainer5.isDisplayed();
					   				    System.out.println("resContainer5 : " + b5.toString());
					   				    TestAssertion.assertionEquals(driver, "true", b5.toString());
	    	    							
	    	    							 synchronized (driver){driver.wait(2000);}		
	    	    			    					}
	    	 			    			 	
	    	    			    			 }
	    	    						}// closing level 5
		    			    			 	
	    	    									}
	    	    			    			 	}// closing level 4

	        					 }
			    			 
  					 }//closing level 3
  				}
  			 }
  			 
			 }//closing level 2

		}// closing level 1


	}
	}// closing test


// -- Mobile
//@Ignore
@Test
public void TC_SRD_US3_3_2() throws Exception {			// Assert the display of resources in the container if leaf node clicked

	if(category.equalsIgnoreCase("Small") == true)
	{
	
	System.out.println("Simple Class name1: " + this.getClass().getSimpleName());
	String tcname = new Exception().getStackTrace()[0].getMethodName();
//	ScreenshotElement cse = new ScreenshotElement();
//	Screenshot c = new Screenshot();
	System.out.println("current method: " +  new Exception().getStackTrace()[0].getMethodName());
	Thread.sleep(10000);

	 
//---------------------------------------------------------------------------------------------------------------------
		 
	//Call launch component 
	  synchronized (driver){driver.wait(30000);}
	Home hm = new Home(); 
	hm.wcg_login(driver);
//	driver.switchTo().alert().dismiss();
//	driver.switchTo().alert().dismiss();
//	driver.switchTo().alert().dismiss();
//	driver.switchTo().alert().dismiss();

			    synchronized (driver){driver.wait(12000);}	
			    
 
//------------------------------------------------------------------------------------------------------
			// Launching SRD from Home Drop-down   
				driver.findElement(By.xpath(home_dropdown)).click();
				synchronized (driver){driver.wait(12000);}
			    driver.findElement(By.xpath(srd_li + "//a")).click();
		    
		    System.out.println("Launched 'Student Resources' from home dropdown");
		    synchronized (driver){driver.wait(6000);}
		     
		    // Counting nodes with children
		    
//------------------------------------------------------------------- for hierarchy Level 1		   
String rootXpath = srd_root;  // level 1 xpath

int testLength1 = testNodeslevel1.length;	// for level 1;
System.out.println("testNodeslevel1 length : " +testLength1);	

//--------------------------------------------------------------------------Mobile-------------------------------------------------------------------

for (int inputNodes1=1; inputNodes1 <= testLength1; inputNodes1++)
{
	{String level1Click = testNodeslevel1[inputNodes1-1][0];
System.out.println("level1Click : " +level1Click);	

//assert level 1
	WebElement level1Text = driver.findElement(By.xpath(rootXpath+"["+ level1Click +"]/div"));
	String strngLevel1 = level1Text.getText();
	String expectedLevel1 = level1[inputNodes1-1][0];
	System.out.println("Level 1 Text: "+strngLevel1);
	TestAssertion.assertionEquals(driver, expectedLevel1, strngLevel1);
//----------

	
driver.findElement(By.xpath(rootXpath+"["+ level1Click +"]/div")).click();
synchronized (driver){driver.wait(2000);}	
//assert breadcrum
WebElement level1bText2 = driver.findElement(By.xpath(srd_breadcrum));
String strngLevel1b2 = level1bText2.getText();
System.out.println("l1 brcm : "+ strngLevel1b2);
TestAssertion.assertionEquals(driver, (expectedLevel1), strngLevel1b2.replace("\n", " "));
//----------

// int level1haveChild = driver.findElements(By.xpath(rootXpath+"["+ level1Click +"][@data-haschildren='true']")).size();

//Asserting for resource container displaying resources
if (testNodeslevel2[inputNodes1-1][0]== null && testNodeslevel2[inputNodes1-1][0]==""){
	WebElement resContainer1 = driver.findElement(By.xpath(srd_resource_container));
	Boolean b1= resContainer1.isDisplayed();
System.out.println("resContainer1 : " + b1.toString());
TestAssertion.assertionEquals(driver, "true", b1.toString());
	
}																										
		
		//for level 2
																															
			if (testNodeslevel2[inputNodes1-1][0]!= null && testNodeslevel2[inputNodes1-1][0]!=""){{
				
				int level2Size = driver.findElements(By.xpath(rootXpath)).size();	// size of level 2
			System.out.println("level2Size: "+level2Size);
			
			
			 if (level2Size !=0){

				 {String level2Click =testNodeslevel2[inputNodes1-1][0];
				
			
					// assert level 2
						WebElement level2Text = driver.findElement(By.xpath(rootXpath+"["+ level2Click +"]/div"));
						String strngLevel2 = level2Text.getText();
						String expectedLevel2 = level2[inputNodes1-1][0];
						System.out.println("Level 2 Text: "+strngLevel2);
						TestAssertion.assertionEquals(driver, expectedLevel2, strngLevel2);
					//----------
	 	
				  driver.findElement(By.xpath(rootXpath+"["+ level2Click +"]/div")).click();
				  synchronized (driver){driver.wait(2000);}		
				// assert breadcrum
					WebElement level2bText2 = driver.findElement(By.xpath(srd_breadcrum));
					String strngLevel2b2 = level2bText2.getText();
					System.out.println("l2 brcm : "+ strngLevel2b2);
					TestAssertion.assertionEquals(driver,(expectedLevel1+" > "+expectedLevel2), strngLevel2b2.replace("\n", " "));
					//----------
				  
				  
				//  int level2haveChild = driver.findElements(By.xpath(rootXpath+"["+ level2Click +"][@data-haschildren='true']")).size(); 
				
				// Asserting for resource container displaying resources
					if (testNodeslevel3[inputNodes1-1][0]== null && testNodeslevel3[inputNodes1-1][0]==""){
	  					WebElement resContainer2 = driver.findElement(By.xpath(srd_resource_container));
	  					Boolean b2= resContainer2.isDisplayed();
	  				System.out.println("resContainer2 : " + b2.toString());
	  				TestAssertion.assertionEquals(driver, "true", b2.toString());
	  					
	  				}
																													
				// for level 3
					 	if (testNodeslevel3[inputNodes1-1][0]!= null && testNodeslevel3[inputNodes1-1][0]!=""){{
					 		int level3Size = driver.findElements(By.xpath(rootXpath)).size();	// size of level 3
			    			System.out.println("level3Size: "+level3Size);
			    			
			    			
			    			 if (level3Size !=0){

			    				 String level3Click =testNodeslevel3[inputNodes1-1][0];
			    					 
			    			 
			    					// assert level 3
			    					WebElement level3Text = driver.findElement(By.xpath(rootXpath+"["+ level3Click +"]/div"));
			    						String strngLevel3 = level3Text.getText();
			    						String expectedLevel3 = level3[inputNodes1-1][0];
			    						System.out.println("Level 3 Text: "+strngLevel3);
			    						TestAssertion.assertionEquals(driver, expectedLevel3, strngLevel3);
			    					//----------
			    		
			    						driver.findElement(By.xpath(rootXpath+"["+ level3Click +"]/div")).click();
							 synchronized (driver){driver.wait(2000);}		
							 // assert breadcrum
	    						WebElement level3bText2 = driver.findElement(By.xpath(srd_breadcrum));
	    						String strngLevel3b2 = level3bText2.getText();
	    						System.out.println("l3 brcm : "+ strngLevel3b2);
	    						TestAssertion.assertionEquals(driver,(expectedLevel1+" > "+expectedLevel2+" > "+ expectedLevel3), strngLevel3b2.replace("\n", " "));
	    						//----------
							 
							
			    			  	// for level 4	 
							// int level3haveChild = driver.findElements(By.xpath(rootXpath+"["+ level3Click +"][@data-haschildren='true']")).size(); 
			    				
							// Asserting for resource container displaying resources
	    						if (testNodeslevel4[inputNodes1-1][0]== null && testNodeslevel4[inputNodes1-1][0]==""){
				   					WebElement resContainer3 = driver.findElement(By.xpath(srd_resource_container));
				   					Boolean b3= resContainer3.isDisplayed();
				   				System.out.println("resContainer3 : " + b3.toString());
				   				TestAssertion.assertionEquals(driver, "true", b3.toString());
				   					
				   				}
	    					 	if (testNodeslevel4[inputNodes1-1][0]!= null && testNodeslevel4[inputNodes1-1][0]!=""){{
	    					 		int level4Size = driver.findElements(By.xpath(rootXpath)).size();	// size of level 4
	    			    			System.out.println("level4Size: "+level4Size);
	    			    			
	    			    			
	    			    			 if (level4Size !=0){

	    			    				 String level4Click =testNodeslevel4[inputNodes1-1][0];
	    			    					 
	    			    			 
	    			    					// assert level 4
	    			    					WebElement level4Text = driver.findElement(By.xpath(rootXpath+"["+ level4Click +"]/div"));
	    			    						String strngLevel4 = level4Text.getText();
	    			    						String expectedLevel4 = level4[inputNodes1-1][0];
	    			    						System.out.println("Level 4 Text: "+strngLevel4);
	    			    						TestAssertion.assertionEquals(driver, expectedLevel4, strngLevel4);
	    			    					//----------
	    			    		
	    			    						driver.findElement(By.xpath(rootXpath+"["+ level4Click +"]/div")).click();
	    							 synchronized (driver){driver.wait(2000);}		
	    							 // assert breadcrum
			    						WebElement level4bText2 = driver.findElement(By.xpath(srd_breadcrum));
			    						String strngLevel4b2 = level4bText2.getText();
			    						System.out.println("l4 brcm : "+ strngLevel4b2);
			    						TestAssertion.assertionEquals(driver,(expectedLevel1+" > "+expectedLevel2+" > "+ expectedLevel3+" > "+ expectedLevel4), strngLevel4b2.replace("\n", " "));
			    						//----------
	    							
	    							 //for level 5
	    							// int level4haveChild = driver.findElements(By.xpath(rootXpath+"["+ level4Click +"][@data-haschildren='true']")).size();		
	    	    					 	
	    							// Asserting for resource container displaying resources
			    						if (testNodeslevel5[inputNodes1-1][0]== null && testNodeslevel5[inputNodes1-1][0]==""){
	    				  					WebElement resContainer4 = driver.findElement(By.xpath(srd_resource_container));
	    				  					Boolean b4= resContainer4.isDisplayed();
	    				  				System.out.println("resContainer4 : " + b4.toString());
	    				  				TestAssertion.assertionEquals(driver, "true", b4.toString());
	    				  					
	    				  				}
	    							 
	    							 if (testNodeslevel5[inputNodes1-1][0]!= null && testNodeslevel5[inputNodes1-1][0]!=""){{
	    								 int level5Size = driver.findElements(By.xpath(rootXpath)).size();	// size of level 5
	    	    			    			System.out.println("level3Size: "+level3Size);
	    	    			    			
	    	    			    			
	    	    			    			 if (level5Size !=0){
	 
	    	    			    				 {String level5Click =testNodeslevel5[inputNodes1-1][0];
	    	    			    					 
	    	    			    			 
	    	    			    					// assert level 5
	    	    			    					WebElement level5Text = driver.findElement(By.xpath(rootXpath+"["+ level5Click +"]/div"));
	    	    			    						String strngLevel5 = level5Text.getText();
	    	    			    						String expectedLevel5 = level5[inputNodes1-1][0];
	    	    			    						System.out.println("Level 5 Text: "+strngLevel5);
	    	    			    						TestAssertion.assertionEquals(driver, expectedLevel5, strngLevel5);
	    	    			        			    		
	    	    			    						driver.findElement(By.xpath(rootXpath+"["+ level5Click +"]/div")).click();
	    	    			    						
	    	    			    						// Asserting for resource container displaying resources
	    	    			    						WebElement resContainer5 = driver.findElement(By.xpath(srd_resource_container));
	    	    					   					Boolean b5= resContainer5.isDisplayed();
	    	    					   				    System.out.println("resContainer5 : " + b5.toString());
	    	    					   				    TestAssertion.assertionEquals(driver, "true", b5.toString());
	    	    			    						
	    	    							 synchronized (driver){driver.wait(2000);}	
	    	    							 
	    	    							// assert breadcrum
		 			    						WebElement level5bText = driver.findElement(By.xpath(srd_breadcrum));
		 			    						String strngLevel5b = level5bText.getText();
		 			    						System.out.println("l5 brcm : "+ strngLevel5b);
		 			    						TestAssertion.assertionEquals(driver, (expectedLevel1+" > "+expectedLevel2+" > "+ expectedLevel3+" > "+ expectedLevel4 +" > "+expectedLevel5), strngLevel5b.replace("\n", " "));
		 			    						//----------
	    	    			    					}
	    	 			    			 	
	    	    			    			 }
	    	    						}		       synchronized (driver){driver.wait(2000);} 
	    	    						
	    	    						Boolean b8= isElementPresent(By.xpath(srd_back_btn));
					    				 TestAssertion.assertionEquals(driver,"true",b8.toString());
	    	    						driver.findElement(By.xpath(srd_back_btn)).click(); }// closing level 5
		    			    			 	
	    	    									}
	    	    			    			 	}		     synchronized (driver){driver.wait(2000);}   
	    	    			    			 	Boolean b8= isElementPresent(By.xpath(srd_back_btn));
	    					    				 TestAssertion.assertionEquals(driver,"true",b8.toString());
	    	    			    			 	driver.findElement(By.xpath(srd_back_btn)).click();}// closing level 4
	    	    			    			 
	        					 }
			    			 
					 }		     synchronized (driver){driver.wait(2000);}   

					 Boolean b8= isElementPresent(By.xpath(srd_back_btn));
    				 TestAssertion.assertionEquals(driver,"true",b8.toString());
					 driver.findElement(By.xpath(srd_back_btn)).click(); } //closing level 3
				}
			 }
			 
			 }		      synchronized (driver){driver.wait(2000);}  
			 
			 Boolean b8= isElementPresent(By.xpath(srd_back_btn));
			 TestAssertion.assertionEquals(driver,"true",b8.toString());
			 driver.findElement(By.xpath(srd_back_btn)).click();}//closing level 2

		} synchronized (driver){driver.wait(2000);}  
		
		Boolean b8= isElementPresent(By.xpath(srd_back_btn));
		 TestAssertion.assertionEquals(driver,"true",b8.toString());
		driver.findElement(By.xpath(srd_back_btn)).click();}// closing level 1

	}

	}// closing test

}