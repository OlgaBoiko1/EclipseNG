package uk.co.eclipse.billing.ngtesting.https.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    private String titleHomePage = "Home Page";
    private String titleImportCDRPage = "Import CDRs Files";

    @FindBy(xpath = ".//*[@id='Pageheading']/span")
    private WebElement headerHomePage;

    @FindBy(xpath = ".//*[@id='Pageheading']/p")
    private WebElement header;

    @FindBy (xpath = ".//span[text()='Billing']")
    private WebElement menuBilling;

    @FindBy (xpath = ".//span[text()='Call Data Manager']")
    private WebElement menuCallDataManager;

    @FindBy (xpath = ".//span[text()='Import CDR']")
    private WebElement menuImportCDR;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isHeaderPresent(){
        return actionWithOurElements.isElementPresent(header);
    }

    public boolean isHeaderHomePageCorrect(){
        return actionWithOurElements.isTextCorrect(headerHomePage, titleHomePage);
    }

    public boolean isHeaderCorrect(String title){
        return actionWithOurElements.isTextCorrect(header, title);
    }

    public void clickOnMenuBilling() {
        actionWithOurElements.clickOnElement(menuBilling);
    }

    public void clickOnMenuCallDataManager() {
        actionWithOurElements.clickOnElement(menuCallDataManager);
    }

    public void clickOnMenuImportCDR() {
        actionWithOurElements.clickOnElement(menuImportCDR);
    }

    public void navigateToMenuImportCDR() {
        clickOnMenuBilling();
        clickOnMenuCallDataManager();
        clickOnMenuImportCDR();
        Assert.assertTrue("Import CDR Page header is not correct", isHeaderCorrect(titleImportCDRPage));
    }
}
