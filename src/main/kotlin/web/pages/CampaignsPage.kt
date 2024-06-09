package web.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import web.base.WebBasePage

class CampaignsPage(driver: WebDriver) : WebBasePage(driver) {

    @FindBy(xpath = "//a[@href='/campaigns/new']")
    private val addNewCampaignButton: WebElement? = null

    @FindBy(xpath = "//input[@name='campaign[name]']")
    private val campaignNameField: WebElement? = null

    @FindBy(xpath = "//input[@name='campaign[description]']")
    private val campaignDescriptionField: WebElement? = null

    @FindBy(xpath = "//input[@value='Create Campaign']")
    private val createCampaignButton: WebElement? = null

    @FindBy(id = "flash_notice")
    private val successMessage: WebElement? = null

    @FindBy(xpath = "//a[contains(text(), 'Destroy')]")
    private val destroyButton: WebElement? = null

    @FindBy(xpath = "//tr//td/a[contains(text(), 'Edit')]")
    private val editButton: WebElement? = null

    @FindBy(xpath = "//input[@value='Update Campaign']")
    private val updateCampaignButton: WebElement? = null

    @FindBy(xpath = "//tbody/tr/td")
    private val campaignsColumns: WebElement? = null

    val getNewCampaignName: String get() = campaignsColumns!!.text
    private val campaignTypeButton = DynamicWebElement("//input[@value='%s']")

    val getSuccessMessageText: String get() = successMessage!!.text

    fun clickOnAddNewCampaign() {
        clickOnElement(addNewCampaignButton)
    }

    fun createCampaign(
        campaignName: String,
        campaignDescription: String,
        campaignType: String,
    ) {
        fillTextField(campaignNameField, campaignName)
        fillTextField(campaignDescriptionField, campaignDescription)
        chooseCampaignType(campaignType)
        clickOnElement(createCampaignButton)
    }

    fun deleteCampaign() {
        clickOnElement(destroyButton)
        driver.switchTo().alert().accept()
    }

    fun editCampaign(
        newName: String,
        newDescription: String,
        newType: String,
    ) {
        clickOnElement(editButton)
        campaignNameField!!.clear()
        fillTextField(campaignNameField, newName)
        campaignDescriptionField!!.clear()
        fillTextField(campaignDescriptionField, newDescription)
        chooseCampaignType(newType)
        clickOnElement(updateCampaignButton)
    }

    private fun chooseCampaignType(campaignType: String) {
        clickOnElement(
            campaignTypeButton.parseDynamicLocator(
                campaignType,
                driver,
                DynamicWebElement.LocatorType.XPATH,
            ),
        )
    }
}
