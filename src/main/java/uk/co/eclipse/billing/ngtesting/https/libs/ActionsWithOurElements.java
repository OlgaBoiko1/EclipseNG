package uk.co.eclipse.billing.ngtesting.https.libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;

    public ActionsWithOurElements(WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver, 15);
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

}
