package US_204;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_204_Login extends BaseDriver {

    @Test
    public void LoginTest() {

        String email = "rfttest@gmail.com";
        String password = "rft12345";
        driver.get("https://demowebshop.tricentis.com/");
        Assert.assertEquals("The website could not be accessed...", "https://demowebshop.tricentis.com/", driver.getCurrentUrl());

        WebElement login1Button = driver.findElement(By.className("ico-login"));
        actions.moveToElement(login1Button).click().build().perform();
        MyFunc.sleep(2);
        Assert.assertEquals("Login page could not be reached.", "https://demowebshop.tricentis.com/login", driver.getCurrentUrl());

        WebElement emailField = driver.findElement(By.id("Email"));
        actions.moveToElement(emailField).click().sendKeys(email).build().perform();
        Assert.assertEquals("Inconsistent email address.", "rfttest@gmail.com", emailField.getAttribute("value"));

        WebElement passwordField = driver.findElement(By.id("Password"));
        actions.moveToElement(passwordField).click().sendKeys(password).build().perform();

        WebElement login2Button = driver.findElement(By.xpath("//*[contains(@class,'button-1 login-button')]"));
        actions.moveToElement(login2Button).click().build().perform();
        MyFunc.sleep(2);
        Assert.assertEquals("Failed to return to homepage...", "https://demowebshop.tricentis.com/", driver.getCurrentUrl());

        WebElement userCheck = driver.findElement(By.xpath("//a[text()='rfttest@gmail.com']"));
        Assert.assertEquals("User not verified!", email, userCheck.getText());
        System.out.println("LOGIN SUCCESS");

        TearDown();
    }
}
