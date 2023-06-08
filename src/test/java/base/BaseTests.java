package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver webDriver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(co);
        /**
         * Implicit wait
         * webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         */
        goHome();
        webDriver.manage().window().maximize();
        homePage = new HomePage(webDriver);
    }

    @BeforeMethod
    public void goHome(){
        webDriver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown(){
        webDriver.quit();
    }
}