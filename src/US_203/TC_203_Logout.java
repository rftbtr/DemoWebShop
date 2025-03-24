package US_203;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_203_Logout extends BaseDriver {

    @Test
    public void Test1() {

        String email="rfttest@gmail.com";
        String password="rft12345";
        driver.get("https://demowebshop.tricentis.com/");
        Assert.assertEquals("The website could not be accessed...", "https://demowebshop.tricentis.com/", driver.getCurrentUrl());

        WebElement login1Button = driver.findElement(By.className("ico-login"));
        login1Button.click();
        MyFunc.sleep(2);
        Assert.assertEquals("Login page could not be reached.", "https://demowebshop.tricentis.com/login", driver.getCurrentUrl());

        WebElement emailField= driver.findElement(By.id("Email"));
        emailField.sendKeys(email);
        Assert.assertEquals("Inconsistent email address.","rfttest@gmail.com",emailField.getAttribute("value"));

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys(password);

        WebElement login2Button= driver.findElement(By.xpath("//*[contains(@class,'button-1 login-button')]"));
        login2Button.click();
        MyFunc.sleep(2);
        Assert.assertEquals("Failed to return to homepage...", "https://demowebshop.tricentis.com/", driver.getCurrentUrl());

        WebElement userCheck= driver.findElement(By.xpath("//a[text()='rfttest@gmail.com']"));
        Assert.assertEquals("User not verified!",email,userCheck.getText());
        System.out.println("LOGIN SUCCESS");

        WebElement logoutButton = driver.findElement(By.className("ico-logout"));
        logoutButton.click();
        WebElement checkLogout = driver.findElement(By.className("ico-register"));
        Assert.assertTrue(checkLogout.isDisplayed());
        System.out.println("LogOut REALIZED");

        WaitAndClose();
    }
}
