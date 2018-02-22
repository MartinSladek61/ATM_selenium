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
    @FindBy(xpath = "//h3[contains(text(),'Nový zaměstnanec - CZ občan - KROK 3')]") private WebElement newCZPersonStep3;

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
    @FindBy(name = "ulice") private WebElement streetFieldStep2;
    @FindBy(name = "psc") private WebElement pscFieldStep2;
    @FindBy(name = "mesto") private WebElement cityFieldStep2;
    @FindBy(name = "zeme") private WebElement countryFieldStep2;

    @FindBy(name = "budID") private WebElement futureIdFieldStep3;
    @FindBy(name = "pozice") private WebElement positionFieldStep3;
    @FindBy(name = "manager") private WebElement managerFieldStep3;
    @FindBy(name = "smlouva") private WebElement contractFieldStep3;
    @FindBy(name = "mzda") private WebElement wageFieldStep3;
    @FindBy(name = "forma_mzdy") private WebElement formOfWageFieldStep3;
    @FindBy(name = "bank_predcisli") private WebElement bankPrefixNumberFieldStep3;
    @FindBy(name = "bank_ucet") private WebElement bankAccountFieldStep3;
    @FindBy(name = "banka") private WebElement bankCodeFieldStep3;
    @FindBy(name = "dovolena") private WebElement vacationFieldStep3;
    @FindBy(name = "dovolenaz") private WebElement vacationBalanceFieldStep3;
    @FindBy(name = "nastup") private WebElement boardingFieldStep3;
    @FindBy(name = "doba_neurcita") private WebElement undefinedTermFieldStep3;
    @FindBy(name = "doba_urcita") private WebElement definedTermFieldStep3;
    @FindBy(name = "zkusebni_doba") private WebElement testTermFieldStep3;
    @FindBy(name = "zkusebka") private WebElement testTermNumberFieldStep3;
    @FindBy(name = "stravenky") private WebElement mealVouchersFieldStep3;
    @FindBy(name = "fte") private WebElement fteFieldStep3;

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

    public void proceedToStep2(){
        isElementEnabled(proceedInProcessWF);
        performClick(proceedInProcessWF);
        Assert.assertTrue(isElementPresent(newCZPersonStep2), "Label 'Nový zaměstnanec - CZ občan - KROK 2' is not displayed");
    }

    public void proceedToStep3(){
        isElementEnabled(submitButton);
        performClick(submitButton);
        Assert.assertTrue(isElementPresent(newCZPersonStep3), "Label 'Nový zaměstnanec - CZ občan - KROK 3' is not displayed");
    }

    //TODO - dodelat porovnani
    public void checkFormGenerateQuestionnaire() throws Exception {
        for(WebElement element : formGenerateQuestionnaire){
            isElementEnabled(element);
            //assertEquals(element.getAttribute("value"), UploadDataFromExcel.setVariablesForNewPerson("NewPerson1", 1, formGenerateQuestionnaire.indexOf(element)));
        }
        performClick(submitButton);
    }

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

    public void checkAndFillFormResidencyDataStep2() throws Exception{
        WebElement[] elementList = {streetFieldStep2, pscFieldStep2, cityFieldStep2, countryFieldStep2};
        for(int i = 0; i < elementList.length; i++){
            isElementEnabled(elementList[i]);
            String s = UploadDataFromExcel.setVariablesForNewPerson("CZ_HPP", 1, i + 7);
            setText(elementList[i], s);
        }
    }

    public void checkJobTitleFormStep3(){
        //TODO
    }
}
