package websiteFiles.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import websiteFiles.openDriver;
import websiteFiles.pages.dvlaVehicleInfo_page;
import websiteFiles.utils.BasePage;

import java.io.IOException;


public class dvlaVehicleInfo_sd extends BasePage {
    dvlaVehicleInfo_page DVI_page = PageFactory.initElements(openDriver.driver, dvlaVehicleInfo_page.class);

    openDriver OD = new openDriver();


    @Given("^I enter url \"([^\"]*)\"$")
    public void iEnterUrl(String url) {
        openURL(url);
    }

    @When("^I click on Start now button$")
    public void iClickOnStartNowButton() {
        DVI_page.clickStartButton();
    }

    @And("^I verify the vehicle details by entering registraiton number$")
    public void iVerifyTheVehicleDetailsByEnteringRegistraitonNumber() throws IOException, InvalidFormatException {
        DVI_page.verifyVehicleDetails();

    }
}

