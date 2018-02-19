package webtest.work.workHRProcesses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;

import org.testng.Assert;
import webtest.work.base.UploadDataFromExcel;

import static org.junit.Assert.assertEquals;
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

    @FindBy(name = "titul") private WebElement degreeSelectFieldStep2;
    @FindBy(name = "jmeno") private WebElement nameFieldStep2;
    @FindBy(name = "prijmeni") private WebElement surnameFieldStep2;
    @FindBy(name = "rc") private WebElement birthNumberFieldStep2;
    @FindBy(name = "cislo_op") private WebElement idNumberFieldStep2;
    @FindBy(name = "email2") private WebElement emailFieldStep2;
    @FindBy(name = "telefon") private WebElement phoneFieldStep2;

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
    public void checkFormGenerateQuestionnaire() throws Exception {
        for(WebElement element : formGenerateQuestionnaire){
            isElementEnabled(element);
            //assertEquals(element.getAttribute("value"), UploadDataFromExcel.setVariablesForNewPerson("NewPerson1", 1, formGenerateQuestionnaire.indexOf(element)));
        }
        performClick(submitButton);
    }

    /*
    public void checkFormPreview(){
        String jmeno = nameFormTextField.getText();
    }
    */

    public void checkAndFillFormPersonalDataStep2() throws Exception{
        WebElement[] elementList = {degreeSelectFieldStep2, nameFieldStep2, surnameFieldStep2, birthNumberFieldStep2, idNumberFieldStep2, emailFieldStep2, phoneFieldStep2};
        for(int i = 0; i < elementList.length; i++){
            isElementEnabled(elementList[i]);
            if(isAttributePresent(elementList[i], "value")){
                String s = UploadDataFromExcel.setVariablesForNewPerson("CZ_HPP", 1, i);
                if(UploadDataFromExcel.setVariablesForNewPerson("CZ_HPP", 0, i).equals("Titul")){
                    Select lang = new Select(degreeSelectFieldStep2);
                    lang.selectByValue(s);
                } else {
                    setText(elementList[i], s);
                }
            } else {
                assertEquals(elementList[i].getAttribute("value"), UploadDataFromExcel.setVariablesForNewPerson("CZ_HPP", 1, i));
            }
        }
    }

    public void checkAndFillFormResidencyDataStep2(){
        //TODO
    }
}
