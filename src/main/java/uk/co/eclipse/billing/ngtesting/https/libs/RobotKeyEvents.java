package uk.co.eclipse.billing.ngtesting.https.libs;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.W32APIOptions;
import org.junit.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotKeyEvents {
    Logger logger;
    Robot robot;
    WebDriver webDriver;

    public RobotKeyEvents(WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            logger.error("Unable to create Robot object because: " + e);
            Assert.fail("Unable to create Robot object because: " + e);
        }
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
        wait3Second();
        User32 user32 = User32.instance;
        WinDef.HWND hWnd = user32.FindWindow(null, "Open");
        user32.ShowWindow(hWnd, User32.SW_SHOW);
        user32.SetForegroundWindow(hWnd);
        user32.SetFocus(hWnd);
        logger.info("Active window is set up");
    }

    public void typeText(String string){
        try {
            wait3Second();
            SetActiveWindow();
            wait3Second();
                for (int i = 0; i < string.length(); i++)
                    {
                        char character = string.charAt(i);
                        typeCharacter(character);
                        waitABit(400);
                    }
            wait3Second();
            logger.info(string + " have been entered");
            pressEnterButton();
            wait3Second();
        } catch (Exception e) {
            logger.error("Can't type text: '" + string + " because: " + e);
            Assert.fail("Can't type text: '" + string + " because: " + e);
        }
    }

    private void waitABit(int timeMS) {
        robot.delay(timeMS);
    }

    private void wait3Second()
    {
        waitABit(3000);
    }

    public void pressEnterButton()
    {
        try{
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            logger.info("Enter button has been pressed");

        }
        catch (Exception e) {
            logger.error("Can't press Enter button because: " + e);
            Assert.fail("Can't press Enter button because: " + e);
        }
    }

    public void typeCharacter(char character)
    {
        switch (character) {
            case 'a': doType(KeyEvent.VK_A); break;
            case 'b': doType(KeyEvent.VK_B); break;
            case 'c': doType(KeyEvent.VK_C); break;
            case 'd': doType(KeyEvent.VK_D); break;
            case 'e': doType(KeyEvent.VK_E); break;
            case 'f': doType(KeyEvent.VK_F); break;
            case 'g': doType(KeyEvent.VK_G); break;
            case 'h': doType(KeyEvent.VK_H); break;
            case 'i': doType(KeyEvent.VK_I); break;
            case 'j': doType(KeyEvent.VK_J); break;
            case 'k': doType(KeyEvent.VK_K); break;
            case 'l': doType(KeyEvent.VK_L); break;
            case 'm': doType(KeyEvent.VK_M); break;
            case 'n': doType(KeyEvent.VK_N); break;
            case 'o': doType(KeyEvent.VK_O); break;
            case 'p': doType(KeyEvent.VK_P); break;
            case 'q': doType(KeyEvent.VK_Q); break;
            case 'r': doType(KeyEvent.VK_R); break;
            case 's': doType(KeyEvent.VK_S); break;
            case 't': doType(KeyEvent.VK_T); break;
            case 'u': doType(KeyEvent.VK_U); break;
            case 'v': doType(KeyEvent.VK_V); break;
            case 'w': doType(KeyEvent.VK_W); break;
            case 'x': doType(KeyEvent.VK_X); break;
            case 'y': doType(KeyEvent.VK_Y); break;
            case 'z': doType(KeyEvent.VK_Z); break;
            case 'A': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_A); break;
            case 'B': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_B); break;
            case 'C': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_C); break;
            case 'D': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_D); break;
            case 'E': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_E); break;
            case 'F': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_F); break;
            case 'G': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_G); break;
            case 'H': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_H); break;
            case 'I': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_I); break;
            case 'J': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_J); break;
            case 'K': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_K); break;
            case 'L': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_L); break;
            case 'M': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_M); break;
            case 'N': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_N); break;
            case 'O': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_O); break;
            case 'P': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_P); break;
            case 'Q': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Q); break;
            case 'R': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_R); break;
            case 'S': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_S); break;
            case 'T': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_T); break;
            case 'U': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_U); break;
            case 'V': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_V); break;
            case 'W': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_W); break;
            case 'X': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_X); break;
            case 'Y': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Y); break;
            case 'Z': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Z); break;
            case '`': doType(KeyEvent.VK_BACK_QUOTE); break;
            case '0': doType(KeyEvent.VK_0); break;
            case '1': doType(KeyEvent.VK_1); break;
            case '2': doType(KeyEvent.VK_2); break;
            case '3': doType(KeyEvent.VK_3); break;
            case '4': doType(KeyEvent.VK_4); break;
            case '5': doType(KeyEvent.VK_5); break;
            case '6': doType(KeyEvent.VK_6); break;
            case '7': doType(KeyEvent.VK_7); break;
            case '8': doType(KeyEvent.VK_8); break;
            case '9': doType(KeyEvent.VK_9); break;
            case '-': doType(KeyEvent.VK_MINUS); break;
            case '=': doType(KeyEvent.VK_EQUALS); break;
            case '~': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE); break;
            case '!': doType(KeyEvent.VK_EXCLAMATION_MARK); break;
            case '@': doType(KeyEvent.VK_AT); break;
            case '#': doType(KeyEvent.VK_NUMBER_SIGN); break;
            case '$': doType(KeyEvent.VK_DOLLAR); break;
            case '%': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_5); break;
            case '^': doType(KeyEvent.VK_CIRCUMFLEX); break;
            case '&': doType(KeyEvent.VK_AMPERSAND); break;
            case '*': doType(KeyEvent.VK_ASTERISK); break;
            case '(': doType(KeyEvent.VK_LEFT_PARENTHESIS); break;
            case ')': doType(KeyEvent.VK_RIGHT_PARENTHESIS); break;
            case '_': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_MINUS); break;
            case '+': doType(KeyEvent.VK_PLUS); break;
            case '\t': doType(KeyEvent.VK_TAB); break;
            case '\n': doType(KeyEvent.VK_ENTER); break;
            case '[': doType(KeyEvent.VK_OPEN_BRACKET); break;
            case ']': doType(KeyEvent.VK_CLOSE_BRACKET); break;
            case '\\': doType(KeyEvent.VK_BACK_SLASH); break;
            case '{': doType(KeyEvent.VK_SHIFT, KeyEvent. VK_OPEN_BRACKET); break;
            case '}': doType(KeyEvent.VK_SHIFT, KeyEvent. VK_CLOSE_BRACKET); break;
            case '|': doType(KeyEvent.VK_SHIFT, KeyEvent. VK_BACK_SLASH); break;
            case ';': doType(KeyEvent.VK_SEMICOLON); break;
            case ':': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_SEMICOLON); break;
            case '\'': doType(KeyEvent.VK_QUOTE); break;
            case '"': doType(KeyEvent.VK_QUOTEDBL); break;
            case ',': doType(KeyEvent.VK_COMMA); break;
            case '<': doType(KeyEvent.VK_LESS); break;
            case '.': doType(KeyEvent.VK_PERIOD); break;
            case '>': doType(KeyEvent.VK_GREATER); break;
            case '/': doType(KeyEvent.VK_SLASH); break;
            case '?': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH); break;
            case ' ': doType(KeyEvent.VK_SPACE); break;
            default:
                throw new IllegalArgumentException("Cannot type character: " + character);
        }
    }

    private void doType(int keyCode)
    {
        try
        {
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
        catch(Exception e)
        {
            logger.error("Invalid key code(s) for character because: " + e);
            Assert.fail("Invalid key code(s) for character because: " + e);
        }
    }

    private void doType(int keyCode1, int keyCode2)
    {
        try
        {
            robot.keyPress(keyCode1);
            robot.keyPress(keyCode2);
            robot.keyRelease(keyCode2);
            robot.keyRelease(keyCode1);
        }
        catch(Exception e)
        {
            logger.error("Invalid key code(s) for character because: " + e);
            Assert.fail("Invalid key code(s) for character because: " + e);
        }
    }

}
