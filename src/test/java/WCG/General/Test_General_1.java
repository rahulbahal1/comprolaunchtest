package WCG.General;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.compro.automation.core.*;
import com.compro.automation.utils.CSVHandler;

@RunWith(Parameterized.class)
public class Test_General_1 { 
	 
	private String testEnv;
	private RemoteWebDriver driver = null;
	
	public Test_General_1(String testEnv){
		this.testEnv = testEnv;
	  }
		 	
	  @Parameters
	   public static Collection<Object[]> data() throws Exception {
		   return (new TestEnvironement()).getEnvironment();
   }
	
	@Before
	public void setUp() {
		driver = TestRun.init(testEnv);
		System.out.println("check editing");
	}
		
	@After
	public void tearDown() throws Exception {
		TestRun.stop(driver);
	}
//-------------------------------------------------------------------------------------------------------------------
@Test
public void TestGeneral()throws Exception{
System.out.println("In @Test");
String flag="false";
Home h = new Home();
h.login(driver);
//synchronized (driver){driver.wait(10000);}
String url = driver.getCurrentUrl();
System.out.println(url);
if(url.contains("ecosystem") || url.contains("Ecosystem"))
	flag="true";
System.out.println("flag : "+flag);
TestAssertion.assertionEquals(driver, "true", flag);
System.out.println("End of @test");
}
}