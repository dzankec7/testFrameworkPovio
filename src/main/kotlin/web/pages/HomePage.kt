package web.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import web.base.WebBasePage

class HomePage(driver: WebDriver) : WebBasePage(driver) {

    @FindBy(id = "flash_notice")
    private val message: WebElement? = null

    private val navTab = DynamicWebElement("//a[contains(text(), '%s')]")

    @FindBy(xpath = "//div/h3")
    private val welcomeHeader: WebElement? = null

    @FindBy(id = "new_user")
    private val signInModal: WebElement? = null

    @FindBy(xpath = "//form[@action='/users']")
    private val signUpModal: WebElement? = null

    val getMessageText: String get() = message!!.text
    val getHeaderText: String get() = welcomeHeader!!.text

    fun isSignInModalDisplayed(): Boolean {
        wait.until(ExpectedConditions.urlContains("https://povio-at.herokuapp.com/users/sign_in"))
        return isElementDisplayed(signInModal)
    }

    fun isSignUpModalDisplayed(): Boolean {
        wait.until(ExpectedConditions.urlContains("https://povio-at.herokuapp.com/users/sign_up"))
        return isElementDisplayed(signUpModal)
    }

    fun isNavTabDisplayed(tabName: String): Boolean {
        return navTab.parseDynamicLocator(tabName, driver, DynamicWebElement.LocatorType.XPATH).isDisplayed
    }

    fun clickOnNavTab(tabName: String) {
        navTab.parseDynamicLocator(tabName, driver, DynamicWebElement.LocatorType.XPATH)
    }
}
