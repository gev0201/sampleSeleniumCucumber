package sample.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import sample.qa.base.TestBase;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 30;

    public void switchToFrame() {
        driver.switchTo().frame("mainpanel");
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
}