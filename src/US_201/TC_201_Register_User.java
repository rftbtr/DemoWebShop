package US_201;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_201_Register_User extends BaseDriver {
    @Test
    public void Test201() {
        driver.get(" https://demowebshop.tricentis.com/");
        System.out.println("demowebshop.com will go to the site");
        MyFunc.sleep(3);

        WebElement register = driver.findElement(By.cssSelector("a[href='/register']"));
        register.click();
        MyFunc.sleep(3);
        System.out.println("Register button clicked");

        WebElement female = driver.findElement(By.cssSelector("input[id='gender-female']"));
        female.click();
        MyFunc.sleep(3);
        System.out.println("female button clicked ");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("sibel");
        MyFunc.sleep(3);
        System.out.println("Fist name button spelled sibel ");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("tester");
        MyFunc.sleep(3);
        System.out.println("tester was typed in the last name button ");

        String randomEmail = generateRandomEmail();
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys(randomEmail);
        MyFunc.sleep(3);
        System.out.println("testorbekli67@gmail.com typed in the email button  ");

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("sibel12");
        MyFunc.sleep(3);
        System.out.println("sibel12 typed in password button ");

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("sibel12");
        MyFunc.sleep(3);
        System.out.println("sibel12 typed in confirmpassword button");//input[@id='ConfirmPassword']

        WebElement loginRegister = driver.findElement(By.xpath("//input[@id='register-button']"));
        loginRegister.click();
        MyFunc.sleep(3);
        System.out.println("Register button clicked");

        WebElement registrationSuccessful = driver.findElement(By.xpath("//input[@value='Continue']"));
        registrationSuccessful.click();
        MyFunc.sleep(3);

        WebElement exit = driver.findElement(By.xpath("(//a[normalize-space()='Log out'])[1]"));
        exit.click();
        MyFunc.sleep(3);


        TearDown();
    }
}
