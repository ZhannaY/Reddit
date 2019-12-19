package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;



public class LoginPage extends BasePage {

    private By emailAddressField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//input[@class='btn btn-primary']");
    private By continueButton = By.xpath("//a[@class='btn btn-primary']");
    private By warningMessageInvalidData = By.xpath("//div[contains(text()," +
            "' Warning: No match for E-Mail Address and/or Password.')]");
    private By warningMessageBlocker = By.xpath("//div[contains(text()," +
            "'Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.')]");
    private By listGroup = By.xpath("//*[@id='column-right']");

    public LoginPage(WebDriver driver) {

        super(driver);
    }



    public LoginPage unsuccessfulLogin(String eMail, String password) {
        findElement(emailAddressField).sendKeys(eMail);
        findElement(passwordField).sendKeys(password);
        findElement(loginButton).click();
        return this;
    }

    public LoginPage unsuccessfulLoginSixTimes(String eMail, String password) {
        int counter = 0;
        findElement(emailAddressField).sendKeys(eMail);
        findElement(passwordField).sendKeys(password);
        do {
            findElement(loginButton).click();
            counter++;
        }while(counter<7);
        return this;
    }

    public LoginPage clickContinueButton() {
        findElement(continueButton).click();
        return this;
    }

    public LoginPage clickLoginButton() {
        findElement(loginButton).click();
        return this;
    }

    public LoginPage clickListGroupElement(String option) {
        List<WebElement> listGroupElements = driver.findElements(listGroup);
        for (WebElement listGroupElement : listGroupElements) {
            if (listGroupElement.getText().contains(option)) {
                listGroupElement.click();
            }
        }
        return this;
    }

    public LoginPage verifyWarningMessageInvalidDataAppears() {
        Assert.assertTrue(findElement(warningMessageInvalidData).isDisplayed());
        return this;
    }

    public void verifyWarningMessageBlockerAppears() {
        Assert.assertTrue(findElement(warningMessageBlocker).isDisplayed());
    }

    public void verifyPageOpens(String ExpectedUrl) {
        Assert.assertEquals(ExpectedUrl, driver.getCurrentUrl());
    }

}
