package uk.nhs.nhsbsa.services.utility;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import uk.nhs.nhsbsa.services.drivermanager.ManageDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class Utility extends ManageDriver {

    //*****************BASIC WEBDRIVER METHODS******************************


    public void pmClickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will get text from element
     */
    public String pmGetTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    public String pmGetTextFromElement(WebElement element) {

        return element.getText();
    }

    /**
     * This method will send text on element
     */
    public void pmSendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }


//*************************** Alert Methods ***************************************//


    /**
     * THIS METHOD SELECTS A PARTICULAR MENU FROM THE MENU BAR
     *
     * @throws InterruptedException
     */

    public void selectMenu(By by, String menu) throws InterruptedException {

        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {
            //Thread.sleep(2000);
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                break;
            }
        }
    }

    public void selectMenu(List<WebElement> element, String menu) throws InterruptedException {

        List<WebElement> names = element;
        for (WebElement name : names) {
            Thread.sleep(2000);
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                break;
            }
        }
    }


//*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void doMouseHoverNoClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void pmDoMouseHoverNoClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


//************************** Waits Methods *********************************************//

    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */
    public WebElement pmWaitUntilVisibilityOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    public WebElement pmWaitUntilStalenessOfElementLocated(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.stalenessOf(element));
        return element;
    }


    public String doWaitUntilTitleIsEqualTo(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.titleContains(expectedMessage));
        return expectedMessage;
    }

    /**
     * This method will wait for an element using Fluent Wait
     * <p>
     * by
     * time
     * pollingTime
     *
     * @return
     */
    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    //************************** ScreenShot Methods *********************************************//
    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/"; // path where screen shot needs to be saved
        TakesScreenshot screenshot = (TakesScreenshot) driver; // method to take screenshot
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /**
     * ******************VERIFICATION METHODS---ASSERT CLASS**********************
     */

    /**
     * This method verifies elements using Assert class after reading text from element
     * <p>
     * expectedMessage
     * actualMessage
     * displayMessage
     */

    public void doVerifyElementsJU(String displayMessage, String expectedMessage, String actualMessage) {
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    /******
     * This method verifies elements using locator directly as the second
     * instead of String
     *  expectedMessage
     *  by
     *  displayMessage
     */

    public void pmVerifyElements(String expectedMessage, By by, String displayMessage) {
        Assert.assertEquals(expectedMessage, by, displayMessage);
    }

    public void pmVerifyElements(String displayMessage, String expectedMessage, WebElement element) {
        String actualMessage = pmGetTextFromElement(element);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    /**
     * This method is getting text from actual Message's WebElement using
     * the Explicit Wait Method. We will then use this as String actualMessage in Verification Method
     * We have used "waitUntilVisibilityOfElementLocated" Explicit Wait Method here
     *
     * @param actualMessage
     * @param timeout
     * @return
     */

    public String doGetTextFromActualMessageForVerificationUsingWait(By actualMessage, int timeout) {
        String verify = pmWaitUntilVisibilityOfElementLocated(actualMessage, timeout).getText();
        return verify;
    }

    /**
     * THIS IS THE VERIFICATION METHOD USING WAIT
     * THIS METHOD WILL WORK IN THE FOLLOWING WAY:
     * 1. Get Expected - can also use the "waitUntilTitleIsEqualTo" explicit wait method.
     * 2. Get Acutal = By getting text from actual element using "waitUntilVisibilityOfElement" method
     * 3. All this incorporated in the Assert Method
     **/

    public String randomString() {
        String randString;
        RandomString rnd = new RandomString(10);
        return randString = rnd.nextString();
    }

}
