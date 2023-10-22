package StepDefinition;

import io.cucumber.java.en.And;
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

public class LoginFailedStep {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user should be open https:\\/\\/www.saucedemo.com\\/")
    public void user_should_be_open_https_www_saucedemo_com() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window();
        driver.get(baseUrl);
    }
    @When("user input invalid username and password")
    public void user_input_invalid_username() throws Exception {
        driver.findElement(By.id("user-name")).sendKeys("WrongUsername");
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("WrongPassword");
        Thread.sleep(500);
    }
    @And("user click button Login")
    public void user_click_button_login() throws Exception {
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }
    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
        System.out.println("Scenario : Invalid Login");
        System.out.println("If Failed Login, You Can See Error " + driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
        driver.quit();
    }
}
