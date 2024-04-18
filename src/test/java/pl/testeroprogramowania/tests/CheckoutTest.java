package pl.testeroprogramowania.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.OrderDetailsPage;
import pl.testeroprogramowania.pages.models.Customer;

public class CheckoutTest extends BaseTest {

    @Test
    private void checkoutTest() {

        ExtentTest test = extentReports.createTest("Search Hotel Test");
        Customer customer = new Customer();
        customer.setEmail("specificemail@test.pl");

//        test.log(Status.PASS"")
        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer,"some random comment");

        Assert.assertEquals(orderDetailsPage.getOrderNotice()
                .getText(),"Thank you. Your order has been received.");

        Assert.assertEquals(orderDetailsPage.getProductName()
                .getText(),"Java Selenium WebDriver × 1");
    }

}
