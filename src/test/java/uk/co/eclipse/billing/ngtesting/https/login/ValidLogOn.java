package uk.co.eclipse.billing.ngtesting.https.login;

import org.junit.Test;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;


public class ValidLogOn extends Parent{

    @Test
    public void validLogOn(){
        loginPage.openLoginPage();
        loginPage.enterCompanyToInput("olga");
        loginPage.enterLoginToInput("olga");
        loginPage.enterPasswordToInput("");
        loginPage.clickOnLoginButton();
//        homePage.confirmUpdateScreenIfExistForUser("olga");
        checkAC("Title of Home Page is not present",homePage.isHeaderHomePagePresent(),true);
        checkAC("Title of Home Page is not correct",homePage.isHeaderHomePageCorrect(),true);
    }
}
