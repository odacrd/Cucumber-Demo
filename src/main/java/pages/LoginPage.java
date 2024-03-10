package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//import static factories.DriverFactory.getFactoryDriver;
//import static factories.DriverFactory.getWebDriverWait;

public class LoginPage {
    public static final String LOGIN_PAGE = "https://practicetestautomation.com/practice-test-login/";
    static public WebDriver driver;
    WebDriverWait wait;
    private LoginPage(){
    }
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public static LoginPage getLoginPage(){
        driver.get(LOGIN_PAGE);
        return new LoginPage(driver);
    }

    private By USERNAME = By.id("username");
    private By PASSWORD = By.id("password");
    private By SUBMIT = By.id("submit");
    private By PAGEH1 = By.tagName("h1");
    private By ERROR = By.id("error");



    public LoginPage enter_Username(String username){
        driver.findElement(USERNAME).sendKeys(username);
        return this;
    }
    public LoginPage enter_Password(String password){
        driver.findElement(PASSWORD).sendKeys(password);
        return this;
    }
    public LoginPage click_Submit(){
        driver.findElement(SUBMIT).click();
        return this;
    }

    public String get_Success_Msg(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PAGEH1)).getText();
    }

    public String get_Error_Msg(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR)).getText();
    }

    public void shutdown(){
        driver.quit();
    }
}