package com.nabla.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.net.BindException;
import java.net.ServerSocket;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.DefaultSelenium;

public class SimpleSTest
{
    private static final String PAGE_TO_LOAD_TIMEOUT = "30000";
    private WebDriver           driver;
    private String              baseUrl              = "http://192.168.0.29:9090"; ;
    private boolean             acceptNextAlert      = true;
    private StringBuffer        verificationErrors   = new StringBuffer();
    private DefaultSelenium     selenium;

    // public static SeleniumServer server;

    @Before
    public void setUp() throws Exception
    {

        // System.setProperty("webdriver.safari.noinstall", "true");

        // http://localhost:4444/selenium-server/driver/?cmd=shutDownSeleniumServer
        // startSeleniumServer(server);

        /*
         * DesiredCapabilities capabillities = DesiredCapabilities.firefox();
         * // say you use the redhat5 label to indicate RHEL5 and the amd64 label
         * // to specify the architecture
         * // capabillities.setCapability("jenkins.label", "redhat5 && amd64");
         * // Say you want a specific node to thread your request, just specify the
         * // node name (it must be running a selenium configuration though)
         * capabillities.setCapability("jenkins.nodeName", "(master)");
         * // capabillities.setCapability("version", "8");
         * capabillities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
         * capabillities.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
         * driver = new RemoteWebDriver(new URL("http://home.nabla.mobi:4444/wd/hub"), capabillities);
         */
        driver = new FirefoxDriver();
        // driver = new HtmlUnitDriver(true);

        // RemoteWebDriver does not implement the TakesScreenshot class
        // if the driver does have the Capabilities to take a screenshot
        // then Augmenter will add the TakesScreenshot methods to the instance
        //WebDriver augmentedDriver = new Augmenter().augment(driver);
        //File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        selenium = new WebDriverBackedSelenium(driver, baseUrl);

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
        // stopSeleniumServer(server, selenium);
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString))
        {
            fail(verificationErrorString);
        }
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

    public static void startSeleniumServer(SeleniumServer server) throws Exception
    {

        try
        {
            ServerSocket serverSocket = new ServerSocket(RemoteControlConfiguration.DEFAULT_PORT);
            serverSocket.close();

            try
            {
                RemoteControlConfiguration rcc = new RemoteControlConfiguration();
                rcc.setPort(RemoteControlConfiguration.DEFAULT_PORT);
                server = new SeleniumServer(false, rcc);

            }
            catch (Exception e)
            {
                System.err.println("Could not create Selenium Server because of: " + e.getMessage());
                e.printStackTrace();
            }
            try
            {
                server.start();
                System.out.println("Server started");
            }
            catch (Exception e)
            {
                System.err.println("Could not start Selenium Server because of: " + e.getMessage());
                e.printStackTrace();
            }
        }
        catch (BindException e)
        {
            System.out.println("Selenium server already up, will reuse...");
        }
    }

    public static void stopSeleniumServer(SeleniumServer server, DefaultSelenium selenium)
    {
        selenium.stop();
        if (server != null)
        {
            try
            {
                selenium.shutDownSeleniumServer();
                server.stop();

                server = null;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
