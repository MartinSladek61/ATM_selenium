package webtest.work.workHRProcesses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;

public class NewCZ_DPPHRProcessPage extends AbstractWorkPage {

    @FindBy(xpath = "//a[@href='./wf_rozcestnik.php?akce=nastavit&typ=dpp_cz&wfproces=44']") private WebElement czDppButon ;

    /**
     * Constructor - overrides by super
     */
    public NewCZ_DPPHRProcessPage(){ super(); }

    /**
     * Overrides isOpen - checking if the page is loaded
     * @return boolean value
     */

    @Override
    public boolean isOpen(){
        boolean statement = isElementPresent(czDppButon); //TODO - zmena na pozdejsi stranku
        if(!statement){ DriverSettings.takeScreenshot(); }
        return statement;
    }
}
