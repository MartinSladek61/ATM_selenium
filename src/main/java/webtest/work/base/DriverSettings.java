package webtest.work.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSettings {
    private static WebDriver driver;

    public static WebDriver getDriver(){ return driver; }

    public static WebDriver inicializeDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\ChromeDriver\\chromedriver.exe");
        String baseUrl = "https://test2:Sparta2857@test1.iswork.cz/";
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    protected WebElement findElement(By by) { return getDriver().findElement(by);}
}
