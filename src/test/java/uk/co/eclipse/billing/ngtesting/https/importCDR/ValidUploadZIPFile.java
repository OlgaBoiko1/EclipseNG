package uk.co.eclipse.billing.ngtesting.https.importCDR;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import uk.co.eclipse.billing.ngtesting.https.libs.ConfigData;
import uk.co.eclipse.billing.ngtesting.https.libs.Properties;
import uk.co.eclipse.billing.ngtesting.https.libs.SpreadsheetData;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ValidUploadZIPFile extends Parent {
    String zipFileName, file1InsideZIP, file2InsideZIP;
    public String company = Properties.getCompany();
    public String login = Properties.getLogin();
    public String password = Properties.getPassword();

    public ValidUploadZIPFile(String zipFileName, String file1InsideZIP, String file2InsideZIP){
        this.zipFileName = zipFileName;
        this.file1InsideZIP = file1InsideZIP;
        this.file2InsideZIP = file2InsideZIP;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testImportCDRData.xls");
        return new SpreadsheetData(spreadsheet, "ValidUploadZIPFile").getData();
    }

    @Test
    public void validUploadZIPFile() {
        loginPage.loginUser(company, login, password);
        homePage.navigateToMenuImportCDR();
        importCDRPage.clickOnButtonSelectCDRFile();
        importCDRPage.uploadCorrectZIPFile();
        importCDRPage.acceptAlertIfPresent();
        //checkAC("Alert shouldn't be displayed", importCDRPage.isAlertAbsent(), true);
        checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen(file1InsideZIP), true);
        checkAC("File name is not displayed on Select File screen", importCDRPage.isFileNameDisplayedOnSelectFileScreen(file2InsideZIP), true);
    }
}
