package US_202;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_202_RegisterUserNegative extends BaseDriver {

    @Test
    public void RegisterUserNegativeTest() {
        driver.get("https://demowebshop.tricentis.com/");
        Assert.assertTrue("Web page could not be accessed.", driver.getTitle().contains("Demo Web Shop"));

        WebElement register = driver.findElement(By.xpath("//*[text()='Register']"));
        register.click();

        WebElement male = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='gender-male']")));
        Assert.assertTrue("Register page could not be accessed.", driver.getTitle().contains("Demo Web Shop. Register"));
        male.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Azim");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Korkmaz");

        String randomEmail = generateRandomEmail();
        WebElement registerEmail = driver.findElement(By.xpath("//input[@id='Email']"));
        registerEmail.sendKeys(randomEmail);

        WebElement registerPassword = driver.findElement(By.xpath("//input[@id='Password']"));
        registerPassword.sendKeys("Testdemowepshop2");

        WebElement registerConfirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        registerConfirmPassword.sendKeys("Testdemowepshop2");

        WebElement registerLoginButton = driver.findElement(By.xpath("//input[@id='register-button']"));
        registerLoginButton.click();

        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Continue']")));
        Assert.assertTrue("Registration was not successful.", continueButton.isDisplayed());
        System.out.println("Registration was successful.");
        continueButton.click();

        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Log out']")));
        logout.click();

        WebElement signInLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Log in']")));
        signInLogin.click();

        WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
        emailField.sendKeys(randomEmail);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password'] "));
        passwordField.sendKeys("Testdemowepshop2");

        WebElement rememberMe = driver.findElement(By.xpath("//input[@id='RememberMe']"));
        rememberMe.click();

        WebElement submitLoginButton = driver.findElement(By.cssSelector("input[value='Log in']"));
        submitLoginButton.click();

        WebElement loginSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='header-links'] a[class='account']")));
        Assert.assertTrue("The login was not successful.", loginSuccess.isDisplayed());
        System.out.println("Login successful.");

        logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Log out']")));
        logout.click();

        register = driver.findElement(By.xpath("//*[text()='Register']"));
        register.click();
        Assert.assertTrue("Register page could not be accessed.", driver.getTitle().contains("Demo Web Shop. Register"));

        male = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='gender-male']")));
        male.click();

        firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Azim");

        lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Korkmaz");

        registerEmail = driver.findElement(By.xpath("//input[@id='Email']"));
        registerEmail.sendKeys(randomEmail);

        registerPassword = driver.findElement(By.xpath("//input[@id='Password']"));
        registerPassword.sendKeys("Testdemowepshop2");

        registerConfirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        registerConfirmPassword.sendKeys("Testdemowepshop2");

        registerLoginButton = driver.findElement(By.xpath("//input[@id='register-button']"));
        registerLoginButton.click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='The specified email already exists']")));
        Assert.assertTrue(" error message would appear on the screen", errorMessage.isDisplayed());
        System.out.println("Error message was displayed.");

        TearDown();
    }
}
