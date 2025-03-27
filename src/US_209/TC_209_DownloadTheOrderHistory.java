package US_209;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TC_209_DownloadTheOrderHistory extends BaseDriver {

    @Test
    public void downloadTheOrderHistoryTest() {

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.sleep(2);

        Assert.assertTrue("Web page could not be accessed.", driver.getTitle().contains("Demo Web Shop"));
        MyFunc.sleep(2);

        WebElement longinLink= driver.findElement(By.cssSelector("a.ico-login"));
        actions.moveToElement(longinLink).click().build().perform();
        MyFunc.sleep(2);

        Assert.assertTrue("The login page could not be accessed.", driver.getTitle().contains("Login"));
        MyFunc.sleep(2);

        WebElement emailInput=driver.findElement(By.cssSelector(".inputs [name='Email']"));
        actions.moveToElement(emailInput).click().sendKeys("BugFathers04@gmail.com").build().perform();
        MyFunc.sleep(2);

        WebElement passwordInput=driver.findElement(By.cssSelector(".inputs [name='Password']"));
        actions.moveToElement(passwordInput).click().sendKeys("123456").build().perform();
        MyFunc.sleep(2);

        WebElement loginBtn=driver.findElement(By.cssSelector(".buttons [type='submit']"));
        actions.moveToElement(loginBtn).click().build().perform();
        MyFunc.sleep(3);

        WebElement myAccountLink=driver.findElement(By.cssSelector(".header-links .account"));
        actions.moveToElement(myAccountLink).click().build().perform();
        MyFunc.sleep(3);

        WebElement myAccountHeader=driver.findElement(By.cssSelector(".page-title h1"));
        Assert.assertTrue("The My Account page could not be accessed.",myAccountHeader.getText().contains("My account - Customer info"));

        WebElement ordersLink=driver.findElement(By.cssSelector(".listbox :nth-child(3) a"));
        actions.moveToElement(ordersLink).click().build().perform();
        MyFunc.sleep(2);

        WebElement myAccountOrdersHeader=driver.findElement(By.cssSelector(".page-title h1"));
        Assert.assertTrue("The Orders page could not be accessed.",myAccountOrdersHeader.getText().contains("My account - Orders"));
        List<WebElement> orders=driver.findElements(By.cssSelector(".order-list .title>strong"));

        /*
        My account - All Orders
        Order Number: 1940662
        Order Number: 1936121
        Order Number: 1935652
        */

        List<String> ordersNumbers=new ArrayList<>();
        ordersNumbers.add("1940662");
        ordersNumbers.add("1936121");
        ordersNumbers.add("1935652");

        for (int i = 0; i < orders.size(); i++) {
            Assert.assertTrue("The requested order could not be found.", orders.get(i).getText().contains(ordersNumbers.get(i)));
        }

        List<WebElement> detailsBtn=driver.findElements(By.cssSelector(".buttons [value='Details']"));
        WebElement ordersInfoPage;
        WebElement pdfInvoiceBtn;

        for (int i = 0; i < detailsBtn.size(); i++) {
            actions.moveToElement(detailsBtn.get(i)).click().build().perform();
            MyFunc.sleep(2);
            ordersInfoPage=driver.findElement(By.cssSelector(".order-number strong"));
            Assert.assertTrue("The requested order page could not be accessed.", ordersInfoPage.getText().contains(ordersNumbers.get(i)));
            MyFunc.sleep(2);
            pdfInvoiceBtn=driver.findElement(By.cssSelector(".page-title>:nth-child(3)"));
            actions.moveToElement(pdfInvoiceBtn).click().build().perform();
            MyFunc.sleep(2);
            driver.navigate().back();
            MyFunc.sleep(2);
        }

        TearDown();
    }
}
