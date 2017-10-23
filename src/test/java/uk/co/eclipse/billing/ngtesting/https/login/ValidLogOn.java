package uk.co.eclipse.billing.ngtesting.https.login;

import org.junit.Test;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

public class ValidLogOn extends Parent{

    @Test
    public void validLogOn(){
        loginPage.openLoginPage();
        loginPage.enterCompanyToInput("olga");
        loginPage.enterLoginToInput("olga");
        loginPage.enterPasswordToInput("KB4!ww!go");
        loginPage.clickOnLoginButton();
       // checkAC("Title is not present",homePage.isHeaderPresent(),true);
       // checkAC("Title is not correct",homePage.isHeaderCorrect(),true);
    }
}
