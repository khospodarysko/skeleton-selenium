package com.kostya;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static ThreadLocal<WebDriver> holder1 = new ThreadLocal<>();

    public static WebDriver driver1() {
        return holder1.get();
    }

    public static WebDriver init1() {
        holder1.set(WebDriverFactory.get());
        return holder1.get();
    }

    public static void quit1() {
        driver1().quit();
        holder1.set(null);
    }
}
