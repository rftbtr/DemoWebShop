package US_205;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_205_NegativeLogin extends BaseDriver {

    @Test
    public void NegativeLoginTest() {
        String email = "cigeyab754@erapk.com";
        String password = "BugFathers4!";
        String randomEmail = "mrtcn@gmail.com";
        String randomPassword = "mrt.1234";

        driver.navigate().to("https://demowebshop.tricentis.com/");
        Assert.assertTrue("Web page could not be accessed.", driver.getTitle().contains("Demo Web Shop"));

        WebElement signInLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Log in']")));
        actions.moveToElement(signInLogin).click().build().perform();

        WebElement submitLoginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='button-1 login-button']")));
        actions.moveToElement(submitLoginButton).click().build().perform();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='validation-summary-errors']")));
        Assert.assertTrue("Error Message Not Found", errorMessage.isDisplayed());
        System.out.println("When the Login button was pressed without entering Email and Password, an error message was displayed.");

        signInLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Log in']")));
        actions.moveToElement(signInLogin).click().build().perform();

        WebElement emailField = driver.findElement(By.xpath("//*[@id='Email']"));
        actions.moveToElement(emailField).click().sendKeys(email).build().perform();

        submitLoginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(submitLoginButton).click().build().perform();

        errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='validation-summary-errors']")));
        Assert.assertTrue("Error Message Not Found", errorMessage.isDisplayed());
        System.out.println("An error message was displayed when the Login button was pressed without entering the password.");

        signInLogin = driver.findElement(By.xpath("//*[@class='ico-login']"));
        actions.moveToElement(signInLogin).click().build().perform();

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Password']")));
        actions.moveToElement(passwordField).click().sendKeys(password).build().perform();

        submitLoginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(submitLoginButton).click().build().perform();

        errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='validation-summary-errors']")));
        Assert.assertTrue("Error Message Not Found", errorMessage.isDisplayed());
        System.out.println("An error message was displayed when the Login button was pressed by entering only Password without entering Email.");

        signInLogin = driver.findElement(By.xpath("//*[@class='ico-login']"));
        actions.moveToElement(signInLogin).click().build().perform();

        WebElement randomMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Email']")));
        actions.moveToElement(randomMail).click().sendKeys(randomEmail).build().perform();

        WebElement randomPasswordField = driver.findElement(By.xpath("//*[@id='Password']"));
        actions.moveToElement(randomPasswordField).click().sendKeys(randomPassword).build().perform();

        submitLoginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(submitLoginButton).click().build().perform();

        errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='validation-summary-errors']")));
        Assert.assertTrue("Error Message Not Found", errorMessage.isDisplayed());
        System.out.println("An error message was displayed when the Login button was pressed with an unregistered Random Email and Password.");

        TearDown();
    }
}

