package newbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class login {
    @Test
    public void main() throws InterruptedException {
        
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        
       
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
 
       
        driver.get("https://signadart.ai/");
        
       
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'block text-inherit w-full h-full rounded-[50px] text-lg font-bold') and text()='Login']")));
        loginButton.click();
        
        
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='userName' and @placeholder='Email']")));
        emailInput.sendKeys("Testingteam@signatech.com");
 
        
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password' and @placeholder='Password']")));
        passwordInput.sendKeys("test@123");
 
        
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']")));
        signInButton.click();
 
        
        WebElement welcomeTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Welcome onboard')]")));
 
        // Check if "Welcome onboard" text is present
        if (welcomeTextElement.isDisplayed()) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

       
        driver.quit();
    }
}
