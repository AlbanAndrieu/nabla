package com.nabla.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Selenium;

public class SimpleSTest
{
    private static final String PAGE_TO_LOAD_TIMEOUT = "30000";
    private WebDriver           driver;
    private String              baseUrl;
    private boolean             acceptNextAlert      = true;
    private StringBuffer        verificationErrors   = new StringBuffer();
    private Selenium            selenium;

    @Before
    public void setUp() throws Exception
    {
        // http://localhost:4444/selenium-server/driver/?cmd=shutDownSeleniumServer

        DesiredCapabilities capabillities = DesiredCapabilities.firefox();
        // say you use the redhat5 label to indicate RHEL5 and the amd64 label to specify the architecture
        // capabillities.setCapability("jenkins.label", "redhat5 && amd64");
        // Say you want a specific node to thread your request, just specify the node name (it must be running a selenium configuration though)
        capabillities.setCapability("jenkins.nodeName", "(master)");
        // capabillities.setCapability("version", "8");
        capabillities.setCapability("platform", Platform.LINUX);
        driver = new RemoteWebDriver(new URL("http://home.nabla.mobi:4444/wd/hub"), capabillities);

        // driver = new FirefoxDriver();
        // driver = new HtmlUnitDriver(true);
        baseUrl = "http://localhost:9090";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    @Test
    public void testSimpleS() throws Exception
    {
        driver.get(baseUrl + "/welcome/hello.xhtml");
        selenium.waitForPageToLoad(PAGE_TO_LOAD_TIMEOUT);
        WebElement myDynamicElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.id("j_idt8")));
        assertEquals("JSF 2.0 Hello World Example - hello.xhtml", driver.findElement(By.cssSelector("h3")).getText());
        driver.findElement(By.name("j_idt8:j_idt9")).clear();
        driver.findElement(By.name("j_idt8:j_idt9")).sendKeys("Test me !!!");
        driver.findElement(By.name("j_idt8:j_idt10")).click();
        assertEquals("JSF 2.0 Hello World Example - welcome.xhtml", driver.findElement(By.cssSelector("h3")).getText());
        assertEquals("Welcome Test me !!!", driver.findElement(By.cssSelector("h4")).getText());
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString))
        {
            fail(verificationErrorString);
        }
        selenium.stop();
    }

    private boolean isElementPresent(By by)
    {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    private boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e)
        {
            return false;
        }
    }

    private String closeAlertAndGetItsText()
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert)
            {
                alert.accept();
            } else
            {
                alert.dismiss();
            }
            return alertText;
        }
        finally
        {
            acceptNextAlert = true;
        }
    }
}
