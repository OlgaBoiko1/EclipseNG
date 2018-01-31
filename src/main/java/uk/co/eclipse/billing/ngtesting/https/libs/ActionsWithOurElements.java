package uk.co.eclipse.billing.ngtesting.https.libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;
    Actions actions;

    public ActionsWithOurElements(WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver, 15);
        actions = new Actions(webDriver);
    }

    public void enterText(WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was entered");
        }
        catch (Exception e){
            logger.error("Can't work with element '" + element + "' because: " + e);
            Assert.fail("Can't work with element " + element + "' because: " + e);
        }
    }

    public void clickOnElement(WebElement element){
        try{
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element is clicked: " + element);
        }
        catch (Exception e){
            logger.error("Can't work with element " + element + "' because: " + e);
            Assert.fail("Can't work with element " + element + "' because: " + e);
        }
    }

    public void mouseHoverAndClick(WebElement element){
        try{
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            actions.moveToElement(element);
            actions.click().build().perform();
            logger.info("Element is mouse hovered and clicked: " + element);
        }
        catch (Exception e){
            logger.error("Can't work with element " + element + "' because: " + e);
            Assert.fail("Can't work with element " + element + "' because: " + e);
        }
    }

    public boolean isElementPresent(WebElement element){
        try {
            if (element.isDisplayed()){
                logger.info("Element is present on the page: " + element);
                return true;
            }
            else return false;
        }
        catch(Exception e){
            logger.error("Element is not present on the page: " + element + "' because: " + e);
            return false;
        }
    }

    public boolean isElementPresent(String xpath){
        try {
            if (webDriver.findElement(By.xpath(xpath)).isDisplayed()){
                logger.info("Element is present on the page: " + xpath);
                return true;
            }
            else return false;
        }
        catch(Exception e){
            logger.error("Element is absent on the page: " + xpath + "' because: " + e);
            return false;
        }
    }

    public boolean isElementAbsent(String xpath){
        try {
            if (webDriver.findElement(By.xpath(xpath)).isDisplayed()){
                //logger.info("Element is present on the page. It is correct. " + xpath);
                return false;
            }
            else return true;
        }
        catch(Exception e){
            //logger.info("Element is absent on the page. It is correct. " + xpath);
            return true;
        }
    }

    public boolean isElementAbsent(WebElement element){
        try {
            if (element.isDisplayed()){
                logger.error("Element is present on the page. It is incorrect. " + element);
                return false;
            }
            else return true;
        }
        catch(Exception e){
            logger.info("Element is absent on the page. It is correct. " + element);
            return true;
        }
    }

    public boolean isTextCorrect(String xpath,String text){
        try {
            WebElement element = webDriver.findElement(By.xpath(xpath));
            if (element.getText().equals(text)){
                logger.info(text + " is correctly displayed");
                return true;
            }
            logger.info(element.getText() + " is displayed for element: " + xpath);
            return false;
        }
        catch(Exception e){
            logger.error("Exception occurs: " + e);
            return false;
        }
    }

    public boolean isTextCorrect(WebElement element,String text){
        try {
            if (element.getText().equals(text)){
                logger.info(text + " text is correctly displayed");
                return true;
            }
            logger.info(element.getText() + " is displayed for element: " + element);
            return false;
        }
        catch(Exception e){
            logger.error("Exception occurs: " + e);
            return false;
        }
    }

    public void selectValueInDDByText(WebElement dropDown, String text) {
        try{
            Select optionsFromDD = new Select(dropDown);
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(dropDown));
            optionsFromDD.selectByVisibleText(text);
            logger.info(text + " is selected in drop down");
            webDriverWait15.until(ExpectedConditions.textToBePresentInElement(optionsFromDD.getFirstSelectedOption(), text));
        }
        catch (Exception e){
            logger.error("Can't work with drop down: " + dropDown);
            Assert.fail("Can't work with drop down: " + dropDown);
        }
    }

    public void doubleClickOnElementByXpath(String xpath) {
        try{
            WebElement element = webDriver.findElement(By.xpath(xpath));
            actions.moveToElement(element).click().doubleClick().perform();
            logger.info("Element is double clicked: " + element);
        }
        catch (Exception e){
            logger.error("Can't double click element: " + xpath + e);
            Assert.fail("Can't double click element" + xpath + e);
        }
    }

    public boolean isAlertAbsent() {
        try {
            webDriverWait15.until(ExpectedConditions.alertIsPresent());
            logger.info("Following alert appears: " + webDriver.switchTo().alert().getText());
            return false;
        }
            catch (Exception e) {
            return true;
        }
    }

    public void setCheckBoxToSelected(WebElement checkBox) {
        try{
            Boolean statusChechBox = checkBox.isSelected();
            if(statusChechBox){
                logger.info("CheckBox is initially checked: "+ checkBox);
            }
            else{
                webDriverWait15.until(ExpectedConditions.elementToBeClickable(checkBox));
                checkBox.click();
                logger.info("Check box is clicked: " + checkBox);
            }
        }
        catch (Exception e){
            logger.error("Can't work with element: " + checkBox);
            Assert.fail("Can't work with element: " + checkBox);
        }
    }

    public void acceptAlert() {
        webDriver.switchTo().alert().accept();
        logger.info("Accept alert");
    }
}
