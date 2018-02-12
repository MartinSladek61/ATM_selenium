package webtest.work.base;

import webtest.work.base.step.AbstractWorkTestStep;
import webtest.work.workHRProcesses.NewCZ_HPPHRProcessPage;

import java.lang.reflect.InvocationTargetException;

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
    public static void newFullTimePersonHRProcess() throws Exception {
        AbstractWorkTestStep step = new AbstractWorkTestStep();
        step.goToHrm();
        step.goToWorkFlow();
        step.checkButtonsOnTop();
        step.checkAndFillNewHRProcessForm();
        //step.logoutFromHrm();
    }

    public static void newCZ_HPPProcess() throws Exception {
        AbstractWorkTestStep step = new AbstractWorkTestStep();
        newFullTimePersonHRProcess();
        step.generateAndStartCzHppWf();
    }
}
