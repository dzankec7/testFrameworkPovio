package web.factory

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.time.Duration

class ChromeDriverManager : DriverManager() {

    /**
     * Create Chrome WebDriver.
     *
     */
    override fun createDriver(): WebDriver {
        val options = ChromeOptions()
        options.addArguments("--disable-popup-blocking")
        options.addArguments("--disable-extensions")
        options.addArguments("--window-size=1920,1080")
        options.addArguments("--remote-allow-origins=*")
        val driver: WebDriver = when (runGrid.lowercase()) {
            "local" -> configureRemoteWebDriver(localGridUrl, options)
            "false" -> ChromeDriver(options)
            else -> throw IllegalStateException("Invalid 'runGrid' argument supplied: $runGrid")
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30L))
        return driver
    }
}
