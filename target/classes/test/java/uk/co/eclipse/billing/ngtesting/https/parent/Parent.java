package uk.co.eclipse.billing.ngtesting.https.parent;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import uk.co.eclipse.billing.ngtesting.https.pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Parent {
    public WebDriver webDriver;

    public LoginPage loginPage;

    public Parent() {
    }

    @Before
    public void setUp() {
        File fileFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
