package computer;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.UtilityMain;

import java.util.List;

public class TestSuite extends UtilityMain {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


    //1.1 selectMenu method
    @Test

    public void verifyProductArrangeInAlphaBaticalOrder(){
        //  1.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));

        //	1.2 Click on Desktop
        clickOnElement(By.xpath("//h2//a[@title='Show products in category Desktops']"));

        //	1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.id("products-orderby"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: Z to A");


    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException{
        // CLick on computer
        clickOnElement(By.linkText("Computers"));

        //
        clickOnElement(By.xpath("//h2//a[@title='Show products in category Desktops']"));

        clickOnElement(By.id("products-orderby"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: A to Z");

        // click on Add to  cart
        Thread.sleep(1000);

        clickOnElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']\n"));

        // verify the text
        String expectedMessage = "Build your own computer";

        String actualMessage=getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("",expectedMessage,actualMessage);

        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        clickOnElement(By.id("product_attribute_1"));
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
      //  2.7.Select "8GB [+$60.00]" using Select class.
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_2"));
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");


        //  2.8 Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_3_7"));


      //  2.9 Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_4_9"));

     //   2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_5_12"));

       // 2.11 Verify the price "$1,475.00"

        String expectMessage = "$1,475.00";
        String actualTextMessage = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals("",expectedMessage,actualMessage);
        Thread.sleep(1000);
      //  2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        Thread.sleep(1000);

      //  2.13 Verify the Message "The product has been added to your shopping cart" on Top green bar
        String expectMessage1 = "\"The product has been added to your shopping cart\" on Top\n" +
                "green Bar";
        String actualTextMessage1 = getTextFromElement(By.xpath("//div[@id='bar-notification']"));
        Assert.assertEquals("",expectedMessage,actualMessage);
        Thread.sleep(1000);
        // close the bar clicking on the cross button
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(1000);
        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement software = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        actions.moveToElement(computer).build().perform();
        Thread.sleep(1000);
        actions.moveToElement(software).click().build().perform();

        String expectedMessage2 = "Shopping Cart";
       String actualM = getTextFromElement(By.xpath("//div[@class='page-title']/h1[1]"));
       Assert.assertEquals("",expectedMessage,actualMessage);

     //  clickOnElement(By.xpath("//input[@class='qty-input']"));

        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@class='qty-input']"));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
   // send 2
       sendTextToElement(By.xpath("//input[@class='qty-input']"),"2");



     clickOnElement(By.id("updatecart"));

     String expectedMessage3 = "$2,950.00";
        String actualMe = getTextFromElement(By.xpath("//tr[@class='order-total']/td[2]/span[1]/strong[1]"));
       Assert.assertEquals("",expectedMessage,actualMessage);

      //  2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));
        Thread.sleep(1000);
        // 2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(1000);
        // 2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage4 = "Welcome, Please Sign In!";
        String mesasage =getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("",expectedMessage,actualMessage);

      //  2.21Click on “CHECKOUT AS GUEST”Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
     //   2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Vivendra");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"test123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"),"86,Ramnagar,Wembely");

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United Kingdom");

       sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Wembley");
       sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"86,Ramnagar,Wembely");
       sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"IA03AH");
       sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07412589631");
     sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FaxNumber']"),"54875167");
     //   2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

      //  2.25 Click on “CONTINUE”

        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button' and @onclick='ShippingMethod.save()']"));
        Thread.sleep(1000);
        //  2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@type='button' and @onclick='PaymentMethod.save()']"));

        //  2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.id("CreditCardType"));
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");

        //  2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "MR S D BHAI");
        sendTextToElement(By.id("CardNumber"), "0759 2136 2156 5987");

        clickOnElement(By.id("ExpireMonth"));
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "04");

        clickOnElement(By.id("ExpireYear"));
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2026");

        sendTextToElement(By.xpath("//input[@id='CardCode']"), "859");
        //  2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@type='button' and @onclick='PaymentInfo.save()']"));

        //  2.30 Verify “Payment Method” is “Credit Card”
        assertVerifyText(By.xpath("//span[contains(text(),'Payment Method:')]"), "Payment Method:");
        assertVerifyText(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");

        //  2.31 Verify “Shipping Method” is “Next Day Air”
        assertVerifyText(By.xpath("//span[contains(text(),'Shipping Method:')]"), "Shipping Method:");
        assertVerifyText(By.xpath("//ul//li//span[contains(text(),'Next Day Air')]"), "Next Day Air");

        //	2.32 Verify Total is “$2,950.00”
        assertVerifyText(By.xpath("//span//strong[contains(text(),'$2,950.00')]"), "$2,950.00");

        //	2.33 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@type='button' and @onclick='ConfirmOrder.save()']"));

        //	2.34 Verify the Text “Thank You”
        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //	2.35 Verify the message “Your order has been successfully processed!”
        assertVerifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),
                "Your order has been successfully processed!");

        //	2.36 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@type='button' and @onclick='setLocation(\"/\")']"));

        //  2.37 Verify the text “Welcome to our store”
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

    }



    }




