package web.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import web.base.WebBasePage

class SignInPage(driver: WebDriver) : WebBasePage(driver) {

    @FindBy(id = "user_email")
    private val emailField: WebElement? = null

    @FindBy(id = "user_password")
    private val passwordField: WebElement? = null

    @FindBy(xpath = "//input[@value='Sign in']")
    private val signInButton: WebElement? = null

    fun signIn(
        email: String,
        password: String,
    ) {
        fillTextField(emailField, email)
        fillTextField(passwordField, password)
        clickOnElement(signInButton)
    }
}
