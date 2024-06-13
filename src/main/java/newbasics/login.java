package newbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class login {
    @Test
    public void main() throws InterruptedException, IOException {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
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

        // Wait for the page to load after login
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement welcomeTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Welcome onboard')]")));

        // Check if "Welcome onboard" text is present
        if (welcomeTextElement.isDisplayed()) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        // Take a screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Save the screenshot to a desired location
        FileHandler.copy(screenshot, new File("./Screenshots/welcome_onboard.png"));

        // Close the browser
        driver.quit();
    }
}
