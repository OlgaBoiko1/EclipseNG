package uk.co.eclipse.billing.ngtesting.https.login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import uk.co.eclipse.billing.ngtesting.https.parent.Parent;

public class ValidLogOnWithOutPageObjects extends Parent{

    @Test
    public void validLogOnWithOutPageObjects() {
        webDriver.get("https://ngtesting.eclipse-billing.co.uk/Login.aspx");
        webDriver.findElement(By.xpath(".//*[@id='txtCompany']")).sendKeys("olga");
        webDriver.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("olga");
        webDriver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("");
        webDriver.findElement(By.xpath(".//*[@id='cmdLogin']")).click();
        Assert.assertTrue("Home page is not displayed",webDriver.findElement(By.xpath(".//*[text()='Home Page']")).isDisplayed());

    }

}
