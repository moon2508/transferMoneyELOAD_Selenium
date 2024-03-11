package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class createEloadOrder {
    public static void main(String[] args) throws Exception {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Launch the Online Store Website
        driver.get("http://192.168.100.192:1999/");

        //Execute login website with username and password
        WebElement username = driver.findElement(By.id("exampleInputEmail1"));
        username.sendKeys("hangptdv");
        WebElement password = driver.findElement(By.id("exampleInputPassword1"));
        password.sendKeys("123456");
        driver.findElement(By.className("btn-success")).click();

        // Access the airtime/eload order - ADD eload order
        driver.navigate().to("http://192.168.100.192:1999/order-itopup/create-sale");
        // Locate the dropdown element

        Select dropdown = new Select(driver.findElement(By.id("providerId")));
//        dropdown.selectByValue("Vinaphone");
        List<WebElement> optionList = dropdown.getOptions();
//        System.out.println;





        System.out.println("Successfully opened the website");

//        driver.quit();

    }
}