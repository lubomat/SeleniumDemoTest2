package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.LoggedUserPage;

public class LoginTest extends BaseTest {

    @Test
    private void loginValidTest() {
        WebElement dashboardLink = new HomePage(driver).openMyAccoutPage()
                .logInValidData("test912@test.pl", "haslotestowe").getDashboardLink();


        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    private void loginInvalidTest() {
        WebElement error = new HomePage(driver).openMyAccoutPage()
                .logInInvalidData("test150@test.pl", "haslotestowe").getError();

        Assert.assertTrue(error.getText().contains("Incorrect username or password."));


    }
}
