package webtest.work.worksmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;

import java.sql.Driver;

public class WorkflowPage extends AbstractWorkPage{

    @FindBy(how = How.XPATH,using = "//a[@href='./wf_nova_osoba_nabor.php']")   //add ID
    private WebElement newFullTimePersonProcessButton ;
    @FindBy(how = How.XPATH,using = "//a[@href='./wf_dpp_hpp_krok_0.php']")    //add ID
    private WebElement newFullTimePersonFromPartTimeButton;
    @FindBy(how = How.XPATH, using = "//a[@href='./prodlouzeni_dohody.php']")   //add ID
    private WebElement contractExtensionButton;
    @FindBy(how = How.XPATH, using = "//a[@href='./odchod_zamestnance.php']")   //add ID
    private WebElement contractTerminationButton;
    @FindBy(how = How.XPATH, using = "//a[@href='./workflow.php']") //add ID
    private WebElement cancelTaskButton;
    //Form - description of elements
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

    /**
     * Constructor - overrides by super
     */
    public WorkflowPage(){ super(); }

    /**
     * Overrides isOpen - checking if the page is loaded
     * @return boolean value
     */
    @Override
    public boolean isOpen(){ return isElementPresent(newFullTimePersonProcessButton); }

    public void createNewFullTimePersonHRProcess(){
        isElementPresent(newFullTimePersonProcessButton);
        performClick(newFullTimePersonProcessButton);
    }

    public void cancelCreatingNewPersonTask(boolean cancel){
        isElementPresent(cancelTaskButton);
        if(cancel){
            performClick(cancelTaskButton);
        }
    }

    public void checkNewHRProcessFormFields(){
        isElementPresent(nameInputFieldElement);
        isElementPresent(surnameInputFieldElement);
        isElementPresent(emailInputFieldElement);
        isElementPresent(phoneInputFieldElement);
        isElementPresent(managerSelectComboBoxElement);
        isElementPresent(startDateInputFieldElement);
        isElementPresent(noteInputFieldElement);
    }

    public void fillInNewHRProcessFormFields(){
        setText(nameInputFieldElement, "Tester");
        setText(surnameInputFieldElement, "Testerovič");
        setText(emailInputFieldElement, "tester.testerovic@email.cz");
        setText(phoneInputFieldElement, "+420 123 456 789");
        Select lang = new Select(managerSelectComboBoxElement);
        lang.selectByValue("Ing. Jan Adminov");
        setText(startDateInputFieldElement, "01.10.2018");
        setText(noteInputFieldElement, "Poznámka k Workflow_123456789_/*-+%ˇ");
    }
}
