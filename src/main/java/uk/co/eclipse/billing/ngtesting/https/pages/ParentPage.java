package uk.co.eclipse.billing.ngtesting.https.pages;

import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uk.co.eclipse.billing.ngtesting.https.libs.*;

import java.io.IOException;


public class ParentPage{
    WebDriver webDriver;
    Logger logger;
    ActionsWithOurElements actionWithOurElements;
    WorkWithUploadWindow workWithUploadWindow;
    DataBaseData dataBaseData;
    Utils utils;
    RobotKeyEvents robotKeyEvents;
    String baseURL;
    String pathToCDRFolder;

    public ParentPage(WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionWithOurElements = new ActionsWithOurElements(webDriver);
        workWithUploadWindow = new WorkWithUploadWindow();
        dataBaseData = new DataBaseData(webDriver);
        utils = new Utils();
        robotKeyEvents = new RobotKeyEvents(webDriver);

        PageFactory.initElements(webDriver, this);
        baseURL = ConfigData.getCfgValue("BASE_URL");
        pathToCDRFolder = ConfigData.getCfgValue("CDR_FOLDER_PATH");
    }

    public void open(String shortUrl){
            try{
                webDriver.get(baseURL+shortUrl);
                logger.info("Page was opened: " + baseURL+shortUrl);
            }
            catch (Exception e){
                logger.error("Page can't be opened " + baseURL+shortUrl);
                utils.myAssertFail("Page can't be opened " + baseURL+shortUrl);
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
