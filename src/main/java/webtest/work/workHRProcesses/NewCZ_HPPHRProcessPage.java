package webtest.work.workHRProcesses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;

import org.testng.Assert;
import webtest.work.worksmoke.NewPersonHRProcessPage;

import java.util.List;

public class NewCZ_HPPHRProcessPage extends AbstractWorkPage{

    @FindBy(xpath = "//a[contains(@href,'hpp_cz')]") private WebElement czHppButton ;
    @FindBy(xpath = "//h1[contains(text(),'Krok 1 - Osobní dotazník/Lékařská prohlídka')]") private WebElement labelStep1;
    @FindBy(className = "form-control") private List<WebElement> formGenerateQuestionnaire;
    @FindBy(xpath = "//input[@type='submit']") private WebElement submitButton;



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

    //TODO - dodelat
    public void checkFormGenerateQuestionnaire(){
        for(WebElement element : formGenerateQuestionnaire){
            isElementEnabled(element);
        }
        performClick(submitButton);
    }
}
