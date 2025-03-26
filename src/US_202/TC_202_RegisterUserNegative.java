package US_202;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_202_RegisterUserNegative extends BaseDriver {

    @Test
    public void RegisterUserNegativeTest() {
        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("went to demowebshop.com");
        MyFunc.sleep(2);

        WebElement register = driver.findElement(By.cssSelector("a[href='/register']"));
        register.click();
        MyFunc.sleep(2);

        WebElement men = driver.findElement(By.cssSelector("input[id='gender-male']"));
        men.click();
        MyFunc.sleep(2);

        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Azim");
        MyFunc.sleep(2);

        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Korkmaz");
        MyFunc.sleep(2);

        String randomEmail = generateRandomEmail();
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys(randomEmail);
        MyFunc.sleep(2);

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("denemedemowepshop2");
        MyFunc.sleep(2);

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("denemedemowepshop2");
        MyFunc.sleep(2);

        WebElement loginRegister = driver.findElement(By.xpath("//input[@id='register-button']"));
        loginRegister.click();
        MyFunc.sleep(2);

        WebElement registrationSuccessful = driver.findElement(By.xpath("//input[@value='Continue']"));
        registrationSuccessful.click();
        MyFunc.sleep(2);

        WebElement exit = driver.findElement(By.xpath("(//a[normalize-space()='Log out'])[1]"));
        exit.click();
        MyFunc.sleep(2);

        WebElement login = driver.findElement(By.xpath("//a[normalize-space()='Log in']"));
        login.click();
        MyFunc.sleep(2);

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='Email']"));
        emailInput.sendKeys(randomEmail);
        MyFunc.sleep(2);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='Password'] "));
        passwordInput.sendKeys("denemedemowepshop2");
        MyFunc.sleep(2);

        WebElement rememberMe = driver.findElement(By.xpath("//input[@id='RememberMe']"));
        rememberMe.click();
        MyFunc.sleep(2);

        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log in']"));
        loginButton.click();
        MyFunc.sleep(2);

        WebElement logout = driver.findElement(By.cssSelector(".ico-logout"));
        logout.click();
        MyFunc.sleep(2);

        WebElement register1 = driver.findElement(By.cssSelector("a[href='/register']"));
        register1.click();
        MyFunc.sleep(2);

        WebElement men1 = driver.findElement(By.cssSelector("input[id='gender-male']"));
        men1.click();
        MyFunc.sleep(2);

        WebElement firstName1 = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName1.sendKeys("Azim");
        MyFunc.sleep(2);

        WebElement lastName1 = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName1.sendKeys("Korkmaz");
        MyFunc.sleep(2);

        WebElement email1 = driver.findElement(By.xpath("//input[@id='Email']"));
        email1.sendKeys(randomEmail);
        MyFunc.sleep(2);

        WebElement password1 = driver.findElement(By.xpath("//input[@id='Password']"));
        password1.sendKeys("denemedemowepshop2");
        MyFunc.sleep(2);

        WebElement confirmPassword1 = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword1.sendKeys("denemedemowepshop2");
        MyFunc.sleep(2);

        WebElement loginRegister1 = driver.findElement(By.xpath("//input[@id='register-button']"));
        loginRegister1.click();
        MyFunc.sleep(2);

        WebElement errorMessage = driver.findElement(By.xpath("//li[normalize-space()='The specified email already exists']"));
        MyFunc.sleep(2);

        Assert.assertTrue(" error message would appear on the screen", errorMessage.isDisplayed());

        TearDown();

    }
}
