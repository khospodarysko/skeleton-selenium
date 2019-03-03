package com.kostya;

import org.testng.annotations.Test;

import static com.kostya.Asserts.assertThat;

public class DatePickerTest extends BaseTest {
    @Test
    public void test3() {
        Driver.driver1().get("https://khospodarysko.github.io/training-selenium/11.%20datepicker.html");
        // assertThat(pageDatePicker).isCalendarDisplayed();

        pageDatePicker.openCalendar();
        assertThat(pageDatePicker).isCalendarDisplayed();

        pageDatePicker.selectDate("2019", "Match", "9");
    }
}
