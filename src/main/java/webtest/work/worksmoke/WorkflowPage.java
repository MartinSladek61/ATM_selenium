package webtest.work.worksmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import webtest.work.base.AbstractWorkPage;

public class WorkflowPage extends AbstractWorkPage{

    @FindBy(how = How.CLASS_NAME,using = "btn btn-success")
    private WebElement newFullTimePersonProcessButton ;
    @FindBy(how = How.CLASS_NAME,using = "btn btn-info")
    private WebElement newFullTimePersonFromPartTimeButton;
    @FindBy(how = How.CLASS_NAME, using = "btn btn-default")
    private WebElement contractExtensionButton;
    @FindBy(how = How.CLASS_NAME, using = "btn btn-danger")
    private WebElement contractTerminationButton;
    @FindBy(how = How.CLASS_NAME, using = "btn btn-box-tool")
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
    private WebElement StartDateInputFieldElement;
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

    }

    public void fillInNewHRProcessFormFields(){

    }
}
