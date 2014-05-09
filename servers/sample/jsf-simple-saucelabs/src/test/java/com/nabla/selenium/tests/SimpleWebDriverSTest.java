package com.nabla.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.BindException;
import java.net.ServerSocket;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class SimpleWebDriverSTest {
    private static final String DEFAULT_CHROMEDRIVER = "C:\\chromedriver\\chromedriver.exe";
    private static final String DEFAULT_URL          = "http://localhost:9090";
    private static final String PAGE_TO_LOAD_TIMEOUT = "30000";
    private WebDriver           driver;
    private String              baseUrl              = DEFAULT_URL;
    private String              chromeDriver         = DEFAULT_CHROMEDRIVER;
    private boolean             acceptNextAlert      = true;
    private StringBuffer        verificationErrors   = new StringBuffer();
    private DefaultSelenium     selenium;

    // public static SeleniumServer server;

    @Before
    public void setUp() throws Exception {

        baseUrl = System.getProperty("webdriver.base.url");

        if (null == baseUrl) {
            System.out.println("Use default webdriver.base.url");
            baseUrl = DEFAULT_URL;
            System.setProperty("webdriver.base.url", baseUrl);
        }
        System.out.println("webdriver.base.url is : " + baseUrl);

        chromeDriver = System.getProperty("webdriver.chrome.driver");
        if (null == chromeDriver) {
            System.out.println("Use default webdriver.base.url");
            chromeDriver = DEFAULT_URL;
            System.setProperty("webdriver.chrome.driver", chromeDriver);
        }
        System.out.println("webdriver.chrome.driver is : " + chromeDriver);

        // ProfilesIni allProfiles = new ProfilesIni();
        // FirefoxProfile profile = allProfiles.getProfile("Selenium");
        // FirefoxProfile profile = new FirefoxProfile();
        // FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
        // driver = new FirefoxDriver(binary, profile);

        driver = new ChromeDriver();
        // driver = new FirefoxDriver(profile);
        // driver = new HtmlUnitDriver(true);

        // RemoteWebDriver does not implement the TakesScreenshot class
        // if the driver does have the Capabilities to take a screenshot
        // then Augmenter will add the TakesScreenshot methods to the instance
        // WebDriver augmentedDriver = new Augmenter().augment(driver);
        // File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        // driver.manage().window().setSize(new Dimension(1920, 1080));
        selenium = new WebDriverBackedSelenium(driver, baseUrl);

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

    // @Test
    public void testSimpleS() throws Exception {
        driver.get(baseUrl + "/welcome/hello.xhtml");
        selenium.waitForPageToLoad(PAGE_TO_LOAD_TIMEOUT);
        // WebElement myDynamicElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.id("j_idt8")));
        assertEquals("JSF 2.0 Hello World Example - hello.xhtml", driver.findElement(By.cssSelector("h3")).getText());
        driver.findElement(By.name("j_idt8:j_idt9")).clear();
        driver.findElement(By.name("j_idt8:j_idt9")).sendKeys("Test me !!!");

        // wait for the application to get fully loaded
        WebElement findOwnerLink = (new WebDriverWait(driver, 5)).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver d) {
                // d.get(baseUrl);
                return d.findElement(By.name("j_idt8:j_idt9"));
            }
        });

        findOwnerLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("j_idt8:j_idt10")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.name("j_idt8:j_idt10")).click();

        assertEquals("JSF 2.0 Hello World Example - welcome.xhtml", driver.findElement(By.cssSelector("h3")).getText());
        assertEquals("Welcome Test me !!!", driver.findElement(By.cssSelector("h4")).getText());
    }

    @After
    public void tearDown() throws Exception {
        // stopSeleniumServer(server, selenium);
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        }
        finally {
            acceptNextAlert = true;
        }
    }

    public static void startSeleniumServer(SeleniumServer server) throws Exception {

        try {
            ServerSocket serverSocket = new ServerSocket(RemoteControlConfiguration.DEFAULT_PORT);
            serverSocket.close();

            try {
                RemoteControlConfiguration rcc = new RemoteControlConfiguration();
                rcc.setPort(RemoteControlConfiguration.DEFAULT_PORT);
                server = new SeleniumServer(false, rcc);

            }
            catch (Exception e) {
                System.err.println("Could not create Selenium Server because of: " + e.getMessage());
                e.printStackTrace();
            }
            try {
                server.start();
                System.out.println("Server started");
            }
            catch (Exception e) {
                System.err.println("Could not start Selenium Server because of: " + e.getMessage());
                e.printStackTrace();
            }
        }
        catch (BindException e) {
            System.out.println("Selenium server already up, will reuse...");
        }
    }

    public static void stopSeleniumServer(SeleniumServer server, DefaultSelenium selenium) {
        selenium.stop();
        if (server != null) {
            try {
                selenium.shutDownSeleniumServer();
                server.stop();

                server = null;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
