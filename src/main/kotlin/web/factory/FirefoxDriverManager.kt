package web.factory

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import java.time.Duration

class FirefoxDriverManager : DriverManager() {

    /**
     * Create Firefox WebDriver.
     *
     */
    override fun createDriver(): WebDriver {
        val options = FirefoxOptions()
        val driver: WebDriver = when (runGrid.lowercase()) {
            "local" -> configureRemoteWebDriver(localGridUrl, options)
            "false" -> FirefoxDriver(options)
            else -> throw IllegalStateException("Invalid 'runGrid' argument supplied: $runGrid")
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30L))
        return driver
    }
}
