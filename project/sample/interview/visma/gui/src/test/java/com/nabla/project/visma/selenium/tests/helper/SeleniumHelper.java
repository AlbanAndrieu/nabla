/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package com.nabla.project.visma.selenium.tests.helper;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

/**
 * DOCUMENT ME! albandri.
 * 
 * @author $Author$
 * @version $Revision$
 * @since $Date$
 */
public class SeleniumHelper
{

    private WebDriver           driver;

    // private final StringBuffer verificationErrors = new StringBuffer();
    private DefaultSelenium     selenium;

    // private static final String DEFAULT_CHROMEDRIVER = "C:\\chromedriver\\chromedriver.exe"; // "/var/lib/chromedriver"
    // private static final String DEFAULT_FIREFOXBIN = "C:\\Program Files\\Mozilla Firefox\\firefox.exe"; // "/usr/lib/firefox/firefox"
    private static final String DEFAULT_CHROMEDRIVER = "/var/lib/chromedriver";            // "C:\\chromedriver\\chromedriver.exe"
    private static final String DEFAULT_FIREFOXBIN   = "/usr/lib/firefox/firefox";         // "C:\\Program Files\\Mozilla Firefox\\firefox.exe"
    public static final String  PAGE_TO_LOAD_TIMEOUT = "30000";

    public static final String  DEFAULT_URL          = "http://localhost:9090";

    public static String        baseUrl              = SeleniumHelper.DEFAULT_URL;
    public static String        chromeDriver         = SeleniumHelper.DEFAULT_CHROMEDRIVER;
    public static String        firefoxBin           = SeleniumHelper.DEFAULT_FIREFOXBIN;

    /**
     * DOCUMENT ME! albandri.
     * 
     * @param driver
     * @param selenium
     * @throws InterruptedException
     */
    public void setUp() throws InterruptedException
    {

        SeleniumHelper.baseUrl = System.getProperty("webdriver.base.url");

        if (null == SeleniumHelper.baseUrl)
        {
            System.out.println("Use default webdriver.base.url");
            SeleniumHelper.baseUrl = SeleniumHelper.DEFAULT_URL;
            System.setProperty("webdriver.base.url", SeleniumHelper.baseUrl);
        }
        System.out.println("webdriver.base.url is : " + SeleniumHelper.baseUrl + "\n");

        SeleniumHelper.chromeDriver = System.getProperty("webdriver.chrome.driver");
        if (null == SeleniumHelper.chromeDriver)
        {
            System.out.println("Use default webdriver.base.url");
            SeleniumHelper.chromeDriver = SeleniumHelper.DEFAULT_CHROMEDRIVER;
            System.setProperty("webdriver.chrome.driver", SeleniumHelper.chromeDriver);
        }
        System.out.println("webdriver.chrome.driver is : " + SeleniumHelper.chromeDriver + "\n");

        SeleniumHelper.firefoxBin = System.getProperty("webdriver.firefox.bin");
        if (null == SeleniumHelper.firefoxBin)
        {
            System.out.println("Use default webdriver.firefox.bin");
            SeleniumHelper.firefoxBin = SeleniumHelper.DEFAULT_FIREFOXBIN;
            System.setProperty("webdriver.firefox.bin", SeleniumHelper.firefoxBin);
        }
        System.out.println("webdriver.firefox.bin is : " + SeleniumHelper.firefoxBin + "\n");
        // ProfilesIni allProfiles = new ProfilesIni();
        // FirefoxProfile profile = allProfiles.getProfile("Selenium");
        // FirefoxProfile profile = new FirefoxProfile();
        // FirefoxBinary binary = new FirefoxBinary(new File(firefoxBin));
        // driver = new FirefoxDriver(binary, profile);

        this.driver = new ChromeDriver();
        // driver = new FirefoxDriver(profile);
        // driver = new HtmlUnitDriver(true);

        // RemoteWebDriver does not implement the TakesScreenshot class
        // if the driver does have the Capabilities to take a screenshot
        // then Augmenter will add the TakesScreenshot methods to the instance
        // WebDriver augmentedDriver = new Augmenter().augment(driver);
        // File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);

        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        // driver.manage().window().setSize(new Dimension(1920, 1080));

        // this.driver.manage().deleteAllCookies();
        // this.driver.get(propertyKeysLoader("login.base.url"));

        this.selenium = new WebDriverBackedSelenium(this.driver, SeleniumHelper.baseUrl);
        this.selenium.waitForPageToLoad(SeleniumHelper.PAGE_TO_LOAD_TIMEOUT);

        Thread.sleep(10000); // 10 s
    }

    /**
     * DOCUMENT ME! albandri.
     * 
     * @param driver
     */
    public void tearDown()
    {

        this.driver.quit();
        /*
         * final String verificationErrorString = this.verificationErrors.toString();
         * if (!"".equals(verificationErrorString))
         * {
         * Assert.fail(verificationErrorString);
         * }
         */

    }

    public WebDriver getDriver()
    {
        return this.driver;
    }

    public DefaultSelenium getSelenium()
    {
        return this.selenium;
    }

    public static void testDragDrop(final String draggable, final String droppable, String expectedResult, final WebDriver driver, final StringBuffer verificationErrors)
    {

        final WebElement source = driver.findElement(By.id(draggable));
        final WebElement target = driver.findElement(By.id(droppable));

        final Actions builder = new Actions(driver);
        builder.dragAndDrop(source, target).perform();
        try
        {
            if (null == expectedResult)
            {
                expectedResult = "Dropped!";
            }
            Assert.assertEquals(expectedResult, target.getText());
        } catch (final Error e)
        {
            verificationErrors.append(e.toString());
        }
    }

    public static void testElementText(final String id, final String expectedResult, final WebDriver driver)
    {
        // Get the message Element
        final WebElement message = driver.findElement(By.id(id));

        // Get the message elements text
        final String messageText = message.getText();

        // Verify message element's text displays "Click on me and my color will change"
        Assert.assertEquals(expectedResult, messageText);
    }

    public static void testElementAttribute(final String id, String expectedResult, final WebDriver driver)
    {
        final WebElement message = driver.findElement(By.id(id));
        if (null == expectedResult)
        {
            expectedResult = "justify";
        }
        Assert.assertEquals(expectedResult, message.getAttribute("align"));
    }

    public static void testElementStyle(final String id, String expectedResult, final WebDriver driver)
    {
        final WebElement message = driver.findElement(By.id(id));
        final String width = message.getCssValue("width");
        if (null == expectedResult)
        {
            expectedResult = "150px";
        }
        Assert.assertEquals(expectedResult, width);
    }

    public static void testDocumentTitle(final String expectedResult, final WebDriver driver)
    {

        final JavascriptExecutor js = (JavascriptExecutor) driver;

        final String title = (String) js.executeScript("return document.title");
        Assert.assertEquals(expectedResult, title);

    }

    public static void remoteDriverScreenShot(final String filePath, WebDriver driver) throws Exception
    {

        Thread.sleep(1000);
        driver = new Augmenter().augment(driver);
        final File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(filePath));

    }

    public static void testTakesScreenshot(final String filePath, final WebDriver driver)
    {
        try
        {
            final File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (final Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void testElementScreenshot(final String filePath, final WebElement element, final WebDriver driver)
    {

        try
        {
            FileUtils.copyFile(WebElementExtender.captureElementBitmap(element), new File(filePath));
        } catch (final Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void testWebTable(final WebElement simpleTable, final int expectedRows)
    {

        // Get all rows
        final List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
        Assert.assertEquals(expectedRows, rows.size());

        // Print data from each row
        for (final WebElement row : rows)
        {
            final List<WebElement> cols = row.findElements(By.tagName("td"));
            for (final WebElement col : cols)
            {
                System.out.print(col.getText() + "\t");
            }
            System.out.println();
        }
    }

    public static void testRowSelectionUsingControlKey(final List<WebElement> tableRowsInput, final List<WebElement> tableRowsOutput, final long expectedRows, final WebDriver driver)
    {

        // List<WebElement> tableRowsInput = driver.findElements(By.xpath("//table[@class='myDataTbl']/tbody/tr"));
        // Selected Row Table shows two rows selected
        // List<WebElement> tableRowsOutput = driver.findElements(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='myDataTbl']/tbody/tr"));

        // Select second and fourth row from Table using Control Key.
        // Row Index start at 0
        final Actions builder = new Actions(driver);
        builder.click(tableRowsInput.get(1)).keyDown(Keys.CONTROL).click(tableRowsInput.get(3)).keyUp(Keys.CONTROL).build().perform();

        // Verify Selected Row Table shows X rows selected
        Assert.assertEquals(expectedRows, tableRowsOutput.size());

    }

    public static void testRowSelectionUsingShiftKey(final List<WebElement> tableRowsInput, final List<WebElement> tableRowsOutput, final long expectedRows, final WebDriver driver)
    {

        // List<WebElement> tableRowsInput = driver.findElements(By.xpath("//table[@class='myDataTbl']/tbody/tr"));
        // Selected Row Table shows two rows selected
        // List<WebElement> tableRowsOutput = driver.findElements(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='myDataTbl']/tbody/tr"));

        // Select first row to fourth row from Table using Shift Key
        // Row Index start at 0
        final Actions builder = new Actions(driver);
        builder.click(tableRowsInput.get(0)).keyDown(Keys.SHIFT).click(tableRowsInput.get(1)).click(tableRowsInput.get(2)).click(tableRowsInput.get(3)).keyUp(Keys.SHIFT).build().perform();

        // Verify Selected Row Table shows X rows selected
        Assert.assertEquals(expectedRows, tableRowsOutput.size());
    }

}
