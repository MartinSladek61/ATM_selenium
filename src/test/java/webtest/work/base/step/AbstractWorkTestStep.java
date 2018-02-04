package webtest.work.base.step;

import webtest.work.worksmoke.LoginPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AbstractWorkTestStep {

    public void login() {
        LoginPage loginPage = new LoginPage();
        assertTrue(loginPage.isOpen(), "Login page doesn't open correctly.");
        loginPage.login();
        assertTrue(loginPage.isUserLogged(), "User isn't logged correctly.");
    }
}
