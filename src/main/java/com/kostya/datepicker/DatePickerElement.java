package com.kostya.datepicker;

import com.kostya.WaitElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Such class encapsulates single, small (maybe repeatable) element that is not actually that simple as button or link
 * but usually a composition of few simple elements
 * with its root locator and all relative elements' locators stored here.
 */
public class DatePickerElement {
    private WebDriver driver;

    public DatePickerElement(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayed() {
        return WaitElement.isNotDisplayed(driver, By.xpath("//div[@id='ui-datepicker-div'][contains(@style, 'display: block')]"));
    }

    public void selectYear(String param) {

    }

    public void selectMonth(String param) {

    }

    public void selectDay(String param) {

    }
}
