package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest{

    @Test
    public void registerUserTest() {

        int randomNumber = (int) (Math.random()*1000);
        WebElement entryTitle = new HomePage(driver).openMyAccoutPage()
                .registerUser("test"+randomNumber+"@test.pl","haslotestowe")
                .getDashboardLink();

        Assert.assertTrue(entryTitle.isDisplayed());
        Assert.assertEquals(entryTitle.getText(),"Dashboard");









    }
}
