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

//            Link to đơn hàng Eload selection
//            List<WebElement> sidebar_headings = driver.findElements(By.tagName("li"));
//            for (WebElement sidebar_heading : sidebar_headings) {
//                if (sidebar_heading.getText().equals("Đơn hàng Airtime, Eload")) {
//                    sidebar_heading.click();
//                    List<WebElement> options = driver.findElements(By.tagName("a"));
//                    for (WebElement option : options) {
//                        if (option.getText().equals("Thêm mới")){
//                            option.click();
//                        }}
//                }
//
//            }

            driver.navigate().to("http://192.168.100.192:1999/order-itopup/create-sale");
            Thread.sleep(5000);
//            driver.navigate().refresh();

            // insert data - Provider
//            List<WebElement> dropdowns = driver.findElements(By.tagName("a"));
//            for (WebElement dropdown : dropdowns) {
//                if (dropdown.getText().equals("Chọn Nhà cung cấp")) {
//                    dropdown.click();
//                    Thread.sleep(500);
//                    List<WebElement> providers = driver.findElements(By.tagName("li"));
//                    for (WebElement provider : providers) {
//                        if (provider.getText().equals("AirTimeVNP")) {
//                            provider.click();
//
//
//                        }
//
//                    }
//
//                }
//            }
//
////            }
//            // insert data -  product
//            List<WebElement> dropdown_products = driver.findElements(By.tagName("a"));
//            for (WebElement dropdown_product : dropdown_products) {
//                if (dropdown_product.getText().equals("Chọn sản phẩm")) {
//                    dropdown_product.click();
//                    Thread.sleep(500);
//                    List<WebElement> products = driver.findElements(By.tagName("li"));
//                    for (WebElement product : products) {
//                        if (product.getText().equals("Eload Vinaphone")) {
//                            product.click();
//                        }
//
//                    }
//                }}
//            Select dropdown = new Select(driver.findElement(By.id("inputProduct_chosen")));
//            dropdown.selectByVisibleText("Eload Vinaphone");

            //option 2
            //click dropdown NCC
            WebElement dropdown = driver.findElement(By.xpath("//a//span[contains(text(),'Chọn Nhà cung cấp')]"));
            dropdown.click();
            driver.findElement(By.cssSelector("#providerId_chosen .chosen-search-input")).sendKeys("Vinaphone");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//em[contains(text(),'Vinaphone')]")).click();

                Thread.sleep(3000);
            WebElement dropdown_product = driver.findElement(By.xpath("//a//span[contains(text(),'Chọn sản phẩm')]"));
            dropdown_product.click();

//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();", dropdown_product);







            System.out.println("Successfully opened the website");

        driver.quit();

        } catch (StaleElementReferenceException e) {
            System.out.println("Exception: " + e);
        }



        // Access the airtime/eload order - ADD eload order
//        driver.navigate().to("http://192.168.100.192:1999/order-itopup/create-sale");











    }
}
