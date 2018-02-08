package webtest.work.worksmoke;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import webtest.work.base.AbstractWorkPage;

public class NewPersonHRProcessPage extends AbstractWorkPage{

    @FindBy(how = How.NAME, using = "jmeno")
    private WebElement nameInputFieldElement;
    @FindBy(how = How.NAME, using = "prijmeni")
    private WebElement surnameInputFieldElement;
    @FindBy(how = How.NAME, using = "email")
    private WebElement emailInputFieldElement;
    @FindBy(how = How.NAME, using = "telefon")
    private WebElement phoneInputFieldElement;
    @FindBy(how = How.NAME, using = "manager")
    private WebElement managerSelectComboBoxElement;
    @FindBy(how = How.NAME, using = "datum_pomeru")
    private WebElement startDateInputFieldElement;
    @FindBy(how = How.NAME, using = "poznamka")
    private WebElement noteInputFieldElement;
    @FindBy(how = How.XPATH, using = "//a[@href='./workflow.php']") //add ID
    private WebElement cancelTaskButton;

    @FindBy(how = How.ID, using = "ano_ne_1")
    private WebElement OnboarActCheckbox1;
    @FindBy(how = How.ID, using = "vlastnik_1")
    private WebElement OnboarActOwnerSelectbox1;
    @FindBy(how = How.ID, using = "termin_1")
    private WebElement OnboardActDateInput1;
    @FindBy(how = How.ID, using = "poznamka_1")
    private WebElement OnboardActNoteInput1;

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
    public void fillInNewHRProcessFormFields(){
        setText(nameInputFieldElement, "Tester");
        setText(surnameInputFieldElement, "Testerovič");
        setText(emailInputFieldElement, "testy@blue-pool.cz");
        setText(phoneInputFieldElement, "+420 123 456 789");
        Select lang = new Select(managerSelectComboBoxElement);
        lang.selectByValue("Ing. Jan Adminov");
        setText(startDateInputFieldElement, "01.10.2018");
        setText(noteInputFieldElement, "Poznámka k Workflow_123456789_/*-+%ˇ");
    }

    public void cancelCreatingNewPersonTask(boolean cancel){
        isElementPresent(cancelTaskButton);
        if(cancel){
            performClick(cancelTaskButton);
        }
    }

    public void setOnboardActivities(){
        OnboarActCheckbox1.click();
        Select owner = new Select(OnboarActOwnerSelectbox1);
        owner.selectByValue("1");
        setText(OnboardActDateInput1, "01.10.2018");
        setText(OnboardActNoteInput1, "Poznámka_123456789/*-+%");
    }
}
