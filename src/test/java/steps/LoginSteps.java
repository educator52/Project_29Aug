package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import poms.BasePOM;
import utils.ThreadLocalBaseDriver;

public class LoginSteps {

    private WebDriver driver;
    BasePOM pom = new BasePOM();

    @Given("^I navigate to basqar$")
    public void i_navigate_to_basqar() {
        ThreadLocalBaseDriver.setBrowser("chrome");
        driver = ThreadLocalBaseDriver.getDriver();
//        driver = BaseDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://test.basqar.techno.study/");
    }

    @When("^I try to login using username and password$")
    public void i_enter_username_and_password() {
        pom.waitAndSendKeys(By.id("mat-input-0"), "daulet2030@gmail.com");
        pom.waitAndSendKeys(By.id("mat-input-1"), "TechnoStudy123@");
        pom.waitAndClick(By.cssSelector("[aria-label=\"LOGIN\"]"));
    }

    @Then("^I am logged in$")
    public void i_am_logged_in() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img.avatar")));
        try{
            pom.waitAndClick(pom.cookiesElement);
        }catch (Exception e){   }

    }


}
