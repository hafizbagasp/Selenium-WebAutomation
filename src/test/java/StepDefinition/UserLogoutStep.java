package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class UserLogoutStep {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User is logged in to SauceDemo")
    public void user_is_logged_in_to_saucedemo() throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }

    @When("User click the logout button")
    public void user_click_the_logout_button() throws Exception {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(500);
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(500);
    }

    @Then("User should be logged out successfully")
    public void user_should_be_logged_out_successfully()  {
        Assert.assertEquals("Swag Labs",driver.findElement(By.className("login_logo")).getText());
        System.out.println("Scenario : User Successful Logout");
        System.out.println("If Success Logout, You Can See Title Name " + driver.findElement(By.className("login_logo")).getText());
        driver.quit();
    }
}
