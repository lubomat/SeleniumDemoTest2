package pl.testeroprogramowania.tests;

import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest{

    @Test
    public void registerUserTest() {

        int randomNumber = (int) (Math.random()*1000);
        new HomePage(driver).openMyAccoutPage()
                .registerUser("test"+randomNumber+"@test.pl","haslotestowe");








    }
}
