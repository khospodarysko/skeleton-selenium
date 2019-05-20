package com.kostya;

import com.kostya.datepicker.DatePickerPage;
import org.testng.annotations.Test;

import static com.kostya.Asserts.assertThat;

public class DatePickerTest extends BaseTest {
    @Test
    public void test1() {
        Driver.driver1().get("https://khospodarysko.github.io/training-selenium/11.%20datepicker.html");
        // assertThat(pageDatePicker).isCalendarDisplayed();

        datePickerPage.openCalendar();
        assertThat(datePickerPage).isCalendarDisplayed();

        datePickerPage.selectDate("2019", "Match", "9");
    }

    @Test
    public void test2() {
        Driver.driver1().get("https://khospodarysko.github.io/training-selenium/11.%20datepicker.html");

        DatePickerPage datePickerPage = new DatePickerPage(Driver.driver1());

        datePickerPage.openCalendar();
        assertThat(datePickerPage).isCalendarDisplayed();

        datePickerPage.selectDate("2019", "Match", "9");
    }
}
