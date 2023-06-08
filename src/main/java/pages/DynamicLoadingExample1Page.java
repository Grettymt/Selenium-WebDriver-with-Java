package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class DynamicLoadingExample1Page {
    private WebDriver webDriver;

    /**
     * Locators
     */
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.id("finish");

    /**
     * Constructor
     * @param webDriver
     */
    public DynamicLoadingExample1Page(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void clickStart(){
        webDriver.findElement(startButton).click();

        /**
         * Explicit wait
         * WebDriverWait wait = new WebDriverWait(webDriver, 5);
         * wait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(loadingIndicator)));
         */

        /**
         * Fluent wait
         */
        FluentWait wait = new FluentWait(webDriver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(
                webDriver.findElement(loadingIndicator)));
    }

    public String getLoadedText(){
        return webDriver.findElement(loadedText).getText();
    }
}