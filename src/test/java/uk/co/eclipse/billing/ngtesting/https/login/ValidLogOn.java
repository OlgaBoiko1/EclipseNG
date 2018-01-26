package uk.co.eclipse.billing.ngtesting.https.login;

import org.junit.Test;
import uk.co.eclipse.billing.ngtesting.https.libs.Properties;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

public class ValidLogOn extends Parent{
    public String company = Properties.getCompany();
    public String login = Properties.getLogin();
    public String password = Properties.getPassword();

    public ValidLogOn(){
    }

    @Test
    public void validLogOn() {
        loginPage.openLoginPage();
        loginPage.enterCompanyToInput(company);
        loginPage.enterLoginToInput(login);
        loginPage.enterPasswordToInput(password);
        loginPage.clickOnLoginButton();
        homePage.confirmUpdateScreenIfExistForUser(login);
        checkAC("Title of Home Page is not present",homePage.isHeaderHomePagePresent(),true);
        checkAC("Title of Home Page is not correct",homePage.isHeaderHomePageCorrect(),true);
    }
}
