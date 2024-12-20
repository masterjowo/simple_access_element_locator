package locator;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import locator.configuration.configuration;

public class TugasLocator1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        configuration.setWindowSize(driver);
        driver.findElement(By.name("name")).sendKeys("Muhammad Ramdhani");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("Muhammad Ramdhani");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("Muhammad Ramdhani");
        driver.findElement(By.xpath("//*[@type='checkbox']")).click();
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='exampleFormControlSelect1']")));
        dropdown.selectByIndex(1);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        driver.findElement(By.xpath("//*[@id='inlineRadio2']")).click();
        driver.findElement(By.xpath("//*[@type='date']")).sendKeys("01-30-2015");
        driver.findElement(By.cssSelector("input.btn.btn-success[type='submit']")).click();
        WebElement successMessage = driver
                .findElement(
                        By.cssSelector("a.close[aria-label='close']"));
        System.out.println(successMessage.getText());
        Assert.assertEquals(successMessage.getText(), "×");

        Thread.sleep(1000);
        driver.quit();

    }

}
