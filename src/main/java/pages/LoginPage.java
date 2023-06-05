package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver webDriver;

    /**
     * Locators
     * @param webDriver
     */
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#login button");

    /**
     * Constructor
     * @param webDriver
     */
    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    /**
     * Interaction with elements
     */
    public void setUsername(String username){
        webDriver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        webDriver.findElement(loginButton).click();
        return new SecureAreaPage(webDriver);
    }
}