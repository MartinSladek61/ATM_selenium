package webtest.work.workHRProcesses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;

public class NewNON_EU_HPPHRProcessPage extends AbstractWorkPage {

    @FindBy(xpath = "//a[@href='./wf_rozcestnik.php?akce=nastavit&typ=hpp_non_eu&wfproces=44']") private WebElement nonEuHppButton ;

    /**
     * Constructor - overrides by super
     */
    public NewNON_EU_HPPHRProcessPage(){ super(); }

    /**
     * Overrides isOpen - checking if the page is loaded
     * @return boolean value
     */

    @Override
    public boolean isOpen(){
        boolean statement = isElementPresent(nonEuHppButton);  //TODO - zmena na pozdejsi stranku
        if(!statement){ DriverSettings.takeScreenshot(); }
        return statement;
    }
}
