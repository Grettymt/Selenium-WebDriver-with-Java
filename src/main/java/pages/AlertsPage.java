package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver webDriver;
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");

    private By results = By.id("result");

    public AlertsPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void triggerAlert(){
        webDriver.findElement(triggerAlertButton).click();
    }

    public void triggerConfirm(){
        webDriver.findElement(triggerConfirmButton).click();
    }

    public void triggerPrompt(){
        webDriver.findElement(triggerPromptButton).click();
    }

    public void alert_clickToAccept(){
        webDriver.switchTo().alert().accept();
    }

    public void alert_clickToDismiss(){
        webDriver.switchTo().alert().dismiss();
    }

    public String alert_getText(){
        return webDriver.switchTo().alert().getText();
    }

    public void alert_setInput(String text){
        webDriver.switchTo().alert().sendKeys(text);
    }

    public String getResult(){
        return webDriver.findElement(results).getText();
    }
}