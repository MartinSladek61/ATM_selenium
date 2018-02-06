package webtest.work.worksmoke;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webtest.work.base.DriverSettings;
import webtest.work.base.AbstractWorkTest;
import org.openqa.selenium.WebDriver;

public class WorkflowNewPersonTest {

    @BeforeMethod
    public void inicializeDriver() throws Exception{
        DriverSettings.closeAllInstancesOfChromeDriver();
        DriverSettings.inicializeDriver();
        AbstractWorkTest.login();
    }

    @AfterMethod
    //TODO logout()
    //public void closeDriver() { DriverSettings.getDriver().close(); }

    @Test
    public void goToHrm() { AbstractWorkTest.newPerson(); }
}
