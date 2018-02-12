package webtest.work.workHRProcesses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;

public class NewCZ_HPPHRProcessPage extends AbstractWorkPage{

    @FindBy(xpath = "//a[@href='./wf_rozcestnik.php?akce=nastavit&typ=hpp_cz&wfproces=44']") private WebElement czHppButton ;

    /**
     * Constructor - overrides by super
     */
    public NewCZ_HPPHRProcessPage(){ super(); }

    /**
     * Overrides isOpen - checking if the page is loaded
     * @return boolean value
     */

    @Override
    public boolean isOpen(){
        boolean statement = isElementPresent(czHppButton);  //TODO - zmena na pozdejsi stranku
        if(!statement){ DriverSettings.takeScreenshot(); }
        return statement;
    }

    public void proceedToCZ_HPPProcess(){
        if (isElementPresent(czHppButton)) {
            performClick(czHppButton);
        }
    }
}
