package uk.co.eclipse.billing.ngtesting.https.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{
    @FindBy(id = "txtCompany")
    private WebElement companyInput;

    @FindBy(id = "txtUsername")
    private WebElement loginInput;

    @FindBy(id = "txtPassword")
    private WebElement passwordInput;

    @FindBy(id = "cmdLogin")
    private WebElement buttonLogin;

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public void openLoginPage(){
        open("https://ngtesting.eclipse-billing.co.uk/Login.aspx");
    }

    public void enterCompanyToInput(String company){
        actionWithOurElements.enterText(companyInput, company);
    }

    public void enterLoginToInput(String login){
        actionWithOurElements.enterText(loginInput, login);
    }

    public void enterPasswordToInput(String password){
        actionWithOurElements.enterText(passwordInput, password);
    }

    public void clickOnLoginButton(){
        actionWithOurElements.clickOnElement(buttonLogin);
    }
}

