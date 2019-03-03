package com.kostya;

import com.kostya.datepicker.DatePickerPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    // -------------------- Pages

    public DatePickerPage pageDatePicker;

    // -------------------- Logs

    /**
     * This is only for logback logging - sifting appender. As TestNG's method invocations is in ascending name
     * order, keep this method name the first by prefixing it with "aaa".
     */
    @BeforeClass(alwaysRun = true)
    public final void beforeClass() {
        MDC.put("class-name", timestamp() + "-" + getClass().getCanonicalName());
        LOG.info("aaaBeforeClass");

        initDriver();
        initPages();
    }

    // And this is the last
    @AfterClass(alwaysRun = true)
    public final void afterClass() {
        LOG.info("zzzAfterClass");

        quitDrivers();

        MDC.remove("class-name");
    }

    private String timestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS"));
    }

    // -------------------- Tests

    private void initDriver() {
        LOG.info("initDriver");
        Driver.init1();
    }

    private void initPages() {
        LOG.info("initPages");
        pageDatePicker = new DatePickerPage();
    }

    private void quitDrivers() {
        LOG.info("quitDrivers");
        Driver.quit1();
    }

}
