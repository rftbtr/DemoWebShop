package US_201;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_201_RegisterUser extends BaseDriver {
    @Test
    public void RegisterUserTest() {
        driver.get(" https://demowebshop.tricentis.com/");
        MyFunc.sleep(3);

        WebElement register = driver.findElement(By.cssSelector("a[href='/register']"));
        register.click();
        MyFunc.sleep(3);

        WebElement female = driver.findElement(By.cssSelector("input[id='gender-female']"));
        female.click();
        MyFunc.sleep(3);

        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("sibel");
        MyFunc.sleep(3);

        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("tester");
        MyFunc.sleep(3);

        String randomEmail = generateRandomEmail();
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys(randomEmail);
        MyFunc.sleep(3);

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("sibel12");
        MyFunc.sleep(3);

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("sibel12");
        MyFunc.sleep(3);

        WebElement loginRegister = driver.findElement(By.xpath("//input[@id='register-button']"));
        loginRegister.click();
        MyFunc.sleep(3);

        WebElement registrationSuccessful = driver.findElement(By.xpath("//input[@value='Continue']"));
        registrationSuccessful.click();
        MyFunc.sleep(3);

        WebElement exit = driver.findElement(By.xpath("(//a[normalize-space()='Log out'])[1]"));
        exit.click();
        MyFunc.sleep(3);

        TearDown();
    }
}
