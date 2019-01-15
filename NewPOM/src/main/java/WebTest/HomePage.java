package WebTest;

import org.openqa.selenium.By;

public class HomePage extends Utils {
    By _registerLink = By.linkText("Register");


    public void click_register_button(){
        click_on_element(_registerLink);

    }
}
