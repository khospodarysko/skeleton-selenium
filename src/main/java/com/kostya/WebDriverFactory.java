package com.kostya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {
    private static final Logger LOG = LoggerFactory.getLogger(WebDriverFactory.class);

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static WebDriver get() {
        WebDriver driver;

        if (System.getProperty("browser") == null) {
            LOG.warn("USING DEFAULT BROWSER");
        }

        String browser = System.getProperty("browser", "chrome");

        switch (browser) {
            case "chrome":
                driver = getChrome();
                break;
            case "chrome-remote":
                DesiredCapabilities cap = DesiredCapabilities.chrome();

                try {
                    driver = new RemoteWebDriver(new URL("http://192.168.1.38:4444/wd/hub"), cap);
                } catch (MalformedURLException e) {
                    throw new RuntimeException("Could not start browser at ");
                }
                break;
            case "firefox":
                driver = getFirefox();
                break;
            default:
                throw new UnsupportedOperationException(String.format("Browser %s is not supported", browser));
        }

        driver.manage().window().maximize();
        LOG.info("Browser window size: WxH: {} x {}",
                driver.manage().window().getSize().getWidth(),
                driver.manage().window().getSize().getHeight()
        );

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        WebDriverEventListener eventListener = new WebDriverEventListener();
        eventDriver.register(eventListener);

        return eventDriver;
    }

    public static WebDriver getChrome() {
        if (isLinux()) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-linux64-2.29");
        }
        if (isMac()) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-mac-73");
        }
        // System.setProperty("webdriver.chrome.args", "--disable-logging");
        // System.setProperty("webdriver.chrome.silentOutput", "true");
        return new ChromeDriver();
    }

    public static WebDriver getFirefox() {
        throw new UnsupportedOperationException();
    }

    public static boolean isWindows() {
        return OS.contains("win");
    }

    public static boolean isMac() {
        return OS.contains("mac");
    }

    public static boolean isLinux() {
        return OS.contains("nux");
    }
}
