package com.kostya;

import java.util.concurrent.TimeUnit;

public class WaitTime {
    public static void seconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public static void seconds(String seconds) {
        try {
            TimeUnit.SECONDS.sleep(Integer.parseInt(seconds));
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
