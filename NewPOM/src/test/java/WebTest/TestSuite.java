package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestSuite extends BaseTest {
   private HomePage homePage = new HomePage();
    private RegistrationPage registrationPage = new RegistrationPage();
    private LogInPage logInPage = new LogInPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private EmailFriendPage emailFriendPage = new EmailFriendPage();
    private NoteBookApplePage noteBookApplePage = new NoteBookApplePage();
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private ComputersPage computersPage = new ComputersPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verify_registration() throws Exception{
        homePage.click_register_button();
        registrationPage.user_fills_in_Registration_page();
        String expected_message = "Your registration completed";
        String actual_message = get_text_from_Web_element(By.xpath("// div[@class=\"page-body\"] / div[@class=\"result\"]"));
        assert_equals(expected_message,actual_message,"Test case failed");
        click_on_element(By.linkText("Log out"));

    }

    @Test
    public void user_should_send_email_with_product_successfully() throws Exception{
        verify_registration();
        homePage.click_log_in_button();
        logInPage.user_enters_login_details();
        homePage.select_product_from_homepage();
        noteBookApplePage.user_clicks_on_email_friend();
        emailFriendPage.user_fills_in_email_friend_page();
        String expected_message = "Your message has been sent.";
        String actual_message = get_text_from_Web_element(By.xpath("//div[@class=\"result\"]"));
        assert_equals(expected_message,actual_message,"Test Case Has failed");

    }

    @Test
    public void unregistered_user_not_able_to_send_email() throws Exception{
        homePage.select_product_from_homepage();
        noteBookApplePage.user_clicks_on_email_friend();
        emailFriendPage.unregistered_user_enters_email();
        emailFriendPage.user_fills_in_email_friend_page();
        String expected_message = "Only registered customers can use email a friend feature";
        String actual_message = get_text_from_Web_element(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"));
        assert_equals(expected_message,actual_message,"Test Case Failed");

    }

    @Test
    public void user_must_accept_terms_and_conditions() throws Exception{
        homePage.select_product_from_homepage();
        noteBookApplePage.user_clicks_add_to_cart();
        shoppingCartPage.user_clicks_on_terms_and_service_button();
        String expected_message = "Welcome, Please Sign In!";
        String actual_message = get_text_from_Web_element(By.xpath("//div[@class=\"page-title\"]"));
        assert_equals(expected_message,actual_message,"Test Case Failed");
    }

    @Test
    public void registered_user_must_be_able_to_purchase_product_successfully() throws Exception{
        verify_registration();
        homePage.click_log_in_button();
        logInPage.user_enters_login_details();
        homePage.select_product_from_homepage();
        noteBookApplePage.user_clicks_add_to_cart();
        shoppingCartPage.user_clicks_on_terms_and_service_button();
        checkoutPage.user_fills_out_checkout_page();
        String expected_message = "Your order has been successfully processed!";
        String actual_message = get_text_from_Web_element(By.xpath("//div[@class=\"section order-completed\"]/div[@class=\"title\"]/strong"));
        assert_equals(expected_message,actual_message,"Test case failed");
    }

    @Test
    public void verify_addToCart__is_present_on_all_products_in_homepage()throws Exception{
        int count = 0;
        List<WebElement> addtocartlist = driver_findElements(By.xpath("// div[@class=\"item-grid\"]  / div / div[@class=\"product-item\"] / div[2] / div[3] / div[2] / input[1]"));
        for (WebElement a:addtocartlist) {
            softAssert.assertEquals("Add to cart",a.getAttribute("value"));
            count++;
        }
        assert_equals(addtocartlist.size(),count,"Test case failed");
        print(addtocartlist.size()+"");
        print(count+"");
        softAssert.assertAll();

    }

    @Test
    public void user_should_sort_price_High_to_Low()throws Exception{
        homePage.select_computer_link_from_homepage();
        computersPage.sort_price_high_to_low();
    }

}
