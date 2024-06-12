package newbasics;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
 
public class signup {
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
 
driver.findElement(By.xpath("//a[text()='Sign up']")).click();
Thread.sleep(3000);
//Click and enter "Kylian" in the first name input field
WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='firstName' and @placeholder='First Name']"));
firstNameInput.sendKeys("Kyl");
Thread.sleep(3000);
//Click and enter "Mbappe" in the last name input field
WebElement lastNameInput = driver.findElement(By.xpath("//input[@name='lastName' and @placeholder='Last Name']"));
lastNameInput.sendKeys("Mb");
Thread.sleep(3000);
//Click and enter "mbappe@gmail.com" in the email input field
WebElement emailInput = driver.findElement(By.xpath("//input[@name='email' and @placeholder='Email']"));
emailInput.sendKeys("pohijap334@adrais.com");
Thread.sleep(3000);
//Click the checkbox input field
WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
checkboxInput.click();
 
 
WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Sign Up']"));
signUpButton.click();
Thread.sleep(4000);
 
driver.close();
 
}
}