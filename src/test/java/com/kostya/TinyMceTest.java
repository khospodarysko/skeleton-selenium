package com.kostya;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TinyMceTest extends BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(TinyMceTest.class);

    @Test
    public void test1() {
        String seconds = RandomStringUtils.randomNumeric(1);
        LOG.info("test 1 - wait {}", seconds);
        WaitTime.seconds(seconds);
    }

    @Test
    public void test2() {
        String seconds = RandomStringUtils.randomNumeric(1);
        LOG.info("test 2 - wait {}", seconds);
        WaitTime.seconds(seconds);
    }

    @Test
    public void test3() {
        String seconds = RandomStringUtils.randomNumeric(1);
        LOG.info("test 3 - wait {}", seconds);
        WaitTime.seconds(seconds);
    }
}
