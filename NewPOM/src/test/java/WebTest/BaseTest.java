package WebTest;

import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils {
    BroswerSelector broswerSelector = new BroswerSelector();

  @BeforeMethod
    public void open_browser(){
      broswerSelector.browserselector();
  }
}
