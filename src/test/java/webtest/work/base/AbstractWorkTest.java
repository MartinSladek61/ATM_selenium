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

    public static void logout(){
        AbstractWorkTestStep step = new AbstractWorkTestStep();
        step.logoutFromHrm();
    }

    /**
     * Declares new person in WORK FLOW - Step 0
     */
    public static void newPersonHRProcess() throws Exception {
        AbstractWorkTestStep step = new AbstractWorkTestStep();
        step.goToHrm();
        step.goToWorkFlow();
        step.checkButtonsOnTop();
        step.checkAndFillNewHRProcessForm();
    }

    public static void newCZ_HPPProcess() throws Exception {
        AbstractWorkTestStep step = new AbstractWorkTestStep();
        newPersonHRProcess();
        step.generateAndStartCzHppWf();
        step.checkAndFillPersonalAndResidencyDataCzHppStep2();
        step.checkAndFillWorkCzHppStep3();
        step.checkAndFillWorkCzHppStep4();
        step.safetyCheckCzHppStep();
    }
}
