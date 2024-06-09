package web.factory

class DriverManagerFactory {

    /**
     * Get DriverManager based on [browser].
     */
    fun getManager(browser: String): DriverManager {
        return when (browser.lowercase()) {
            "chrome" -> ChromeDriverManager()
            "firefox" -> FirefoxDriverManager()
            else -> throw IllegalStateException("Browser not supplied: $browser")
        }
    }
}
