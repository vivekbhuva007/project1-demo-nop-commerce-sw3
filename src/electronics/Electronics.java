package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.UtilityMain;

public class Electronics  extends UtilityMain {


    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }



@Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){

    //Mouse Hover on “Electronics”Tab
    mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

    //Mouse Hover on “Cell phones” and click
    mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
    clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul[1]/li[2]"));

    // Verify the text “Cell phones”
    assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");

    //




}
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException{



        //  2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //  2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));


        //  2.3 Verify the text “Cell phones”
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");

        // 	2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));

        // 2.5 Click on product name “Nokia Lumia 1020” link

        Thread.sleep(2000);
        clickOnElement(By.linkText("Nokia Lumia 1020"));

        //2.6 Verify the text “Nokia Lumia 1020
        assertVerifyText(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020");
        Thread.sleep(2000);

        //2.7 Verify the price “$349.00”
        assertVerifyText(By.xpath("//span[@id='price-value-20']"), "$349.00");
      //  2.8 Change quantity to 2
        Actions action = new Actions(driver);
        clickOnElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");




      //  2.9 Click on “ADD TO CART” tab

        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
       // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green bar
        assertVerifyText(By.xpath("//div[@id='bar-notification']/div/p"), "The product has been added to your shopping cart");

      //  After that close the bar clicking on the cross button.
        Thread.sleep(1000);
        clickOnElement(By.cssSelector("span.close"));

      //  2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHoverToElementAndClick(By.xpath("//li[@id='topcartlink']/a/span[1]"));
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        //	2.12 Verify the message "Shopping cart"
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //2.13
       WebElement text= driver.findElement(By.xpath("//input[@class=\"qty-input\"]"));
        String qty=text.getAttribute("value");
        Assert.assertEquals("","2",qty);

        // 2.14 Verify the total $698.00
        assertVerifyText(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"),"$698.00");

        //  2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //  2.16 Click on checkout
        clickOnElement(By.id("checkout"));

        //  2.17 Verify the Text “Welcome, Please Sign In!”
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        // 	2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[@onclick='location.href=\"https://demo.nopcommerce.com/register?returnUrl=%2Fcart\"']"));

        //	2.19 Verify the text “Register”
        assertVerifyText(By.xpath("//h1[contains(text(),'Register')]"), "Register");

        //	2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElement(By.id("FirstName"), "abc");
        sendTextToElement(By.id("LastName"), "abc123");

        selectByValueFromDropdown(By.xpath("//select[@name='DateOfBirthDay']"), "4");
        //clickOnElement(By.xpath("//select[@name='DateOfBirthDay']"));
        selectByValueFromDropdown(By.xpath("//select[@name='DateOfBirthMonth']"), "April");
        selectByValueFromDropdown(By.xpath("//select[@name='DateOfBirthYear']"), "1998");

        sendTextToElement(By.id("Email"), "vivendra122@gmail.com");
        sendTextToElement(By.id("Password"), "885522");
        sendTextToElement(By.id("ConfirmPassword"), "885522");

        //	2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));

        //	2.22 Verify the message “Your registration completed”
        assertVerifyText(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");

        //	2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //	2.24 Verify the text “Shopping cart”
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //	2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //	2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //	2.27 Fill the Mandatory fields
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "vivendra");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "vaghani");
        clickOnElement(By.id("BillingNewAddress_CountryId"));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        clickOnElement(By.id("BillingNewAddress_StateProvinceId"));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "Other");
        sendTextToElement(By.id("BillingNewAddress_City"), "london");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "007 street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "RO4 R74");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "9854238724");

        //	2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[text() = 'Continue']"));

        //	2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //  2.30 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

        //  2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']")); //credit card

        clickOnElement(By.xpath("//div[@id='checkout-step-payment-method']/div/button"));//continue

        //  2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");

        //  2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "abc");
        sendTextToElement(By.id("CardNumber"), "5232 1478 4876 3353");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "02");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2024");
        sendTextToElement(By.id("CardCode"), "000");

        //  2.34 Click on “CONTINUE”CHECKOUT”
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));

        //  2.35 Verify “Payment Method” is “Credit Card”
        assertVerifyText(By.xpath("//li[@class='payment-method']/span[2]"), "Credit Card");

        //  2.36 Verify “Shipping Method” is “2nd Day Air”
        assertVerifyText(By.xpath("//li[@class='shipping-method']/span[2]"), "2nd Day Air");

        //	2.37 Verify Total is “$698.00”
        assertVerifyText(By.xpath("//td[@class='subtotal']/span"), "$698.00");

        //	2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[text()='Confirm']"));

        //	2.39 Verify the Text “Thank You”
        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //	2.40 Verify the message “Your order has been successfully processed!”
        assertVerifyText(By.xpath("//div[@class='section order-completed']//strong"), "Your order has been successfully processed!");

        //	2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //  2.42 Verify the text “Welcome to our store”
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

        //  2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //  2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/", url);












    }
   // public tearDown(){
     //   closeBrowser();
    }

