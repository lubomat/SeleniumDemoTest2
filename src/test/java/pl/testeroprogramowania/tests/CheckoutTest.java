package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.OrderDetailsPage;
import pl.testeroprogramowania.pages.models.Customer;

public class CheckoutTest extends BaseTest {

    @Test
    private void checkoutTest() {
        Customer customer = new Customer();
        customer.setEmail("specificemail@test.pl");


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
