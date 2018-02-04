package webtest.work.worksmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.PropertiesData;

public class LoginPage extends AbstractWorkPage {

    private static final String NICKNAME_FIELD_NAME = "login";
    private static final String PASSWORD_FIELD_NAME = "heslo";
    private static final String LOGIN_BUTTON_CLASSNAME = "login-buttons";
    private static final String HOME_LOGO_CLASSNAME = "logo-lg";

    @Override
    public boolean isOpen() { return isElementPresent(By.name(NICKNAME_FIELD_NAME)); }

    public void login() {
        setText(getNicknameFieldElement(), PropertiesData.getUsername());
        setText(getPasswordFieldElement(), PropertiesData.getPassword());
        performClick(getLoginButtonElement());
    }

    private WebElement getNicknameFieldElement() { return findElementByName(NICKNAME_FIELD_NAME); }

    private WebElement getPasswordFieldElement() { return findElementByName(PASSWORD_FIELD_NAME); }

    private WebElement getLoginButtonElement() { return findElementByClassName(LOGIN_BUTTON_CLASSNAME); }

    public boolean isUserLogged() { return isElementPresent(By.className(HOME_LOGO_CLASSNAME)); }
}
