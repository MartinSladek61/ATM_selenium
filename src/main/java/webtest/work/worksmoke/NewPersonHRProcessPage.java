package webtest.work.worksmoke;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;
import webtest.work.base.UploadDataFromExcel;

import java.util.List;
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
    /*Dodelat classy jinak se z toho zblaznim*/
    @FindBy(xpath = "//input[contains(@id,'ano_ne_')]") private List<WebElement> yes_noList;
    @FindBy(xpath = "//select[contains(@id,'vlastnik_')]") private List<WebElement> ownerList;
    @FindBy(xpath = "//input[contains(@id,'termin_')]") private List<WebElement> dateList;
    @FindBy(xpath = "//input[contains(@id,'poznamka_')]") private List<WebElement> noteList;

    /**
     * Constructor - overrides by super
     */
    public NewPersonHRProcessPage(){ super(); }

    /**
     * Overrides isOpen - checking if the page is loaded
     * @return boolean value
     */
    @Override
    public boolean isOpen(){
        boolean statement = isElementPresent(nameInputFieldElement);
        if(!statement){ DriverSettings.takeScreenshot(); }
        return statement;
    }

    /**
     * Checks form field's existence    TODO-predelat na List
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
     * Fills fields in the form
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

    /**
     * Sets onboard activities
     */
    public void setOnboardActivities(){

        String[] idValues = {"1", "35", "1177332167", "15", "36"};
            for(WebElement element : yes_noList) {
                if(isElementPresent(element)){ element.click(); }

            }

            for(WebElement element1 : ownerList){
                if(isElementPresent(element1)){
                    Select owner = new Select(element1);
                    Random rand = new Random();
                    owner.selectByValue(idValues[rand.nextInt(idValues.length)]);
                }
            }

            for(WebElement element2 : dateList){
                if(dateList.indexOf(element2) < 10) {
                    setText(element2, "0" + dateList.indexOf(element2) + ".10.2019");
                } else {
                    setText(element2, dateList.indexOf(element2) + ".10.2019");
                }
            }

          for(WebElement element3 : noteList){
              setText(element3, "Poznámka_" + noteList.indexOf(element3) + "_/*-+");
          }
    }

    /**
     * Submits filled form
     */
    public void submitFormNewPersonTask(){
        performClick(submitButtonElement);
    }

    /**
     * Checks and clicks on cancel task button
     *
     * @param cancel if true, cancels the task
     */
    public void cancelCreatingNewPersonTask(boolean cancel){
        isElementPresent(cancelTaskButton);
        if(cancel){
            performClick(cancelTaskButton);
        }
    }
}
