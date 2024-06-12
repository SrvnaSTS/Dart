package newbasics;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
 
public class logout {
@Test
	public void main() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
ChromeDriver driver = new ChromeDriver ();
driver.manage().window().maximize();
 
driver.get("https://signadart.ai/");
 
Thread.sleep(3000);
 
driver.findElement(By.xpath("//span[contains(@class, 'block text-inherit w-full h-full rounded-[50px] text-lg font-bold') and text()='Login']")).click();
 
Thread.sleep(3000);
 
driver.findElement(By.xpath("//input[@name='userName' and @placeholder='Email']")).sendKeys("Testingteam@signatech.com");
 
Thread.sleep(2000);
 
driver.findElement(By.xpath("//input[@name='password' and @placeholder='Password']")).sendKeys("test@123");
 
Thread.sleep(2000);
 
driver.findElement(By.xpath("//button[text()='Sign In']")).click();
 
Thread.sleep(4000);
 
driver.findElement(By.xpath("//span[contains(@class, 'avatar') and contains(@class, 'avatar-circle') and contains(@class, 'bg-amber-500')]")).click();
 
Thread.sleep(3000);
 
driver.findElement(By.xpath("//span[text()='Sign Out']")).click();
Thread.sleep(4000);
 
driver.close();
 
}
}