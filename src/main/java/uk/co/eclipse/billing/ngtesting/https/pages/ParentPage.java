package uk.co.eclipse.billing.ngtesting.https.pages;

import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uk.co.eclipse.billing.ngtesting.https.libs.ActionsWithOurElements;
import uk.co.eclipse.billing.ngtesting.https.libs.DataBaseData;
import uk.co.eclipse.billing.ngtesting.https.libs.Utils;
import uk.co.eclipse.billing.ngtesting.https.libs.WorkWithUploadWindow;


public class ParentPage{
    WebDriver webDriver;
    Logger logger;
    ActionsWithOurElements actionWithOurElements;
    WorkWithUploadWindow workWithUploadWindow;
    DataBaseData dataBaseData;
    Utils utils = new Utils();

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionWithOurElements = new ActionsWithOurElements(webDriver);
        workWithUploadWindow = new WorkWithUploadWindow(webDriver);
        dataBaseData = new DataBaseData(webDriver);

        PageFactory.initElements(webDriver, this);
    }

    public void open(String url){
            try{
                webDriver.get(url);
                logger.info("Page was opened: " + url);
            }
            catch (Exception e){
                logger.error("Page can't be opened " + url);
                utils.myAssertFail("Page can't be opened " + url);
            }
    }

    //NG is updated if isSysUpdated field in users table is 1 for corresponding user
    public Boolean isNGUpdated(String user){
        try {
            if (dataBaseData.getIsSysUpdated(user)){
                logger.info("NG has been updated for user: "+ user);
                return true;
            }
            else {
                logger.info("NG is not updated for user: " + user);
                return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("Couldn't perform operation with DB" + e);
            utils.myAssertFail("Couldn't perform operation with DB" + e);
            return null;
        }
    }

}
