package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;


public class HomePage extends BasePage {

    private By logInButton = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[1]/header/div/div[2]/div[2]/div[1]/a[1]");
    private By userNameField = By.xpath("//*[@id=\"loginUsername\"]");
    private By passwordField = By.xpath("//*[@id=\"loginPassword\"]");
    private By signInButton = By.xpath("/html/body/div/div/div[2]/div/form/fieldset[5]/button");
    private By accountIcon = By.xpath("//*[@id=\"email-collection-tooltip-id\"]/img");
    private By warningMessage = By.xpath("/html/body/div/div/div[2]/div/form/fieldset[1]/div");


    public HomePage(WebDriver driver) {

        super(driver);
    }

    public HomePage successfulLogin(String userName, String password) {

        findElement(logInButton).click();
        driver.switchTo().frame(0);
        findElement(userNameField).sendKeys(userName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        findElement(passwordField).sendKeys(password);
        findElement(signInButton).click();
        return this;
    }

    public HomePage unsuccessfulLogin(String userName, String password) {

        findElement(logInButton).click();
        driver.switchTo().frame(0);
        findElement(userNameField).sendKeys(userName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        findElement(passwordField).sendKeys(password);
        findElement(signInButton).click();
        return this;
    }

    public void verifyAccountItemAppears() {

        Assert.assertTrue(findElement(accountIcon).isDisplayed());
    }

    public void verifyWarningMessageAppears() {

        Assert.assertTrue(findElement(warningMessage).isDisplayed());
    }
}
