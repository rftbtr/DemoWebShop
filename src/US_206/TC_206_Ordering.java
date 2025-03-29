package US_206;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TC_206_Ordering extends BaseDriver {

    @Test
    public void OrderingTest() {
        driver.navigate().to("https://demowebshop.tricentis.com/");
        Assert.assertTrue("Web page could not be accessed.", driver.getTitle().contains("Demo Web Shop"));

        Login();

        WebElement pageDown = driver.findElement(By.cssSelector("div[class='column my-account'] h3"));
        actions.moveToElement(pageDown).build().perform();

        WebElement laptop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='product-title']//a[contains(text(),'14.1-inch Laptop')]")));
        actions.moveToElement(laptop).click().build().perform();

        Assert.assertTrue("The page could not be accessed.", driver.getTitle().contains("14.1-inch Laptop"));

        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#add-to-cart-button-31")));
        actions.moveToElement(addToCartButton).click().build().perform();

        WebElement shoppingCart = driver.findElement(By.cssSelector("li[id='topcartlink'] [class='cart-label']"));
        actions.moveToElement(shoppingCart).click().build().perform();

        WebElement checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout")));
        Assert.assertTrue("The checkout button is not displayed.", checkout.isDisplayed());

        WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='CountryId']")));
        country.click();
        Select countrySelect = new Select(country);
        countrySelect.selectByValue("1");

        WebElement state = driver.findElement(By.cssSelector("#StateProvinceId"));
        state.click();
        Select stateSelect = new Select(state);
        stateSelect.selectByValue("9");

        WebElement zipCode = driver.findElement(By.cssSelector("#ZipPostalCode"));
        zipCode.clear();
        zipCode.sendKeys("99999");

        WebElement termsOfService = driver.findElement(By.cssSelector("#termsofservice"));
        actions.moveToElement(termsOfService).click().build().perform();

        actions.moveToElement(checkout).click().build().perform();

        WebElement checkoutSuccess = driver.findElement(By.cssSelector("div[class='page-title'] h1"));
        Assert.assertTrue("The checkout was not successful.", checkoutSuccess.isDisplayed());

        /// The address directing operations have been moved to BaseDriver.java and turned into methods.
        newAddressInput();

        WebElement shippingMethodMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='description'] i")));
        Assert.assertTrue("The shipping method is not displayed.", shippingMethodMessage.isDisplayed());

        WebElement inStorePickup = driver.findElement(By.cssSelector("label[for='PickUpInStore']"));
        Assert.assertTrue("The in-store pickup option is not displayed.", inStorePickup.isDisplayed());
        actions.moveToElement(inStorePickup).click().build().perform();

        WebElement shippingContinueButton = driver.findElement(By.cssSelector("input[onclick='Shipping.save()']"));
        shippingContinueButton.click();
        System.out.println("Shipping method selected.");

        WebElement paymentMethodMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='payment-details'] label[for='paymentmethod_2']")));
        Assert.assertTrue("The payment method is not displayed.", paymentMethodMessage.isDisplayed());

        WebElement creditCard = driver.findElement(By.cssSelector("#paymentmethod_2"));
        creditCard.click();

        WebElement PayMethodContBtn = driver.findElement(By.cssSelector("input[class='button-1 payment-method-next-step-button']"));
        PayMethodContBtn.click();
        System.out.println("Payment method selected.");

        WebElement paymentOptionCreditCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='CreditCardTypes']")));
        Assert.assertTrue("The payment option is not displayed.", paymentOptionCreditCard.isDisplayed());

        WebElement creditCardType = driver.findElement(By.cssSelector("#CreditCardType"));
        creditCardType.click();
        Select creditCardTypeSelect = new Select(creditCardType);
        creditCardTypeSelect.selectByValue("Visa");

        WebElement cardholderName = driver.findElement(By.cssSelector("#CardholderName"));
        cardholderName.sendKeys("Techno Study");

        WebElement creditCardNumber = driver.findElement(By.cssSelector("#CardNumber"));
        creditCardNumber.sendKeys("4242 4242 4242 4242");

        WebElement expirationMonth = driver.findElement(By.cssSelector("#ExpireMonth"));
        expirationMonth.click();
        Select expirationMonthSelect = new Select(expirationMonth);
        expirationMonthSelect.selectByValue("1");

        WebElement expirationYear = driver.findElement(By.cssSelector("#ExpireYear"));
        expirationYear.click();
        Select expirationYearSelect = new Select(expirationYear);
        expirationYearSelect.selectByValue("2032");

        WebElement cardCode = driver.findElement(By.cssSelector("#CardCode"));
        cardCode.sendKeys("123");

        WebElement paymentContBtn = driver.findElement(By.cssSelector("input[class='button-1 payment-info-next-step-button']"));
        paymentContBtn.click();
        System.out.println("Payment information saved.");

        pageDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='column my-account'] h3")));
        actions.moveToElement(pageDown).build().perform();

        WebElement subTotal = driver.findElement(By.xpath("//span[@class='product-price']"));
        Assert.assertTrue("The subtotal is not displayed.", subTotal.isDisplayed());
        String subTotalText = subTotal.getText().trim();
        float floatSubTotal = Float.parseFloat(subTotalText);

        WebElement total = driver.findElement(By.xpath("//span[@class='product-price order-total']"));
        Assert.assertTrue("The total is not displayed.", total.isDisplayed());
        String totalText = total.getText().trim();
        float floatTotal = Float.parseFloat(totalText);

        Assert.assertEquals("Sub-total and Order-total do not match", floatSubTotal, floatTotal, 0.1f);
        System.out.println("The total is correct.");

        WebElement confirmOrderButton = driver.findElement(By.cssSelector("input[value='Confirm']"));
        confirmOrderButton.click();
        System.out.println("Order confirmed.");

        WebElement orderCompletedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='title']/strong")));
        Assert.assertTrue("The order was not successful.", orderCompletedMessage.isDisplayed());
        System.out.println("Order successful.");

        TearDown();
    }
}
