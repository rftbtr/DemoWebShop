package US_208;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TC_208_UsingCouponsAndGiftCardsNegative extends BaseDriver {

    @Test
    public void UsingCouponsAndGiftCardsNegativeTest() {
        driver.get("https://demowebshop.tricentis.com");
        Assert.assertTrue("Web page could not be accessed.", driver.getTitle().contains("Demo Web Shop"));

        Login();

        WebElement computersLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/computers'][1]")));
        actions.moveToElement(computersLink).build().perform();

        WebElement laptopLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/notebooks'][1]")));
        actions.moveToElement(laptopLink).click().build().perform();

        WebElement addToCartButton = driver.findElement(By.xpath("//input[@value='Add to cart']"));
        actions.moveToElement(addToCartButton).click().build().perform();

        WebElement shoppingCartLink = driver.findElement(By.xpath("//a[@class='ico-cart']"));
        actions.moveToElement(shoppingCartLink).click().build().perform();

        WebElement laptop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='product-name']")));
        Assert.assertTrue("The product you added to the cart does not appear.", laptop.isDisplayed());

        WebElement discountCode = driver.findElement(By.xpath("//input[@name='discountcouponcode']"));
        actions.moveToElement(discountCode).click().sendKeys("Test1").build().perform();

        WebElement applyCouponButton = driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']"));
        actions.moveToElement(applyCouponButton).click().build().perform();

        WebElement applyCouponMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),\"The coupon code you entered couldn't be applied to your order\")]")));
        Assert.assertTrue("The coupon code is not applied.", applyCouponMessage.isDisplayed());

        WebElement giftCardCode = driver.findElement(By.xpath("//input[@name='giftcardcouponcode']"));
        actions.moveToElement(giftCardCode).click().sendKeys("Test2").build().perform();

        WebElement applyGiftCardButton = driver.findElement(By.xpath("//input[@name='applygiftcardcouponcode']"));
        actions.moveToElement(applyGiftCardButton).click().build().perform();

        WebElement applyGiftCardMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),\"The coupon code you entered couldn't be applied to your order\")]")));
        Assert.assertTrue("The gift card code is not applied.", applyGiftCardMessage.isDisplayed());

        Select country = new Select(driver.findElement(By.xpath("//select[@id='CountryId']")));
        country.selectByVisibleText("United States");

        Select state = new Select(driver.findElement(By.xpath("//select[@id='StateProvinceId']")));
        state.selectByVisibleText("California");

        WebElement zipCode = driver.findElement(By.cssSelector("#ZipPostalCode"));
        zipCode.clear();
        zipCode.sendKeys("99999");

        WebElement termsOfService = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        actions.moveToElement(termsOfService).click().build().perform();

        WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
        actions.moveToElement(checkoutButton).click().build().perform();

        /// The address directing operations have been moved to BaseDriver.java and turned into methods.
        newAddressInput();

        WebElement shippingContinueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='Shipping.save()']")));
        actions.moveToElement(shippingContinueButton).click().build().perform();

        WebElement shippingMethod = driver.findElement(By.xpath("//input[@id='shippingoption_0']"));
        actions.moveToElement(shippingMethod).click().build().perform();

        WebElement shippingMethodContBtn = driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));
        actions.moveToElement(shippingMethodContBtn).click().build().perform();

        WebElement paymentMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='paymentmethod_2']")));
        actions.moveToElement(paymentMethod).click().build().perform();

        WebElement PayMethodContBtn = driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
        actions.moveToElement(PayMethodContBtn).click().build().perform();

        Select creditCard = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='CreditCardType']"))));
        creditCard.selectByVisibleText("Visa");

        WebElement cardHolderName = driver.findElement(By.xpath("//input[@id='CardholderName']"));
        actions.moveToElement(cardHolderName).click().sendKeys("Test Cardholder Name").build().perform();

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='CardNumber']"));
        actions.moveToElement(cardNumber).click().sendKeys("4242 4242 4242 4242").build().perform();

        Select expirationMonth = new Select(driver.findElement(By.xpath("//select[@id='ExpireMonth']")));
        expirationMonth.selectByVisibleText("01");

        Select expirationYear = new Select(driver.findElement(By.xpath("//select[@id='ExpireYear']")));
        expirationYear.selectByVisibleText("2032");

        WebElement cardCode = driver.findElement(By.xpath("//input[@id='CardCode']"));
        actions.moveToElement(cardCode).click().sendKeys("123").build().perform();

        WebElement paymentContBtn = driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']"));
        actions.moveToElement(paymentContBtn).click().build().perform();
        System.out.println("Payment information has been entered.");

        WebElement pageDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='column my-account'] h3")));
        actions.moveToElement(pageDown).build().perform();

        WebElement confirmOrderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='ConfirmOrder.save()']")));
        actions.moveToElement(confirmOrderButton).click().build().perform();

        WebElement orderCompletedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='title']/strong")));
        Assert.assertTrue("The order was not successful.", orderCompletedMessage.isDisplayed());
        System.out.println("Order successful.");

        TearDown();
    }
}
