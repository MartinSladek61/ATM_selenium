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
    /*public void closeDriver() {
        AbstractWorkTest.logout();
        DriverSettings.getDriver().close();
    }*/

    @Test
    public void ISW_364() throws Exception { AbstractWorkTest.newFullTimePersonHRProcess(); }

    @Test
    public void ISW_378() throws  Exception{AbstractWorkTest.newCZ_HPPProcess();}
}
