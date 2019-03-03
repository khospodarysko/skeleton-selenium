package com.kostya;

import com.kostya.datepicker.DatePickerPage;

import org.assertj.core.api.Assertions;

public class Asserts extends Assertions {
    public static DatePickerPage.DatePickerPageAssert assertThat(DatePickerPage actual) {
        return new DatePickerPage.DatePickerPageAssert(actual);
    }
}
