package sacucedemo.LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.LoginPage.LoginPage;
import Utilities.DriverFactory;
import java.io.IOException;

public class LoginPageTest {

 WebDriver driver= DriverFactory.getDriver();
    @Test(dataProvider = "DataProvider")
    public void verifyLoginPage (String username,String password) throws IOException {
        driver.get("https://www.saucedemo.com/");
        LoginPage l = new LoginPage();
        l.login(username, password);
        WebElement msg=driver.findElement(By.xpath("//form/h3"));
        String text=msg.getText();
        String expectedText = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(text,expectedText);
    }
    @DataProvider(name = "DataProvider")

    public static Object[][] dataProviderMethod(){

        return new Object[][] { { "locked_out_user","secret_sauce" }};
    }
}


