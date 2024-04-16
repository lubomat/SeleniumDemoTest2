package pl.testeroprogramowania.tests;

import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.models.Customer;

public class CheckoutTest extends BaseTest {

    @Test
    private void checkoutTest() {
        Customer customer = new Customer();
        customer.setEmail("specificemail@test.pl");


        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer,"some random comment");
    }
}
