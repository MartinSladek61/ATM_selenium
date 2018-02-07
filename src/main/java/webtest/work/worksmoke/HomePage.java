package webtest.work.worksmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import webtest.work.base.AbstractWorkPage;

public class HomePage extends AbstractWorkPage{

    @FindBy(how = How.XPATH, using = "//h2[text()='WORK InfoPortál']")
    private WebElement mainHeaderLabel;
    @FindBy(how = How.XPATH, using = "//div[@class='col-lg-6']/a[@href='./appmanager.php?app=work_hrm']")
    private WebElement workHrmFastAccesButton;
    @FindBy(how = How.CLASS_NAME, using = "user-image")
    private WebElement userImageRTopCorner;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Odhlásit se')]")
    private WebElement logoutButton;

    /**
     * Constructor - overrides by super
     */
    public HomePage(){
        super();
    }

    /**
     * Logouts from WORK's homepage
     */
    public void logoutFromHomePage(){
        logoutFromWork(userImageRTopCorner, logoutButton);
    }

    /**
     * clicks on WORK HRM button on home page
     */
    public void clickToHrm () {
        performClick(workHrmFastAccesButton);
    }

    /**
     * Checks if is user logged by checking given element
     * @return boolean value
     */
    public boolean isUserLogged() { return isElementPresent(mainHeaderLabel); }
}
