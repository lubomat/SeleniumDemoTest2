package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        int randomNumber = (int) (Math.random() * 1000);

        WebElement dashboardLink = new HomePage(driver).openMyAccoutPage()
                .registerUserValidData("test" + randomNumber + "@test.pl", "haslotestowe")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
        System.out.println(randomNumber);
    }

    @Test
    public void registerUserWithSameEmailTest() {
        WebElement error = new HomePage(driver).openMyAccoutPage()
                .registerUserInvalidData("test@test.pl", "haslotestowe")
                .getError();

        Assert.assertTrue(error.getText().contains(
                " An account is already registered with your email address. Please log in."));
    }

}
