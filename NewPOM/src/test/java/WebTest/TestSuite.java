package WebTest;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void verify_registration(){
        homePage.click_register_button();
    }


}
