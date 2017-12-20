package uk.co.eclipse.billing.ngtesting.https.parent;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import uk.co.eclipse.billing.ngtesting.https.libs.DataBaseData;
import uk.co.eclipse.billing.ngtesting.https.libs.Utils;
import uk.co.eclipse.billing.ngtesting.https.pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

public class Parent {
    public WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    private Utils utils = new Utils();
    private String pathToScreenshot;
    private boolean isTestPass = false;
    private boolean isScreenshotTaken = false;

    //initialize all pages
    public LoginPage loginPage;
    public HomePage homePage;
    public ImportCDRPage importCDRPage;
    public ParentPage parentPage;
    public DataBaseData dataBaseData;

    public Parent() {
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        File file = new File("");
        File fileFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        pathToScreenshot = file.getAbsolutePath() + "\\target\\screenshots\\" + this.getClass().getPackage().getName()
                + "\\" + this.getClass().getSimpleName() + "\\"
                + this.testName.getMethodName() + "_" + "Chrome" + ".jpg";
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        importCDRPage = new ImportCDRPage(webDriver);
        dataBaseData = new DataBaseData(webDriver);
        parentPage = new ParentPage(webDriver);
    }

    @After
    public void tearDown() {
        if (!(webDriver == null)) {
            if (!isTestPass && !isScreenshotTaken) {
                utils.screenShot(pathToScreenshot);
            }
            webDriver.quit();
        }
    }


    public void checkAC(String message, boolean actualResult, boolean expectedResult) {
        if (!(actualResult == expectedResult)) {
            utils.screenShot(pathToScreenshot);
            isScreenshotTaken = true;
            logger.error("AC failed: " + message + " Browser = " + "Chrome.");
        }
        else setTestPass();
        Assert.assertThat(message + ". Browser = " + "Chrome. " + "ScreenShot: " + pathToScreenshot, actualResult, is(expectedResult));
    }

    private void setTestPass(){
        isTestPass = true;
    }
}
