package webtest.work.worksmoke;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(how = How.XPATH, using = "//input[@type='submit']") private WebElement submitButtonElement; //add ID

    /*Dodelat classy jinak se z toho zblaznim*/
    @FindBy(xpath = "//input[contains(@id,'ano_ne_')]") private List<WebElement> yes_noList;
    @FindBy(xpath = "//select[contains(@id,'vlastnik_')]") private List<WebElement> ownerList;
    @FindBy(xpath = "//input[contains(@id,'termin_')]") private List<WebElement> dateList;
    @FindBy(xpath = "//input[contains(@id,'poznamka_')]") private List<WebElement> noteList;

    private WebElement[] elementList = {nameInputFieldElement, surnameInputFieldElement, emailInputFieldElement, phoneInputFieldElement, managerSelectComboBoxElement, startDateInputFieldElement, noteInputFieldElement};

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
     * Checks form field's existence
     */
    public void checkNewHRProcessFormFields(){
        for(WebElement element : elementList){
            isElementEnabled(element);
        }
    }

    /**
     * Fills fields in the form
     */
    public void fillInNewHRProcessFormFields() throws Exception {
        for(int i = 0; i < elementList.length; i++){
            String s = UploadDataFromExcel.setVariablesForNewPerson("NewPerson1", 1, i);
            if(UploadDataFromExcel.setVariablesForNewPerson("NewPerson1", 0, i).equals("Manažer")){
                Select lang = new Select(managerSelectComboBoxElement);
                lang.selectByValue(s);
            } else {
                setText(elementList[i], s);
            }
        }
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
        isElementEnabled(submitButtonElement);
        performClick(submitButtonElement);
    }
}
