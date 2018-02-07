package webtest.work.worksmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import webtest.work.base.AbstractWorkPage;

public class HrmPage extends AbstractWorkPage{

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Karta zaměstnance')]")
    private WebElement mainHeaderLabel;
    @FindBy(how = How.CLASS_NAME, using = "user-image")
    private WebElement userImageRTopCorner;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Odhlásit se')]")
    private WebElement logoutButton;
    @FindBy(how = How.XPATH, using = "//a[@href='./workflow.php']")
    private WebElement workFlowLeftMenu;

    /**
     * Constructor - overrides by super
     */
    public HrmPage(){
        super();
    }

    /**
     * Overrides isOpen - checking if the page is loaded
     * @return boolean value
     */
    @Override
    public boolean isOpen() { return isElementPresent(mainHeaderLabel);}

    /**
     * Goes to Work Flow page
     */
    public void goToWorkFlow(){
        isElementPresent(workFlowLeftMenu);
        performClick(workFlowLeftMenu);
    }

    /**
     * Logouts from WORK's HRM page
     */
    public void logoutFromHrmPage(){
        logoutFromWork(userImageRTopCorner, logoutButton);
    }
}
