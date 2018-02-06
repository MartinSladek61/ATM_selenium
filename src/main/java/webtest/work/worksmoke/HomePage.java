package webtest.work.worksmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import webtest.work.base.AbstractWorkPage;

public class HomePage extends AbstractWorkPage{

    @FindBy(how = How.XPATH, using = "//h2[text()='WORK InfoPortál']")
    WebElement mainHeaderLabel;
    @FindBy(how = How.XPATH, using = "//div[@class='col-lg-6']/a[@href='./appmanager.php?app=work_hrm']")
    WebElement workHrmFastAccesButton;

    public HomePage(){
        super();
    }

    public void clickToHrm () {
        performClick(workHrmFastAccesButton);
    }

    public boolean isUserLogged() { return isElementPresent(mainHeaderLabel); }
}
