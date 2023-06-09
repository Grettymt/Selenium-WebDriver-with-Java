package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {

    private WebDriver webDriver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver webDriver){
        this.webDriver = webDriver;
        navigate = webDriver.navigate();
    }

    public void goBack(){
        navigate.back();
    }

    public void goFordware(){
        navigate.forward();
    }

    public void refreshPage(){
        navigate.refresh();
    }

    public void goTo(String url){
        navigate.to(url);
    }

    public void switchToTab(String tabTitle){
        var windows = webDriver.getWindowHandles();

        System.out.println("Number of tabs: " + windows.size());

        System.out.println("Window handles");
        windows.forEach(System.out::println);

        for (String window : windows){
            System.out.println("Switching to window: " + window);
            webDriver.switchTo().window(window);

            System.out.println("Current window title: " + webDriver.getTitle());

            if(tabTitle.equals(webDriver.getTitle())){
                break;
            }
        }
    }
}