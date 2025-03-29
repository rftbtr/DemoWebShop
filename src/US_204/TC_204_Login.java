package US_204;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;

public class TC_204_Login extends BaseDriver {

    @Test
    public void LoginTest() {
        driver.get("https://demowebshop.tricentis.com/");
        Assert.assertEquals("The website could not be accessed...", "https://demowebshop.tricentis.com/", driver.getCurrentUrl());

        Login();

        TearDown();
    }
}
