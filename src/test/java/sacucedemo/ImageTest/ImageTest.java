package sacucedemo.ImageTest;

import Pages.LoginPage.LoginPage;
import Pages.PurchasePage.PurchasePage;
import Utilities.ConfigurationReader;
import Utilities.DriverFactory;
import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;


public class ImageTest extends TestBase {
      LoginPage loginPage=new LoginPage();
      PurchasePage purchasePage=new PurchasePage();
      String username= ConfigurationReader.getProperty("userName");
      String password=ConfigurationReader.getProperty("password");
      WebDriver driver= DriverFactory.getDriver();

    @Test
    public void verifyImageLoading() throws IOException {
        SoftAssert softAssert = new SoftAssert();
       loginPage.login(username,password);
        List<WebElement> images = driver.findElements(By.tagName("img"));
        int imageLinkCount = 1;
        for(WebElement each: images){
            softAssert.assertTrue(purchasePage.verifyImageActive(each), "Checked Link" + imageLinkCount++);
        }
        softAssert.assertAll();
    }

}
