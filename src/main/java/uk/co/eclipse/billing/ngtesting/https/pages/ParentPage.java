package uk.co.eclipse.billing.ngtesting.https.pages;

import org.apache.log4j.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uk.co.eclipse.billing.ngtesting.https.libs.ActionsWithOurElements;
import uk.co.eclipse.billing.ngtesting.https.libs.WorkWithUploadWindow;

import static org.hamcrest.core.Is.is;

public class ParentPage{
    WebDriver webDriver;
    Logger logger;
    ActionsWithOurElements actionWithOurElements;
    WorkWithUploadWindow workWithUploadWindow;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionWithOurElements = new ActionsWithOurElements(webDriver);
        workWithUploadWindow = new WorkWithUploadWindow(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void open(String url){
            try{
                webDriver.get(url);
                logger.info("Page was opened: " + url);
            }
            catch (Exception e){
                logger.error("Page can't be opened " + url);
                Assert.fail("Page can't be opened " + url);
            }
    }
}
