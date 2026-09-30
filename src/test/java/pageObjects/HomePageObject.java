package pageObjects;

import base.BasePageObject;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class HomePageObject extends BasePageObject {

    public HomePageObject(Page page)
    {
        super(page);
    }

    private final Locator signUpOrLoginLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Signup / Login"));
    private final Locator loginHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(Pattern.compile("Login")));
    private final Locator signupHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(Pattern.compile("Signup")));

    public Locator getSignUpOrLoginLink() {
        return signUpOrLoginLink;
    }

    public Locator getLoginHeading() {
        return loginHeading;
    }

    public Locator getSignupHeading() {return signupHeading;}
}
