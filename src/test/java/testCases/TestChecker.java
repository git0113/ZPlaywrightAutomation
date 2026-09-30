package testCases;

import base.BaseTest;
import org.testng.annotations.Test;

public class TestChecker extends BaseTest {

    @Test
    public void checkTest() throws Exception {
        homePageInteraction.navigateToSignupOrLoginPage();
        //loginOrSignupPageInteraction.login();
        signupPageInteraction.navigateToSignupPage();
        signupPageInteraction.signupUser();
    }
}
