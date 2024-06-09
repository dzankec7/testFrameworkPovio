package web.testcases

import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import web.base.WebBaseTest
import web.pages.HomePage

class AppHealthCheckTest : WebBaseTest() {

    @Test
    fun verifyAppHealth() {
        val homePage = HomePage(driver)
        homePage.navigateToUrl("https://povio-at.herokuapp.com/")
        assertEquals(homePage.getHeaderText, "Welcome", "Header is not displayed or does not have correct value")
        homePage.clickOnNavTab("Sign in")
        assertTrue(homePage.isSignInModalDisplayed(), "Sign in page is not opened")
        homePage.clickOnNavTab("Sign up")
        assertTrue(homePage.isSignUpModalDisplayed(), "Sign up page is not opened")
    }
}
