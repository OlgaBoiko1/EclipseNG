package uk.co.eclipse.billing.ngtesting.https.importCDR;

import org.junit.Test;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;


public class ValidUploadTXTFileGammaWLR extends Parent {

    @Test
    public void validUploadTXTFileGammaWLR(){
        loginPage.loginUser("olga", "olga", "");
        homePage.navigateToMenuImportCDR();
        importCDRPage.clickOnButtonSelectCDRFile();
        checkAC("Select File screen is not displayed",importCDRPage.isSelectFileScreenDisplayed(), true);
        if (importCDRPage.isFileNameAbsentOnSelectFileScreen("1GammaWLR.txt")) {
            importCDRPage.clickOnButtonSelectFileScreenUpload();
            checkAC("Upload screen is not displayed", importCDRPage.isUploadScreenDisplayed(), true);
            importCDRPage.mouseHoverAndClickOnButtonSelect();
            importCDRPage.selectTXTFileGammaWLR();
            checkAC("File name is not displayed on Upload screen", importCDRPage.isFileNameDisplayedOnUploadScreen("1GammaWLR.txt"), true);
            importCDRPage.clickOnButtonUpload();
            checkAC("Alert shouldn't be displayed", importCDRPage.isAlertAbsent(), true);
            checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen("1GammaWLR.txt"), true);
        }
        importCDRPage.selectFilterInDDByText("Gamma WLR/WLRPPU/WLROA FCSv3");
        importCDRPage.doubleClickOnFileIcon("1GammaWLR.txt");
        checkAC("Select File screen is not closed",importCDRPage.isSelectFileScreenDisplayed(), false);
        checkAC("File is not uploaded",importCDRPage.isFileNameDisplayedOnImportCDRScreen("1GammaWLR.txt"), true);
        checkAC("Filter name is not correct",importCDRPage.isFilterNameCorrect("1GammaWLR.txt","Gamma WLR/WLRPPU/WLROA FCSv3"), true);
        checkAC("Imported flag is not correct",importCDRPage.isImportedFlagCorrect("1GammaWLR.txt","No"), true);
        checkAC("Protected flag is not correct",importCDRPage.isProtectedFlagCorrect("1GammaWLR.txt","No"), true);
        checkAC("Edit button is not present for the file",importCDRPage.isEditButtonPresentForFile("1GammaWLR.txt"), true);

    }
}
