package Pages.PurchasePage;

import Pages.LoginPage.LoginPage;
import Utilities.DriverFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PurchasePage {
    WebDriver driver=DriverFactory.getDriver();
    public PurchasePage(){ PageFactory.initElements(driver,this);}

    @FindBy(id="shopping_cart_container")
    public WebElement shoppingCart;

    @FindBy(xpath=".//a[@class='btn_action checkout_button'][1]")
    public WebElement checkOutButton;

    @FindBy(id="first-name")
    public WebElement firstNameFieldID;

    @FindBy(id="last-name")
    public WebElement lastNameFieldID ;

    @FindBy(id= "postal-code")
    public WebElement postalCodeID;

    @FindBy(xpath = ".//input[@value='CONTINUE']")
    public WebElement continueButton;

    @FindBy(xpath = ".//a[@class='btn_action cart_button']")
    public WebElement finishPurchaseButton ;


    @FindBy(xpath = ".//h2[@class='complete-header']")
    public WebElement successMessage ;



    //finds items that contain string in the shopping page and returns "add to Cart" CTA Web Element buttons
    public List<WebElement> findItem(String name) {
        List<WebElement> res = new ArrayList<>();
        String itemCard="//div[@class='inventory_item']";

        for(WebElement each: driver.findElements(By.xpath(itemCard))){
            if(each.findElement(
                    By.xpath(".//div[@class='inventory_item_name']"))
                    .getText().contains(name) ){
                res.add(each.findElement(By.xpath(".//button[@class='btn_primary btn_inventory']")));
            }
        }
        return res;
    }

    public void buyAll(String itemName){
        for(WebElement each: findItem(itemName)){
            each.click();
        }
        shoppingCart.click();
        checkOutButton.click();
        //Sending some dummy data for FirstName, lastName etc part
        firstNameFieldID.sendKeys("John", Keys.TAB, "Smith", Keys.TAB, "12345", Keys.ENTER);
        finishPurchaseButton.click();

    }


    /*
       Assuming we have to check links, use this to make sure we get the correct image link
    */
    public boolean verifyImageActive(WebElement imgElement) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(imgElement.getAttribute("src"));
        HttpResponse response = client.execute(request);
        // verifying response code he HttpStatus should be 200 if not,
        // increment as invalid images count
        return response.getStatusLine().getStatusCode()==200;
    }

}




