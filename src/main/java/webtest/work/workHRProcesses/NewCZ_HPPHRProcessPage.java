package webtest.work.workHRProcesses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;

import org.testng.Assert;

import java.util.List;

public class NewCZ_HPPHRProcessPage extends AbstractWorkPage{

    @FindBy(xpath = "//a[contains(@href,'hpp_cz')]") private WebElement czHppButton ;
    @FindBy(xpath = "//h1[contains(text(),'Krok 1 - Osobní dotazník/Lékařská prohlídka')]") private WebElement labelStep1;
    @FindBy(className = "form-control") private List<WebElement> formGenerateQuestionnaire;
    @FindBy(xpath = "//input[@type='submit']") private WebElement submitButton;
    @FindBy(xpath = "//a[contains(@href,'./wf_novy_zam_krok_1.')]") private WebElement proceedInProcessWF;
    @FindBy(xpath = "//h3[contains(text(),'Nový zaměstnanec - CZ občan - KROK 2')]") private WebElement newCZPersonStep2;

    /* //TODO - CELY FORMULAR PREDELAR, NEJDOU UCHOPIT TEXTOVE HODNOTY!!!
    @FindBy(xpath = "//strong[contains(text(),'Tester')]") private WebElement nameFormTextField;
    */

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
        boolean statement = isElementPresent(labelStep1);
        if(!statement){ DriverSettings.takeScreenshot(); }
        return statement;
    }

    public void proceedToProcess(){
        Assert.assertTrue(isElementPresent(czHppButton), "The czHppButton is not displayed.");
        performClick(czHppButton);
    }

    public void proceedInProcessStep1(){
        isElementEnabled(proceedInProcessWF);
        performClick(proceedInProcessWF);
        isElementPresent(newCZPersonStep2);
    }

    //TODO - dodelat porovnani
    public void checkFormGenerateQuestionnaire(){
        for(WebElement element : formGenerateQuestionnaire){
            isElementEnabled(element);
        }
        performClick(submitButton);
    }

    /*
    public void checkFormPreview(){
        String jmeno = nameFormTextField.getText();
    }
    */
}
