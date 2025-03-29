package US_201;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;

public class TC_201_RegisterUser extends BaseDriver {

    @Test
    public void RegisterUserTest() {
        driver.get(" https://demowebshop.tricentis.com/");
        Assert.assertTrue("Web page could not be accessed.", driver.getTitle().contains("Demo Web Shop"));

        RegisterWithRandomEmail();
        Logout();

        TearDown();
    }
}
