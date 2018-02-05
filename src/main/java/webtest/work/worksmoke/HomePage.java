package webtest.work.worksmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webtest.work.base.AbstractWorkPage;

public class HomePage extends AbstractWorkPage{

    private static final String MAIN_HEADER_LABEL_XPATH = "//h2[text()='WORK InfoPortál']";
    private static final String WORK_HRM_FAST_ACCESS_BUTTON_XPATH = "//div[@class='col-lg-6']/a[@href='./appmanager.php?app=work_hrm']";

    public void clickToHrm () {
        performClick(getWorkHrmButtonElement());
    }

    public boolean isUserLogged() { return isElementPresent(By.xpath(MAIN_HEADER_LABEL_XPATH)); }

    private WebElement getHomeLogoElement() { return findElementByXpath(MAIN_HEADER_LABEL_XPATH); }

    private WebElement getWorkHrmButtonElement() { return findElementByXpath(WORK_HRM_FAST_ACCESS_BUTTON_XPATH); }
}
