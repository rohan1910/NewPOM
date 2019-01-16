package WebTest;

import org.openqa.selenium.By;

public class ComputersPage extends Utils {
    By _notebooksLink = By.xpath("//div[@class=\"picture\"]/a[@href=\"/notebooks\"]");
    By _sortPriceFunction = By.id("products-orderby");

    public void sort_price_high_to_low(){
        click_on_element(_notebooksLink);
        select_from_dropdown_by_int(_sortPriceFunction,(4));

    }
}
