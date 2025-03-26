package US_207;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_207_SurveyResponse extends BaseDriver {
    @Test
    public void SurveyResponseTest() {
        String email = "naxeh39287@boyaga.com";
        String password = "123456789b";
        driver.navigate().to("https://demowebshop.tricentis.com/");
        MyFunc.sleep(1);

        WebElement communityPoll = driver.findElement(By.cssSelector("[id='pollanswers-1']"));
        actions.moveToElement(communityPoll).click().build().perform();
        MyFunc.sleep(1);

        WebElement errorVote = driver.findElement(By.xpath("//*[@id='poll-block-1'] /div /input"));
        actions.moveToElement(errorVote).click().build().perform();
        MyFunc.sleep(1);

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='poll-block-1'] /div /following::div"));
        Assert.assertTrue("Error Message Not Found", errorMessage.isDisplayed());
        System.out.println(errorMessage.getText());

        WebElement loginButton = driver.findElement(By.xpath("//a[@class='ico-login']"));
        actions.moveToElement(loginButton).click().build().perform();
        MyFunc.sleep(1);

        WebElement emailHolder = driver.findElement(By.xpath("//input[@id='Email']"));
        actions.moveToElement(emailHolder).click().sendKeys(email).build().perform();

        WebElement passwordHolder = driver.findElement(By.xpath("//input[@id='Password']"));
        actions.moveToElement(passwordHolder).click().sendKeys(password).build().perform();

        WebElement login = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(login).click().build().perform();

        WebElement community = driver.findElement(By.cssSelector("[id='pollanswers-1']"));
        actions.moveToElement(community).click().build().perform();
        MyFunc.sleep(1);

        WebElement vote = driver.findElement(By.xpath("//*[@id='poll-block-1'] /div /input"));
        actions.moveToElement(vote).click().build().perform();
        MyFunc.sleep(1);

        WebElement communityResults = driver.findElement(By.xpath("//ul[@class='poll-results']"));
        Assert.assertTrue("Votes Not Found", communityResults.isDisplayed());
        System.out.println(communityResults.getText());

        WebElement results = driver.findElement(By.xpath("//span[@class='poll-total-votes']"));
        Assert.assertTrue("Results Not Found", results.isDisplayed());
        System.out.println(results.getText());

        TearDown();
    }
}
