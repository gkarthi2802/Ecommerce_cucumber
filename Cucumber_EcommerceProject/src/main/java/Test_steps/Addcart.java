package Test_steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Addcart {
	public WebDriver driver;
//@Given("^Given user logged into the website$")	
public void user_login() {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karthik\\Desktop\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();	
	 driver.get("http://automationpractice.com/index.php");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	 driver.findElement(By.partialLinkText("Sign in")).click();
	 driver.findElement(By.id("email")).sendKeys("gkarthi28@gmail.com");	
	 driver.findElement(By.id("passwd")).sendKeys("XXXXXXXXX");	
	 driver.findElement(By.id("SubmitLogin")).click();
	
}

//@When ("^user move to item and add to cart$")
public void user_add_item() throws InterruptedException {

	driver.findElement(By.partialLinkText("women")).click();
	Thread.sleep(2000);
	
	//Adding Item
	Actions act = new Actions(driver);	
    WebElement faded = driver.findElement(By.cssSelector("img[alt='Faded Short Sleeve T-shirts']"));
	act.moveToElement(faded).perform();
    driver.findElement(By.xpath("//*[@id=\\\"center_column\\\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span\")")).click();
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")).click();
	
	
	
}

//@When("^ select one more item and add to cart$")
public void user_add_item2() throws InterruptedException {
	//Adding another Item.
	
	Thread.sleep(2000);
	Actions act = new Actions(driver);
	WebElement blouse = driver.findElement(By.cssSelector("img[alt='Blouse']"));
	act.moveToElement(blouse).perform();
	driver.findElement(By.xpath("//*[@id=\\\"center_column\\\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span\")")).click();
	
	driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
	driver.findElement(By.name("processAddress")).click();

	driver.findElement(By.id("cgv")).click();
	driver.findElement(By.name("processCarrier")).click();

	driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();

	driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button"));
	

	
}

//@Then("^ it should show two items in the cart$")
public void list_has_items() {

String msg =driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")).getText();	

int count = Integer.parseInt(msg);

Assert.assertEquals(count, 2);
	
}
//@Then(" let u confirm the order")
public void order_confirm() {

	String msg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText();
	
	Assert.assertEquals(msg, "Your order on My Store is complete." );
}



}
