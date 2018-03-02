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
    @FindBy(xpath = "//h3[contains(text(),'Náhled a kontrola žádosti:')]") private WebElement newCZPersonFromStep3To4;
    @FindBy(xpath = "//h3[contains(text(),'Nový zaměstnanec - CZ občan - KROK 4')]") private WebElement newCZPersonStep4;
    @FindBy(xpath = "//a[contains(text(),'Ano, odeslat hned a pokračovat')]") private WebElement sendDocsAndContinueToStep4;
    @FindBy(xpath = "//h3[contains(text(),'Nový zaměstnanec - CZ občan - DETAIL WF')]") private WebElement newCZPersonStepDetail;

    /* //TODO - CELY FORMULAR PREDELAR, NEJDOU UCHOPIT TEXTOVE HODNOTY!!!
    @FindBy(xpath = "//strong[contains(text(),'Tester')]") private WebElement nameFormTextField;
    */

    /* Step 2 */
    @FindBy(name = "titul") private WebElement degreeSelectFieldStep2;
    @FindBy(name = "jmeno") private WebElement nameFieldStep2;
    @FindBy(name = "prijmeni") private WebElement surnameFieldStep2;
    @FindBy(name = "rc") private WebElement birthNumberFieldStep2;
    @FindBy(name = "cislo_op") private WebElement idNumberFieldStep2;
    @FindBy(name = "email2") private WebElement email2FieldStep2;
    @FindBy(name = "telefon") private WebElement phoneFieldStep2;
    @FindBy(name = "ulice") private WebElement streetFieldStep2;
    @FindBy(name = "psc") private WebElement pscFieldStep2;
    @FindBy(name = "mesto") private WebElement cityFieldStep2;
    @FindBy(name = "zeme") private WebElement countryFieldStep2;
    /* Step 3 */
    @FindBy(name = "budID") private WebElement futureIdFieldStep3;
    @FindBy(name = "pozice") private WebElement positionSelectStep3;
    @FindBy(name = "manager") private WebElement managerSelectStep3;
    @FindBy(name = "smlouva") private WebElement contractSelectStep3;
    @FindBy(name = "mzda") private WebElement wageFieldStep3;
    @FindBy(name = "forma_mzdy") private WebElement formOfWageSelectStep3;
    @FindBy(name = "bank_predcisli") private WebElement bankPrefixNumberFieldStep3;
    @FindBy(name = "bank_ucet") private WebElement bankAccountFieldStep3;
    @FindBy(name = "banka") private WebElement bankCodeFieldStep3;
    @FindBy(name = "dovolena") private WebElement vacationFieldStep3;
    @FindBy(name = "dovolenaz") private WebElement vacationBalanceFieldStep3;
    @FindBy(name = "nastup") private WebElement boardingFieldStep3;
    @FindBy(name = "doba_neurcita") private WebElement undefinedTermSelectStep3;
    @FindBy(name = "doba_urcita") private WebElement definedTermFieldStep3;
    @FindBy(name = "zkusebni_doba") private WebElement testTermSelectStep3;
    @FindBy(name = "zkusebka") private WebElement testTermNumberFieldStep3;
    @FindBy(name = "stravenky") private WebElement mealVouchersFieldStep3;
    @FindBy(name = "fte") private WebElement fteSelectStep3;
    @FindBy(name = "soubor_osobni_dotaznik") private WebElement filePersonalQStep3;
    @FindBy(name = "soubor_prohlidka") private WebElement fileHealthQStep3;
    @FindBy(name = "poznamka") private WebElement noteStep3;
    /* Step 4  */
    @FindBy(name = "email") private WebElement emailFieldStep4;
    @FindBy(name = "licence") private WebElement licenseSelectStep4;
    @FindBy(name = "tarif") private WebElement tariffSelectStep4;
    @FindBy(name = "work_ip") private WebElement infoPortalSelectStep4;
    @FindBy(name = "work_hrm") private WebElement hrmSelectStep4;
    @FindBy(name = "work_pm") private WebElement projectsSelectStep4;
    /* Detail check and security check */
    @FindBy(xpath = "//a[contains(text(),'bezpečnostní prověrku')]") private WebElement securityCheckButton;

    /**
     * Constructor - overridden by super
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
        proceed(proceedInProcessWF);
        Assert.assertTrue(isElementPresent(newCZPersonStep2), "Label 'Nový zaměstnanec - CZ občan - KROK 2' is not displayed");
    }

    public void proceedToStep3(){
        proceed(submitButton);
        Assert.assertTrue(isElementPresent(newCZPersonStep3), "Label 'Nový zaměstnanec - CZ občan - KROK 3' is not displayed");
    }

    public void proceedToStep3AndHalf(){
        proceed(submitButton);
        Assert.assertTrue(isElementPresent(newCZPersonFromStep3To4), "Label 'Náhled a kontrola žádosti:' is not displayed");
    }

    public void proceedToStep4(){
        proceed(sendDocsAndContinueToStep4);
        Assert.assertTrue(isElementPresent(newCZPersonStep4), "Label 'Nový zaměstnanec - CZ občan - KROK 4' is not displayed");
    }

    public void proceedToSafetyCheck(){
        proceed(submitButton);
        Assert.assertTrue(isElementPresent(newCZPersonStepDetail), "Label 'Nový zaměstnanec - CZ občan - DETAIL WF' is not displayed");
    }

    //TODO - dodelat porovnani
    public void checkFormGenerateQuestionnaire() throws Exception {
        for(WebElement element : formGenerateQuestionnaire){
            isElementEnabled(element);
        }
        performClick(submitButton);
    }

    public void checkAndFillFormPersonalDataStep2() throws Exception{
        WebElement[] elementList = {degreeSelectFieldStep2, nameFieldStep2, surnameFieldStep2, birthNumberFieldStep2, idNumberFieldStep2, email2FieldStep2, phoneFieldStep2};
        for(int i = 0; i < elementList.length; i++){
            isElementEnabled(elementList[i]);
            if(!isAttributePresent(elementList[i], "value")){
                String s = UploadDataFromExcel.setVariablesForNewPerson("CZ_HPP", 1, i);
                if(UploadDataFromExcel.setVariablesForNewPerson("CZ_HPP", 0, i).equals("Titul")){
                    Select lang = new Select(elementList[i]);
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

    public void checkAndFillJobTitleFormStep3() throws Exception {
        int skipRows, row = 0, col1 = 0, col2 = 0;
        Assert.assertTrue(isAttributePresent(futureIdFieldStep3, "readonly"));
        WebElement[] selectList = {positionSelectStep3, managerSelectStep3, contractSelectStep3, formOfWageSelectStep3, undefinedTermSelectStep3, testTermSelectStep3, fteSelectStep3};
        WebElement[] textFieldList = {wageFieldStep3, bankPrefixNumberFieldStep3, bankAccountFieldStep3, bankCodeFieldStep3, vacationFieldStep3, vacationBalanceFieldStep3, boardingFieldStep3, noteStep3};
        for (WebElement select : selectList) {
            if (row == 0) { skipRows = 4; } else { skipRows = 2; }
            row = row + skipRows;
            isElementEnabled(select);
            checkSelect(select, "CZ_HPP", row, 0);
            Select box = new Select(select);
            box.selectByValue(UploadDataFromExcel.setVariablesForNewPerson("CZ_HPP", 23, col1));
            col1++;
        }
        for(WebElement textElement : textFieldList){
            isElementEnabled(textElement);
            setText(textElement, UploadDataFromExcel.setVariablesForNewPerson("CZ_HPP", 20, col2));
            col2++;
        }
    }

    public void checkAndFillAccessesFormStep4() throws Exception {
        WebElement[] selectList = {licenseSelectStep4, tariffSelectStep4 , infoPortalSelectStep4, hrmSelectStep4, projectsSelectStep4};
        int skipRows = 2, row = 26, col = 0;
        Assert.assertTrue(isAttributePresent(futureIdFieldStep3, "readonly"));
        if(!emailFieldStep4.isSelected()){
            performClick(emailFieldStep4);
        }
        for(WebElement select : selectList){
            isElementEnabled(select);
            checkSelect(select, "CZ_HPP", row, 0);
            Select box = new Select(select);
            box.selectByValue(UploadDataFromExcel.setVariablesForNewPerson("CZ_HPP", 37, col));
            row = row + skipRows;
            col++;
        }
    }

    public void checkDetailWFAndRequestSafetyCheck(){
        if(isElementPresent(securityCheckButton)){ performClick(securityCheckButton); }
    }
}
