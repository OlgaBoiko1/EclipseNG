package uk.co.eclipse.billing.ngtesting.https.importCDR;

import org.junit.Test;
import uk.co.eclipse.billing.ngtesting.https.libs.Properties;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

public class ValidUploadZIPFile extends Parent {
    public String company = Properties.getCompany();
    public String login = Properties.getLogin();
    public String password = Properties.getPassword();

    @Test
    public void validUploadZIPFile(){
        loginPage.loginUser(company, login, password);
        homePage.navigateToMenuImportCDR();
        importCDRPage.clickOnButtonSelectCDRFile();
        importCDRPage.uploadCorrectZIPFile();
        checkAC("Alert shouldn't be displayed", importCDRPage.isAlertAbsent(), true);
        checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen("1BT.csv"), true);
        checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen("1DaisyAllMobile.CSV"), true);
        checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen("1GammaWLR.txt"), true);
    }
}
