package uk.co.eclipse.billing.ngtesting.https.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImportCDRPage extends ParentPage {
    private String title = "Import CDRs Files";
    private String fileName = "1BT.csv";

    @FindBy(xpath = ".//*[@id='Pageheading']/p")
    private WebElement header;

    @FindBy(xpath = ".//td[text()='1BT.csv']/following-sibling::td[1]")
    private WebElement filterNameElement;

    @FindBy(xpath = ".//span[text()='1BT.csv']")
    private WebElement fileNameIcon;

    @FindBy(xpath = ".//*[@id='ctl00_footerPlaceholder_rfeServerFiles_asyncUpload1row0']/span/span")
    private WebElement fileNameElement;

    @FindBy(xpath = ".//td[text()='1BT.csv']")
    private WebElement fileNameText;

    @FindBy(xpath = ".//span[text()='Upload' and @class='rtbText']")
    private WebElement buttonSelectFileScreenUpload;

    @FindBy(xpath = ".//input[@id='ctl00_footerPlaceholder_rfeServerFiles_btnUpload_input']")
    private WebElement buttonUpload;

    @FindBy(xpath = ".//*[@id='ctl00_FunctionBarPlaceHolder_cmdShowFileSelect']/span/img")
    private WebElement buttonSelectCDRFile;

    @FindBy(xpath = ".//*[@id='FileSelectPopup']")
    private WebElement screenSelectFile;

    @FindBy(xpath = ".//td[text()='1BT.csv']/following-sibling::td[2]/a")
    private WebElement importedFlagElement;

    @FindBy(xpath = ".//td[text()='1BT.csv']/following-sibling::td[3]")
    private WebElement protectedFlagElement;

    @FindBy(xpath = ".//td[text()='1BT.csv']/preceding-sibling::td[2]/a")
    private WebElement editButton;

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

    public boolean isHeaderCorrect(){
        return actionWithOurElements.isTextCorrect(header, title);
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

    public void selectFileByPath() {
        actionWithOurElements.setPathToFile();
    }

    public void clickOnButtonUpload(){
        actionWithOurElements.clickOnElement(buttonUpload);
    }

    public boolean isFileNameDisplayedOnUploadScreen() {
        return actionWithOurElements.isTextCorrect(fileNameElement, fileName);
    }

    public boolean isFileNameDisplayedOnSelectFileScreen() {
        return actionWithOurElements.isElementPresent(fileNameIcon);
    }

    public void selectFilterInDDByText(String filterName) {
        actionWithOurElements.selectValueInDDByText(filterDropDown, filterName);
    }

    public void doubleClickOnFileIcon() {
        actionWithOurElements.doubleClickOnElement(fileNameIcon);
    }

    public boolean isFileNameDisplayedOnImportCDRScreen() {
        return actionWithOurElements.isElementPresent(fileNameText);
    }

    public boolean isFilterNameCorrect(String filterName) {
        return actionWithOurElements.isTextCorrect(filterNameElement,filterName);
    }

    public boolean isImportedFlagCorrect(String ImportedFlagExpectedValue) {
        return actionWithOurElements.isTextCorrect(importedFlagElement,ImportedFlagExpectedValue);
    }

    public boolean isProtectedFlagCorrect(String ProtectedFlagExpectedValue) {
        return actionWithOurElements.isTextCorrect(protectedFlagElement,ProtectedFlagExpectedValue);
    }

    public boolean isEditButtonPresentForFile() {
        return actionWithOurElements.isElementPresent(editButton);
    }
}
