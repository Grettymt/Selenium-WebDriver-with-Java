package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver webDriver;

    public HomePage (WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public LoginPage clickFormAthentication(){
        clickLink("Form Authentication");
        return new LoginPage(webDriver);
    }

    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(webDriver);
    }

    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(webDriver);
    }

    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(webDriver);
    }

    /**
     * Method that allows you to navigate to the alerts page and perform additional actions on that page.
     */
    public AlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(webDriver);
    }

    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(webDriver);
    }

    /**
     * Method that performs click in the WYSIWYG editor
     */
    public WysisygEditorPage clickWysiwygEditor(){
        clickLink("WYSIWYG Editor");
        return new WysisygEditorPage(webDriver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDom(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(webDriver);
    }

    public InfiniteScrollPage clickInfiniteScroll(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(webDriver);
    }

    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(webDriver);
    }

    private void clickLink(String linkText){
        webDriver.findElement(By.linkText(linkText)).click();
    }
}