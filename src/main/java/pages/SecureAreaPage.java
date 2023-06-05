package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver webDriver;
    private By statusAlert = By.id("flash");

    public SecureAreaPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public String getAlertText(){
       return webDriver.findElement(statusAlert).getText();
    }
}