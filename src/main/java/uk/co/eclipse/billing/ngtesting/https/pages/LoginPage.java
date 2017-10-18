package uk.co.eclipse.billing.ngtesting.https.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage{

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public void openLoginPage(){
        open("https://ngtesting.eclipse-billing.co.uk/Login.aspx");
    }
}

