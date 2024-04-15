package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.testeroprogramowania.pages.models.Customer;

public class AddressDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement billingFirstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement billingLastNameInput;

    @FindBy(id = "billing_company")
    private WebElement billingCompanyInput;

    @FindBy(id = "billing_country")
    private WebElement billingCountrySelect;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddres1Input;


    @FindBy(id = "billing_postcode")
    private WebElement billingPostcodeInput;

    @FindBy(id = "billing_city")
    private WebElement billingCityInput;

    @FindBy(id = "billing_phone")
    private WebElement billingPhoneInput;

    @FindBy(id = "billing_email")
    private WebElement billingEmailInput;

    @FindBy(id = "order_comments")
    private WebElement orderCommentsInput;

    @FindBy(xpath = "//*[@id=\"place_order\"]")
    private WebElement placeOrderButton;


    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public OrderDetailsPage fillAddressDetails(Customer customer, String comments) {
        billingFirstNameInput.sendKeys(customer.getFirstName());
        billingLastNameInput.sendKeys(customer.getLastName());
        billingCompanyInput.sendKeys(customer.getCompany());

        Select countrySelect = new Select(billingCountrySelect);
        countrySelect.selectByVisibleText(customer.getCountry());

        billingAddres1Input.sendKeys(String.format("%s %s",
                customer.getStreet(),customer.getHouseNumber()));
        billingPostcodeInput.sendKeys(customer.getZipCode());
        billingCityInput.sendKeys(customer.getCity());
        billingPhoneInput.sendKeys(customer.getPhone());
        billingEmailInput.sendKeys(customer.getEmail());
        orderCommentsInput.sendKeys(comments);
        try {
            placeOrderButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            placeOrderButton.click();
        }
        return new OrderDetailsPage(driver);
    }


}
