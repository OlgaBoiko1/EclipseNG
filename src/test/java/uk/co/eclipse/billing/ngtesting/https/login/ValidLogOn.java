package uk.co.eclipse.billing.ngtesting.https.login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import uk.co.eclipse.billing.ngtesting.https.libs.ConfigData;
import uk.co.eclipse.billing.ngtesting.https.libs.SpreadsheetData;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ValidLogOn extends Parent{
    String company, login, password;

    public ValidLogOn(String company, String login, String password){
        super();
        this.company = company;
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testLoginData1.xls");
        return new SpreadsheetData(spreadsheet, "ValidLogOn").getData();
    }


    @Test
    public void ValidLogOn() {
        loginPage.openLoginPage();
        loginPage.enterCompanyToInput(company);
        loginPage.enterLoginToInput(login);
        loginPage.enterPasswordToInput(password);
        loginPage.clickOnLoginButton();
        homePage.confirmUpdateScreenIfExistForUser("olga");
        checkAC("Title of Home Page is not present",homePage.isHeaderHomePagePresent(),true);
        checkAC("Title of Home Page is not correct",homePage.isHeaderHomePageCorrect(),true);
    }
}
