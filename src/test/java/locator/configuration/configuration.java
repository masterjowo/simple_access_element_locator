package locator.configuration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class configuration {
    public static void setWindowSize(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(1440, 832));
    }
}
