package pageInteractions;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.LoginOrSignupPageObject;

import static utils.ConfigReader.getProperty;
import static utils.EncryptAndDecrypt.decrypt;

public class LoginOrSignupPageInteraction extends LoginOrSignupPageObject
{
    private static final Logger logger = LogManager.getLogger(LoginOrSignupPageInteraction.class);

    public LoginOrSignupPageInteraction(Page page) {
        super(page);
    }

    public void login() throws Exception {
        logger.info("Entering login email");
        getLoginEmail().fill(getProperty("username"));

        logger.info("Entering login password");
        getLoginPassword().fill(decrypt(getProperty("password")));

        logger.info("Clicking login button");
        getLoginButton().click();
        logger.info("Login button clicked successfully");
    }
}
