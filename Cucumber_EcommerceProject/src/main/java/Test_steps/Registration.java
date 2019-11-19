package Test_steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import okhttp3.internal.connection.RouteSelector.Selection;


public class Registration {

public WebDriver driver;

//@Given("^user opens the browser and enter the url http://automationpractice.com/index.php$")
public void open_browser_and_enter_the_url() {

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karthik\\Desktop\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();	
	driver.get("http://automationpractice.com/index.php");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);	
}
	
//@When("^user clicks on signin button$")
public void clicks_signin_button() {
	driver.findElement(By.partialLinkText("Sign in")).click();		
}

//@When("^user enters the emailid and click on create an account$")
public void user_enter_emailid_click_on_create() {

	driver.findElement(By.id("email_create")).sendKeys("abcdefg@gmail.com");
	driver.findElement(By.id("SubmitCreate")).click();
	
}

//@When("^fill the registration details$")
public void fill_register_details() {

	driver.findElement(By.id("id_gender1")).click();
	driver.findElement(By.id("customer_firstname")).sendKeys("Karthik");
	driver.findElement(By.id("customer_lastname")).sendKeys("Gollaputi");
	driver.findElement(By.id("passwd")).sendKeys("Karthik");

	WebElement date = driver.findElement(By.id("days"));

	Select sel_date = new Select(date);

	sel_date.selectByIndex(25);


	WebElement months= driver.findElement(By.id("months"));

	Select sel_month = new Select(months);

	sel_month.selectByIndex(2);


	WebElement year= driver.findElement(By.id("year"));

	Select sel_year = new Select(year);

	sel_year.selectByVisibleText("1992");

	driver.findElement(By.id("firstname")).sendKeys("Karthik");

	driver.findElement(By.id("lastname")).sendKeys("Gollaputi");


	driver.findElement(By.id("company")).sendKeys("Atos India pvt Ltd");



	driver.findElement(By.id("address1")).sendKeys("150,DugdaleHill Lane");


	driver.findElement(By.id("address2")).sendKeys("Pottersbar,EN62DE");


	driver.findElement(By.id("city")).sendKeys("pottersbar");

	WebElement state = driver.findElement(By.id("year"));

	Select sel_state = new Select(year);

	sel_state.selectByIndex(8);


	driver.findElement(By.id("postcode")).sendKeys("51611");

	WebElement country= driver.findElement(By.id("year"));

	Select sel_country = new Select(year);

	sel_country.selectByIndex(1);

	driver.findElement(By.id("phone_mobile")).sendKeys("9884009132");


	driver.findElement(By.id("alias")).sendKeys("pottersbar");

		
	
}

//@When(^"click on Register button$")
public void click_register_button() {
	driver.findElement(By.id("submitAccount")).click();	
}

//@Then("^User should get registered in the website and it displays a success message$")
public void assert_register_success() {
String welcome_txt = driver.findElement(By.className("info-account")).getText();
Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", welcome_txt);
	
}

}
