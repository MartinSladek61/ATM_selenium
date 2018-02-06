package webtest.work.worksmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import webtest.work.base.AbstractWorkPage;
import webtest.work.base.PropertiesData;

public class LoginPage extends AbstractWorkPage {

    @FindBy(how= How.NAME, using = "login")
    WebElement nicknameFieldElement;
    @FindBy(how= How.NAME, using = "heslo")
    WebElement passwdFieldElement;
    @FindBy(how= How.CLASS_NAME, using = "login-buttons")
    WebElement loginButtonElement;

    public LoginPage(){
        super();
    }

    @Override
    public boolean isOpen() { return isElementPresent(nicknameFieldElement); }

    public void login() {
        setText(nicknameFieldElement, PropertiesData.getUsername());
        setText(passwdFieldElement, PropertiesData.getPassword());
        performClick(loginButtonElement);
    }

}
