package webtest.work.worksmoke;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;

public class NewCZ_HPPHRProcessPage extends AbstractWorkPage{

    @FindBy(xpath = "//a[@href='./wf_rozcestnik.php?akce=nastavit&typ=hpp_cz&wfproces=44']") private WebElement czHppButton ;
    @FindBy(xpath = "//a[@href='./wf_rozcestnik.php?akce=nastavit&typ=hpp_eu&wfproces=44']") private WebElement euHppButton ;
    @FindBy(xpath = "//a[@href='./wf_rozcestnik.php?akce=nastavit&typ=hpp_non_eu&wfproces=44']") private WebElement nonEuHppButton ;
    @FindBy(xpath = "//a[@href='./wf_rozcestnik.php?akce=nastavit&typ=dpp_cz&wfproces=44']") private WebElement czDppButon ;
    @FindBy(xpath = "//a[@href='./wf_rozcestnik.php?akce=nastavit&typ=dpp_eu&wfproces=44']") private WebElement euDppButton ;
    @FindBy(xpath = "//a[@href='./wf_rozcestnik.php?akce=nastavit&typ=dpp_non_eu&wfproces=44']") private WebElement nonEuDppButton ;


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
        boolean statement = isElementPresent(czHppButton);
        if(!statement){ DriverSettings.takeScreenshot(); }
        return statement;
    }
}
