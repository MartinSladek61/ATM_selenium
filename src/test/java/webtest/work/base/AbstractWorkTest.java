package webtest.work.base;

import webtest.work.base.step.AbstractWorkTestStep;

public class AbstractWorkTest {

    /**
     * Performs login
     */
    public static void login() {
        AbstractWorkTestStep step = new AbstractWorkTestStep();
        step.login();
    }

    /**
     * Declares new person in WORK FLOW - Step 0
     */
    public static void newFullTimePersonHRProcess() throws Exception {
        AbstractWorkTestStep step = new AbstractWorkTestStep();
        step.goToHrm();
        step.goToWorkFlow();
        step.checkButtonsOnTop();
        step.checkAndFillNewHRProcessForm();
        //step.logoutFromHrm();
    }
}
