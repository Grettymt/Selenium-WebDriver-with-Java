package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysisygEditorPage {
    private WebDriver webDriver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.xpath("//button[@title='Increase indent']//span[@class='tox-icon tox-tbtn__icon-wrap']//*[name()='svg']");

    /**
     * Constructor
     * @param webDriver
     */
    public WysisygEditorPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    /**
     * Method that deletes the content of the ifram clearing the area to write a new text.
     */
    public void clearTextArea(){
        switchToEditArea();
        webDriver.findElement(textArea).clear();
        switchToMainArea();
    }

    /**
     * Method that allows you to switch to the editing area, enter the provided text in the text area, and then
     * switch focus back to the main area.
     * @param text
     */
    public void setTextArea(String text){
        switchToEditArea();
        webDriver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    /**
     * A method that allows you to switch to the editing area, get the text present in the specified text area,
     * and then switch focus back to the main area. Returns the text obtained as a result.
     * @return text
     */
    public String getTextFromEditor(){
        switchToEditArea();
        String text = webDriver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    /**
     * Method for locating and clicking a decrease indent button.
     */
    public void decreaseIndention(){
        webDriver.findElement(decreaseIndentButton).click();
    }

    /**
     * Method that allows changing the iframe, which contains the editing area.
     */
    private void switchToEditArea (){
        webDriver.switchTo().frame(editorIframeId);
    }

    /**
     * Method that allows exiting the ifram to return to the main area.
     */
    private void switchToMainArea(){
        webDriver.switchTo().parentFrame();
    }
}