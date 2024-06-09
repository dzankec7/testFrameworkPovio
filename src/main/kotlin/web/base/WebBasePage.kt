package web.base

import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

open class WebBasePage(driver: WebDriver) {
    protected val wait = WebDriverWait(driver, Duration.ofSeconds(30L))
    protected var driver: WebDriver = driver

    init {
        PageFactory.initElements(AjaxElementLocatorFactory(driver, 10), this)
    }

    fun navigateToUrl(url: String) {
        driver.navigate().to(url)
        wait.until(ExpectedConditions.urlContains(url))
    }

    fun clickOnElement(aWebElement: WebElement?, scrollToElement: Boolean = true) {
        if (scrollToElement) {
            scrollToElement(aWebElement)
        }
        aWebElement!!.click()
    }

    fun scrollToElement(element: WebElement?) {
        val action = Actions(driver)
        action.moveToElement(element)
        action.perform()
    }

    fun isElementDisplayed(element: WebElement?): Boolean {
        return try {
            element!!.isDisplayed
        } catch (exception: NoSuchElementException) {
            false
        }
    }

    fun fillTextField(webElement: WebElement?, value: String, intervalMS: Long = 0) {
        webElement!!.click()
        value.toCharArray()
            .forEach {
                webElement.sendKeys(it.toString())
                Thread.sleep(intervalMS.coerceAtMost((250)))
            }
    }

    class DynamicWebElement(private val locatorValue: String) {

        fun parseDynamicLocator(
            dynamicPortion: String,
            driver: WebDriver,
            locatorType: LocatorType = LocatorType.XPATH,
        ): WebElement {
            val resolvedLocatorValue = String.format(locatorValue, dynamicPortion)
            val locator = when (locatorType) {
                LocatorType.XPATH -> By.xpath(resolvedLocatorValue)
                LocatorType.ID -> By.id(resolvedLocatorValue)
            }
            return driver.findElement(locator)
        }

        enum class LocatorType {
            ID,
            XPATH,
        }
    }
}
