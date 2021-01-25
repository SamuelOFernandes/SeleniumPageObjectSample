package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {

    public static void take(WebDriver driver, String file) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File(file));
        } catch (Exception e) {
            System.out.println("Ocorreu algum problema para copiar o arquivo para  a pasta" + e.getMessage());
        }
    }
}
