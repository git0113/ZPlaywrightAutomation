package pageObjects;

import base.BasePageObject;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class LoginOrSignupPageObject extends BasePageObject
{
    public LoginOrSignupPageObject(Page page)
    {
        super(page);
    }

    private final Locator loginEmail = page.locator("[data-qa='login-email']");
    private final Locator loginPassword = page.locator("[data-qa='login-password']");
    private final Locator loginButton = page.locator("[data-qa='login-button']");

    public Locator getLoginButton() {
        return loginButton;
    }

    public Locator getLoginPassword() {
        return loginPassword;
    }

    public Locator getLoginEmail() {
        return loginEmail;
    }


}
