package WCG.General;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.compro.automation.utils.CSVHandler;

public class Health_check {
	CSVHandler login_details = null;
    public void health_login(RemoteWebDriver driver ) throws Exception {
    	//String b = Integer.toString(i);
    	login_details = new CSVHandler("src/test/resources/login_health_check.csv");
		String baseurl  = login_details.getElementXpath("baseurl0");
    	String usertype = login_details.getElementXpath("usertype");
    	String username = login_details.getElementXpath("username");
    	String password = login_details.getElementXpath("password");
		driver.get(baseurl + "/login/teacher/login.spr");
		System.out.println(usertype);
		synchronized (driver){driver.wait(5000);}	
	    driver.findElement(By.id("j_username")).clear();
		driver.findElement(By.id("j_username")).sendKeys(username);
		driver.findElement(By.id("passwordField")).clear();
	    driver.findElement(By.id("passwordField")).sendKeys(password);
	    driver.findElement(By.id("imgLogin")).click();
	    synchronized (driver) {driver.wait(10000);}
 }
}
