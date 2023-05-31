package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class BaseTests {
    private WebDriver webDriver;

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(co);
        webDriver.get("https://the-internet.herokuapp.com/");
        webDriver.manage().window().maximize();

        /*
        WebElement inputsLink = webDriver.findElement(By.linkText("Inputs"));
        inputsLink.click();
*/
        WebElement shiftingCont = webDriver.findElement(By.linkText("Shifting Content"));
        shiftingCont.click();

        WebElement menu = webDriver.findElement(By.linkText("Example 1: Menu Element"));
        menu.click();

        List<WebElement> links = webDriver.findElements(By.tagName("li"));
        System.out.println("Cantidad de links: " + links.size());

        System.out.println(webDriver.getTitle());
        webDriver.quit();
    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}