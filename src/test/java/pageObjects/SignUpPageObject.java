package pageObjects;

import base.BasePageObject;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class SignUpPageObject extends BasePageObject {
    public SignUpPageObject(Page page) {
        super(page);
    }

    private final Locator signupName = page.locator("[data-qa='signup-name']");
    private final Locator signupEmail = page.locator("[data-qa='signup-email']");
    private final Locator signupButton = page.locator("[data-qa='signup-button']");
    private final Locator accountInformationHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(Pattern.compile("Enter Account Information", Pattern.CASE_INSENSITIVE)));
    private final Locator mrRadioButton = page.locator("#id_gender1");
    private final Locator mrsRadioButton = page.locator("#id_gender2");
    private final Locator userName = page.locator("#name");
    private final Locator email = page.locator("#email");
    private final Locator password = page.locator("#password");
    private final Locator days = page.locator("#days");
    private final Locator month = page.locator("#months");
    private final Locator years = page.locator("#years");
    private final Locator newsLetterCheckbox = page.locator("#newsletter");
    private final Locator offersCheckbox = page.locator("#optin");
    private final Locator fName = page.locator("#first_name");
    private final Locator lName = page.locator("#last_name");
    private final Locator company = page.locator("#company");
    private final Locator address1 = page.locator("#address1");
    private final Locator address2 = page.locator("#address2");
    private final Locator country = page.locator("#country");
    private final Locator state = page.locator("#state");
    private final Locator city = page.locator("#city");
    private final Locator zip = page.locator("#zipcode");
    private final Locator mobile = page.locator("#mobile_number");
    private final Locator createAccount = page.locator("[data-qa='create-account']");
    private final Locator accountCreated = page.locator("[data-qa='account-created']");
    private final Locator accountDeleted = page.locator("[data-qa='account-deleted']");
    private final Locator continueButton = page.locator("[data-qa='continue-button']");
    private final Locator deleteAccount = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Delete Account"));

    private Locator loggedInUserName(String uname) {return page.getByText("Logged in as " + uname, new Page.GetByTextOptions().setExact(true));}

    public Locator getLoggedInUserName(String uname) {return loggedInUserName(uname);}

    public Locator getAccountDeleted() {return accountDeleted;}

    public Locator getDeleteAccount() {return deleteAccount;}

    public Locator getContinueButton() {return continueButton;}

    public Locator getAccountCreated() {return accountCreated;}

    public Locator getCreateAccount() {return createAccount;}

    public Locator getNewsLetterCheckbox() {return newsLetterCheckbox;}

    public Locator getOffersCheckbox() {return offersCheckbox;}

    public Locator getfName() {return fName;}

    public Locator getlName() {return lName;}

    public Locator getCompany() {return company;}

    public Locator getAddress1() {return address1;}

    public Locator getAddress2() {return address2;}

    public Locator getCountry() {return country;}

    public Locator getState() {return state;}

    public Locator getCity() {return city;}

    public Locator getZip() {return zip;}

    public Locator getMobile() {return mobile;}

    public Locator getMrRadioButton() {return mrRadioButton;}

    public Locator getMrsRadioButton() {return mrsRadioButton;}

    public Locator getUserName() {return userName;}

    public Locator getEmail() {return email;}

    public Locator getPassword() {return password;}

    public Locator getDays() {return days;}

    public Locator getMonth() {return month;}

    public Locator getYears() {return years;}

    public Locator getSignupName() {return signupName;}

    public Locator getSignupEmail() {return signupEmail;}

    public Locator getSignupButton() {return signupButton;}

    public Locator getAccountInformationHeading() {return accountInformationHeading;}

}
