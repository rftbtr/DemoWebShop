package US_206;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_206_Ordering extends BaseDriver {
    @Test
    public void OrderingTest() {
        driver.navigate().to("https://demowebshop.tricentis.com/");
        MyFunc.sleep(2);

        Assert.assertTrue("Web page could not be accessed.", driver.getTitle().contains("Demo Web Shop"));
        MyFunc.sleep(2);

        WebElement loginLink = driver.findElement(By.cssSelector(".ico-login"));
        actions.moveToElement(loginLink).click().build().perform();
        MyFunc.sleep(3);

        Assert.assertTrue("The login page could not be accessed.", driver.getTitle().contains("Login"));
        MyFunc.sleep(1);

        WebElement emailInput = driver.findElement(By.cssSelector("#Email"));
        actions.moveToElement(emailInput).click().sendKeys("cigeyab754@erapk.com").build().perform();
        MyFunc.sleep(1);

        WebElement passwordInput = driver.findElement(By.cssSelector("#Password"));
        actions.moveToElement(passwordInput).click().sendKeys("BugFathers4!").build().perform();
        MyFunc.sleep(1);

        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log in']"));
        actions.moveToElement(loginButton).click().build().perform();
        MyFunc.sleep(3);

        WebElement loginSuccess = driver.findElement(By.cssSelector("div[class='header-links'] a[class='account']"));
        Assert.assertTrue("The login was not successful.", loginSuccess.isDisplayed());
        System.out.println("Login successful.");
        MyFunc.sleep(3);

        WebElement pageDown = driver.findElement(By.cssSelector("div[class='column my-account'] h3"));
        actions.moveToElement(pageDown).build().perform();
        MyFunc.sleep(3);

        WebElement laptop = driver.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'14.1-inch Laptop')]"));
        actions.moveToElement(laptop).click().build().perform();
        MyFunc.sleep(5);

        Assert.assertTrue("The page could not be accessed.", driver.getTitle().contains("14.1-inch Laptop"));
        MyFunc.sleep(3);

        WebElement addToCart = driver.findElement(By.cssSelector("#add-to-cart-button-31"));
        actions.moveToElement(addToCart).click().build().perform();
        MyFunc.sleep(5);

        WebElement shoppingCart = driver.findElement(By.cssSelector("li[id='topcartlink'] [class='cart-label']"));
        actions.moveToElement(shoppingCart).click().build().perform();
        MyFunc.sleep(3);

        WebElement checkout = driver.findElement(By.cssSelector("#checkout"));
        Assert.assertTrue("The checkout button is not displayed.", checkout.isDisplayed());
        MyFunc.sleep(3);

        WebElement country = driver.findElement(By.xpath("//select[@id='CountryId']"));
        country.click();
        MyFunc.sleep(3);
        Select countrySelect = new Select(country);
        countrySelect.selectByValue("1");
        MyFunc.sleep(3);

        WebElement state = driver.findElement(By.cssSelector("#StateProvinceId"));
        state.click();
        MyFunc.sleep(2);
        Select stateSelect = new Select(state);
        stateSelect.selectByValue("9");
        MyFunc.sleep(2);

        WebElement zipCode = driver.findElement(By.cssSelector("#ZipPostalCode"));
        zipCode.clear();
        MyFunc.sleep(2);
        zipCode.sendKeys("99999");
        MyFunc.sleep(1);

        WebElement termsOfService = driver.findElement(By.cssSelector("#termsofservice"));
        actions.moveToElement(termsOfService).click().build().perform();
        MyFunc.sleep(1);

        actions.moveToElement(checkout).click().build().perform();
        MyFunc.sleep(3);

        WebElement checkoutSuccess = driver.findElement(By.cssSelector("div[class='page-title'] h1"));
        Assert.assertTrue("The checkout was not successful.", checkoutSuccess.isDisplayed());
        MyFunc.sleep(3);

        /// address directing operations have been moved to BaseDriver.java and turned into methods.
        newAddressInput();
        MyFunc.sleep(2);

        WebElement shippingMethodMessage = driver.findElement(By.cssSelector("p[class='description'] i"));
        Assert.assertTrue("The shipping method is not displayed.", shippingMethodMessage.isDisplayed());
        MyFunc.sleep(3);

        WebElement inStorePickup = driver.findElement(By.cssSelector("label[for='PickUpInStore']"));
        Assert.assertTrue("The in-store pickup option is not displayed.", inStorePickup.isDisplayed());
        actions.moveToElement(inStorePickup).click().build().perform();
        MyFunc.sleep(3);

        WebElement continueButton2 = driver.findElement(By.cssSelector("input[onclick='Shipping.save()']"));
        continueButton2.click();
        System.out.println("Shipping method selected.");
        MyFunc.sleep(3);

        WebElement paymentMethodMessage = driver.findElement(By.cssSelector("div[class='payment-details'] label[for='paymentmethod_2']"));
        Assert.assertTrue("The payment method is not displayed.", paymentMethodMessage.isDisplayed());
        MyFunc.sleep(3);

        WebElement creditCard = driver.findElement(By.cssSelector("#paymentmethod_2"));
        creditCard.click();
        MyFunc.sleep(1);

        WebElement continueButton3 = driver.findElement(By.cssSelector("input[class='button-1 payment-method-next-step-button']"));
        continueButton3.click();
        System.out.println("Payment method selected.");
        MyFunc.sleep(3);

        WebElement paymentOptionCreditCard = driver.findElement(By.cssSelector("label[for='CreditCardTypes']"));
        Assert.assertTrue("The payment option is not displayed.", paymentOptionCreditCard.isDisplayed());
        MyFunc.sleep(3);

        WebElement creditCardType = driver.findElement(By.cssSelector("#CreditCardType"));
        creditCardType.click();
        MyFunc.sleep(3);
        Select creditCardTypeSelect = new Select(creditCardType);
        creditCardTypeSelect.selectByValue("Visa");
        MyFunc.sleep(3);

        WebElement cardholderName = driver.findElement(By.cssSelector("#CardholderName"));
        cardholderName.sendKeys("Techno Study");
        MyFunc.sleep(1);

        WebElement creditCardNumber = driver.findElement(By.cssSelector("#CardNumber"));
        creditCardNumber.sendKeys("4242 4242 4242 4242");
        MyFunc.sleep(1);

        WebElement expirationMonth = driver.findElement(By.cssSelector("#ExpireMonth"));
        expirationMonth.click();
        MyFunc.sleep(2);
        Select expirationMonthSelect = new Select(expirationMonth);
        expirationMonthSelect.selectByValue("1");
        MyFunc.sleep(2);

        WebElement expirationYear = driver.findElement(By.cssSelector("#ExpireYear"));
        expirationYear.click();
        MyFunc.sleep(2);
        Select expirationYearSelect = new Select(expirationYear);
        expirationYearSelect.selectByValue("2032");
        MyFunc.sleep(2);

        WebElement cardCode = driver.findElement(By.cssSelector("#CardCode"));
        cardCode.sendKeys("123");
        MyFunc.sleep(3);

        WebElement continueButton4 = driver.findElement(By.cssSelector("input[class='button-1 payment-info-next-step-button']"));
        continueButton4.click();
        System.out.println("Payment information saved.");
        MyFunc.sleep(3);

        pageDown = driver.findElement(By.cssSelector("div[class='column my-account'] h3"));
        actions.moveToElement(pageDown).build().perform();
        MyFunc.sleep(3);

        WebElement subTotal = driver.findElement(By.xpath("//span[@class='product-price']"));
        Assert.assertTrue("The subtotal is not displayed.", subTotal.isDisplayed());
        String subTotalText = subTotal.getText().trim();
        float floatSubTotal = Float.parseFloat(subTotalText);
        MyFunc.sleep(3);

        WebElement total = driver.findElement(By.xpath("//span[@class='product-price order-total']"));
        Assert.assertTrue("The total is not displayed.", total.isDisplayed());
        String totalText = total.getText().trim();
        float floatTotal = Float.parseFloat(totalText);
        MyFunc.sleep(3);

        Assert.assertEquals("Sub-total and Order-total do not match", floatSubTotal, floatTotal, 0.1f);
        System.out.println("The total is correct.");
        MyFunc.sleep(3);

        WebElement confirmOrder = driver.findElement(By.cssSelector("input[value='Confirm']"));
        confirmOrder.click();
        System.out.println("Order confirmed.");
        MyFunc.sleep(3);

        WebElement orderSuccess = driver.findElement(By.cssSelector("div[class='title'] strong"));
        Assert.assertTrue("The order was not successful.", orderSuccess.isDisplayed());
        System.out.println("Order successful.");

        TearDown();
    }
}
