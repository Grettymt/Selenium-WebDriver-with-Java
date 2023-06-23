package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    /**
     * This variable is used to store an instance of the WebDriver controller, which is an interface provided by
     * Selenium to interact with web browsers.
     */
    private WebDriver webDriver;

    /**
     * Locator
     */
    private By dropdown = By.id("dropdown");

    /**
     * Constructor
     * @param webDriver
     */
    public DropdownPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    /**
     * Method that allows you to select a specific option from a dropdown menu
     * @param option
     */
    public void selectFromDropDown(String option){
        findDropElement().selectByVisibleText(option);
    }

    /**
     * This method retrieves the selected options from a dropdown list item and returns them as a list of text strings
     * @return
     */
    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements =
                findDropElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    /**
     * A method that allows the drop-down list element to be encapsulated in an object of type Select, which makes
     * it easier to interact with the operations related to drop-down lists
     * @return
     */
    private Select findDropElement(){
        return new Select(webDriver.findElement(dropdown));
    }
}