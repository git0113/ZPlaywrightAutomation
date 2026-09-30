package pageInteractions;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.HomePageObject;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageInteraction extends HomePageObject
{
    private static final Logger logger = LogManager.getLogger(HomePageInteraction.class);

    public HomePageInteraction(Page page) {
        super(page);
    }

    public void navigateToSignupOrLoginPage()
    {
        logger.info("Clicking Signup/Login link on home page");
        getSignUpOrLoginLink().click();
        logger.info("Verifying New User Signup heading is visible");
        assertThat(getSignupHeading()).isVisible();
        logger.info("New User Signup heading is visible");

    }

}
