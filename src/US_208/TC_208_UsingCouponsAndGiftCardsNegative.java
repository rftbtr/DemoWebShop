package US_208;

import Utility.BaseDriver;
import Utility.MyFunc;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_208_UsingCouponsAndGiftCardsNegative extends BaseDriver {

    @Test
    public void UsingCouponsAndGiftCardsNegativeTest() {
        driver.get("https://demowebshop.tricentis.com");

        WebElement loginLink = driver.findElement(By.xpath("//a[@class='ico-login']"));
        actions.moveToElement(loginLink).click().build().perform();
        MyFunc.sleep(1);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
        actions.moveToElement(emailField).click().sendKeys("test55@testin.com").build().perform();
        MyFunc.sleep(1);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
        actions.moveToElement(passwordField).click().sendKeys("Test12345").build().perform();
        MyFunc.sleep(1);

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(loginButton).click().build().perform();
        MyFunc.sleep(1);

        WebElement computersLink = driver.findElement(By.xpath("//a[@href='/computers'][1]"));

        actions.moveToElement(computersLink).build().perform();
        MyFunc.sleep(1);

        WebElement laptopLink = driver.findElement(By.xpath("//a[@href='/notebooks'][1]"));
        actions.moveToElement(laptopLink).click().build().perform();
        MyFunc.sleep(1);

        WebElement addToCartButton = driver.findElement(By.xpath("//input[@value='Add to cart']"));
        actions.moveToElement(addToCartButton).click().build().perform();
        MyFunc.sleep(1);

        WebElement shoppingCartLink = driver.findElement(By.xpath("//a[@class='ico-cart']"));
        actions.moveToElement(shoppingCartLink).click().build().perform();
        MyFunc.sleep(1);

        WebElement laptop = driver.findElement(By.xpath("//a[@class='product-name']"));
        MyFunc.sleep(1);

        Assert.assertTrue("The product you added to the cart does not appear.", laptop.isDisplayed());
        MyFunc.sleep(1);

        WebElement discountCode = driver.findElement(By.xpath("//input[@name='discountcouponcode']"));
        actions.moveToElement(discountCode).click().sendKeys("Test1").build().perform();
        MyFunc.sleep(1);

        WebElement applyCouponButton = driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']"));
        actions.moveToElement(applyCouponButton).click().build().perform();
        MyFunc.sleep(2);

        WebElement applyCouponMessage = driver.findElement(By.xpath("//div[contains(text(),\"The coupon code you entered couldn't be applied to your order\")]"));

        Assert.assertTrue("The coupon code is not applied.", applyCouponMessage.isDisplayed());
        MyFunc.sleep(1);

        WebElement giftCardCode = driver.findElement(By.xpath("//input[@name='giftcardcouponcode']"));
        actions.moveToElement(giftCardCode).click().sendKeys("Test2").build().perform();
        MyFunc.sleep(1);

        WebElement applyGiftCardButton = driver.findElement(By.xpath("//input[@name='applygiftcardcouponcode']"));
        actions.moveToElement(applyGiftCardButton).click().build().perform();
        MyFunc.sleep(2);

        WebElement applyGiftCardMessage = driver.findElement(By.xpath("//div[contains(text(),\"The coupon code you entered couldn't be applied to your order\")]"));

        Assert.assertTrue("The gift card code is not applied.", applyGiftCardMessage.isDisplayed());
        MyFunc.sleep(1);

        Select country = new Select(driver.findElement(By.xpath("//select[@id='CountryId']")));
        country.selectByVisibleText("United States");
        MyFunc.sleep(1);

        Select state = new Select(driver.findElement(By.xpath("//select[@id='StateProvinceId']")));
        state.selectByVisibleText("New York");
        MyFunc.sleep(1);

        WebElement clickAgreeButton = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        actions.moveToElement(clickAgreeButton).click().build().perform();
        MyFunc.sleep(1);

        WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
        actions.moveToElement(checkoutButton).click().build().perform();
        MyFunc.sleep(1);

        /// address directing operations have been moved to BaseDriver.java and turned into methods.
        newAddressInput();
        MyFunc.sleep(2);

        WebElement continueButton2 = driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
        actions.moveToElement(continueButton2).click().build().perform();
        MyFunc.sleep(1);

        WebElement shippingMethod = driver.findElement(By.xpath("//input[@id='shippingoption_0']"));
        actions.moveToElement(shippingMethod).click().build().perform();
        MyFunc.sleep(1);

        WebElement continueButton3 = driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));
        actions.moveToElement(continueButton3).click().build().perform();
        MyFunc.sleep(1);

        WebElement paymentMethod = driver.findElement(By.xpath("//input[@id='paymentmethod_2']"));
        actions.moveToElement(paymentMethod).click().build().perform();
        MyFunc.sleep(1);

        WebElement continueButton4 = driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
        actions.moveToElement(continueButton4).click().build().perform();
        MyFunc.sleep(1);

        Select creditCard = new Select(driver.findElement(By.xpath("//select[@id='CreditCardType']")));
        creditCard.selectByVisibleText("Visa");
        MyFunc.sleep(1);

        WebElement cardHolderName = driver.findElement(By.xpath("//input[@id='CardholderName']"));
        actions.moveToElement(cardHolderName).click().sendKeys("Test Cardholder Name").build().perform();
        MyFunc.sleep(1);

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='CardNumber']"));
        actions.moveToElement(cardNumber).click().sendKeys("4242 4242 4242 4242").build().perform();
        MyFunc.sleep(1);

        Select expirationMonth = new Select(driver.findElement(By.xpath("//select[@id='ExpireMonth']")));
        expirationMonth.selectByVisibleText("01");
        MyFunc.sleep(1);

        Select expirationYear = new Select(driver.findElement(By.xpath("//select[@id='ExpireYear']")));
        expirationYear.selectByVisibleText("2032");

        WebElement cardCode = driver.findElement(By.xpath("//input[@id='CardCode']"));
        actions.moveToElement(cardCode).click().sendKeys("123").build().perform();
        MyFunc.sleep(1);

        WebElement continueButton5 = driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']"));
        actions.moveToElement(continueButton5).click().build().perform();
        MyFunc.sleep(1);

        WebElement confirmOrderButton = driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));
        actions.moveToElement(confirmOrderButton).click().build().perform();
        MyFunc.sleep(1);

        WebElement orderCompletedMessage = driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));

        Assert.assertTrue("The order is not completed.", orderCompletedMessage.isDisplayed());
        MyFunc.sleep(1);

        TearDown();
    }
}
