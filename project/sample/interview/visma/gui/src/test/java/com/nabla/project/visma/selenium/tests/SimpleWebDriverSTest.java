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

import org.apache.commons.lang.time.StopWatch;
import org.jboss.arquillian.junit.InSequence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nabla.project.visma.selenium.tests.helper.SeleniumHelper;
import com.nabla.project.visma.selenium.tests.pageobjects.LoanPage;

public class SimpleWebDriverSTest
{

    private final SeleniumHelper helper = new SeleniumHelper();

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

    @Test
    @InSequence(1)
    public void testWithGoodInputS() throws Exception
    {
        // Get the Start Time
        final long startTime = System.currentTimeMillis();

        // Create an instance of Loan Page class
        // and provide the driver
        final LoanPage loanPage = new LoanPage();

        // Open the Loan Calculator Page
        loanPage.get();

        loanPage.calculatePayments("1000000", "10");

        // Get the End Time
        final long endTime = System.currentTimeMillis();

        // Measure total time
        final long totalTime = endTime - startTime;
        System.out.println("Total Page Load Time: " + totalTime + " milliseconds");

        Assert.assertEquals("Housing Loan Cost Calculator (Results)", this.helper.getDriver().findElement(By.cssSelector("h3")).getText());
        loanPage.Ensure_the_fund_transfer_is_complete("Payments total is : 1302315.33552576902309236382167649640");
        final WebElement simpleTable = this.helper.getDriver().findElement(By.id("payments"));
        SeleniumHelper.testWebTable(simpleTable, 121);
        Assert.assertEquals("10852.62779604807519243636518063747", this.helper.getDriver().findElement(By.xpath("//td[2]")).getText());

        SeleniumHelper.testTakesScreenshot("testWithGoodInputS.png", this.helper.getDriver());
        // Thread.sleep(1000);

        this.helper.getSelenium().open("/visma/");
        this.helper.getSelenium().waitForPageToLoad("1500");

        loanPage.close();
    }

    @Test
    @InSequence(2)
    public void testWithWrongInputS() throws Exception
    {
        // Get the StopWatch Object and start the StopWatch
        final StopWatch pageLoad = new StopWatch();
        pageLoad.start();

        // Create an instance of Loan Page class
        // and provide the driver
        final LoanPage loanPage = new LoanPage();

        // Open the Loan Calculator Page
        loanPage.get();

        loanPage.He_enters_loan_amount("-10");
        loanPage.He_enters_payback_time("0");

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

        loanPage.Ensure_a_transaction_failure_message(2, "Please enter the amount of your loan. Ex. 200000: Validation Error: Specified attribute is not between the expected values of 1 and 1,000,000,000.");
        loanPage.Ensure_a_transaction_failure_message(3, "Please enter the number of years you have to pay back your loan. Ex. 30: Validation Error: Specified attribute is not between the expected values of 1 and 120.");

        SeleniumHelper.testTakesScreenshot("testWithWrongInputS.png", this.helper.getDriver());
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
