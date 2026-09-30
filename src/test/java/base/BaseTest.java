package base;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageInteractions.HomePageInteraction;
import pageInteractions.LoginOrSignupPageInteraction;
import pageInteractions.SignupPageInteraction;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static utils.ConfigReader.getProperty;

public class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    protected Page page;

    public BrowserContext getBrowserContext() {
        return context;
    }
    public Playwright getPlaywright() {
        return playwright;
    }
    public Browser getBrowser() {
        return browser;
    }
    public Page getPage() {
        return page;
    }

    public HomePageInteraction homePageInteraction;
    public LoginOrSignupPageInteraction loginOrSignupPageInteraction;
    public SignupPageInteraction signupPageInteraction;


    private void initialize() {
        String url = getProperty("url");
        logger.info("Initializing Playwright");
        playwright = Playwright.create();
        logger.info("Launching browser");
        BrowserType.LaunchOptions browserOptions = new BrowserType.LaunchOptions();
        browser = playwright.chromium().launch(browserOptions
                .setChannel("msedge")
                .setHeadless(false)
                .setSlowMo(1000)
                .setArgs(List.of("--start-maximized")));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = context.newPage();
        logger.info("Navigating to URL: {}", url);
        page.navigate(url);
        logger.info("Browser setup completed");
        page.waitForLoadState();
        Locator homeHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("AutomationExercise"));
        logger.info("Validating home page heading is visible");
        assertThat(homeHeading).isVisible();
        logger.info("Home page heading is visible");
    }

    @BeforeTest
    public void beforeMethod() {
        logger.info("Starting test setup");
        initialize();
        logger.info("Test setup completed");
    }

    @BeforeMethod
    public void objectAllocation()
    {
        logger.info("Initializing page interaction objects");
        homePageInteraction = new HomePageInteraction(page);
        loginOrSignupPageInteraction = new LoginOrSignupPageInteraction(page);
        signupPageInteraction = new SignupPageInteraction(page);
        logger.info("Page interaction objects initialized");
    }

    @AfterTest
    public void afterMethod() {
        logger.info("Closing browser resources");
        if (page != null) {
            logger.info("Closing page");
            page.close();
        }
        if (context != null) {
            logger.info("Closing browser context");
            context.close();
        }
        if (browser != null) {
            logger.info("Closing browser");
            browser.close();
        }
        if (playwright != null) {
            logger.info("Closing Playwright");
            playwright.close();
        }
        logger.info("Browser resources closed");
    }


}
