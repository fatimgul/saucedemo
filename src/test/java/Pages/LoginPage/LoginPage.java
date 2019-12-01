package Pages.LoginPage;

import Utilities.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){PageFactory.initElements(DriverFactory.getDriver(),this);}
    @FindBy(id = "user-name")
    @CacheLookup
    public WebElement userNameElement;

    @FindBy(id = "password")
    @CacheLookup
    public WebElement passwordElement;

    @FindBy(className="btn_action")
    public WebElement loginButtonElement;

    public void login(String username, String password){
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }


}

