package webtest.work.workHRProcesses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;

public class NewEU_HPPHRProcessPage extends AbstractWorkPage {

    @FindBy(xpath = "//a[contains(@href,'hpp_eu')]") private WebElement euHppButton ;

    /**
     * Constructor - overrides by super
     */
    public NewEU_HPPHRProcessPage(){ super(); }

    /**
     * Overrides isOpen - checking if the page is loaded
     * @return boolean value
     */

    @Override
    public boolean isOpen(){
        boolean statement = isElementPresent(euHppButton);  //TODO - zmena na pozdejsi stranku
        if(!statement){ DriverSettings.takeScreenshot(); }
        return statement;
    }
}
