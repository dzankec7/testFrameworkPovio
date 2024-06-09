package web.testcases

import org.testng.Assert.assertEquals
import org.testng.annotations.Test
import web.base.WebBaseTest
import web.pages.HomePage
import web.pages.RegistrationPage
import java.util.UUID

class RegistrationFlowTest : WebBaseTest() {

    @Test
    fun successfulRegistration() {
        val registrationPage = RegistrationPage(driver)
        registrationPage.navigateToUrl("https://povio-at.herokuapp.com/users/sign_up")
        registrationPage.createNewUser(
            name = "Test${UUID.randomUUID()}",
            email = "Test${UUID.randomUUID()}@povio.com",
            password = "bB11111#",
            passwordConfirmation = "bB11111#",
        )
        val homePage = HomePage(driver)
        assertEquals(
            homePage.getMessageText,
            "Welcome! You have signed up successfully.",
            "Successful sign up message is not displayed.",
        )
    }

    @Test
    fun unsuccessfulRegistration() {
        val registrationPage = RegistrationPage(driver)
        registrationPage.navigateToUrl("https://povio-at.herokuapp.com/users/sign_up")
        registrationPage.createNewUser(
            name = "Test${UUID.randomUUID()}",
            email = "tes123t@gmail.com",
            password = "bB11111#",
            passwordConfirmation = "bB11111#",
        )
        assertEquals(
            registrationPage.getErrorMessageText,
            "Email has already been taken",
            "Error message for taken email is not displayed.",
        )
    }
}
