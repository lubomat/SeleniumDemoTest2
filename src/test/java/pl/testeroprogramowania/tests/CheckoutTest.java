package pl.testeroprogramowania.tests;

import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.models.Customer;

public class CheckoutTest extends BaseTest {

    @Test
    private void checkoutTest() {
        Customer customer = new Customer();
        customer.setFirstName("Andrzej");
        customer.setLastName("Testowy");
        customer.setCompany("Firma");
        customer.setCountry("Portugal");
        customer.setStreet("Warszawska");
        customer.setHouseNumber("22");
        customer.setZipCode("11111");
        customer.setCity("Testowe");
        customer.setPhone("111111111");
        customer.setEmail("testowe@test.pl");
        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer,"some random comment");
    }
}
