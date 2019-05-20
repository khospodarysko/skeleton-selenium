package com.kostya.datepicker;

import com.kostya.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebDriver;

public class DatePickerPage {
    private DatePickerElement datePicker;

    /*
     * The main reason to pass WebDriver instance into page object is the
     * ability to create the same page with different driver.
     */
    public DatePickerPage(WebDriver driver) {
        datePicker = new DatePickerElement(driver);
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

    /*
     * Custom AssertJ assertion specific only to this page.
     */
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
