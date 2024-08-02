package newbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class login {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testLogin() {
        driver.get("https://signadart.ai/");

        // Wait for the Login button to be clickable and click it
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Login']")));
        loginButton.click();

        // Wait for the email input to be visible and enter the email
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='userName' and @placeholder='Email']")));
        emailInput.sendKeys("Testingteam@signatech.com");

        // Wait for the password input to be visible and enter the password
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password' and @placeholder='Password']")));
        passwordInput.sendKeys("test@123");

        // Wait for the Sign In button to be clickable and click it
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']")));
        signInButton.click();

        // Wait for the "Welcome onboard" text to be visible
        WebElement welcomeTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Welcome onboard')]")));

        // Check if "Welcome onboard" text is present
        if (welcomeTextElement.isDisplayed()) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
