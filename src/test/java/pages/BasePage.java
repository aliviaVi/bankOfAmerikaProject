package pages;

import context.TestContext;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
   public TestContext context;

    public BasePage(TestContext context) {
        this.context = context;
        PageFactory.initElements(context.driver, this);
    }
}
