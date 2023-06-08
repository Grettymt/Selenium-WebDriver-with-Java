package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver webDriver;
    private String linkXpath_Format = ".//a[contains(text(), '%s')]";
    private By link_Example1 = By.xpath(String.format(linkXpath_Format, "Example 1"));

    public DynamicLoadingPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public DynamicLoadingExample1Page clickExample1(){
        webDriver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(webDriver);
    }
}