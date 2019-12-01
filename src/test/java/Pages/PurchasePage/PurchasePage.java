package Pages.PurchasePage;

import Utilities.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {
    public PurchasePage(){ PageFactory.initElements(DriverFactory.getDriver(),this);}
    @FindBy(xpath="//*[@class='inventory_container']")
    public static WebElement inventoryList;

    }

