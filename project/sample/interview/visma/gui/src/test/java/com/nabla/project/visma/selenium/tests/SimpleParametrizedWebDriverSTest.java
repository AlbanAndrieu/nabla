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

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.jboss.arquillian.junit.InSequence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nabla.project.visma.selenium.tests.helper.SeleniumHelper;

@RunWith(value = Parameterized.class)
public class SimpleParametrizedWebDriverSTest
{

    private final SeleniumHelper helper = new SeleniumHelper();

    private final String         loanAmount;
    private final String         paybackTime;

    private final String         totalPayments;
    private final String         firstPayment;
    private final int            expectedPayments;

    public SimpleParametrizedWebDriverSTest(final String aLoanAmount, final String aPaybackTime, final String aTotalPayments, final String aFirstPayment, final int aExpectedPayments)
    {
        this.loanAmount = aLoanAmount;
        this.paybackTime = aPaybackTime;
        this.totalPayments = aTotalPayments;
        this.firstPayment = aFirstPayment;
        this.expectedPayments = aExpectedPayments;
    }

    @Parameters
    public static Collection<Object[]> testData()
    {
        return Arrays.asList(new Object[][]
        {
        { "1000000", "10", "1302315.33552576902309236382167649640", "10852.62779604807519243636518063747", 121 },
        { "200000", "30", "408808.080969842113801990388563829760", "1135.578002694005871672195523788416", 361 } });
    }

    @Before
    public void setUp() throws Exception
    {

        this.helper.setUp();
    }

    /*
     * @Before
     * public void homePageRefresh() throws IOException
     * {
     * driver.manage().deleteAllCookies();
     * // driver.get(propertyKeysLoader("login.base.url"));
     * }
     */

    // @Given("the user is on Loan Page")
    public void The_user_is_on_loan_page()
    {

        this.helper.getDriver().get(SeleniumHelper.baseUrl + "/visma/loan.xhtml");
    }

    // @When("he enters \"([^\"]*)\" as loan amount")
    public void He_enters_loan_amount(final String loanAmount)
    {
        this.helper.getDriver().findElement(By.name("loan_form:loanAmount")).clear();
        this.helper.getDriver().findElement(By.name("loan_form:loanAmount")).sendKeys(loanAmount);
    }

    // @And("he enters \"([^\"]*)\" as payback time")
    public void He_enters_payback_time(final String paybackTime)
    {
        this.helper.getDriver().findElement(By.name("loan_form:paybackTime")).clear();
        this.helper.getDriver().findElement(By.name("loan_form:paybackTime")).sendKeys(paybackTime);
    }

    // @And("he Submits request for payments calculation")
    public void He_submits_request_for_fund_transfer()
    {
        this.helper.getDriver().findElement(By.id("transfer")).click();
    }

    // @Then("ensure the payment schedule is accurate with \"([^\"]*)\" message")
    public void Ensure_the_fund_transfer_is_complete(final String msg)
    {
        final WebElement message = this.helper.getDriver().findElement(By.cssSelector("h4"));
        Assert.assertEquals(message.getText(), msg);
    }

    @Test
    @InSequence(1)
    public void testWithGoodInputS() throws Exception
    {
        // Get the Start Time
        final long startTime = System.currentTimeMillis();

        this.The_user_is_on_loan_page();

        final JavascriptExecutor js = (JavascriptExecutor) this.helper.getDriver();

        // Get the Load Event End
        final long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");

        // Get the Navigation Event Start
        final long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");

        // Difference between Load Event End and Navigation Event Start is Page Load Time
        System.out.println("Page Load Time is " + ((loadEventEnd - navigationStart) / 1000) + " seconds.");

        this.helper.getSelenium().waitForPageToLoad(SeleniumHelper.PAGE_TO_LOAD_TIMEOUT);

        // Wait for the Calculate Button
        new WebDriverWait(this.helper.getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.id("loan_form:payment")));

        // WebElement myDynamicElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.id("loan_form")));
        Assert.assertEquals("Housing Loan Cost Calculator", this.helper.getDriver().findElement(By.cssSelector("h3")).getText());
        this.He_enters_loan_amount(this.loanAmount);
        this.He_enters_payback_time(this.paybackTime);

        // wait for the application to get fully loaded
        /*
         * final WebElement findOwnerLink = (new WebDriverWait(this.helper.getDriver(), 5)).until(new ExpectedCondition<WebElement>()
         * {
         * @Override
         * public WebElement apply(final WebDriver d)
         * {
         * // d.get(baseUrl);
         * return d.findElement(By.name("loan_form:paybackTime"));
         * }
         * });
         * findOwnerLink.click();
         */

        final WebDriverWait wait = new WebDriverWait(this.helper.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("loan_form:payment")));
        this.helper.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        this.helper.getDriver().findElement(By.name("loan_form:payment")).click();

        // Get the End Time
        final long endTime = System.currentTimeMillis();

        // Measure total time
        final long totalTime = endTime - startTime;
        System.out.println("Total Page Load Time: " + totalTime + " milliseconds");

        Assert.assertEquals("Housing Loan Cost Calculator (Results)", this.helper.getDriver().findElement(By.cssSelector("h3")).getText());
        this.Ensure_the_fund_transfer_is_complete("Payments total is : " + this.totalPayments);
        final WebElement simpleTable = this.helper.getDriver().findElement(By.id("payments"));
        SeleniumHelper.testWebTable(simpleTable, this.expectedPayments);
        Assert.assertEquals(this.firstPayment, this.helper.getDriver().findElement(By.xpath("//td[2]")).getText());

        // SeleniumHelper.testTakesScreenshot("testWithGoodInputS.png", this.helper.getDriver());
        // Thread.sleep(1000);

        this.helper.getSelenium().open("/visma/");
        this.helper.getSelenium().waitForPageToLoad("1500");
    }

    @After
    public void tearDown() throws Exception
    {
        this.helper.tearDown();
    }
}
