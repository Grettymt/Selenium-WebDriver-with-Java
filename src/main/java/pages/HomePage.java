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

    private void clickLink(String linkText){
        webDriver.findElement(By.linkText(linkText)).click();
    }
}