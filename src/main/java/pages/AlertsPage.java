package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver webDriver;

    /**
     * Locators
     */
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");

    private By results = By.id("result");

    /**
     * Constructor
     * @param webDriver
     */
    public AlertsPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    /**
     * Method that allows clicking on the JS Alert button
     */
    public void triggerAlert(){
        webDriver.findElement(triggerAlertButton).click();
    }

    /**
     * Method that allows clicking on the JS Confirm button
     */
    public void triggerConfirm(){
        webDriver.findElement(triggerConfirmButton).click();
    }

    /**
     * Method that allows clicking on the JS Prompt button
     */
    public void triggerPrompt(){
        webDriver.findElement(triggerPromptButton).click();
    }

    /**
     * Method that allows you to click the accept button of the alert
     * switchTo() --> Allows to change the current DOM context to an alert as it is in this case.
     */
    public void alert_clickToAccept(){
        webDriver.switchTo().alert().accept();
    }

    /**
     * Method that allows you to click the cancel button of the alert.
     */
    public void alert_clickToDismiss(){
        webDriver.switchTo().alert().dismiss();
    }

    /**
     * Method that allows to obtain the text of the message of an alert in the browser.
     * @return
     */
    public String alert_getText(){
        return webDriver.switchTo().alert().getText();
    }

    /**
     * Method that allows to enter a text in an alert window.
     * @param text
     */
    public void alert_setInput(String text){
        webDriver.switchTo().alert().sendKeys(text);
    }

    /**
     * Method that allows to return the text of the element identified as "results".
     */
    public String getResult(){
        return webDriver.findElement(results).getText();
    }
}