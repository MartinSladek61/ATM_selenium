package webtest.work.workHRProcesses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;

public class NewNON_EU_DPPHRProcessPage extends AbstractWorkPage {

    @FindBy(xpath = "//a[contains(@href,'dpp_non_eu')]") private WebElement nonEuDppButton ;

    /**
     * Constructor - overridden by super
     */
    public NewNON_EU_DPPHRProcessPage(){ super(); }

    /**
     * Overrides isOpen - checking if the page is loaded
     * @return boolean value
     */

    @Override
    public boolean isOpen(){
        boolean statement = isElementPresent(nonEuDppButton);  //TODO - zmena na pozdejsi stranku
        if(!statement){ DriverSettings.takeScreenshot(); }
        return statement;
    }
}
