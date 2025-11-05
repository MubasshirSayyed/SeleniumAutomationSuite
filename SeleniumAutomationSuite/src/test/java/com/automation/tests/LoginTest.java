package com.automation.tests;

import com.automation.pages.LoginPage;
import com.automation.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"), "Login Failed!");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("invalid_user", "wrong_pass");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("saucedemo"), "Should not navigate away!");
    }
}
