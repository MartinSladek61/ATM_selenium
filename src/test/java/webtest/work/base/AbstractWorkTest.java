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
     * Declares new person in WORK FLOW
     */
    public static void newPerson() {
        AbstractWorkTestStep step = new AbstractWorkTestStep();
        step.goToHrm();
        step.goToWorkFlow();
        step.logoutFromHrm();
    }
}
