package sacucedemo.PurchaseTest;

import Pages.LoginPage.LoginPage;
import Pages.PurchasePage.PurchasePage;
import Utilities.ConfigurationReader;
import Utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends TestBase {
    PurchasePage purchasePage=new PurchasePage();
    LoginPage login=new LoginPage();
    String username= ConfigurationReader.getProperty("userName");
    String password=ConfigurationReader.getProperty("password");
    String buyingAllTshirt="T-Shirt";

    @Test
    public void buyAllTShirts(){
        login.login(username,password);
        purchasePage.buyAll(buyingAllTshirt);

        //use getText for getting THANK YOU FOR YOUR ORDER
        String successMessageResult = purchasePage.successMessage.getText();
        Assert.assertEquals(successMessageResult, "THANK YOU FOR YOUR ORDER");

    }


}
