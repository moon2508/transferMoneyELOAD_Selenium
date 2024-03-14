package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class approveEloadOrder {
    public static void main(String[] args) throws Exception {
        // Create a new instance of the Firefox driver
        WebDriver driver = new ChromeDriver();

        //Launch the Online Store Website
        driver.get("http://192.168.100.192:1999/");

        driver.manage().window().maximize();

        //Execute login website with username and password
        WebElement username = driver.findElement(By.id("exampleInputEmail1"));
        username.sendKeys("haptdv");
        WebElement password = driver.findElement(By.id("exampleInputPassword1"));
        password.sendKeys("123456");
        driver.findElement(By.className("btn-success")).click();
        Thread.sleep(1000);

//            Link to đơn hàng Eload selection

        driver.findElement(By.linkText("Đơn hàng Airtime, Eload")).click();
        driver.findElement(By.cssSelector("li:nth-child(32) li:nth-child(1) > a")).click();

        //find order with chờ duyệt status
        driver.findElement(By.cssSelector("#status_chosen span")).click();
        driver.findElement(By.xpath("//li[contains(text(),'Chờ duyệt')]")).click();

        driver.findElement(By.cssSelector("#searchListOrder")).click();

        //click a order
        driver.findElement(By.cssSelector(".text-center > a")).click();

        //click Duyệt button
        driver.findElement(By.xpath("//button[contains(text(),'Duyệt')]")).click();
        Thread.sleep(1000);


        //input MPIN
        WebElement content =  driver.findElement(By.xpath("//div//input[@id='contentApproveOrderEload']"));
        content.click();
        content.sendKeys("123456");

        //Accept
        driver.findElement(By.cssSelector("#approveOrderEload .btn-danger")).click();

        driver.quit();


    }
}
