package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {
    private WebDriver webDriver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void enterText(String text){
        webDriver.findElement(inputField).sendKeys(text);
    }

    public void enterPi(){
        enterText(Keys.chord(Keys.ALT, "p") + " = 3.14");
    }

    public String getResult(){
        return webDriver.findElement(resultText).getText();
    }
}