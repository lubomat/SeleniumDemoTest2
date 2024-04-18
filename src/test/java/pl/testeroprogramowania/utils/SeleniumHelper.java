package pl.testeroprogramowania.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SeleniumHelper {

    public static void waitForClickable(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    //   MediaEntityModelProvider
    public static Media getScreenshot(WebDriver driver) throws IOException {
        String path = takeScreenshot(driver);
        return MediaEntityBuilder.createScreenCaptureFromPath(path).build();

    }

    private static String takeScreenshot(WebDriver driver) throws IOException {
        int randomNumber = (int) (Math.random() * 1000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/screenshot" + randomNumber + ".png";
        FileUtils.copyFile(file, new File(path));
        return path;
    }
}
