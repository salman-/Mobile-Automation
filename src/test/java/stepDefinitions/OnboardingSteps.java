package stepDefinitions;

import services.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.*;

public class OnboardingSteps extends Driver {

    Driver driver;
    WelcomePage wp;
    WhatIsYourNamePage wynp;
    GenderSelectionPage gsp;
    HowOldAreYouPage hoayp;
    WhichSymptomsAreYouSuffering wsays;
    WhichConditionsAreYouSuffering wcays;
    ReceivingTreatments rt;
    ReceivingMedication rm;
    CreatingAccount ca;
    HowDidYouHearAboutApp hdyhaa;
    ForYourInformation fyi;
    Dashboard dashboard;

    public OnboardingSteps(Driver driver){
        this.driver = driver;
    }

    public OnboardingSteps(){ }

    @Given("^I tap Get started button$")
    public void i_tap_Get_started_button() throws Throwable {
        wp = new WelcomePage(driver);
        wp.clickOnGetStartedButton();
}

    @Given("^I insert my name as \"([^\"]*)\"$")
    public void i_insert_my_name_as(String name) throws Throwable {
        wynp = new WhatIsYourNamePage(wp.getDriver());
        wynp.writeAge(name);
        wynp.clickOnNext();
    }

    @Given("^I select my \"([^\"]*)\"$")
    public void i_select_my(String gender) throws Throwable {
        gsp = new GenderSelectionPage(wynp.getDriver());
        gsp.clickOnGender(gender);
    }

    @Given("^I insert my age as \"([^\"]*)\"$")
    public void i_insert_my_age_as(String age) throws Throwable {
        hoayp = new HowOldAreYouPage(gsp.getDriver());
        hoayp.insertAge(age);
        hoayp.clickOnNext();
    }

    @Given("^I click on \"([^\"]*)\"$")
    public void i_click_on(String symptom) throws Throwable {
        wsays = new WhichSymptomsAreYouSuffering(hoayp.getDriver());
        wsays.clickOnSymptom(symptom);
        wsays.clickOnNext();
    }

    @Given("^I click on the \"([^\"]*)\"$")
    public void i_click_on_the(String condition) throws Throwable {
        wcays = new WhichConditionsAreYouSuffering(wsays.getDriver());
        wcays.clickOnConditions(condition);
        wcays.clickOnNext();
    }

    @Given("^I specify \"([^\"]*)\" of my problem$")
    public void i_specify_of_my_problem(String arg1) throws Throwable {
        wcays.clickOnNext();
    }

    @Given("^I  am receiving \"([^\"]*)\"$")
    public void i_am_receiving(String receivingTreatment) throws Throwable {
        rt = new ReceivingTreatments(wcays.getDriver());
        rt.clickOnButton(receivingTreatment);
        rt.clickOnNext();
    }

    @Given("^I am taking \"([^\"]*)\"$")
    public void i_am_taking(String receivingMedications) throws Throwable {
        rm = new ReceivingMedication(rt.getDriver());
        rm.clickOnButton(receivingMedications);
        rm.clickOnNext();
    }

    @Given("^I insert my Email as \"([^\"]*)\"$")
    public void i_insert_my_Email_as(String email) throws Throwable {
        ca = new CreatingAccount(rm.getDriver());
        if(email.equals("Not Now"))
            ca.clickOnNotNow();
        else{
            ca.insertEmail(email);
            ca.clickOnNext();
        }
    }

    @Given("^I hear about the app in an \"([^\"]*)\"$")
    public void i_hear_about_the_app_in_an(String option) throws Throwable {
        hdyhaa = new HowDidYouHearAboutApp(ca.getDriver());
        hdyhaa.clickOnOption(option);
        hdyhaa.clickOnNext();
    }

    @When("^I click on OK$")
    public void i_click_on_OK() throws Throwable {
        fyi = new ForYourInformation(hdyhaa.getDriver());
        fyi.clickOnOK();
    }

    @Then("^I am in Dashboard view$")
    public void i_am_in_Dashboard_view() throws Throwable {
        dashboard = new Dashboard(fyi.getDriver());
        dashboard.findDashboard();
    }

}
