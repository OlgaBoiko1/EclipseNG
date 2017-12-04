package uk.co.eclipse.billing.ngtesting.https.importCDR;

import org.junit.Test;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

public class ValidUploadCSVFileBlizzardTelecom extends Parent{

    @Test
    public void validUploadCSVFileBlizzardTelecom(){
        loginPage.loginUser("olga", "olga", "");
        homePage.navigateToMenuImportCDR();
        importCDRPage.clickOnButtonSelectCDRFile();
        checkAC("Select File screen is not displayed",importCDRPage.isSelectFileScreenDisplayed(), true);
        if (!importCDRPage.isFileNameDisplayedOnSelectFileScreen("1BT.csv")) {
            importCDRPage.clickOnButtonSelectFileScreenUpload();
            checkAC("Upload screen is not displayed", importCDRPage.isUploadScreenDisplayed(), true);
            importCDRPage.mouseHoverAndClickOnButtonSelect();
            importCDRPage.selectCSVFileBlizzardTelecom();
            checkAC("File name is not displayed on Upload screen", importCDRPage.isFileNameDisplayedOnUploadScreen("1BT.csv"), true);
            importCDRPage.clickOnButtonUpload();
            checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen("1BT.csv"), true);
        }
        importCDRPage.selectFilterInDDByText("Blizzard Telecom (Union Str. aBILLity)");
        importCDRPage.doubleClickOnFileIcon("1BT.csv");
        checkAC("Select File screen is not closed",importCDRPage.isSelectFileScreenDisplayed(), false);
        checkAC("File is not uploaded",importCDRPage.isFileNameDisplayedOnImportCDRScreen("1BT.csv"), true);
        checkAC("Filter name is not correct",importCDRPage.isFilterNameCorrect("1BT.csv","Blizzard Telecom (Union Str. aBILLity)"), true);
        checkAC("Imported flag is not correct",importCDRPage.isImportedFlagCorrect("1BT.csv","No"), true);
        checkAC("Protected flag is not correct",importCDRPage.isProtectedFlagCorrect("1BT.csv","No"), true);
        checkAC("Edit button is not present for the file",importCDRPage.isEditButtonPresentForFile("1BT.csv"), true);
    }
}
