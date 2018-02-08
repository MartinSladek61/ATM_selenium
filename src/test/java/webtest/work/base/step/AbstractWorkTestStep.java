package webtest.work.base.step;

import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;
import webtest.work.worksmoke.HrmPage;
import webtest.work.worksmoke.LoginPage;
import webtest.work.worksmoke.HomePage;
import webtest.work.worksmoke.WorkflowPage;

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
        assertTrue(hrmPage.isOpen(), "HRM page doesn't open correctly.");
        hrmPage.closeTab(DriverSettings.getDriver(), 0);
        hrmPage.switchToTabs(DriverSettings.getDriver(), 0);
    }

    /**
     * Go to Work Flow page
     */
    public void goToWorkFlow(){
        HrmPage hrmPage = new HrmPage();
        hrmPage.goToWorkFlow();
        WorkflowPage workflowPage = new WorkflowPage();
        workflowPage.createNewFullTimePersonHRProcess();
    }

    public void checkButtonsOnTop(){
        WorkflowPage workflowPage = new WorkflowPage();
        workflowPage.cancelCreatingNewPersonTask(false);
    }

    public void checkAndFillNewHRProcessForm(){
        WorkflowPage workflowPage = new WorkflowPage();
        workflowPage.checkNewHRProcessFormFields();
        workflowPage.fillInNewHRProcessFormFields();
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
