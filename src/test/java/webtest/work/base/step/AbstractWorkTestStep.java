package webtest.work.base.step;

import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;
import webtest.work.worksmoke.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AbstractWorkTestStep {

    /**
     * Performs login
     */
    public void login() {
        LoginPage loginPage = new LoginPage();
        assertTrue(loginPage.isOpen(), "Login page doesn't open correctly.");
        loginPage.login();
        HomePage homePage = new HomePage();
        assertTrue(homePage.isUserLogged(), "User isn't logged correctly.");
    }

    /**
     * Goes to HRM page, closes old tab and switches to the new tab
     */
    public void goToHrm() {
        HomePage homePage = new HomePage();
        assertTrue(homePage.isUserLogged(), "User isn't logged correctly.");
        homePage.clickToHrm();
        HrmPage hrmPage = new HrmPage();
        hrmPage.switchToTabs(DriverSettings.getDriver(), 1);
        hrmPage.closeTab(DriverSettings.getDriver(), 0);
        hrmPage.switchToTabs(DriverSettings.getDriver(), 0);
        assertTrue(hrmPage.isOpen(), "HRM page doesn't open correctly.");
    }

    /**
     * Goes to Work Flow page
     */
    public void goToWorkFlow(){
        HrmPage hrmPage = new HrmPage();
        assertTrue(hrmPage.isOpen(), "HRM page doesn't open correctly.");
        hrmPage.goToWorkFlow();
        WorkflowPage workflowPage = new WorkflowPage();
        assertTrue(workflowPage.isOpen(), "Work Flow page doesn't open correctly.");
        workflowPage.createNewFullTimePersonHRProcess();
    }

    /**
     * Checks Top Button
     */
    public void checkButtonsOnTop(){
        NewPersonHRProcessPage newPerson = new NewPersonHRProcessPage();
        assertTrue(newPerson.isOpen(), "New Person page doesn't open correctly.");
        newPerson.cancelCreatingNewPersonTask(false);
    }

    /**
     * Checks form fields and fills them in
     */
    public void checkAndFillNewHRProcessForm() throws Exception {
        NewPersonHRProcessPage newPerson = new NewPersonHRProcessPage();
        assertTrue(newPerson.isOpen(), "New Person page doesn't open correctly.");
        newPerson.checkNewHRProcessFormFields();
        newPerson.fillInNewHRProcessFormFields();
        newPerson.setOnboardActivities();
    }

    /**
     * Loouts from HRM page and from entire app then
     */
    public void logoutFromHrm(){
        HrmPage hrmPage = new HrmPage();
        hrmPage.logoutFromHrmPage();
        HomePage homePage = new HomePage();
        homePage.logoutFromHomePage();
    }

    /**
     * Logouts from Home page; logouts from entire app
     */
    public void logoutFromHome(){
        HomePage homePage = new HomePage();
        homePage.logoutFromHomePage();
    }
}
