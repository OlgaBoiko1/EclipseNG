package uk.co.eclipse.billing.ngtesting.https.login;

import org.junit.Test;
import uk.co.eclipse.billing.ngtesting.https.libs.ConfigData;
import uk.co.eclipse.billing.ngtesting.https.libs.ExcelDriver;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

import java.io.IOException;
import java.util.Map;


public class ValidLogOnWithExcelData extends Parent{
    private ExcelDriver excelDriver;

    @Test
    public void validLogOnWithExcelData() throws IOException {
        excelDriver = new ExcelDriver();
        Map<String,String> dataSet = excelDriver.getMultipleData(ConfigData.getCfgValue("DATA_FILE_PATH") + "testLoginData.xls","ValidLogOn",1);
        loginPage.openLoginPage();
        loginPage.enterCompanyToInput(dataSet.get("company"));
        loginPage.enterLoginToInput(dataSet.get("login"));
        loginPage.enterPasswordToInput(dataSet.get("password"));
        loginPage.clickOnLoginButton();
        homePage.confirmUpdateScreenIfExistForUser("login");
        checkAC("Title of Home Page is not present",homePage.isHeaderHomePagePresent(),true);
        checkAC("Title of Home Page is not correct",homePage.isHeaderHomePageCorrect(),true);
    }
}
