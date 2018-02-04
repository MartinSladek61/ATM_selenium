package webtest.work.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractWorkPage extends DriverSettings {

    public boolean isOpen(){ return true; }

    public WebElement findElementByXpath(String xpath) { return findElement(By.xpath(xpath)); }

    public WebElement findElementById(String id) { return findElement(By.id(id)); }

    public WebElement findElementByClassName(String className) { return findElement(By.className(className)); }

    public WebElement findElementByName(String name) { return findElement(By.name(name));}

    public void performClick(WebElement element) { element.click(); }

    public boolean isElementPresent(By by){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void sleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setText(WebElement element, String text) { element.sendKeys(text);}
}
