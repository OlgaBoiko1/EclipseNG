package uk.co.eclipse.billing.ngtesting.https.libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;
    Actions actions;
    Robot robot;

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
            logger.error("Can't work with element " + element);
            Assert.fail("Can't work with element " + element);
        }
    }

    public void clickOnElement(WebElement element){
        try{
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element was clicked");
        }
        catch (Exception e){
            logger.error("Can't work with element " + element);
            Assert.fail("Can't work with element " + element);
        }
    }

    public void setPathToFile(){
        try{
            //Enter path D:\Upload\cdr\1BT.csv
            robot = new Robot();
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_SEMICOLON);
            robot.keyRelease(KeyEvent.VK_SEMICOLON);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyRelease(KeyEvent.VK_U);
            robot.keyPress(KeyEvent.VK_P);
            robot.keyRelease(KeyEvent.VK_P);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyPress(KeyEvent.VK_O);
            robot.keyRelease(KeyEvent.VK_O);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_NUMPAD1);
            robot.keyRelease(KeyEvent.VK_NUMPAD1);
            robot.keyPress(KeyEvent.VK_B);
            robot.keyRelease(KeyEvent.VK_B);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);
            robot.keyPress(KeyEvent.VK_PERIOD);
            robot.keyRelease(KeyEvent.VK_PERIOD);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        }
        catch (AWTException exception){
            logger.error("Can't enter path to file" + exception);
            Assert.fail("Can't enter path to file" + exception);
        }
    }

    public void mouseHoverAndClick(WebElement element){
        try{
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            actions.moveToElement(element);
            actions.click().build().perform();
            logger.info("Element is mouse hovered and clicked");
        }
        catch (Exception e){
            logger.error("Can't work with element " + element);
            Assert.fail("Can't work with element " + element);
        }
    }

    public boolean isElementPresent(WebElement element){
        try {
            if (element.isDisplayed()){
                logger.info("Element is present on the page");
                return true;
            }
            else return false;
        }
        catch(Exception e){
            logger.info("Element is not present on the page");
            return false;
        }
    }

    public boolean isTextCorrect(WebElement element,String text){
        try {
            if (element.getText().equals(text)){
                logger.info(text + " is correctly displayed");
                return true;
            }
            logger.info(element.getText());
            return false;
        }
        catch(Exception e){
            return false;
        }
    }

    public void selectValueInDDByText(WebElement dropDown, String text) {
        try{
            Select optionsFromDD = new Select(dropDown);
            Thread.sleep(2000);
            optionsFromDD.selectByVisibleText(text);
            logger.info(text + " is selected in drop down");
        }
        catch (Exception e){
            logger.error("Can't work with drop down");
            Assert.fail("Can't work with drop down");
        }
    }

    public void doubleClickOnElement(WebElement element) {
        try{
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            Action doubleClick = actions.doubleClick(element).build();
            doubleClick.perform();
            doubleClick.perform();
            logger.info("Element is double clicked");
            Thread.sleep(2000);
        }
        catch (Exception e){
            logger.error("Can't double click element " + element);
            Assert.fail("Can't double click element " + element);
        }
    }
}
