package webtest.work.base;

import webtest.work.base.step.AbstractWorkTestStep;

public class AbstractWorkTest {

    public static void login() {
        AbstractWorkTestStep step = new AbstractWorkTestStep();
        step.login();
    }
}
