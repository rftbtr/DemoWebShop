package US_208;

import Utility.BaseDriver;
import Utility.MyFunc;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class US_208_Negative_Using_coupons_and_gift_cards extends BaseDriver {

    @Test
    public void US_208_Negative_Using_coupons_and_gift_cards() {
        driver.get("https://demowebshop.tricentis.com");

        WebElement loginLink = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginLink.click();
        MyFunc.sleep(1);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
        emailField.sendKeys("test55@testin.com");
        MyFunc.sleep(1);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
        passwordField.sendKeys("Test12345");
        MyFunc.sleep(1);

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        MyFunc.sleep(1);

        WebElement computersLink = driver.findElement(By.xpath("//a[@href='/computers'][1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(computersLink).build().perform();
        MyFunc.sleep(1);

        WebElement laptopLink = driver.findElement(By.xpath("//a[@href='/notebooks'][1]"));
        laptopLink.click();
        MyFunc.sleep(1);

        WebElement addToCartButton = driver.findElement(By.xpath("//input[@value='Add to cart']"));
        addToCartButton.click();
        MyFunc.sleep(1);

        WebElement shoppingCartLink = driver.findElement(By.xpath("//a[@class='ico-cart']"));
        shoppingCartLink.click();
        MyFunc.sleep(1);

        WebElement laptop = driver.findElement(By.xpath("//a[@class='product-name']"));
        MyFunc.sleep(1);

        Assert.assertTrue("The product you added to the cart does not appear.", laptop.isDisplayed());
        MyFunc.sleep(1);

        WebElement discountCode = driver.findElement(By.xpath("//input[@name='discountcouponcode']"));
        discountCode.sendKeys("Test1");
        MyFunc.sleep(1);

        WebElement applyCouponButton = driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']"));
        applyCouponButton.click();
        MyFunc.sleep(2);

        WebElement applyCouponMessage = driver.findElement(By.xpath("//div[contains(text(),\"The coupon code you entered couldn't be applied to your order\")]"));

        Assert.assertTrue("The coupon code is not applied.", applyCouponMessage.isDisplayed());
        MyFunc.sleep(1);

        WebElement giftCardCode = driver.findElement(By.xpath("//input[@name='giftcardcouponcode']"));
        giftCardCode.sendKeys("Test2");
        MyFunc.sleep(1);

        WebElement applyGiftCardButton = driver.findElement(By.xpath("//input[@name='applygiftcardcouponcode']"));
        applyGiftCardButton.click();
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
        clickAgreeButton.click();
        MyFunc.sleep(1);

        WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkoutButton.click();
        MyFunc.sleep(1);

        Select newAddress = new Select(driver.findElement(By.xpath("//select[@id='billing-address-select']")));
        newAddress.selectByVisibleText("New Address");
        MyFunc.sleep(1);

        Select country2 = new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
        country2.selectByVisibleText("United States");
        MyFunc.sleep(1);

        Select state2 = new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']")));
        state2.selectByVisibleText("New York");
        MyFunc.sleep(1);

        WebElement city = driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        city.sendKeys("New York");
        MyFunc.sleep(1);

        WebElement address1 = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']"));
        address1.sendKeys("123 Main Street");
        MyFunc.sleep(1);

        WebElement zipCode2 = driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
        zipCode2.sendKeys("12345");
        MyFunc.sleep(1);

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='BillingNewAddress.PhoneNumber']"));
        phoneNumber.sendKeys("1234567890");
        MyFunc.sleep(1);

        WebElement continueButton = driver.findElement(By.xpath("//input[@onclick='Billing.save()']"));
        continueButton.click();
        MyFunc.sleep(3);

        WebElement continueButton2 = driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
        continueButton2.click();
        MyFunc.sleep(1);

        WebElement shippingMethod = driver.findElement(By.xpath("//input[@id='shippingoption_0']"));
        shippingMethod.click();
        MyFunc.sleep(1);

        WebElement continueButton3 = driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));
        continueButton3.click();

        WebElement paymentMethod = driver.findElement(By.xpath("//input[@id='paymentmethod_2']"));
        paymentMethod.click();
        MyFunc.sleep(1);

        WebElement continueButton4 = driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
        continueButton4.click();
        MyFunc.sleep(1);

        Select creditCard = new Select(driver.findElement(By.xpath("//select[@id='CreditCardType']")));
        creditCard.selectByVisibleText("Visa");
        MyFunc.sleep(1);

        WebElement cardHolderName = driver.findElement(By.xpath("//input[@id='CardholderName']"));
        cardHolderName.sendKeys("Test Cardholder Name");
        MyFunc.sleep(1);

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='CardNumber']"));
        cardNumber.sendKeys("4242 4242 4242 4242");
        MyFunc.sleep(1);

        Select expirationMonth = new Select(driver.findElement(By.xpath("//select[@id='ExpireMonth']")));
        expirationMonth.selectByVisibleText("01");
        MyFunc.sleep(1);

        Select expirationYear = new Select(driver.findElement(By.xpath("//select[@id='ExpireYear']")));
        expirationYear.selectByVisibleText("2032");

        WebElement cardCode = driver.findElement(By.xpath("//input[@id='CardCode']"));
        cardCode.sendKeys("123");
        MyFunc.sleep(1);

        WebElement continueButton5 = driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']"));
        continueButton5.click();
        MyFunc.sleep(1);

        WebElement confirmOrderButton = driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));
        confirmOrderButton.click();
        MyFunc.sleep(1);

        WebElement orderCompletedMessage = driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));

        Assert.assertTrue("The order is not completed.", orderCompletedMessage.isDisplayed());
        MyFunc.sleep(1);

        TearDown();
    }
}
