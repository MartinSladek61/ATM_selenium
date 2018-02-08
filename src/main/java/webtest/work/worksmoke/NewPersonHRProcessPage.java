package webtest.work.worksmoke;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;
import webtest.work.base.UploadDataFromExcel;
import java.util.Random;

public class NewPersonHRProcessPage extends AbstractWorkPage{

    @FindBy(how = How.NAME, using = "jmeno") private WebElement nameInputFieldElement;
    @FindBy(how = How.NAME, using = "prijmeni") private WebElement surnameInputFieldElement;
    @FindBy(how = How.NAME, using = "email") private WebElement emailInputFieldElement;
    @FindBy(how = How.NAME, using = "telefon") private WebElement phoneInputFieldElement;
    @FindBy(how = How.NAME, using = "manager") private WebElement managerSelectComboBoxElement;
    @FindBy(how = How.NAME, using = "datum_pomeru") private WebElement startDateInputFieldElement;
    @FindBy(how = How.NAME, using = "poznamka") private WebElement noteInputFieldElement;
    @FindBy(how = How.XPATH, using = "//a[@href='./workflow.php']") private WebElement cancelTaskButton; //add ID
    @FindBy(how = How.XPATH, using = "//input[@type='submit']") private WebElement submitButtonElement; //add ID

    /**
     * Constructor - overrides by super
     */
    public NewPersonHRProcessPage(){ super(); }

    /**
     * Overrides isOpen - checking if the page is loaded
     * @return boolean value
     */
    @Override
    public boolean isOpen(){ return isElementPresent(nameInputFieldElement); }

    /**
     * Checks form field's existence
     */
    public void checkNewHRProcessFormFields(){
        isElementPresent(nameInputFieldElement);
        isElementPresent(surnameInputFieldElement);
        isElementPresent(emailInputFieldElement);
        isElementPresent(phoneInputFieldElement);
        isElementPresent(managerSelectComboBoxElement);
        isElementPresent(startDateInputFieldElement);
        isElementPresent(noteInputFieldElement);
    }

    /**
     * Fills field"s in the form
     */
    public void fillInNewHRProcessFormFields() throws Exception {
        String  name = UploadDataFromExcel.setVariablesForNewPerson("NewPerson1", 1, 0);
        String  surname = UploadDataFromExcel.setVariablesForNewPerson("NewPerson1", 1, 1);
        String  email = UploadDataFromExcel.setVariablesForNewPerson("NewPerson1", 1, 2);
        String  phone = UploadDataFromExcel.setVariablesForNewPerson("NewPerson1", 1, 3);
        String  manager = UploadDataFromExcel.setVariablesForNewPerson("NewPerson1", 1, 4);
        String  startDate = UploadDataFromExcel.setVariablesForNewPerson("NewPerson1", 1, 5);
        String  note = UploadDataFromExcel.setVariablesForNewPerson("NewPerson1", 1, 6);

        setText(nameInputFieldElement, name);
        setText(surnameInputFieldElement, surname);
        setText(emailInputFieldElement, email);
        setText(phoneInputFieldElement, phone);
        Select lang = new Select(managerSelectComboBoxElement);
        lang.selectByValue(manager);
        setText(startDateInputFieldElement, startDate);
        setText(noteInputFieldElement, note);
    }

    public void setOnboardActivities(){

        String[] idValues = {"1", "35", "1177332167", "15", "36"};
        Random rand = new Random();

        for(int i = 1; i < 15; i++){
            WebElement OnboarActCheckbox = DriverSettings.getDriver().findElement(By.id("ano_ne_" + i));
            isElementPresent(OnboarActCheckbox);
            WebElement OnboarActOwnerSelectbox = DriverSettings.getDriver().findElement(By.id("vlastnik_" + i));
            isElementPresent(OnboarActOwnerSelectbox);
            WebElement OnboardActDateInput = DriverSettings.getDriver().findElement(By.id("termin_" + i));
            isElementPresent(OnboardActDateInput);
            WebElement OnboardActNoteInput = DriverSettings.getDriver().findElement(By.id("poznamka_" + i));
            isElementPresent(OnboardActNoteInput);

            OnboarActCheckbox.click();
            Select owner = new Select(OnboarActOwnerSelectbox);
            owner.selectByValue(idValues[rand.nextInt(idValues.length)]);
            setText(OnboardActDateInput, "0" + i + ".10.2018");
            setText(OnboardActNoteInput, "Poznámka_" + i + i + i + "/*-+");
        }
    }

    public void submitFormNewPersonTask(){
        performClick(submitButtonElement);
    }

    public void cancelCreatingNewPersonTask(boolean cancel){
        isElementPresent(cancelTaskButton);
        if(cancel){
            performClick(cancelTaskButton);
        }
    }


}
