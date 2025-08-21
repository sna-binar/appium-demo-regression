package tests;

import com.applitools.eyes.selenium.Eyes;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.EyesManager;

import static org.testng.Assert.assertTrue;

public class CheckoutJourneyTestWithApplitools extends BaseTest {
    EyesManager eyesManager = new EyesManager();
    Eyes eyes = null;

    private HomePage homePage;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;
    private ThankYouPage thankYouPage;

    @BeforeClass()
    public void setUpPage() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
        thankYouPage = new ThankYouPage(driver);
    }

    @Test(description = "User can log in")
    public void loginTest() {
        try {
            eyes = eyesManager.getEyes(driver, "Visual Check - Login Page");
            homePage.goToViewMenuPage();
            // Integrasi visual testing Applitools pada View Menu Page
            homePage.visualCheckHomePage(eyes);
            homePage.goToLoginPage();

            // Integrasi visual testing Applitools pada Login Page
            loginPage.visualCheckLoginPage(eyes);
            loginPage.enterUsername("bod@example.com");
            loginPage.enterPassword("10203040");
            loginPage.clickLoginButton();
            // Tutup Eyes session setelah semua check
            eyesManager.closeEyes();

        } finally {
            if (eyes != null) {
                eyesManager.abortEyesIfNotClosed();
            }
        }
    }

    @Test(description = "User can add product to cart and open cart",
            dependsOnMethods = "loginTest")
    public void addProductToCartTest() {
        productsPage.clickSauceLabsBackpack();
        productsPage.clickAddToCartBtn();
        productsPage.clickCartBtn();
    }

    @Test(description = "User can proceed from cart to checkout",
            dependsOnMethods = "addProductToCartTest")
    public void proceedToCheckoutTest() {
        cartPage.clickProceedToCheckout();
    }

    @Test(description = "User can fill shipping details and proceed to payment",
            dependsOnMethods = "proceedToCheckoutTest")
    public void fillShippingTest() {
        checkoutPage.enterFullName("QA Test");
        checkoutPage.enterAddress("123 Test Street");
        checkoutPage.enterCity("Test City");
        checkoutPage.enterZipCode("12345");
        checkoutPage.enterCountry("Indonesia");
        checkoutPage.clickProceedToReviewOrder();
        checkoutPage.clickProceedToPayment();
    }

    @Test(description = "User can fill payment details and place order",
            dependsOnMethods = "fillShippingTest")
    public void paymentAndPlaceOrderTest() {
        paymentPage.enterFullName("QA Test");
        paymentPage.enterCardNumber("1234567890123456");
        paymentPage.enterExpirationDate("1230");
        paymentPage.enterSecurityCode("123");
        paymentPage.clickReviewOrderButton();
        paymentPage.clickPlaceOrderButton();
    }

    @Test(description = "Thank You page is displayed with expected elements",
            dependsOnMethods = "paymentAndPlaceOrderTest")
    public void verifyThankYouPageTest() {
        assertTrue(thankYouPage.isCheckoutCompleteDisplayed(),       "Checkout Complete text should be displayed");
        assertTrue(thankYouPage.isThankYouForYourOrderDisplayed(),   "Thank you for your order text should be displayed");
        assertTrue(thankYouPage.isContinueShoppingButtonDisplayed(), "Continue Shopping button should be displayed");
    }
}
