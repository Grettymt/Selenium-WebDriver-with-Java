package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    /**
     * An EventFiringWebDriver instance is being used to interact with the browser and log events during test execution
     */
    private EventFiringWebDriver webDriver;
    protected HomePage homePage;

    /**
     * Method that prepares the test environment and configures the necessary tools before starting
     * the tests in the class
     */
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        webDriver = new EventFiringWebDriver(new ChromeDriver(co));
        webDriver.register(new EventReporter());
        /**
         * Implicit wait
         * webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         */
        goHome();
        webDriver.manage().window().maximize();
        homePage = new HomePage(webDriver);
    }

    /**
     * Method that allows to load the home page of the website before each test method
     */
    @BeforeMethod
    public void goHome(){
        webDriver.get("https://the-internet.herokuapp.com/");
    }

    /**
     * Method that allows the WebDriver instance to be closed and terminated and is executed after all test methods
     * in the class have been executed
     */
    @AfterClass
    public void tearDown(){
        webDriver.quit();
    }

    /**
     * Method to capture and save screenshots of failed test cases
     * @param result
     */
    @AfterMethod
    public void recordFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)webDriver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots" + result.getName() + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * A method that provides an instance of WindowManager that allows you to manage browser windows and
     * perform operations related to them.
     * @return
     */
    public WindowManager getWindowManager(){
        return new WindowManager(webDriver);
    }
}