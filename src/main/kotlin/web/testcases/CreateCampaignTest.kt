package web.testcases

import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import web.base.WebBaseTest
import web.pages.CampaignsPage
import web.pages.EditAccountPage
import web.pages.HomePage
import web.pages.RegistrationPage
import java.util.*

class CreateCampaignTest : WebBaseTest() {

    @Test
    fun verifyCampaignCreationFlow() {
        val registrationPage = RegistrationPage(driver)
        registrationPage.createNewUser(
            name = "Test${UUID.randomUUID()}",
            email = "Test${UUID.randomUUID()}@povio.com",
            password = "bB11111#",
            passwordConfirmation = "bB11111#",
        )
        val campaignsPage = CampaignsPage(driver)
        assertTrue(HomePage(driver).isNavTabDisplayed("Home"))
        campaignsPage.navigateToUrl("https://povio-at.herokuapp.com/campaigns")
        campaignsPage.clickOnAddNewCampaign()
        campaignsPage.createCampaign(
            campaignName = "Campaign Test",
            campaignDescription = "Campaign Description Testing",
            campaignType = "repeatable",
        )
        assertEquals(
            campaignsPage.getSuccessMessageText,
            "Campaign was successfully created.",
            "Success message for capmaign creation is not displayed.",
        )
        campaignsPage.deleteCampaign()
        val editAccountPage = EditAccountPage(driver)
        editAccountPage.cancelAccount()
    }
}
