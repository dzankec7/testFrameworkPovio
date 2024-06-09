package web.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import web.base.WebBasePage

class RegistrationPage(driver: WebDriver) : WebBasePage(driver) {

    @FindBy(id = "user_name")
    private val nameField: WebElement? = null

    @FindBy(id = "user_email")
    private val emailField: WebElement? = null

    @FindBy(id = "user_password")
    private val passwordField: WebElement? = null

    @FindBy(id = "user_password_confirmation")
    private val passwordConfirmationField: WebElement? = null

    @FindBy(xpath = "//input[@value='Sign up']")
    private val signUpButton: WebElement? = null

    @FindBy(id = "error_explanation")
    private val errorMessage: WebElement? = null

    val getErrorMessageText: String get() = errorMessage!!.text

    fun createNewUser(
        name: String,
        email: String,
        password: String,
        passwordConfirmation: String,
    ) {
        navigateToUrl("https://povio-at.herokuapp.com/users/sign_up")
        populateRegistrationFields(name, email, password, passwordConfirmation)
        clickOnSignUpButton()
    }

    private fun populateRegistrationFields(
        name: String,
        email: String,
        password: String,
        passwordConfirmation: String,
    ) {
        fillTextField(nameField, name)
        fillTextField(emailField, email)
        fillTextField(passwordField, password)
        fillTextField(passwordConfirmationField, passwordConfirmation)
    }

    private fun clickOnSignUpButton() {
        clickOnElement(signUpButton)
    }
}
