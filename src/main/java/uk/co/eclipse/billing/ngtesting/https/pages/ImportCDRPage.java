package uk.co.eclipse.billing.ngtesting.https.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class ImportCDRPage extends ParentPage {

    @FindBy(xpath = ".//*[@id='ctl00_footerPlaceholder_rfeServerFiles_asyncUpload1row0']/span/span")
    private WebElement fileNameElement;

    @FindBy(xpath = ".//span[text()='Upload' and @class='rtbText']")
    private WebElement buttonSelectFileScreenUpload;

    @FindBy(xpath = ".//input[@id='ctl00_footerPlaceholder_rfeServerFiles_btnUpload_input']")
    private WebElement buttonUpload;

    @FindBy(xpath = ".//*[@id='ctl00_FunctionBarPlaceHolder_cmdShowFileSelect']/span/img")
    private WebElement buttonSelectCDRFile;

    @FindBy(id = "FileSelectPopup")
    private WebElement screenSelectFile;

    @FindBy(xpath = ".//em[@id='ctl00_footerPlaceholder_rfeServerFiles_windowManagerfileExplorerUpload_title']")
    private WebElement screenUpload;

    @FindBy(id = "footerPlaceholder_cboFiltersSvr")
    private WebElement filterDropDown;

    @FindBy(xpath = ".//*[@value='Select' and @type='button']")
    private WebElement buttonSelect;

    public ImportCDRPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonSelectCDRFile (){
        actionWithOurElements.clickOnElement(buttonSelectCDRFile);
    }

    public boolean isSelectFileScreenDisplayed() {
        return actionWithOurElements.isElementPresent(screenSelectFile);
    }

    public void clickOnButtonSelectFileScreenUpload() {
        actionWithOurElements.clickOnElement(buttonSelectFileScreenUpload);
    }

    public boolean isUploadScreenDisplayed() {
        return actionWithOurElements.isElementPresent(screenUpload);
    }

    public void mouseHoverAndClickOnButtonSelect() {
        actionWithOurElements.mouseHoverAndClick(buttonSelect);
    }

    public void enterPathToCDRFolder() {
        robotKeyEvents.typeText("c:\\Upload\\cdr");
    }

    public void enterFileName(String fileName) {
        robotKeyEvents.typeText(fileName);
    }

    public void selectTXTFileGammaWLR(){
        workWithUploadWindow.enterPathToCDRFolder();
        workWithUploadWindow.enterFileNameTXTGammaWLR();
    }

    public void selectCorrectZIPFile() {
        workWithUploadWindow.enterPathToCDRFolder();
        workWithUploadWindow.enterFileNameZIPFile();
    }

    public void clickOnButtonUpload(){
        actionWithOurElements.clickOnElement(buttonUpload);
    }

    public boolean isFileNameDisplayedOnUploadScreen(String fileName) {
        return actionWithOurElements.isTextCorrect(fileNameElement, fileName);
    }

    public boolean isFileNameDisplayedOnSelectFileScreen(String fileName) {
        return actionWithOurElements.isElementPresent(".//span[text()='"+fileName+"']");
    }

    public boolean isFileNameAbsentOnSelectFileScreen(String fileName) {
        return actionWithOurElements.isElementAbsent(".//span[text()='"+fileName+"']");
    }

    public void selectFilterInDDByText(String filterName) {
        actionWithOurElements.selectValueInDDByText(filterDropDown, filterName);
    }

    public void doubleClickOnFileIcon(String fileName) {
       actionWithOurElements.doubleClickOnElementByXpath(".//a[@title ='"+fileName+"']");
    }

    public boolean isFileNameDisplayedOnImportCDRScreen(String fileName) {
        return actionWithOurElements.isElementPresent(".//td[text()='"+fileName+"']");
    }

    public boolean isFilterNameCorrect(String fileName, String filterName) {
        return actionWithOurElements.isTextCorrect(".//td[text()='"+fileName+"']/following-sibling::td[1]",filterName);
    }

    public boolean isImportedFlagCorrect(String fileName,String ImportedFlagExpectedValue) {
        return actionWithOurElements.isTextCorrect(".//td[text()='"+fileName+"']/following-sibling::td[2]/a", ImportedFlagExpectedValue);
    }

    public boolean isProtectedFlagCorrect(String fileName, String ProtectedFlagExpectedValue) {
        return actionWithOurElements.isTextCorrect(".//td[text()='"+fileName+"']/following-sibling::td[4]",ProtectedFlagExpectedValue);
    }

    public boolean isEditButtonPresentForFile(String fileName) {
        return actionWithOurElements.isElementPresent(".//td[text()='"+fileName+"']/preceding-sibling::td[2]/a");
    }

//    public void uploadFileBlizzardTelecom(){
//        clickOnButtonSelectFileScreenUpload();
//        mouseHoverAndClickOnButtonSelect();
//        selectCSVFileBlizzardTelecom();
//        clickOnButtonUpload();
//    }
//
//    public void uploadFileGammaWLR(){
//        clickOnButtonSelectFileScreenUpload();
//        mouseHoverAndClickOnButtonSelect();
//        selectTXTFileGammaWLR();
//        clickOnButtonUpload();
//    }

    public void uploadCorrectZIPFile(){
        clickOnButtonSelectFileScreenUpload();
        mouseHoverAndClickOnButtonSelect();
        selectCorrectZIPFile();
        clickOnButtonUpload();
    }

    public boolean isAlertAbsent() {
        return actionWithOurElements.isAlertAbsent();
    }

    public void acceptAlertIfPresent(){
        if(!actionWithOurElements.isAlertAbsent()) {
            actionWithOurElements.acceptAlert();
        }
    }

}
