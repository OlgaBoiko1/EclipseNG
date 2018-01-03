package uk.co.eclipse.billing.ngtesting.https.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    private String titleHomePage = "Home Page";
    private String titleImportCDRPage = "Import CDRs Files";

    @FindBy(xpath = ".//*[@id='Pageheading']/span")
    private WebElement headerHomePage;

    @FindBy(id="ctl00_ckInfo")
    private WebElement checkBoxUpdateInfo;

    @FindBy(id="ctl00_ckSetup")
    private WebElement checkBoxSetUpInfo;

    @FindBy(id="ctl00_ckPopupTest")
    private WebElement checkBoxTestPopUps;

    @FindBy(id="ctl00_ckCacheClear")
    private WebElement checkBoxClearCache;

    @FindBy(id="popSysUpdate")
    private WebElement updateScreen;

    @FindBy(xpath = ".//*[@id='Pageheading']/p")
    private WebElement header;

    @FindBy (xpath = ".//span[text()='Billing']")
    private WebElement menuBilling;

    @FindBy (xpath = ".//span[text()='Call Data Manager']")
    private WebElement menuCallDataManager;

    @FindBy (xpath = ".//span[text()='Import CDR']")
    private WebElement menuImportCDR;

    @FindBy (id = "ctl00_rbtnCloseOK_input")
    private WebElement buttonContinue;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isHeaderPresent(){
        return actionWithOurElements.isElementPresent(header);
    }

    public boolean isHeaderHomePagePresent(){
        return actionWithOurElements.isElementPresent(headerHomePage);
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
        utils.myAssertTrue("Import CDR Page header is not correct", isHeaderCorrect(titleImportCDRPage));
    }

    public boolean isUpdateScreenAbsent() {
        return actionWithOurElements.isElementAbsent(updateScreen);
    }

    public boolean isUpdateScreenDisplayed(){
        return actionWithOurElements.isElementPresent(updateScreen);
    }

    public void checkAcknowledgedForUpdateInfo(){
        actionWithOurElements.setCheckBoxToSelected(checkBoxUpdateInfo);
    }

    public void checkAcknowledgedForSetUpInfo(){
        actionWithOurElements.setCheckBoxToSelected(checkBoxSetUpInfo);
    }

    public void checkAcknowledgedForTestPopUps(){
        actionWithOurElements.setCheckBoxToSelected(checkBoxTestPopUps);
    }

    public void checkAcknowledgedForClearCache(){
        actionWithOurElements.setCheckBoxToSelected(checkBoxClearCache);
    }

    public void clickOnButtonContinue(){
        actionWithOurElements.clickOnElement(buttonContinue);
    }

    public void confirmUpdateScreenIfExistForUser(String user) {
        Boolean result = isNGUpdated(user);
        if(result) {
            utils.myAssertTrue("NG is updated but corresponding update screen doesn't appear.", isUpdateScreenDisplayed());
            //Confirm Update screen
            checkAcknowledgedForUpdateInfo();
            checkAcknowledgedForSetUpInfo();
            checkAcknowledgedForTestPopUps();
            checkAcknowledgedForClearCache();
            clickOnButtonContinue();
        }
        utils.myAssertTrue("Update screen is incorrectly displayed.", isUpdateScreenAbsent());
    }
}
