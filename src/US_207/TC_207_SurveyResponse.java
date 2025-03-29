package US_207;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_207_SurveyResponse extends BaseDriver {

    @Test
    public void SurveyResponseTest() {
        driver.navigate().to("https://demowebshop.tricentis.com/");
        Assert.assertTrue("Web page could not be accessed.", driver.getTitle().contains("Demo Web Shop"));

        WebElement communityPoll = driver.findElement(By.cssSelector("[id='pollanswers-1']"));
        actions.moveToElement(communityPoll).click().build().perform();

        WebElement errorVote = driver.findElement(By.xpath("//*[@id='poll-block-1'] /div /input"));
        actions.moveToElement(errorVote).click().build().perform();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='poll-block-1'] /div /following::div")));
        Assert.assertTrue("Error Message Not Found", errorMessage.isDisplayed());
        System.out.println(errorMessage.getText());

        /**
         * We tried to vote without logging in and got an error message.
         * Because Community Poll voting can only be done once after logging in with a registered user
         * In order to ensure the flow of the test, votes were sent to the Community Poll voting by registering with random e-mail each time.
         */

        RegisterWithRandomEmail();

        WebElement community = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='pollanswers-1']")));
        actions.moveToElement(community).click().build().perform();

        WebElement vote = driver.findElement(By.xpath("//*[@id='poll-block-1'] /div /input"));
        actions.moveToElement(vote).click().build().perform();

        WebElement communityResults = driver.findElement(By.xpath("//ul[@class='poll-results']"));
        Assert.assertTrue("Votes Not Found", communityResults.isDisplayed());
        System.out.println(communityResults.getText());

        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='poll-total-votes']")));
        Assert.assertTrue("Results Not Found", results.isDisplayed());
        System.out.println(results.getText());

        TearDown();
    }
}
