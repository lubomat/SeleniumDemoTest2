package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement billingFirstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement billingLastNameInput;

    @FindBy(id = "billing_company")
    private WebElement billingCompanyInput;

    @FindBy(id = "select2-billing_country-container")
    private WebElement billingCountrySelect;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddres1Input;

    @FindBy(id = "billing_address_2")
    private WebElement billingAddres2Input;

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

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;


    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void enterData(String firstName, String lastName,
                          String company, String adres1,
                          String adres2, String postcode,
                          String city, String phone, String email) {
        billingFirstNameInput.sendKeys(firstName);
        billingLastNameInput.sendKeys(lastName);
        billingCompanyInput.sendKeys(company);
        billingAddres1Input.sendKeys(adres1);
        billingAddres2Input.sendKeys(adres2);
        billingPostcodeInput.sendKeys(postcode);
        billingCityInput.sendKeys(city);
        billingPhoneInput.sendKeys(phone);
        billingEmailInput.sendKeys(email);
        placeOrderButton.click();
    }


}
