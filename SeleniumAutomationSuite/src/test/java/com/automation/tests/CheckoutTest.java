package com.automation.tests;

import com.automation.pages.*;
import com.automation.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckoutFlow() {
        // Step 1: Login
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Step 2: Add item to cart
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addFirstItemToCart();
        inventory.openCart();

        // Step 3: Proceed to checkout
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        // Step 4: Fill checkout details
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillDetails("Mubasshir", "Sayyed", "411001");
        checkout.finishCheckout();

        // Step 5: Assert success message
        String msg = checkout.getSuccessMessage();
        Assert.assertEquals(msg, "Thank you for your order!", "Checkout failed!");
    }
}
