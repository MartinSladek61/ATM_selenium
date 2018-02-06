package webtest.work.worksmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import webtest.work.base.AbstractWorkPage;

public class HrmPage extends AbstractWorkPage{

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Karta zaměstnance')]")
    WebElement mainHeaderLabel;
    @FindBy(how = How.CLASS_NAME, using = "user-image")
    WebElement userImageRTopCorner;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Odhlásit se')]")
    WebElement logoutButton;

    public HrmPage(){
        super();
    }

    @Override
    public boolean isOpen() { return isElementPresent(mainHeaderLabel);}

    public void logoutFromHrmPage(){
        logoutFromWork(userImageRTopCorner, logoutButton);
    }
}
