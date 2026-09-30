package base;

import com.microsoft.playwright.Page;

import java.util.Objects;

//This class is created to avoid page null pointer exception
//As java initialize variables before constructors, the page will be null and so no web elements are located
public class BasePageObject {
    protected final Page page;

    public BasePageObject(Page page) {
        this.page = Objects.requireNonNull(page, "page must be initialized before creating page objects");
    }
}
