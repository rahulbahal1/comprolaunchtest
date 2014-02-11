package myngconnect_server_status;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;


import com.compro.automation.utils.CSVHandler;

public class Home {
		CSVHandler login_details = null;
        public void login(RemoteWebDriver driver) throws Exception {
			login_details = new CSVHandler("src/test/resources/login_details.csv");
		String baseurl  = login_details.getElementXpath("baseurl");
    	String usertype = login_details.getElementXpath("usertype");
    	String username = login_details.getElementXpath("username");
    	String password = login_details.getElementXpath("password");

		System.out.println("usertype:"+usertype);
		synchronized (driver){driver.wait(5000);}	
    	if (usertype.equalsIgnoreCase("student"))
    		driver.get(baseurl + "/login/student/textLogin/login.spr");
    	else if (usertype.equalsIgnoreCase("teacher") || usertype.equalsIgnoreCase("educator"))
    		driver.get(baseurl + "/login/teacher/login.spr");
	    driver.findElement(By.id("j_username")).clear();
		driver.findElement(By.id("j_username")).sendKeys(username);
		driver.findElement(By.id("passwordField")).clear();
	    driver.findElement(By.id("passwordField")).sendKeys(password);
	    driver.findElement(By.id("imgLogin")).click();
 }
}