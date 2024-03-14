package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class createEloadOrder {
    public static void main(String[] args) throws Exception {
        try {
            // Create a new instance of the Firefox driver
            WebDriver driver = new ChromeDriver();

            //Launch the Online Store Website
            driver.get("http://192.168.100.192:1999/");

            driver.manage().window().maximize();

            //Execute login website with username and password
            WebElement username = driver.findElement(By.id("exampleInputEmail1"));
            username.sendKeys("hangptdv");
            WebElement password = driver.findElement(By.id("exampleInputPassword1"));
            password.sendKeys("123456");
            driver.findElement(By.className("btn-success")).click();
            Thread.sleep(1000);

//            Link to đơn hàng Eload selection

            driver.findElement(By.linkText("Đơn hàng Airtime, Eload")).click();
            driver.findElement(By.cssSelector("li:nth-child(32) li:nth-child(1) > a")).click();
            driver.findElement(By.cssSelector(".btn-success")).click(); // click to Thêm mới button

            Thread.sleep(1000);

            //click dropdown NCC
            WebElement dropdown = driver.findElement(By.xpath("//a//span[contains(text(),'Chọn Nhà cung cấp')]"));
            dropdown.click();
            driver.findElement(By.cssSelector("#providerId_chosen .chosen-search-input")).sendKeys("AirTimeVNP");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//em[contains(text(),'AirTimeVNP')]")).click();
            Thread.sleep(1000);

            //click dropdown product
            WebElement dropdown_product = driver.findElement(By.xpath("//a//span[contains(text(),'Chọn sản phẩm')]"));
            dropdown_product.click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//li[contains(text(),'Eload Vinaphone')]")).click();
            Thread.sleep(1000);

            //click seller
            driver.findElement(By.xpath("//span[contains(text(),'Chọn Pháp nhân bán')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#merchantSale_chosen .active-result:nth-child(2)")).click();

            //click seller account
            driver.findElement(By.cssSelector("#phoneNumberConnection_chosen span")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//li[contains(text(),'Imedia - 0915971772')]")).click();

            //click buyer
            driver.findElement(By.cssSelector("#merchantBuy_chosen span")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//li[contains(text(),'PCQ')]")).click();

            // click phone number
            driver.findElement(By.cssSelector("#phoneNumber_chosen span")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#phoneNumber_chosen .active-result:nth-child(2)")).click();

            //input quantity & commission
            driver.findElement((By.cssSelector(".quantity-0"))).sendKeys("10000000");
            driver.findElement(By.cssSelector(".commission-0")).sendKeys("1.5");

            //note order
            driver.findElement(By.cssSelector("#sale-note")).sendKeys("Test đơn hàng bằng selenium");
//            driver.findElement(By.cssSelector(".btn-success")).click();
            driver.findElement(By.xpath("//button[contains(text(),'Gửi duyệt')]")).click();


            System.out.println("Successfully opened the website");

            driver.quit();

        } catch (StaleElementReferenceException e) {
            System.out.println("Exception: " + e);
        }

    }
}
