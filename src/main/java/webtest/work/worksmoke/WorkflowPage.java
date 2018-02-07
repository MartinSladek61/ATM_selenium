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
    WebElement cancelTaskButton;
    //TODO Elemenety ve formulari Vlozeni nove osoby

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
