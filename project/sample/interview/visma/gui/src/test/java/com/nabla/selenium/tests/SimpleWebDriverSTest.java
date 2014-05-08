package com.nabla.selenium.tests;

import java.util.concurrent.TimeUnit;

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

public class SimpleWebDriverSTest {
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
    public void setUp() throws Exception {

        this.baseUrl = System.getProperty("webdriver.base.url");

        if (null == this.baseUrl) {
            System.out.println("Use default webdriver.base.url");
            this.baseUrl = SimpleWebDriverSTest.DEFAULT_URL;
            System.setProperty("webdriver.base.url", this.baseUrl);
        }
        System.out.println("webdriver.base.url is : " + this.baseUrl + "\n");

        this.chromeDriver = System.getProperty("webdriver.chrome.driver");
        if (null == this.chromeDriver) {
            System.out.println("Use default webdriver.base.url");
            this.chromeDriver = SimpleWebDriverSTest.DEFAULT_CHROMEDRIVER;
            System.setProperty("webdriver.chrome.driver", this.chromeDriver);
        }
        System.out.println("webdriver.chrome.driver is : " + this.chromeDriver + "\n");

        this.firefoxBin = System.getProperty("webdriver.firefox.bin");
        if (null == this.firefoxBin) {
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
    public void testSimpleS() throws Exception {
        this.driver.get(this.baseUrl + "/visma/loan.xhtml");
        this.selenium.waitForPageToLoad(SimpleWebDriverSTest.PAGE_TO_LOAD_TIMEOUT);
        // WebElement myDynamicElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.id("j_idt8")));
        Assert.assertEquals("JSF 2.0 Visma Loan test - loan.xhtml", this.driver.findElement(By.cssSelector("h3")).getText());
        this.driver.findElement(By.name("j_idt8:j_idt9")).clear();
        this.driver.findElement(By.name("j_idt8:j_idt9")).sendKeys("Test me !!!");

        // wait for the application to get fully loaded
        final WebElement findOwnerLink = (new WebDriverWait(this.driver, 5)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(final WebDriver d) {
                // d.get(baseUrl);
                return d.findElement(By.name("j_idt8:j_idt9"));
            }
        });

        findOwnerLink.click();

        final WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("j_idt8:j_idt10")));
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        this.driver.findElement(By.name("j_idt8:j_idt10")).click();

        Assert.assertEquals("JSF 2.0 Visma Loan test results - payment.xhtml", this.driver.findElement(By.cssSelector("h3")).getText());
        Assert.assertEquals("Payment Test me !!!", this.driver.findElement(By.cssSelector("h4")).getText());
    }

    @After
    public void tearDown() throws Exception {
        this.driver.quit();
        final String verificationErrorString = this.verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }
}
