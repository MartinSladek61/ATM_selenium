package webtest.work.base.step;

import webtest.work.base.DriverSettings;
import webtest.work.worksmoke.HrmPage;
import webtest.work.worksmoke.LoginPage;
import webtest.work.worksmoke.HomePage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AbstractWorkTestStep {

    public void login() {
        LoginPage loginPage = new LoginPage();
        assertTrue(loginPage.isOpen(), "Login page doesn't open correctly.");
        loginPage.login();
        HomePage homePage = new HomePage();
        assertTrue(homePage.isUserLogged(), "User isn't logged correctly.");
    }

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

    public void logoutFromHrm(){
        HrmPage hrmPage = new HrmPage();
        hrmPage.logoutFromHrmPage();
        HomePage homePage = new HomePage();
        homePage.logoutFromHomePage();
    }

    public void logoutFromHome(){
        HomePage homePage = new HomePage();
        homePage.logoutFromHomePage();
    }
}
