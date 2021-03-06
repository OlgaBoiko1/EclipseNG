package uk.co.eclipse.billing.ngtesting.https.libs;

import com.sun.jna.win32.W32APIOptions;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WorkWithUploadWindow {
    RobotKeyEvents robotKeyEvents;
    Logger logger = Logger.getLogger(getClass());
    Robot robot;

    public interface User32 extends W32APIOptions {
        User32 instance = (User32) Native.loadLibrary("user32", User32.class, DEFAULT_OPTIONS);
        boolean ShowWindow(WinDef.HWND hWnd, int nCmdShow);
        boolean SetForegroundWindow(WinDef.HWND hWnd);
        boolean SetFocus(WinDef.HWND hWnd);
        WinDef.HWND FindWindow(String winClass, String title);
        int SW_SHOW = 1;
    }

    public void SetActiveWindow(){
        User32 user32 = (User32) User32.instance;
        WinDef.HWND hWnd = user32.FindWindow(null, "Open");
        user32.ShowWindow(hWnd, User32.SW_SHOW);
        user32.SetForegroundWindow(hWnd);
        user32.SetFocus(hWnd);
        logger.info("Active window is set up");
    }

    public void enterPathToCDRFolder() {
        try {
            robot = new Robot();
            robot.delay(3000);
            SetActiveWindow();
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.delay(2000);
//            robotKeyEvents.typeText(":");
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_SEMICOLON);
            robot.keyRelease(KeyEvent.VK_SEMICOLON);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.delay(2000);
            robot.keyPress(KeyEvent.VK_BACK_SLASH);
            robot.keyRelease(KeyEvent.VK_BACK_SLASH);
            robot.delay(2000);
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
            robot.keyPress(KeyEvent.VK_BACK_SLASH);
            robot.keyRelease(KeyEvent.VK_BACK_SLASH);
            robot.delay(2000);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
            robot.delay(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        } catch (AWTException e) {
            Assert.fail("" + e);
        }
    }

    //Enter file 1CDR.zip which contains 1BT.csv, 1DaisyAllMobile.csv, 1GammaWLR.txt
    public void enterFileNameZIPFile() {
        try{
            robot = new Robot();
            SetActiveWindow();
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
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        }
        catch(AWTException exception){
            logger.error("Can't enter file name" + exception);
            Assert.fail("Can't enter file name" + exception);
        }
    }

    //Enter file 1BT.csv
    public void enterFileNameCSVBlizzardTelecom(){
        try{
            robot = new Robot();
            SetActiveWindow();
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
            robot.delay(1000);
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
            SetActiveWindow();
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
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        }
        catch (AWTException exception){
            logger.error("Can't enter file name" + exception);
            Assert.fail("Can't enter file name" + exception);
        }
    }

}
