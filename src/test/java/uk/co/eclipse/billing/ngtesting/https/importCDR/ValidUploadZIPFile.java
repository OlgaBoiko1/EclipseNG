package uk.co.eclipse.billing.ngtesting.https.importCDR;

import org.junit.Test;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

public class ValidUploadZIPFile extends Parent {

    @Test
    public void validUploadZIPFile(){
        loginPage.loginUser("olga", "olga", "");
        homePage.navigateToMenuImportCDR();
        importCDRPage.clickOnButtonSelectCDRFile();
        importCDRPage.uploadCorrectZIPFile();
        checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen("1BT.csv"), true);
        checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen("1DaisyAllMobile.CSV"), true);
        checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen("1GammaWLR.txt"), true);
    }
}
