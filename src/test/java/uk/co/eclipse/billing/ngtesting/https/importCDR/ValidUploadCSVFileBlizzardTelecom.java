package uk.co.eclipse.billing.ngtesting.https.importCDR;

import org.junit.Test;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

public class ValidUploadCSVFileBlizzardTelecom extends Parent{

    @Test
    public void validUploadCSVFileBlizzardTelecom(){
        loginPage.loginUser("olga", "olga", "");
        homePage.clickOnMenuBilling();
        homePage.clickOnMenuCallDataManager();
        homePage.clickOnMenuImportCDR();
        checkAC("Header is not correct",importCDRPage.isHeaderCorrect(), true);
        importCDRPage.clickOnButtonSelectCDRFile();
        checkAC("Select File screen is not displayed",importCDRPage.isSelectFileScreenDisplayed(), true);
        importCDRPage.clickOnButtonSelectFileScreenUpload();
        checkAC("Upload screen is not displayed",importCDRPage.isUploadScreenDisplayed(), true);
        importCDRPage.mouseHoverAndClickOnButtonSelect();
        importCDRPage.selectFileByPath();
        checkAC("File name is not displayed on Upload screen",importCDRPage.isFileNameDisplayedOnUploadScreen(), true);
        importCDRPage.clickOnButtonUpload();
        checkAC("File name is not displayed on Select File screen",importCDRPage.isFileNameDisplayedOnSelectFileScreen(), true);
        importCDRPage.selectFilterInDDByText("Blizzard Telecom (Union Str. aBILLity)");
        importCDRPage.doubleClickOnFileIcon();
        checkAC("Select File screen is not closed",importCDRPage.isSelectFileScreenDisplayed(), false);
        checkAC("File is not uploaded",importCDRPage.isFileNameDisplayedOnImportCDRScreen(), true);
        checkAC("Filter name is not correct",importCDRPage.isFilterNameCorrect("Blizzard Telecom (Union Str. aBILLity)"), true);
        checkAC("Imported flag is not correct",importCDRPage.isImportedFlagCorrect("No"), true);
        checkAC("Protected flag is not correct",importCDRPage.isProtectedFlagCorrect("No"), true);
        checkAC("Edit button is not present for the file",importCDRPage.isEditButtonPresentForFile(), true);
    }
}
