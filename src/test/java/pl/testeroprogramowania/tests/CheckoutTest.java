package pl.testeroprogramowania.tests;

import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class CheckoutTest extends BaseTest {

    @Test
    private void checkoutTest() {
        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .enterData("Andrzej","Testowy",
                        "Firma", "Warszawska",
                        "150","11111","Warszawa",
                        "123123123","testowy@test.pl");
    }
}
