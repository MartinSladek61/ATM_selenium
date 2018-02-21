package webtest.work.worksmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.DriverSettings;
import webtest.work.base.PropertiesData;

public class LoginPage extends AbstractWorkPage {

    @FindBy(name = "login") private WebElement nicknameFieldElement;
    @FindBy(name = "heslo") private WebElement passwdFieldElement;
    @FindBy(name = "login-buttons") private WebElement loginButtonElement;

    /**
     * Constructor - overrides by super
     */
    public LoginPage(){ super(); }

    /**
     * Overrides isOpen - checking if the page is loaded
     * @return boolean value
     */
    @Override
    public boolean isOpen() {
        boolean statement = isElementPresent(nicknameFieldElement);
        if(!statement){ DriverSettings.takeScreenshot(); }
        return statement;}

    /**
     * Gives login data to the form, clicks on button and performs login
     */
    public void login() {
        setText(nicknameFieldElement, PropertiesData.getUsername());
        setText(passwdFieldElement, PropertiesData.getPassword());
        performClick(loginButtonElement);
    }

}
