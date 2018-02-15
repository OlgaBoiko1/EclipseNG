package uk.co.eclipse.billing.ngtesting.https.parent;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import uk.co.eclipse.billing.ngtesting.https.libs.DataBaseData;
import uk.co.eclipse.billing.ngtesting.https.libs.Properties;
import uk.co.eclipse.billing.ngtesting.https.libs.Utils;
import uk.co.eclipse.billing.ngtesting.https.pages.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static uk.co.eclipse.billing.ngtesting.https.libs.Properties.browser;

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
    public void setUp() throws MalformedURLException {
        File file = new File("");

        if (Properties.getBrowser().equalsIgnoreCase("RemoteChrome")){
            logger.info("Chrome will be started");
            File fileFF = new File("./drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
            //webDriver = new ChromeDriver();
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
            logger.info("Chrome has been started successfully.");
            webDriver.manage().window().maximize();
        }
        if (Properties.getBrowser().equalsIgnoreCase("RemoteFF")){
            logger.info("FF will be started");
            File fileFF = new File("./drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
            //webDriver = new FirefoxDriver();
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
            logger.info("FF has been started successfully.");
            webDriver.manage().window().setSize(new Dimension(1920, 1080));
        }
        else logger.error("Browser can not be defined");

        pathToScreenshot = file.getAbsolutePath() + "\\target\\screenshots\\" + this.getClass().getPackage().getName()
                + "\\" + this.getClass().getSimpleName() + "\\"
                + this.testName.getMethodName() + "_" + Properties.getBrowser() + ".jpg";
        //webDriver.manage().window().maximize();
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
            logger.error("AC failed: " + message + ". Browser = " + Properties.getBrowser());
        }
        else setTestPass();
        Assert.assertThat(message + ". Browser = " + Properties.getBrowser() + ". ScreenShot: " + pathToScreenshot, actualResult, is(expectedResult));
    }

    private void setTestPass(){
        isTestPass = true;
    }
}
