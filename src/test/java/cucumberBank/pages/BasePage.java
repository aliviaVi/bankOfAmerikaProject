package cucumberBank.pages;

import cucumberBank.context.TestContext;
import org.openqa.selenium.support.PageFactory;

public class BasePage {


    public BasePage() {
        PageFactory.initElements(TestContext.getThreadLocalDriver(), this);
    }
}
