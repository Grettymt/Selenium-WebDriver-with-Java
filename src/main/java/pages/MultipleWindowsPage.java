package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage {

    private WebDriver webDriver;
    private By clickHereLink = By.linkText("Click Here");

    public MultipleWindowsPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void clickHere(){
        webDriver.findElement(clickHereLink).click();
    }
}