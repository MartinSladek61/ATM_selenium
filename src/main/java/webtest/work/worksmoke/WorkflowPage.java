package webtest.work.worksmoke;


import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;

public class WorkflowPage extends AbstractWorkPage{

    @FindBy(how = How.XPATH,using = "//a[@href='./wf_nova_osoba_nabor.php']")   //add ID
    private WebElement newFullTimePersonProcessButton ;
    @FindBy(how = How.XPATH,using = "//a[@href='./wf_dpp_hpp_krok_0.php']")    //add ID
    private WebElement newFullTimePersonFromPartTimeButton;
    @FindBy(how = How.XPATH, using = "//a[@href='./prodlouzeni_dohody.php']")   //add ID
    private WebElement contractExtensionButton;
    @FindBy(how = How.XPATH, using = "//a[@href='./odchod_zamestnance.php']")   //add ID
    private WebElement contractTerminationButton;


    /**
     * Constructor - overrides by super
     */
    public WorkflowPage(){ super(); }

    /**
     * Overrides isOpen - checking if the page is loaded
     * @return boolean value
     */
    @Override
    public boolean isOpen(){
        boolean statement = isElementPresent(newFullTimePersonProcessButton);
        if(!statement){ DriverSettings.takeScreenshot(); }
        return statement;
    }

    public void createNewFullTimePersonHRProcess(){
        isElementPresent(newFullTimePersonProcessButton);
        performClick(newFullTimePersonProcessButton);
    }



}
