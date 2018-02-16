package uk.co.eclipse.billing.ngtesting.https.libs;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.W32APIOptions;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.awt.event.KeyEvent;

public class WorkWithUploadWindow {
    WebDriver webDriver;
    Logger logger;
    Robot robot;

    public WorkWithUploadWindow(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public interface User32 extends W32APIOptions {

        User32 instance = (User32) Native.loadLibrary("user32", User32.class, DEFAULT_OPTIONS);

        boolean ShowWindow(WinDef.HWND hWnd, int nCmdShow);

        boolean SetForegroundWindow(WinDef.HWND hWnd);

        boolean SetFocus(WinDef.HWND hWnd);

        WinDef.HWND FindWindow(String winClass, String title);

        int SW_SHOW = 1;

    }

    public void SetActiveWindow(){
        User32 user32 = User32.instance;
        WinDef.HWND hWnd = user32.FindWindow(null, "testing1 - Company - ImportCDRs");
        robot.delay(60000);
        //user32.ShowWindow(hWnd, User32.SW_SHOW);
        user32.SetFocus(hWnd);
        user32.SetForegroundWindow(hWnd);
//        char[] windowText = new char[512];
//        User32.GetWindowText(hWnd, windowText, 512);
//        String wText = Native.toString(windowText);
//        logger.info(wText);
        logger.info("Active window is set up");
    }

    //Enter path D:\Upload\cdr\
    public void enterPathToCDRFolder(){
        try{
            robot = new Robot();
            SetActiveWindow();
            robot.delay(6000);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            logger.info("Enter c letter");
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_SEMICOLON);
            robot.keyRelease(KeyEvent.VK_SEMICOLON);
            logger.info("Enter : letter");
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            logger.info("Enter button pressed");
            robot.delay(6000);
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
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        }
        catch (AWTException exception){
            logger.error("Can't enter path to CDR folder" + exception);
            Assert.fail("Can't enter path to CDR folder" + exception);
        }
    }

    //Enter file 1BT.csv
    public void enterFileNameCSVBlizzardTelecom(){
        try{
            robot = new Robot();
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

    //Enter file 1CDR.zip which contains 1BT.csv, 1DaisyAllMobile.csv, 1GammaWLR.txt
    public void enterFileNameZIPFile() {
        try{
            robot = new Robot();
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_NUMPAD1);
            robot.keyRelease(KeyEvent.VK_NUMPAD1);
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
}
