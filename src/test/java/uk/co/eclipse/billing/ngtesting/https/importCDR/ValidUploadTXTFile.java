package uk.co.eclipse.billing.ngtesting.https.importCDR;

import org.junit.Test;
import uk.co.eclipse.billing.ngtesting.https.libs.Properties;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;


public class ValidUploadTXTFile extends Parent {
    public String company = Properties.getCompany();
    public String login = Properties.getLogin();
    public String password = Properties.getPassword();
    public String CDRFileName = Properties.getCDRFileName();
    public String CDRFilterName = Properties.getCDRFilterName();

    @Test
    public void validUploadTXTFile(){
        loginPage.loginUser(company, login, password);
        homePage.navigateToMenuImportCDR();
        importCDRPage.clickOnButtonSelectCDRFile();
        checkAC("Select File screen is not displayed",importCDRPage.isSelectFileScreenDisplayed(), true);
        if (importCDRPage.isFileNameAbsentOnSelectFileScreen(CDRFileName)) {
            importCDRPage.clickOnButtonSelectFileScreenUpload();
            checkAC("Upload screen is not displayed", importCDRPage.isUploadScreenDisplayed(), true);
            importCDRPage.mouseHoverAndClickOnButtonSelect();
            importCDRPage.selectTXTFileGammaWLR();
            checkAC("File name is not displayed on Upload screen", importCDRPage.isFileNameDisplayedOnUploadScreen(CDRFileName), true);
            importCDRPage.clickOnButtonUpload();
            importCDRPage.acceptAlertIfPresent();
            checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen(CDRFileName), true);
        }
        importCDRPage.selectFilterInDDByText(CDRFilterName);
        importCDRPage.doubleClickOnFileIcon(CDRFileName);
        checkAC("File is not uploaded",importCDRPage.isFileNameDisplayedOnImportCDRScreen(CDRFileName), true);
        checkAC("Filter name is not correct",importCDRPage.isFilterNameCorrect(CDRFileName,CDRFilterName), true);
        checkAC("Imported flag is not correct",importCDRPage.isImportedFlagCorrect(CDRFileName,"No"), true);
        checkAC("Protected flag is not correct",importCDRPage.isProtectedFlagCorrect(CDRFileName,"No"), true);
        checkAC("Edit button is not present for the file",importCDRPage.isEditButtonPresentForFile(CDRFileName), true);

    }
}
