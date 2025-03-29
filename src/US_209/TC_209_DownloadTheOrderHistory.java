package US_209;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class TC_209_DownloadTheOrderHistory extends BaseDriver {

    @Test
    public void downloadTheOrderHistoryTest() {
        driver.navigate().to("https://demowebshop.tricentis.com/");
        Assert.assertTrue("Web page could not be accessed.", driver.getTitle().contains("Demo Web Shop"));

        Login();

        WebElement myAccountEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header-links .account")));
        actions.moveToElement(myAccountEmail).click().build().perform();

        WebElement myAccountHeader = driver.findElement(By.cssSelector(".page-title h1"));
        Assert.assertTrue("The My Account page could not be accessed.", myAccountHeader.getText().contains("My account - Customer info"));

        WebElement ordersLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".listbox :nth-child(3) a")));
        actions.moveToElement(ordersLink).click().build().perform();

        WebElement myAccountOrdersHeader = driver.findElement(By.cssSelector(".page-title h1"));
        Assert.assertTrue("The Orders page could not be accessed.", myAccountOrdersHeader.getText().contains("My account - Orders"));

        List<WebElement> orders = driver.findElements(By.cssSelector(".order-list .title>strong"));
        List<WebElement> detailsBtn = driver.findElements(By.cssSelector(".buttons [value='Details']"));

        int totalOrders = orders.size();
        Assert.assertTrue("The number of orders is less than 3.", totalOrders >= 3);

        for (int i = 0; i < 3; i++) {
            String currentOrderNumber = orders.get(i).getText();
            WebElement currentDetailsBtn = detailsBtn.get(i);

            actions.moveToElement(currentDetailsBtn).click().build().perform();

            WebElement orderInfoPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-number strong")));
            String detailText = orderInfoPage.getText();

            String expectedOrderNumber = currentOrderNumber.replaceAll("[^0-9]", "");
            String actualOrderNumber = detailText.replaceAll("[^0-9]", "");

            System.out.println("Order number: " + expectedOrderNumber);
            System.out.println("Order details: " + actualOrderNumber);

            Assert.assertEquals("The requested order page could not be accessed.", expectedOrderNumber, actualOrderNumber);

            WebElement pdfInvoiceBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-title>:nth-child(3)")));
            actions.moveToElement(pdfInvoiceBtn).click().build().perform();

            driver.navigate().back();
            ordersLink = driver.findElement(By.cssSelector(".listbox :nth-child(3) a"));
            actions.moveToElement(ordersLink).click().build().perform();

            orders = driver.findElements(By.cssSelector(".order-list .title>strong"));
            detailsBtn = driver.findElements(By.cssSelector(".buttons [value='Details']"));
        }
        TearDown();
    }
}
