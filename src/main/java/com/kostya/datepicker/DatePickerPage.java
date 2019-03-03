package com.kostya.datepicker;

import com.kostya.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.assertj.core.api.AbstractAssert;

public class DatePickerPage {
    private DatePickerElement datePicker;

    public DatePickerPage() {
        datePicker = new DatePickerElement();
    }

    public void openCalendar() {
        if (!datePicker.isDisplayed()) {
            Driver.driver1().findElement(By.id("datepicker")).click();
        }
    }

    public void closeCalendar() {
        if (datePicker.isDisplayed()) {
            Driver.driver1().findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
        }
    }

    /**
     * @param year  as 2019
     * @param month as March
     * @param day   as 3
     */
    // TODO all fields are enums (month and day definitely could be), year - how many years are needed for tests?
    public void selectDate(String year, String month, String day) {
        datePicker.selectYear(year);
        datePicker.selectMonth(month);
        datePicker.selectDay(day);
    }

    public static class DatePickerPageAssert extends AbstractAssert<DatePickerPageAssert, DatePickerPage> {

        public DatePickerPageAssert(DatePickerPage actual) {
            super(actual, DatePickerPageAssert.class);
        }

        public DatePickerPageAssert isCalendarDisplayed() {
            isNotNull();

            if (!actual.datePicker.isDisplayed()) {
                failWithMessage("Expected calendar to be displayed but it was not");
            }

            return this;
        }
    }
}
