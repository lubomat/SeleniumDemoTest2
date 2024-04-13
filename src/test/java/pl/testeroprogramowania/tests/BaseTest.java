package pl.testeroprogramowania.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.testeroprogramowania.utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com/");
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();

    }
}
