package com.kostya.datepicker;

import com.kostya.WaitElement;

import org.openqa.selenium.By;

public class DatePickerElement {
    public boolean isDisplayed() {
        return WaitElement.isNotDisplayed(By.xpath("//div[@id='ui-datepicker-div'][contains(@style, 'display: block')]"));
    }

    public void selectYear(String param) {

    }

    public void selectMonth(String param) {

    }

    public void selectDay(String param) {

    }
}
