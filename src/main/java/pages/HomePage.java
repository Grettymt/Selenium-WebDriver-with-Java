package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    /**
     * This variable is used to store an instance of the WebDriver controller, which is an interface provided by
     * Selenium to interact with web browsers.
     */
    private WebDriver webDriver;

    /**
     * Constructor
     * @param webDriver
     */
    public HomePage (WebDriver webDriver){
        this.webDriver = webDriver;
    }

    /**
     * Method that allows you to click the "Form Authentication" link and navigate to the login page
     * @return
     */
    public LoginPage clickFormAthentication(){
        clickLink("Form Authentication");
        return new LoginPage(webDriver);
    }

    /**
     * Method that allows you to click the "Dropdown" link
     * @return
     */
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

    public MultipleWindowsPage clickMultipleWindows(){
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(webDriver);
    }

    /**
     * Method that allows you to click on a link within the web page
     * @param linkText
     */
    private void clickLink(String linkText){
        webDriver.findElement(By.linkText(linkText)).click();
    }
}