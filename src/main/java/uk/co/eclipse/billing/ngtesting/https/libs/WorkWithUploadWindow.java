package uk.co.eclipse.billing.ngtesting.https.libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;

public class WorkWithUploadWindow {
    WebDriver webDriver;
    Logger logger;
    Robot robot;

    public WorkWithUploadWindow(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }
    //Enter path to CDR
    public void enterPathToCDRFolder(){
        try{
            setClipboardData("C:\\Upload\\cdr");
            robot = new Robot();
            robot.delay(4000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(4000);
            pressEnterButton();
            robot.delay(3000);
        }
        catch (AWTException exception){
            logger.error("Can't enter path to CDR folder" + exception);
            Assert.fail("Can't enter path to CDR folder" + exception);
        }
    }
//        try{
//            robot = new Robot();
//            robot.delay(1000);
//            robot.keyPress(KeyEvent.VK_C);
//            robot.keyRelease(KeyEvent.VK_C);
//            robot.delay(1000);
//            robot.keyPress(KeyEvent.VK_SHIFT);
//            robot.keyPress(KeyEvent.VK_SEMICOLON);
//            robot.keyRelease(KeyEvent.VK_SEMICOLON);
//            robot.keyRelease(KeyEvent.VK_SHIFT);
//            robot.keyPress(KeyEvent.VK_BACK_SLASH);
//            robot.keyPress(KeyEvent.VK_BACK_SLASH);
//            robot.delay(1000);
////            robot.keyPress(KeyEvent.VK_ENTER);
////            robot.keyRelease(KeyEvent.VK_ENTER);
//            robot.delay(6000);
//            robot.keyPress(KeyEvent.VK_U);
//            robot.keyRelease(KeyEvent.VK_U);
//            robot.keyPress(KeyEvent.VK_P);
//            robot.keyRelease(KeyEvent.VK_P);
//            robot.keyPress(KeyEvent.VK_L);
//            robot.keyRelease(KeyEvent.VK_L);
//            robot.keyPress(KeyEvent.VK_O);
//            robot.keyRelease(KeyEvent.VK_O);
//            robot.keyPress(KeyEvent.VK_A);
//            robot.keyRelease(KeyEvent.VK_A);
//            robot.keyPress(KeyEvent.VK_D);
//            robot.keyRelease(KeyEvent.VK_D);
//            robot.keyPress(KeyEvent.VK_BACK_SLASH);
//            robot.keyPress(KeyEvent.VK_BACK_SLASH);
//            robot.delay(1000);
////            robot.delay(500);
////            robot.keyPress(KeyEvent.VK_ENTER);
////            robot.keyRelease(KeyEvent.VK_ENTER);
//            robot.delay(3000);
//            robot.keyPress(KeyEvent.VK_C);
//            robot.keyRelease(KeyEvent.VK_C);
//            robot.keyPress(KeyEvent.VK_D);
//            robot.keyRelease(KeyEvent.VK_D);
//            robot.keyPress(KeyEvent.VK_R);
//            robot.keyRelease(KeyEvent.VK_R);
//            robot.delay(500);
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//            robot.delay(3000);
//        }
//        catch (AWTException exception){
//            logger.error("Can't enter path to CDR folder" + exception);
//            Assert.fail("Can't enter path to CDR folder" + exception);
//        }
//    }

    public void pressEnterButton()
    {
        try{
            robot.keyPress(KeyEvent.VK_ENTER);
            logger.info("Enter button has been pressed");

        }
        catch (Exception e) {
            logger.error("Can't press Enter button because: " + e);
            Assert.fail("Can't press Enter button because: " + e);
        }
    }
    //Enter file 1BT.csv
    public void enterFileNameCSVBlizzardTelecom(){
        try{
            robot = new Robot();
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);
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
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        }
        catch (AWTException exception){
            logger.error("Can't enter file name" + exception);
            Assert.fail("Can't enter file name" + exception);
        }
    }

    //Enter file 1GammaWLR.txt
    public void enterFileNameTXTGammaWLR(){
        try{
            robot = new Robot();
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_NUMPAD1);
            robot.keyRelease(KeyEvent.VK_NUMPAD1);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_G);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_M);
            robot.keyPress(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_M);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_W);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
            robot.keyPress(KeyEvent.VK_PERIOD);
            robot.keyRelease(KeyEvent.VK_PERIOD);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);
            robot.keyPress(KeyEvent.VK_X);
            robot.keyRelease(KeyEvent.VK_X);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        }
        catch (AWTException exception){
            logger.error("Can't enter file name" + exception);
            Assert.fail("Can't enter file name" + exception);
        }
    }

    //Enter file 1CDR.zip
    public void enterFileNameZIPFile() {
        try{
            robot = new Robot();
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
            robot.keyPress(KeyEvent.VK_PERIOD);
            robot.keyRelease(KeyEvent.VK_PERIOD);
            robot.keyPress(KeyEvent.VK_Z);
            robot.keyRelease(KeyEvent.VK_Z);
            robot.keyPress(KeyEvent.VK_I);
            robot.keyRelease(KeyEvent.VK_I);
            robot.keyPress(KeyEvent.VK_P);
            robot.keyRelease(KeyEvent.VK_P);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        }
        catch(AWTException exception){
            logger.error("Can't enter file name" + exception);
            Assert.fail("Can't enter file name" + exception);
        }
    }

//    public void enterFileNameZIPFile(CharSequence characters)
//    {}


}
