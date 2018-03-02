package webtest.work.base.step;

import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;
import webtest.work.workHRProcesses.NewCZ_HPPHRProcessPage;
import webtest.work.worksmoke.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AbstractWorkTestStep {

    private Method testMethod;

    /**
     * Performs login
     */
    public void login() {
        LoginPage loginPage = new LoginPage();
        assertTrue(loginPage.isOpen(), "Login page doesn't open correctly.");
        loginPage.login();
        HomePage homePage = new HomePage();
        assertTrue(homePage.isOpen(), "User isn't logged correctly.");
    }

    /**
     * Goes to HRM page, closes old tab and switches to the new tab
     */
    public void goToHrm() {
        HomePage homePage = new HomePage();
        assertTrue(homePage.isOpen(), "User isn't logged correctly.");
        homePage.clickToHrm();
        HrmPage hrmPage = new HrmPage();
        hrmPage.switchToTabs(DriverSettings.getDriver(), 1);
        AbstractWorkPage.closeTab(DriverSettings.getDriver(), 0);
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
        workflowPage.createNewPersonHRProcess();
    }

    /**
     * Checks Top Button
     */
    public void checkButtonsOnTop(){
        NewPersonHRProcessPage newPerson = new NewPersonHRProcessPage();
        assertTrue(newPerson.isOpen(), "New Person page doesn't open correctly.");
        newPerson.cancelCreatingTask(false);
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
        newPerson.submitFormNewPersonTask();
    }

    public void generateAndStartCzHppWf() throws Exception {
        NewCZ_HPPHRProcessPage czProcessPage = new NewCZ_HPPHRProcessPage();
        czProcessPage.proceedToProcess();
        assertTrue(czProcessPage.isOpen(), "CZ HPP process page doesn't open correctly.");
        czProcessPage.checkFormGenerateQuestionnaire();
        czProcessPage.proceedToStep2();
    }

    public void checkAndFillPersonalAndResidencyDataCzHppStep2() throws Exception {
        NewCZ_HPPHRProcessPage czProcessPage = new NewCZ_HPPHRProcessPage();
        czProcessPage.cancelCreatingTask(false);
        czProcessPage.collapseTaskButton(false);
        czProcessPage.checkAndFillFormPersonalDataStep2();
        czProcessPage.checkAndFillFormResidencyDataStep2();
    }

    public void checkAndFillWorkCzHppStep3() throws Exception {
        NewCZ_HPPHRProcessPage czProcessPage = new NewCZ_HPPHRProcessPage();
        czProcessPage.proceedToStep3();
        czProcessPage.cancelCreatingTask(false);
        czProcessPage.collapseTaskButton(false);
        czProcessPage.previousStepTaskButton(true);
        czProcessPage.checkFormGenerateQuestionnaire();
        czProcessPage.checkAndFillJobTitleFormStep3();
        czProcessPage.proceedToStep3AndHalf();
    }

    public void checkAndFillWorkCzHppStep4() throws Exception {
        NewCZ_HPPHRProcessPage czProcessPage = new NewCZ_HPPHRProcessPage();
        czProcessPage.cancelCreatingTask(false);
        czProcessPage.collapseTaskButton(false);
        czProcessPage.previousStepTaskButton(false);
        czProcessPage.proceedToStep4();
        czProcessPage.cancelCreatingTask(false);
        czProcessPage.collapseTaskButton(false);
        czProcessPage.checkAndFillAccessesFormStep4();
    }

    public void safetyCheckCzHppStep(){
        NewCZ_HPPHRProcessPage czProcessPage = new NewCZ_HPPHRProcessPage();
        czProcessPage.proceedToSafetyCheck();
        czProcessPage.checkDetailWFAndRequestSafetyCheck();
    }


    public void generateAndStartWF(String ClassName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class classTemp = Class.forName(ClassName);
        Object obj = classTemp.getConstructor().newInstance();
        testMethod.invoke(obj).getClass().getMethod("proceedToProcess");
    }

    /**
     * Logouts from HRM page and from entire app then
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
