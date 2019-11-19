package Test_steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login {

	public WebDriver driver;
//@Given("^user opens the browser and enter the url http://automationpractice.com/index.php$")
public void open_browser_enter_url() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karthik\\Desktop\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();	
	driver.get("http://automationpractice.com/index.php");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
}

//@When(" ^user clicks on signin button$")
public void user_clicks_sign_in_button() {

	driver.findElement(By.partialLinkText("Sign in")).click();		

}

//When("^ user enters username and password$")
public void fill_username_paassword() {

 driver.findElement(By.id("email")).sendKeys("gkarthi28@gmail.com");	
 driver.findElement(By.id("passwd")).sendKeys("XXXXXXXXX");	
}

//@When("^ click on sign in button$")
public void click_sign_in() {
 driver.findElement(By.id("SubmitLogin")).click();	
}

//@When("^Then it should navigate to the page with title Myaccount-mystore$")
public void assert_loginpage() {

	String title = driver.getTitle();
	Assert.assertEquals("My account - My Store", title);
	
	
}

}
