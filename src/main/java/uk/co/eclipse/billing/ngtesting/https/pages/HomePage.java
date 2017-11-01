package uk.co.eclipse.billing.ngtesting.https.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    private String title = "Home Page";

    @FindBy(xpath = ".//*[@id='Pageheading']/span")
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

    public boolean isHeaderCorrect(){
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
}
