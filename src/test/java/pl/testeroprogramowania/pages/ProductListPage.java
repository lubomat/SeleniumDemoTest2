package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {


    @FindBy(xpath = "//h2[text()='Java Selenium WebDriver']")
    private WebElement javaSeleniumWebDriverProduct;

    private WebDriver driver;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage openProduct(String title) {
        driver.findElement(By.xpath("//h2[text()='"+title+"']")).click();
        return new ProductPage(driver);
    }
}
