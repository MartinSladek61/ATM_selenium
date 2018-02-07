package webtest.work.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Třída AbstractWorkPage slouží k definování metod společným pro všechny stránky aplikace
 */
public class AbstractWorkPage extends DriverSettings {

    /**
     * Constructor; inits all WebElements - is overriden lately
     */
    public AbstractWorkPage(){
        PageFactory.initElements(DriverSettings.getDriver(), this);
    }

    /**
     * Checks if is page open - is overriden lately
     * @return boolean value
     */
    public boolean isOpen(){ return true; }

    /**
     * Finds element by given Xpath
     * @param xpath To the element
     * @return WebElement
     */
    public WebElement findElementByXpath(String xpath) { return findElement(By.xpath(xpath)); }

    /**
     * Finds element by given id
     * @param id To the Element
     * @return WebElement
     */
    public WebElement findElementById(String id) { return findElement(By.id(id)); }

    /**
     * Finds element by given className
     * @param className To the Element
     * @return WebElement
     */
    public WebElement findElementByClassName(String className) { return findElement(By.className(className)); }

    /**
     * Finds element by given name
     * @param name To the Elelement
     * @return WebElement
     */
    public WebElement findElementByName(String name) { return findElement(By.name(name));}

    /**
     * Performs click on given element
     * @param element specifies element
     */
    protected void performClick(WebElement element) { element.click(); }

    /**
     * checks if is element present on page
     * @param element specifies element
     * @return boolean value
     */
    protected boolean isElementPresent(WebElement element){
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    /**
     * Switching to given tab by index in web driver
     * @param driver specifies driver
     * @param tabIndex specifies tab index
     */
    public void switchToTabs(WebDriver driver, int tabIndex) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }

    /**
     * Closing given tab by index in web driver
     * @param driver specifies driver
     * @param tabIndex specifies tab index
     */
    public static void closeTab(WebDriver driver, int tabIndex){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
        driver.close();
    }

    /**
     * Sleeps for time in given miliseconds
     * @param milis specifies miliseconds
     */
    public void sleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sending string to the element
     * @param element specifies element
     * @param text specifies string text
     */
    protected void setText(WebElement element, String text) { element.sendKeys(text);}

    /**
     * Logouts from WORK app using user-image and button "Odhlásit se"
     * @param userImageRTopCorner specifies webelement
     * @param logoutButton specifies webelement
     */
    protected void logoutFromWork(WebElement userImageRTopCorner, WebElement logoutButton){
        String expanded = userImageRTopCorner.getAttribute("aria-expanded");
        if (expanded == null || expanded.equals("false")){
            performClick(userImageRTopCorner);
            performClick(logoutButton);
        } else {
            performClick(logoutButton);
        }
    }
}
