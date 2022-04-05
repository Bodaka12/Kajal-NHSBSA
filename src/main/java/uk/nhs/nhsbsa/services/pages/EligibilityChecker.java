package uk.nhs.nhsbsa.services.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.nhs.nhsbsa.services.utility.Utility;

public class EligibilityChecker extends Utility {
    private static final Logger log = LogManager.getLogger(EligibilityChecker.class.getName());


    public EligibilityChecker() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='next-button']")
    WebElement StartButton;
    @CacheLookup
    @FindBy(xpath = "//input[@id='radio-wales']")
    WebElement wales;
    @CacheLookup
    @FindBy(xpath = "//input[@id='next-button']")
    WebElement next;
    @CacheLookup
    @FindBy(xpath = "//input[@id='radio-yes']")
    WebElement yes;
    @CacheLookup
    @FindBy(xpath = "//input[@id='next-button']")
    WebElement next1;
    @CacheLookup
    @FindBy(xpath = "//input[@id='radio-wales']")
    WebElement wales1;
    @CacheLookup
    @FindBy(xpath = "//input[@id='next-button']")
    WebElement next2;
    @CacheLookup
    @FindBy(xpath = "//input[@id='dob-day']")
    WebElement day;
    @CacheLookup
    @FindBy(xpath = "//input[@id='dob-month']")
    WebElement month;
    @CacheLookup
    @FindBy(xpath = "//input[@id='dob-year']")
    WebElement year;
    @CacheLookup
    @FindBy(xpath = "//input[@id='next-button']")
    WebElement next3;
    @CacheLookup
    @FindBy(xpath = "//input[@id='radio-yes']")
    WebElement yes1;
    @CacheLookup
    @FindBy(xpath = "//input[@id='next-button']")
    WebElement next4;
    @CacheLookup
    @FindBy(xpath = "//input[@id='radio-no']")
    WebElement no;
    @CacheLookup
    @FindBy(xpath = "//input[@id='next-button']")
    WebElement next5;
    @CacheLookup
    @FindBy(xpath = "//input[@id='radio-no']")
    WebElement no1;
    @CacheLookup
    @FindBy(xpath = "//input[@id='next-button']")
    WebElement next6;
    @CacheLookup
    @FindBy(xpath = "//input[@id='radio-no']")
    WebElement no2;
    @CacheLookup
    @FindBy(xpath = "//input[@id='next-button']")
    WebElement next7;
    @CacheLookup
    @FindBy(xpath = "//input[@id='radio-no']")
    WebElement no3;
    @CacheLookup
    @FindBy(xpath = "//input[@id='next-button']")
    WebElement next8;
    @CacheLookup
    @FindBy(xpath = "//input[@id='radio-no']")
    WebElement no4;
    @CacheLookup
    @FindBy(xpath = "//input[@id='next-button']")
    WebElement next9;
    @CacheLookup
    @FindBy(xpath = "//h1[@id='result-heading']")
    WebElement getresult;
    //    You get help with NHS costs
    public void clickOnStartButton() {
        log.info("clicking on sign in button : " + StartButton.toString());
        pmClickOnElement(StartButton);
    }
    public void clickOnWales() {
        log.info("clicking on sign in button : " + wales.toString());
        pmClickOnElement(wales);
    }
    public void clickOnnextBtn() {
        log.info("clicking on sign in button : " + next.toString());
        pmClickOnElement(next);
    }
    public void clickOnYes() {
        log.info("clicking on sign in button : " + yes.toString());
        pmClickOnElement(yes);
    }
    public void clickOnNextBtn1() {
        log.info("clicking on sign in button : " + next1.toString());
        pmClickOnElement(next1);
    }
    public void clickOnWales1() {
        log.info("clicking on sign in button : " + wales1.toString());
        pmClickOnElement(wales1);
    }
    public void clickOnNextBtn2() {
        log.info("clicking on sign in button : " + next2.toString());
        pmClickOnElement(next2);
    }
    public void enterDay(String number) {
        log.info("clicking on sign in button : " + day.toString());
        pmSendTextToElement(day,number);
    }
    public void enterMonth(String number) {
        log.info("clicking on sign in button : " + month.toString());
        pmSendTextToElement(month,number);
    }
    public void enterYear(String number) {
        log.info("clicking on sign in button : " + year.toString());
        pmSendTextToElement(year,number);
    }
    public void clickOnNextBtn3() {
        log.info("clicking on sign in button : " + next3.toString());
        pmClickOnElement(next3);
    }
    public void clickOnYes1() {
        log.info("clicking on sign in button : " + yes1.toString());
        pmClickOnElement(yes1);
    }
    public void clickOnNext4() {
        log.info("clicking on sign in button : " + next4.toString());
        pmClickOnElement(next4);
    }
    public void clickOnNo() {
        log.info("clicking on sign in button : " + no.toString());
        pmClickOnElement(no);
    }
    public void clickOnNextBtn5() {
        log.info("clicking on sign in button : " + next5.toString());
        pmClickOnElement(next5);
    }
    public void clickOnNo1() {
        log.info("clicking on sign in button : " + no1.toString());
        pmClickOnElement(no1);
    }
    public void clickOnNextBtn6() {
        log.info("clicking on sign in button : " + next6.toString());
        pmClickOnElement(next6);
    }
    public void clickOnNo2() {
        log.info("clicking on sign in button : " + no2.toString());
        pmClickOnElement(no2);
    }
    public void clickOnNextBtn7() {
        log.info("clicking on sign in button : " + next7.toString());
        pmClickOnElement(next7);
    }
    public void clickOnNo3() {
        log.info("clicking on sign in button : " + no3.toString());
        pmClickOnElement(no3);
    }
    public void clickOnNextBtn8() {
        log.info("clicking on sign in button : " + next8.toString());
        pmClickOnElement(next8);
    }
    public void clickOnNo4() {
        log.info("clicking on sign in button : " + no4.toString());
        pmClickOnElement(no4);
    }
    public void clickOnNextBtn9() {
        log.info("clicking on sign in button : " + next9.toString());
        pmClickOnElement(next9);
    }
    public String VerifyResultMsg() {
        log.info("Verify register Text:  displayed on register page " + getresult.toString());
        return pmGetTextFromElement(getresult);
    }
}
