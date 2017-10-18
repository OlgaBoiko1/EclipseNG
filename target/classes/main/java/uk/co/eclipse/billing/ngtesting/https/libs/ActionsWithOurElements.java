package uk.co.eclipse.billing.ngtesting.https.libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }


}
