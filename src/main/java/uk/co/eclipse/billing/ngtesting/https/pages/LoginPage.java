package uk.co.eclipse.billing.ngtesting.https.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.eclipse.billing.ngtesting.https.libs.Utils;


public class LoginPage extends ParentPage{
    HomePage homePage;
    Utils utils = new Utils();

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
        homePage = new HomePage(webDriver);
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

    public void loginUser(String company, String login, String password){
        openLoginPage();
        enterCompanyToInput(company);
        enterLoginToInput(login);
        enterPasswordToInput(password);
        clickOnLoginButton();
        utils.myAssertTrue("Can't work with the Home Page", homePage.isHeaderHomePageCorrect());
    }

}

