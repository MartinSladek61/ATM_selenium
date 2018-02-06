package webtest.work.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    public static void closeAllInstancesOfChromeDriver() throws Exception{
        String processName = "chromedriver.exe";
        if (isProcessRunning(processName)) {
            killProcess(processName);
        }
    }

    public static boolean isProcessRunning(String serviceName) {
        final String TASKLIST = "tasklist";
        try {
            Process p = Runtime.getRuntime().exec(TASKLIST);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(serviceName) ){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void killProcess(String serviceName) throws Exception{
        final String KILL = "taskkill /F /IM ";
        Runtime.getRuntime().exec(KILL + serviceName + " /T");
    }

    protected WebElement findElement(By by) { return getDriver().findElement(by);}
}
