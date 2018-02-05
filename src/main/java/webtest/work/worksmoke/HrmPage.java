package webtest.work.worksmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webtest.work.base.AbstractWorkPage;

public class HrmPage extends AbstractWorkPage{

    private static final String MAIN_HEADER_LABEL_XPATH = "//h1[contains(text(),'Karta zaměstnance')]";

    @Override
    public boolean isOpen() { return isElementPresent(By.xpath(MAIN_HEADER_LABEL_XPATH));}

    private WebElement getMainHeaderLabelElement() { return findElementByXpath(MAIN_HEADER_LABEL_XPATH); }
}
