package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    private void loginValidTest() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccoutPage()
                .logInValidData("test290@test.pl", "haslotestowe")
                .getDashboardLink();


        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    private void loginInvalidDataTest() {
        WebElement error = new HomePage(driver)
                .openMyAccoutPage()
                .logInInvalidData("test290@test.pl", "haslotestowe1")
                .getError();

        Assert.assertTrue(error.getText().contains("Incorrect username or password."));
    }

}
