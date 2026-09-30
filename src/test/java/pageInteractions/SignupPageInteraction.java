package pageInteractions;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.SignUpPageObject;

import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static utils.CommonUtilities.*;
import static utils.ConfigReader.*;
import static utils.EncryptAndDecrypt.*;

public class SignupPageInteraction extends SignUpPageObject {
    private static final Logger logger = LogManager.getLogger(SignupPageInteraction.class);

    public SignupPageInteraction(Page page) {
        super(page);
    }

    public static String name = generateRandomName();
    public static String email = generateRandomEmail();
    public static String mobileNumber = generateRandomPhoneNumber();

    public void navigateToSignupPage()
    {
        logger.info("Entering signup name: {}", name);
        getSignupName().fill(name);
        logger.info("Entering signup email: {}", email);
        getSignupEmail().fill(email);
        logger.info("Clicking signup button");
        getSignupButton().click();
        logger.info("Signup button clicked successfully");
        logger.info("Verifying Enter Account Information heading is visible");
        assertThat(getAccountInformationHeading()).isVisible();
        logger.info("Enter Account Information heading is visible");
    }

    public void signupUser() throws Exception {
        logger.info("Selecting title");
        getMrRadioButton().click();
        logger.info("Validating prefilled signup name and email");
        assertThat(getUserName()).hasValue(name);
        assertThat(getEmail()).hasValue(email);
        logger.info("Entering signup password");
        getPassword().fill(decrypt(getProperty("password")));
        logger.info("Selecting date of birth");
        Map<String, String> dob = generateRandomDOB();
        String day = dob.get("day");
        String month = dob.get("month");
        String year = dob.get("year");
        selectDropdownByVisibleText(getDays(), day);
        selectDropdownByVisibleText(getMonth(), month);
        selectDropdownByVisibleText(getYears(), year);
        logger.info("Selected date of birth: {}-{}-{}", day, month, year);
        logger.info("Selecting newsletter and offers checkboxes");
        checkCheckbox(getNewsLetterCheckbox());
        checkCheckbox(getOffersCheckbox());
        logger.info("Entering account address details");
        getCompany().scrollIntoViewIfNeeded();
        getfName().fill(name);
        getlName().fill(name);
        getCompany().fill(name);
        getAddress1().fill(name);
        getAddress2().fill(name);
        selectDropdownByVisibleText(getCountry(), "India");
        logger.info("Selected country: India");
        getState().fill(name);
        getCity().fill(name);
        getZip().fill(mobileNumber);
        getMobile().scrollIntoViewIfNeeded();
        getMobile().fill(mobileNumber);
        logger.info("Submitting create account form");
        getCreateAccount().click();
        logger.info("Validating account created confirmation");
        assertThat(getAccountCreated()).isVisible();
        logger.info("Account created successfully");
        logger.info("Clicking Continue button after account creation");
        getContinueButton().click();
        logger.info("Continue button clicked after account creation");
        logger.info("Verifying logged-in username is visible: {}", name);
        assertThat(getLoggedInUserName(name)).isVisible();
        logger.info("Logged-in username is visible: {}", name);
        logger.info("Clicking Delete Account link");
        getDeleteAccount().click();
        logger.info("Verifying Account Deleted confirmation is visible");
        assertThat(getAccountDeleted()).isVisible();
        logger.info("Account Deleted confirmation is visible");
        logger.info("Clicking Continue button after account deletion");
        getContinueButton().click();
        logger.info("Continue button clicked after account deletion");
    }
}
