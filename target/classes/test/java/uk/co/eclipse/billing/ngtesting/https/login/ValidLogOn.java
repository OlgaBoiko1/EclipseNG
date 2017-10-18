package uk.co.eclipse.billing.ngtesting.https.login;

import org.junit.Test;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

public class ValidLogOn extends Parent{

    @Test
    public void validLogOn(){
        loginPage.openLoginPage();
//        loginPage.enterLoginToInput();
//        loginPage.enterPasswordToInput();
//        loginPage.clickOnLoginButton();
//        checkAC("Home page text is not present",,true);
    }
}
