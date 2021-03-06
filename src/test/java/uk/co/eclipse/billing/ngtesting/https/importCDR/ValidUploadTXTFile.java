package uk.co.eclipse.billing.ngtesting.https.importCDR;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import uk.co.eclipse.billing.ngtesting.https.libs.ConfigData;
import uk.co.eclipse.billing.ngtesting.https.libs.Properties;
import uk.co.eclipse.billing.ngtesting.https.libs.SpreadsheetData;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ValidUploadTXTFile extends Parent {
    String cdrFileName, cdrFilterName;
    public String company = Properties.getCompany();
    public String login = Properties.getLogin();
    public String password = Properties.getPassword();

    public ValidUploadTXTFile(String cdrFileName, String cdrFilterName){
        this.cdrFileName = cdrFileName;
        this.cdrFilterName = cdrFilterName;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testImportCDRData.xls");
        return new SpreadsheetData(spreadsheet, "ValidUploadTXTFile").getData();
    }

    @Test
    public void validUploadTXTFile(){
        loginPage.loginUser(company, login, password);
        homePage.navigateToMenuImportCDR();
        importCDRPage.clickOnButtonSelectCDRFile();
        checkAC("Select File screen is not displayed",importCDRPage.isSelectFileScreenDisplayed(), true);
        if (importCDRPage.isFileNameAbsentOnScreen(cdrFileName)) {
            importCDRPage.clickOnButtonSelectFileScreenUpload();
            checkAC("Upload screen is not displayed", importCDRPage.isUploadScreenDisplayed(), true);
            importCDRPage.mouseHoverAndClickOnButtonSelect();
            importCDRPage.selectTXTFileGammaWLR();
            checkAC("File name is not displayed on Upload screen", importCDRPage.isFileNameDisplayedOnUploadScreen(cdrFileName), true);
            importCDRPage.clickOnButtonUpload();
            importCDRPage.acceptAlertIfPresent();
            checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen(cdrFileName), true);
        }
        importCDRPage.selectFilterInDDByText(cdrFilterName);
        importCDRPage.doubleClickOnFileIcon(cdrFileName);
        importCDRPage.acceptAlertIfPresent();
        checkAC("Select File screen is not closed",importCDRPage.isSelectFileScreenDisplayed(), false);
        checkAC("File is not uploaded",importCDRPage.isFileNameDisplayedOnImportCDRScreen(cdrFileName), true);
        checkAC("Filter name is not correct",importCDRPage.isFilterNameCorrect(cdrFileName,cdrFilterName), true);
        checkAC("Imported flag is not correct",importCDRPage.isImportedFlagCorrect(cdrFileName,"No"), true);
        checkAC("Protected flag is not correct",importCDRPage.isProtectedFlagCorrect(cdrFileName,"No"), true);
        checkAC("Edit button is not present for the file",importCDRPage.isEditButtonPresentForFile(cdrFileName), true);

    }
}
