package utility;
import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UtilityMain extends BaseTest{

    public void clickOnElement(By by) {
      //  WebElement loginLink = driver.findElement(by);
       // WebElement loginlink = driver.findElement(By.name(""))
       // loginlink.click();
        driver.findElement(by).click();
    }


   // this method will insert text
    public void sendTextToElement(By by, String text) {
         driver.findElement(by).sendKeys(text);




    }
    //This method verify the expected text
    public void assertVerifyText(By by, String expectedtext) {
        String actualText = getTextFromElement(by);
        String expectedText = expectedtext;
        Assert.assertEquals("Error has occurred --->  Test failed : ", expectedText, actualText);
    }
    //
    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
   // ===================================================Alert method===================

    // This method will switch to alert
    public void switchToAlert(){
        driver.switchTo().alert();


    }
    // This method will accept alert
    public void acceptAlert(){
        driver.switchTo().alert().accept();

    }
    // this method will get text from alert
    public  String getTextFromAlert() {
        return driver.switchTo().alert().getText();

    }

    // this method will dismiss alert
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();

    }
   //  this method wii send text to alert
    public void sendTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);

    }


    //Homework 4 methods acceptAlert,dismissAlert,  String getTextFromAlert, sendTextToAlert(String text)

//************************ Select class methods*******************

    // this method will select options by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
      // homework 3 method
    /**
     * This method will select the option by value
     */
    public void selectByValueFromDropdown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(value);
    }



        /**
         * This method will select the option by index
         */
        public void selectByIndexFromDropDown(By by, int index) {
            WebElement dropDown = driver.findElement(by);
            Select select = new Select(dropDown);
            select.selectByIndex(index);
        }


    /**
     * This method will select the option by contains text
     */
    public void selectByContainTextFromDropdown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
         selectByContainTextFromDropdown(by, text);
    }


  //===========================================mouse hover=====================================================
    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        WebElement mouseHover= driver.findElement(by);
        actions.moveToElement(mouseHover).build().perform();

    }
    public void mouseHoverToElementAndClick(By by){
        Actions actions = new Actions(driver);
        WebElement mouseHoveAndClick = driver.findElement(by);
        actions.moveToElement(mouseHoveAndClick).click().build().perform();

    }
    public void clearQuantityFromBox(By by,String text) {
        Actions action = new Actions(driver);
        WebElement qty =driver.findElement(by);
        qty.clear();
        qty.clear();
        qty.sendKeys(text);

    }





    }
