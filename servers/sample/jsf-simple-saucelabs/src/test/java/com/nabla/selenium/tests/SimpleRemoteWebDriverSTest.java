package com.nabla.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.SauceOnDemandTestWatcher;
import com.thoughtworks.selenium.DefaultSelenium;

@RunWith(Parameterized.class)
public class SimpleRemoteWebDriverSTest implements SauceOnDemandSessionIdProvider {
    private static final String        DEFAULT_CHROMEDRIVER = "C:\\chromedriver\\chromedriver.exe";
    private static final String        DEFAULT_URL          = "http://localhost:9090";
    private static final String        PAGE_TO_LOAD_TIMEOUT = "30000";
    private WebDriver                  driver;
    private String                     baseUrl              = DEFAULT_URL;
    private String                     chromeDriver         = DEFAULT_CHROMEDRIVER;
    private boolean                    acceptNextAlert      = true;
    private StringBuffer               verificationErrors   = new StringBuffer();
    private DefaultSelenium            selenium;

    private static DesiredCapabilities capabilities;
    private static Platform            ANDROID, LINUX, MAC, UNIX, VISTA, WINDOWS, XP, platformValue;
    private String                     browser, browserVersion, platform, sessionId = "";

    // Create an array of available platforms from the "private static Platform" declaration above
    Platform[]                         platformValues       = Platform.values();

    // public static SeleniumServer server;

    /**
     * Constructs a {@link com.saucelabs.common.SauceOnDemandAuthentication} instance using the supplied Sauce
     * user name and access key. To use the authentication supplied by environment variables or
     * from an external file, use the no-arg {@link com.saucelabs.common.SauceOnDemandAuthentication} constructor.
     */
    public SauceOnDemandAuthentication authentication       = new SauceOnDemandAuthentication();

    public Platform setPlatformCapabilities(String platformParam) {

        String platformVal = platformParam;

        for (int p = 0; p < platformValues.length; p++) {
            platformValue = platformValues[p++];
            if (platformValue.toString() == platformVal)
                break;
        }

        return platformValue;

    }

    /**
     * JUnit Rule that marks Sauce Jobs as passed/failed when the test succeeds or fails.
     */
    public @Rule
    SauceOnDemandTestWatcher resultReportingTestWatcher = new SauceOnDemandTestWatcher(this, authentication);

    /**
     * JUnit Rule that records the test name of the current test. When this is referenced
     * during the creation of {@link org.openqa.selenium.remote.DesiredCapabilities}, the test method name is assigned
     * to the Sauce Job name and recorded in Jenkins Console Output and in the Sauce Jobs
     * Report in the Jenkins project's home page.
     */
    public @Rule
    TestName                 testName                   = new TestName();

    /**
     * JUnit annotation that runs each test once for each item in a Collection.
     *
     * Feel free to add as many additional parameters as you like to the capabilitiesParams array.
     *
     * Note: If you add parameters for the MAC platform, make sure that you have Mac minutes in
     * your <a href="https://saucelabs.com/login">Sauce account</a> or the test will fail.
     */
    @Parameters
    public static Collection<Object[]> data() {

        String json = System.getenv("SAUCE_ONDEMAND_BROWSERS");
        List<Object[]> browsers = new ArrayList<Object[]>();
        JSONArray browserArray = null;
        try {
            browserArray = new JSONArray(json);
            for (int i = 0; i < browserArray.length(); i++) {
                JSONObject browserJSON = browserArray.getJSONObject(i);
                browsers.add(new Object[] { browserJSON.get("browser"), browserJSON.get("browser-version"), browserJSON.get("os") });

            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        return browsers;

    }

    public SimpleRemoteWebDriverSTest(String s1, String s2, String s3) {
        browser = s1;
        browserVersion = s2;
        platform = s3;
    }

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

        // System.setProperty("webdriver.safari.noinstall", "true");

        // http://localhost:4444/selenium-server/driver/?cmd=shutDownSeleniumServer
        // startSeleniumServer(server);

        // FirefoxProfile profile = new ProfilesIni().getProfile("Selenium");

        // capabilities = DesiredCapabilities.firefox();
        // capabilities = DesiredCapabilities.chrome();
        // capabilities.setCapability(FirefoxDriver.PROFILE, profile);

        // FirefoxBinary ffb = new FirefoxBinary(new File("/usr/lib/firefox/firefox"));
        // /usr/bin/firefox
        // C:\Program Files (x86)\Mozilla Firefox\firefox.exe

        // capabilities.setCapability(FirefoxDriver.BINARY, ffb);
        // say you use the redhat5 label to indicate RHEL5 and the amd64 label
        // to specify the architecture
        // capabilities.setCapability("jenkins.label", "redhat5 && amd64");
        // Say you want a specific node to thread your request, just specify the
        // node name (it must be running a selenium configuration though)
        // capabilities.setCapability("jenkins.nodeName", "(master)");

        // capabilities.setVersion("12");
        // capabilities.setPlatform(Platform.WINDOWS);

        // capabilities.setCapability("version", "8");
        // capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");

        // capabilities.setCapability(CapabilityType.VERSION, "12");
        // capabilities.setCapability(CapabilityType.BROWSER_NAME, "googlechrome");

        // capabilities.setCapability(CapabilityType.PLATFORM, Platform.LINUX);

        // driver = new RemoteWebDriver(new URL("http://albanandrieu:2e5a4730-39e1-41c2-9e1f-a84fa24e15fd@ondemand.saucelabs.com:80/wd/hub"), capabilities);
        // driver = new RemoteWebDriver(new URL("http://nabla:5655798f-14ba-4bc6-9d11-8d039a2517c0@ondemand.saucelabs.com:80/wd/hub"), capabilities);

        capabilities = new DesiredCapabilities(browser, browserVersion, setPlatformCapabilities(platform));
        capabilities.setCapability("name", this.getClass().getName() + "." + testName.getMethodName());
        // driver = new RemoteWebDriver(new URL("http://home.nabla.mobi:4444/wd/hub"), capabilities);
        this.driver = new RemoteWebDriver(new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub"), capabilities);
        this.sessionId = ((RemoteWebDriver) driver).getSessionId().toString();

        if (browserVersion == "")
            browserVersion = "unspecified";
        String browserName = String.format("%-19s", browser).replaceAll(" ", ".").replaceFirst("[.]", " ");
        String browserVer = String.format("%-19s", browserVersion).replaceAll(" ", ".");
        System.out.println("@Test validateTitle() testing browser/version: " + browserName + browserVer + "platform: " + platform);

        // FirefoxProfile profile = new FirefoxProfile();
        // FirefoxBinary binary = new FirefoxBinary(new File("C:\\path to firefox\\firefox.exe"));
        // driver = new FirefoxDriver(binary, profile);
        // driver = new FirefoxDriver();
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
        // selenium = new WebDriverBackedSelenium(driver, baseUrl);

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
        driver.get(baseUrl + "/welcome/hello.xhtml");
        // selenium.waitForPageToLoad(PAGE_TO_LOAD_TIMEOUT);
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

    @Override
    public String getSessionId() {
        return sessionId;
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

    /*
     * public static void startSeleniumServer(SeleniumServer server) throws Exception
     * {
     * try
     * {
     * ServerSocket serverSocket = new ServerSocket(RemoteControlConfiguration.DEFAULT_PORT);
     * serverSocket.close();
     * try
     * {
     * RemoteControlConfiguration rcc = new RemoteControlConfiguration();
     * rcc.setPort(RemoteControlConfiguration.DEFAULT_PORT);
     * server = new SeleniumServer(false, rcc);
     * }
     * catch (Exception e)
     * {
     * System.err.println("Could not create Selenium Server because of: " + e.getMessage());
     * e.printStackTrace();
     * }
     * try
     * {
     * server.start();
     * System.out.println("Server started");
     * }
     * catch (Exception e)
     * {
     * System.err.println("Could not start Selenium Server because of: " + e.getMessage());
     * e.printStackTrace();
     * }
     * }
     * catch (BindException e)
     * {
     * System.out.println("Selenium server already up, will reuse...");
     * }
     * }
     * public static void stopSeleniumServer(SeleniumServer server, DefaultSelenium selenium)
     * {
     * selenium.stop();
     * if (server != null)
     * {
     * try
     * {
     * selenium.shutDownSeleniumServer();
     * server.stop();
     * server = null;
     * }
     * catch (Exception e)
     * {
     * e.printStackTrace();
     * }
     * }
     * }
     */
}
