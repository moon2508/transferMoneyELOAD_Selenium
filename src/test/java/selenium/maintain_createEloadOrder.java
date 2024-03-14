package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.LocalDate;
import java.util.Random;
public class maintain_createEloadOrder {
    //function generate random number
    private static int getRamdomNumber(int number) {
        Random random = new Random();
        return (random.nextInt(number));
    }
    //function getdate now
    private static LocalDate getDate(){
        LocalDate currentDate = LocalDate.now();
        return currentDate;
    };
    //function get cssSelector
    private static void clickCssSelector(WebDriver driver,String cssSelector) throws InterruptedException {
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
        String money = String.valueOf(getRamdomNumber(100)*100000);
        System.out.println(getDate());

        WebDriver driver = new ChromeDriver();
        String url ="http://192.168.100.192:1999/";
        String username = "hangptdv";
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
        clickCssSelector(driver,".btn-success");

        //click dropdown NCC
        clickXpath(driver,"//a//span[contains(text(),'Chọn Nhà cung cấp')]");
        sendkeyCssSelector(driver,"#providerId_chosen .chosen-search-input","AirTimeVNP");
        clickXpath(driver,"//em[contains(text(),'AirTimeVNP')]");

        //click dropdown product
        clickXpath(driver,"//a//span[contains(text(),'Chọn sản phẩm')]");
        clickXpath(driver,"//li[contains(text(),'Eload Vinaphone')]");

        //click seller
        clickXpath(driver,"//span[contains(text(),'Chọn Pháp nhân bán')]");
        clickCssSelector(driver,"#merchantSale_chosen .active-result:nth-child(2)");

        //click seller account
        clickCssSelector(driver,"#phoneNumberConnection_chosen span");
        clickXpath(driver,"//li[contains(text(),'Imedia - 0915971772')]");

        //click buyer
        clickCssSelector(driver,"#merchantBuy_chosen span");
        clickXpath(driver, "//li[contains(text(),'PCQ')]");

        // click phone number
        clickCssSelector(driver,"#phoneNumber_chosen span");
        clickCssSelector(driver,"#phoneNumber_chosen .active-result:nth-child(2)");

        //input quantity & commission

        sendkeyCssSelector(driver,".quantity-0", money);
        sendkeyCssSelector(driver,".commission-0","1.5");
        //note order
        sendkeyCssSelector(driver,"#sale-note", "Test đơn hàng Selenium "+ getRamdomNumber(100)+ " ngày "+ getDate());
//        clickCssSelector(driver,".btn-success"); // click thêm mới
        clickXpath(driver,"//button[contains(text(),'Gửi duyệt')]");

        System.out.println("Successfully opened the website");

        driver.quit();

    }




}
