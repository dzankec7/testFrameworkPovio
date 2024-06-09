package web.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import web.base.WebBasePage

class EditAccountPage(driver: WebDriver) : WebBasePage(driver) {

    @FindBy(xpath = "//input[@value='Cancel my account']")
    private val cancelMyAccountButton: WebElement? = null

    fun clickOnCancelMyAccountButton() {
        clickOnElement(cancelMyAccountButton)
    }

    fun cancelAccount() {
        navigateToUrl("https://povio-at.herokuapp.com/users/edit")
        wait.until(ExpectedConditions.urlContains("https://povio-at.herokuapp.com/users/edit"))
        clickOnCancelMyAccountButton()
        driver.switchTo().alert().accept()
    }
}
