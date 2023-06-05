package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    private WebDriver webDriver;

    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");


    public HoversPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    /**
     * @param index starts at 1
     */
    public FigureCaption hoverOverFigure(int index){
        WebElement figure = webDriver.findElements(figureBox).get(index - 1);

        Actions actions = new Actions(webDriver);
        actions.moveToElement(figure).perform();

        return new FigureCaption(figure.findElement(boxCaption));
    }
}