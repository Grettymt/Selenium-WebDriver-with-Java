package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver webDriver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void selectFromDropDown(String option){
        findDropElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements =
                findDropElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropElement(){
        return new Select(webDriver.findElement(dropdown));
    }
}
