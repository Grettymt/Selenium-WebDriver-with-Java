package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {
    private WebDriver webDriver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void scrollToTable(){
        WebElement tableElement = webDriver.findElement(table);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)webDriver).executeScript(script, tableElement);
    }
}