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
public class ValidUploadZIPFile extends Parent {
    String FileName1, FileName2;
    public String company = Properties.getCompany();
    public String login = Properties.getLogin();
    public String password = Properties.getPassword();

    public ValidUploadZIPFile(String FileName1, String FileName2){
        this.FileName1 = FileName1;
        this.FileName2 = FileName2;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testImportCDRData.xls");
        return new SpreadsheetData(spreadsheet, "ValidUploadZIPFile").getData();
    }

    @Test
    public void validUploadZIPFile(){
        loginPage.loginUser(company, login, password);
        homePage.navigateToMenuImportCDR();
        importCDRPage.clickOnButtonSelectCDRFile();
        importCDRPage.uploadCorrectZIPFile();
        importCDRPage.acceptAlertIfPresent();
        //checkAC("Alert shouldn't be displayed", importCDRPage.isAlertAbsent(), true);
        checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen(FileName1), true);
        checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen(FileName2), true);
    }
}
