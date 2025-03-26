package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Random;

public class BaseDriver {
    public static WebDriver driver;
    public static Actions actions;

    static {
        CloseFaultyWindows();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        actions = new Actions(driver);
    }

    public static void TearDown() {
        MyFunc.sleep(6);
        driver.quit();
    }

    public static void CloseFaultyWindows() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {
        }
    }

    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com"};
        Random random = new Random();

        StringBuilder username = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            username.append(characters.charAt(random.nextInt(characters.length())));
        }

        String domain = domains[random.nextInt(domains.length)];

        return username.toString() + "@" + domain;
    }

    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        Random random = new Random();

        StringBuilder password = new StringBuilder();
        while (!password.toString().matches(".*[A-Z].*") || !password.toString().matches(".*[a-z].*") || !password.toString().matches(".*[0-9].*") || !password.toString().matches(".*[!@#$%^&*].*")) {
            password.setLength(0);
            for (int i = 0; i < 8; i++) {
                password.append(characters.charAt(random.nextInt(characters.length())));
            }
        }

        return password.toString();
    }

    public static void newAddressInput() {
        WebElement firstName = driver.findElement(By.cssSelector("label[for='BillingNewAddress_FirstName']"));

        if (firstName.isDisplayed()) {
            WebElement billingCountry = driver.findElement(By.cssSelector("#BillingNewAddress_CountryId"));
            actions.moveToElement(billingCountry).click().build().perform();
            MyFunc.sleep(1);
            Select billingCountrySelect = new Select(billingCountry);
            billingCountrySelect.selectByValue("1");
            MyFunc.sleep(1);

            WebElement billingState = driver.findElement(By.cssSelector("#BillingNewAddress_StateProvinceId"));
            actions.moveToElement(billingState).click().build().perform();
            MyFunc.sleep(1);
            Select billingStateSelect = new Select(billingState);
            billingStateSelect.selectByValue("9");
            MyFunc.sleep(1);

            WebElement billingCity = driver.findElement(By.cssSelector("#BillingNewAddress_City"));
            actions.moveToElement(billingCity).click().sendKeys("Fresno").build().perform();
            MyFunc.sleep(1);

            WebElement billingAddress1 = driver.findElement(By.cssSelector("#BillingNewAddress_Address1"));
            actions.moveToElement(billingAddress1).click().sendKeys("2823 Fresno St").build().perform();
            MyFunc.sleep(1);

            WebElement billingZipCode = driver.findElement(By.cssSelector("#BillingNewAddress_ZipPostalCode"));
            actions.moveToElement(billingZipCode).click().sendKeys("99999").build().perform();
            MyFunc.sleep(1);

            WebElement billingPhoneNumber = driver.findElement(By.cssSelector("#BillingNewAddress_PhoneNumber"));
            actions.moveToElement(billingPhoneNumber).click().sendKeys("555-555-5555").build().perform();
            MyFunc.sleep(1);

            WebElement continueButton1 = driver.findElement(By.cssSelector("input[onclick='Billing.save()']"));
            continueButton1.click();
            System.out.println("Billing information saved.");
            MyFunc.sleep(5);
        } else {
            WebElement selectBillingAddress = driver.findElement(By.cssSelector("#billing-address-select"));
            actions.moveToElement(selectBillingAddress).click().build().perform();
            MyFunc.sleep(3);

            WebElement newAddress = driver.findElement(By.xpath("//option[normalize-space()='New Address']"));
            newAddress.click();
            MyFunc.sleep(3);

            WebElement billingCountry = driver.findElement(By.cssSelector("#BillingNewAddress_CountryId"));
            billingCountry.click();
            MyFunc.sleep(1);
            Select billingCountrySelect = new Select(billingCountry);
            billingCountrySelect.selectByValue("1");
            MyFunc.sleep(1);

            WebElement billingState = driver.findElement(By.cssSelector("#BillingNewAddress_StateProvinceId"));
            billingState.click();
            MyFunc.sleep(1);
            Select billingStateSelect = new Select(billingState);
            billingStateSelect.selectByValue("9");
            MyFunc.sleep(1);

            WebElement billingCity = driver.findElement(By.cssSelector("#BillingNewAddress_City"));
            billingCity.sendKeys("Fresno");
            MyFunc.sleep(1);

            WebElement billingAddress1 = driver.findElement(By.cssSelector("#BillingNewAddress_Address1"));
            billingAddress1.sendKeys("2823 Fresno St");
            MyFunc.sleep(1);

            WebElement billingZipCode = driver.findElement(By.cssSelector("#BillingNewAddress_ZipPostalCode"));
            billingZipCode.sendKeys("99999");
            MyFunc.sleep(1);

            WebElement billingPhoneNumber = driver.findElement(By.cssSelector("#BillingNewAddress_PhoneNumber"));
            billingPhoneNumber.sendKeys("555-555-5555");
            MyFunc.sleep(1);

            WebElement continueButton1 = driver.findElement(By.cssSelector("input[onclick='Billing.save()']"));
            continueButton1.click();
            System.out.println("Billing information saved.");
            MyFunc.sleep(5);
        }

    }
}
