package uk.nhs.nhsbsa.services.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import uk.nhs.nhsbsa.services.pages.EligibilityChecker;

public class MyStepdefs {
    static String day = "20";
    static String month = "8";
    static String year = "1961";
    @Given("^I am a person from Wales$")
    public void iAmAPersonFromWales() {
        new EligibilityChecker().clickOnStartButton();
        new EligibilityChecker().clickOnWales();
        new EligibilityChecker().clickOnnextBtn();
    }

    @When("^I put my GP Practice$")
    public void iPutMyGPPractice() {
        new EligibilityChecker().clickOnYes();
        new EligibilityChecker().clickOnNextBtn1();
    }

    @And("^I Put my Dental Practice$")
    public void iPutMyDentalPractice() {
        new EligibilityChecker().clickOnWales1();
        new EligibilityChecker().clickOnNextBtn2();
    }

    @And("^I put my Date Of Birth$")
    public void iPutMyDateOfBirth() {
        new EligibilityChecker().enterDay(day);
        new EligibilityChecker().enterMonth(month);
        new EligibilityChecker().enterYear(year);
        new EligibilityChecker().clickOnNextBtn3();

    }

    @And("^I live with a partner or not$")
    public void iLiveWithAPartnerOrNot() {
        new EligibilityChecker().clickOnYes1();
        new EligibilityChecker().clickOnNext4();

    }

    @And("^I put my or my partner claim any benefits or tax credits\\?$")
    public void iPutMyOrMyPartnerClaimAnyBenefitsOrTaxCredits() {
        new EligibilityChecker().clickOnNo();
        new EligibilityChecker().clickOnNextBtn5();
    }

    @And("^I Put my pregnant or have you given birth in the last (\\d+) months\\?$")
    public void iPutMyPregnantOrHaveYouGivenBirthInTheLastMonths(int arg0) {
        new EligibilityChecker().clickOnNo1();
        new EligibilityChecker().clickOnNextBtn6();

    }

    @And("^I put my have an injury or illness caused by serving in the armed forces\\?$")
    public void iPutMyHaveAnInjuryOrIllnessCausedByServingInTheArmedForces() {
        new EligibilityChecker().clickOnNo2();
        new EligibilityChecker().clickOnNextBtn7();
    }

    @And("^I put my or my partner live permanently in a care home\\?$")
    public void iPutMyOrMyPartnerLivePermanentlyInACareHome() {
        new EligibilityChecker().clickOnNo3();
        new EligibilityChecker().clickOnNextBtn8();
    }

    @And("^I put my and my partner have more than £(\\d+),(\\d+) in savings, investments or property\\?$")
    public void iPutMyAndMyPartnerHaveMoreThan£InSavingsInvestmentsOrProperty(int arg0, int arg1) {
        new EligibilityChecker().clickOnNo4();
        new EligibilityChecker().clickOnNextBtn9();
    }

    @Then("^I should get a result of whether I will get help or not$")
    public void iShouldGetAResultOfWhetherIWillGetHelpOrNot() {
        Assert.assertEquals(new EligibilityChecker().VerifyResultMsg(), "Based on what you've told us\n" +
                "You get help with NHS costs");
    }
}
