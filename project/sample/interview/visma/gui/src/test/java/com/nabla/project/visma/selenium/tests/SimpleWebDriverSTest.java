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
package com.nabla.project.visma.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.jboss.arquillian.junit.InSequence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class SimpleWebDriverSTest
{
    // private static final String DEFAULT_CHROMEDRIVER = "C:\\chromedriver\\chromedriver.exe"; // "/var/lib/chromedriver"
    // private static final String DEFAULT_FIREFOXBIN = "C:\\Program Files\\Mozilla Firefox\\firefox.exe"; // "/usr/lib/firefox/firefox"
    private static final String DEFAULT_CHROMEDRIVER = "/var/lib/chromedriver";                  // "C:\\chromedriver\\chromedriver.exe"
    private static final String DEFAULT_FIREFOXBIN   = "/usr/lib/firefox/firefox";               // "C:\\Program Files\\Mozilla Firefox\\firefox.exe"
    private static final String DEFAULT_URL          = "http://localhost:9090";
    private static final String PAGE_TO_LOAD_TIMEOUT = "30000";
    private WebDriver           driver;
    private String              baseUrl              = SimpleWebDriverSTest.DEFAULT_URL;
    private String              chromeDriver         = SimpleWebDriverSTest.DEFAULT_CHROMEDRIVER;
    private String              firefoxBin           = SimpleWebDriverSTest.DEFAULT_FIREFOXBIN;

    private final StringBuffer  verificationErrors   = new StringBuffer();
    private DefaultSelenium     selenium;

    @Before
    public void setUp() throws Exception
    {

        this.baseUrl = System.getProperty("webdriver.base.url");

        if (null == this.baseUrl)
        {
            System.out.println("Use default webdriver.base.url");
            this.baseUrl = SimpleWebDriverSTest.DEFAULT_URL;
            System.setProperty("webdriver.base.url", this.baseUrl);
        }
        System.out.println("webdriver.base.url is : " + this.baseUrl + "\n");

        this.chromeDriver = System.getProperty("webdriver.chrome.driver");
        if (null == this.chromeDriver)
        {
            System.out.println("Use default webdriver.base.url");
            this.chromeDriver = SimpleWebDriverSTest.DEFAULT_CHROMEDRIVER;
            System.setProperty("webdriver.chrome.driver", this.chromeDriver);
        }
        System.out.println("webdriver.chrome.driver is : " + this.chromeDriver + "\n");

        this.firefoxBin = System.getProperty("webdriver.firefox.bin");
        if (null == this.firefoxBin)
        {
            System.out.println("Use default webdriver.firefox.bin");
            this.firefoxBin = SimpleWebDriverSTest.DEFAULT_FIREFOXBIN;
            System.setProperty("webdriver.firefox.bin", this.firefoxBin);
        }
        System.out.println("webdriver.firefox.bin is : " + this.firefoxBin + "\n");
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
        this.selenium = new WebDriverBackedSelenium(this.driver, this.baseUrl);

        Thread.sleep(10000); // 10 s
        // screenshot.
    }

    /*
     * @Before
     * public void homePageRefresh() throws IOException
     * {
     * driver.manage().deleteAllCookies();
     * // driver.get(propertyKeysLoader("login.base.url"));
     * }
     */

    @Test
    @InSequence(1)
    public void testWithGoodInputS() throws Exception
    {
        this.driver.get(this.baseUrl + "/visma/loan.xhtml");
        this.selenium.waitForPageToLoad(SimpleWebDriverSTest.PAGE_TO_LOAD_TIMEOUT);
        // WebElement myDynamicElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.id("loan_form")));
        Assert.assertEquals("Housing Loan Cost Calculator", this.driver.findElement(By.cssSelector("h3")).getText());
        this.driver.findElement(By.name("loan_form:loanAmount")).clear();
        this.driver.findElement(By.name("loan_form:loanAmount")).sendKeys("1000000");
        this.driver.findElement(By.name("loan_form:paybackTime")).clear();
        this.driver.findElement(By.name("loan_form:paybackTime")).sendKeys("10");

        // wait for the application to get fully loaded
        final WebElement findOwnerLink = (new WebDriverWait(this.driver, 5)).until(new ExpectedCondition<WebElement>()
        {
            @Override
            public WebElement apply(final WebDriver d)
            {
                // d.get(baseUrl);
                return d.findElement(By.name("loan_form:paybackTime"));
            }
        });

        findOwnerLink.click();

        final WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("loan_form:payment")));
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        this.driver.findElement(By.name("loan_form:payment")).click();

        Assert.assertEquals("Housing Loan Cost Calculator (Results)", this.driver.findElement(By.cssSelector("h3")).getText());
        Assert.assertEquals("Payments total is : 1302315.33552576902309236382167649640", this.driver.findElement(By.cssSelector("h4")).getText());
        Assert.assertEquals("10852.62779604807519243636518063747", this.driver.findElement(By.xpath("//td[2]")).getText());

        Thread.sleep(1000);
        this.selenium.open("/visma/");
        this.selenium.waitForPageToLoad("1500");
    }

    @Test
    @InSequence(2)
    public void testWithWrongInputS() throws Exception
    {
        this.driver.get(this.baseUrl + "/visma/loan.xhtml");
        this.selenium.waitForPageToLoad(SimpleWebDriverSTest.PAGE_TO_LOAD_TIMEOUT);
        // WebElement myDynamicElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.id("loan_form")));
        Assert.assertEquals("Housing Loan Cost Calculator", this.driver.findElement(By.cssSelector("h3")).getText());
        this.driver.findElement(By.name("loan_form:loanAmount")).clear();
        this.driver.findElement(By.name("loan_form:loanAmount")).sendKeys("-10");
        this.driver.findElement(By.name("loan_form:paybackTime")).clear();
        this.driver.findElement(By.name("loan_form:paybackTime")).sendKeys("0");

        // wait for the application to get fully loaded
        final WebElement findOwnerLink = (new WebDriverWait(this.driver, 5)).until(new ExpectedCondition<WebElement>()
        {
            @Override
            public WebElement apply(final WebDriver d)
            {
                // d.get(baseUrl);
                return d.findElement(By.name("loan_form:paybackTime"));
            }
        });

        findOwnerLink.click();

        final WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("loan_form:payment")));
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        this.driver.findElement(By.name("loan_form:payment")).click();

        Assert.assertEquals("Please enter the amount of your loan. Ex. 200000: Validation Error: Specified attribute is not between the expected values of 1 and 1,000,000,000.",
                this.driver.findElement(By.xpath("//table[@id='loan_form:panel']/tbody/tr[2]/td[3]/span")).getText());
        Assert.assertEquals("Please enter the number of years you have to pay back your loan. Ex. 30: Validation Error: Specified attribute is not between the expected values of 1 and 120.",
                this.driver.findElement(By.xpath("//table[@id='loan_form:panel']/tbody/tr[3]/td[3]/span")).getText());

        Thread.sleep(1000);
        this.selenium.open("/visma/");
        this.selenium.waitForPageToLoad("1500");
    }

    @After
    public void tearDown() throws Exception
    {
        this.driver.quit();
        final String verificationErrorString = this.verificationErrors.toString();
        if (!"".equals(verificationErrorString))
        {
            Assert.fail(verificationErrorString);
        }
    }
}
