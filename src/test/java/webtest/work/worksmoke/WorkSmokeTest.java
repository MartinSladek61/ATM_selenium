package webtest.work.worksmoke;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webtest.work.base.DriverSettings;
import webtest.work.base.AbstractWorkTest;

public class WorkSmokeTest {

    @BeforeMethod
    public void inicializeDriver() { DriverSettings.inicializeDriver(); }

    @AfterMethod
    public void closeDriver() { DriverSettings.getDriver().close(); }

    @Test
    public void loginToWork() { AbstractWorkTest.login() ; }
}
