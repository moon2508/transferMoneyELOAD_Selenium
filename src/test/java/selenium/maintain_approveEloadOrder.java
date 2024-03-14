package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class maintain_approveEloadOrder {
    private static void clickCssSelector(WebDriver driver, String cssSelector) throws InterruptedException {
        driver.findElement(By.cssSelector(cssSelector)).click();
        Thread.sleep(1000);
    };
    private static void sendkeyCssSelector(WebDriver driver,String cssSelector, String  string) throws InterruptedException {
        driver.findElement(By.cssSelector(cssSelector)).sendKeys(string);
        Thread.sleep(1000);
    };
    private static void clicklinkText(WebDriver driver,String txt) throws InterruptedException {
        driver.findElement(By.linkText(txt)).click();
        Thread.sleep(1000);
    };
    private static void clickXpath(WebDriver driver,String txt) throws InterruptedException {
        driver.findElement(By.xpath(txt)).click();
        Thread.sleep(1000);
    };

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String url ="http://192.168.100.192:1999/";
        String username = "haptdv";
        String password ="123456";
        //Launch the Online Store Website
        driver.get(url);
        driver.manage().window().maximize();

        //Execute login website with username and password
        sendkeyCssSelector(driver,"#exampleInputEmail1",username);
        sendkeyCssSelector(driver,"#exampleInputPassword1",password);
        clickCssSelector(driver,".btn-success");

         // Link to đơn hàng Eload selection
        clicklinkText(driver,"Đơn hàng Airtime, Eload");
        clickCssSelector(driver,"li:nth-child(32) li:nth-child(1) > a");

        //find order with chờ duyệt status
        clickCssSelector(driver,"#status_chosen span");
        clickXpath(driver,"//li[contains(text(),'Chờ duyệt')]");
        clickCssSelector(driver,"#searchListOrder");

        //click a order
        clickCssSelector(driver,".text-center > a");

        //click Duyệt button
        clickXpath(driver,"//button[contains(text(),'Duyệt')]");

        //input MPIN
        clickCssSelector(driver,"#contentApproveOrderEload");
        sendkeyCssSelector(driver,"#contentApproveOrderEload","123456");

       //Accept
        clickCssSelector(driver,"#approveOrderEload .btn-danger");
        driver.quit();
    }
}

