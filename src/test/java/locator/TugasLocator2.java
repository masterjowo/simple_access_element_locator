package locator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import locator.configuration.configuration;

public class TugasLocator2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        configuration.setWindowSize(driver);
        driver.findElement(By.xpath("//*[@for='radio2']")).click();
        driver.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys("mala");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-1']//div[text()='Guatemala']")).click();
        // Switch Window Example
        driver.findElement(By.id("openwindow")).click();
        String mainWindow = driver.getWindowHandle();// get id saat ini
        Set<String> allWindows = driver.getWindowHandles();// get all id tab
        System.out.println(allWindows);
        // switch ke jendela baru
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(2000);
        WebElement newWindowElement = driver.findElement(By.xpath("//span[contains(text(), 'Siri Balaji')]"));
        System.out.println(newWindowElement.getText());// Isi halaman di jendela baru
        Assert.assertEquals("Siri Balaji Residency, 2 GaddiAnnaram, Hyderabad.", newWindowElement.getText());
        driver.close();
        driver.switchTo().window(mainWindow);// Kembali ke jendela utama
        System.out.println(driver.getTitle());// Kembali ke jendela utama

        Thread.sleep(1000);
        driver.quit();

    }

}
