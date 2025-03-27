package US_205;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_205_NegativeLogin extends BaseDriver {
    @Test
    public void NegativeLoginTest() {
        String email = "testorbekli@gmail.com";
        String password = "sibel12";
        String randomEmail = "mrtcn@gmail.com";
        String randomPassword = "mrt.123";
        driver.navigate().to("https://demowebshop.tricentis.com/");
        MyFunc.sleep(1);

        WebElement mainLogin = driver.findElement(By.xpath("//*[@class='ico-login']"));
        actions.moveToElement(mainLogin).click().build().perform();
        MyFunc.sleep(1);

        WebElement firstLogin = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(firstLogin).click().build().perform();
        MyFunc.sleep(1);

        WebElement errorMessage = driver.findElement(By.xpath("//*[@class='validation-summary-errors']"));
        Assert.assertTrue("Error Message Not Found", errorMessage.isDisplayed());
        System.out.println(errorMessage.getText());

        WebElement mainLogin1 = driver.findElement(By.xpath("//*[@class='ico-login']"));
        actions.moveToElement(mainLogin1).click().build().perform();
        MyFunc.sleep(1);

        WebElement mail = driver.findElement(By.xpath("//*[@id='Email']"));
        actions.moveToElement(mail).click().sendKeys(email).build().perform();
        MyFunc.sleep(1);

        WebElement secondLogin = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(secondLogin).click().build().perform();
        MyFunc.sleep(1);

        WebElement errorMessage2 = driver.findElement(By.xpath("//*[@class='validation-summary-errors']"));
        Assert.assertTrue("Error Message Not Found", errorMessage2.isDisplayed());
        System.out.println("Error Message Displayed");

        WebElement mainLogin2 = driver.findElement(By.xpath("//*[@class='ico-login']"));
        actions.moveToElement(mainLogin2).click().build().perform();
        MyFunc.sleep(1);

        WebElement passwrd = driver.findElement(By.xpath("//*[@id='Password']"));
        actions.moveToElement(passwrd).click().sendKeys(password).build().perform();
        MyFunc.sleep(1);

        WebElement thirdLogin = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(thirdLogin).click().build().perform();
        MyFunc.sleep(1);

        WebElement errorMessage3 = driver.findElement(By.xpath("//*[@class='validation-summary-errors']"));
        Assert.assertTrue("Error Message Not Found", errorMessage3.isDisplayed());
        System.out.println("Error Message Displayed");
        MyFunc.sleep(1);

        WebElement mainLogin3 = driver.findElement(By.xpath("//*[@class='ico-login']"));
        actions.moveToElement(mainLogin3).click().build().perform();
        MyFunc.sleep(1);

        WebElement randomMail = driver.findElement(By.xpath("//*[@id='Email']"));
        actions.moveToElement(randomMail).click().sendKeys(randomEmail).build().perform();
        MyFunc.sleep(2);

        WebElement randomPasswrd = driver.findElement(By.xpath("//*[@id='Password']"));
        actions.moveToElement(randomPasswrd).click().sendKeys(randomPassword).build().perform();
        MyFunc.sleep(1);

        WebElement randomLogin = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(randomLogin).click().build().perform();
        MyFunc.sleep(1);

        WebElement errorMessage4 = driver.findElement(By.xpath("//*[@class='validation-summary-errors']"));
        Assert.assertTrue("Error Message Not Found", errorMessage4.isDisplayed());
        System.out.println("Error Message Displayed");


        TearDown();

    }
}

