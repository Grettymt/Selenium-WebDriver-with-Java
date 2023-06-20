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
     * --- Interaction with elements ----
     */

    /**
     * @param username, ingresar un nombre de usuario en un campo de texto
     */
    public void setUsername(String username){
        webDriver.findElement(usernameField).sendKeys(username);
    }

    /**
     *
     * @param password, ingresar una contraseña en un campo de texto
     */
    public void setPassword(String password){
        webDriver.findElement(passwordField).sendKeys(password);
    }

    /**
     * Hacer clic en un botón de inicio de sesión en la página web
     * @return
     */
    public SecureAreaPage clickLoginButton(){
        webDriver.findElement(loginButton).click();
        return new SecureAreaPage(webDriver);
    }
}