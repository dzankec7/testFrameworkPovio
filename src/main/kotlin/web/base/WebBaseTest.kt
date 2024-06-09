package web.base

import org.openqa.selenium.WebDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import web.factory.DriverManagerFactory

open class WebBaseTest {

    private var threadSafeDriver: ThreadLocal<WebDriver> = ThreadLocal<WebDriver>()
    protected val driver: WebDriver get() = this.threadSafeDriver.get()

    /**
     * Initialize browser driver and navigate page.
     */
    @BeforeMethod
    fun setUp() {
        val browser = System.getProperty("browser", "chrome")
        setDriver(DriverManagerFactory().getManager(browser).createDriver())
    }

    /**
     * Quit the driver.
     */
    @AfterMethod
    fun tearDown() {
        try {
            driver.quit()
        } catch (error: Throwable) {
            println(error)
        }
    }

    private fun setDriver(driver: WebDriver) {
        this.threadSafeDriver.set(driver)
    }
}
