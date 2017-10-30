package uk.co.eclipse.billing.ngtesting.https.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    private String title = "Home Page";

    @FindBy(xpath = ".//*[@id='Pageheading']/span")
    private WebElement header;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isHeaderPresent(){
        return actionWithOurElements.isElementPresent(header);
    }

    public boolean isHeaderCorrect(){
        return actionWithOurElements.isTextCorrect(header, title);
    }
}
