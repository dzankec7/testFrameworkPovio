package web.factory

import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

abstract class DriverManager {

    protected val runGrid: String = System.getProperty("runGrid", "false")
    protected val localGridUrl = URL("http://localhost:4444")

    abstract fun createDriver(): WebDriver

    /**
     * Configure Remote WebDriver with [remoteAddress] and [capabilities].
     */
    protected fun configureRemoteWebDriver(remoteAddress: URL, capabilities: Capabilities): RemoteWebDriver {
        val driver = RemoteWebDriver(remoteAddress, capabilities)
        driver.fileDetector = LocalFileDetector()
        return driver
    }
}
