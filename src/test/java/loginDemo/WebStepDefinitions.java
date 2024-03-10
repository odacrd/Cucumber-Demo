package loginDemo;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebStepDefinitions {

    LoginPage loginPage;
    WebDriver driver;

    @Before
    public void startUp(){
        driver = new ChromeDriver();
    }

    @Given ("I open the login page")
    public void openLoginPage(){
        loginPage = new LoginPage(driver);
    }

    @When("I enter the username as {string} and password as {string}")
    public void enterUsernameAndPassword(String username, String password) throws InterruptedException {
        loginPage.enter_Username(username)
                .enter_Password(password);
    }

    @When ("I click the login button")
    public void clickLoginButton() {
        loginPage.click_Submit();
    }

    @Then("I see the login {string} msg")
    public void seeLoginSuccess(String message){
        String text = "";
        try {
            text = loginPage.get_Success_Msg();
        } catch(NoSuchElementException e){
            text = loginPage.get_Error_Msg();
        }
        Assert.assertEquals(text,message);
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

}