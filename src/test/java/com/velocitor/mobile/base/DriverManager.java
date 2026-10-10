package com.velocitor.mobile.base;

import com.velocitor.mobile.utils.Config;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;
import java.time.Duration;

public final class DriverManager {

    private static final ThreadLocal<AndroidDriver> DRIVER = new ThreadLocal<>();

    public static void start() {

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(Config.get("platformName"))
                .setAutomationName(Config.get("automationName"))
                .setDeviceName(Config.get("deviceName"))
                .setUdid(Config.get("udid"))
                .setNewCommandTimeout(
                        Duration.ofSeconds(
                                Long.parseLong(Config.get("newCommandTimeout"))
                        )
                );

        String version = Config.get("platformVersion");

        if (version != null && !version.isBlank()) {
            options.setPlatformVersion(version);
        }

        String app = System.getProperty(
                "appPath",
                Config.get("appPath")
        );

        options.setApp(app);

        try {
            DRIVER.set(
                    new AndroidDriver(
                            new URL(Config.appiumServer()),
                            options
                    )
            );
        } catch (Exception e) {
            throw new RuntimeException(
                    "Unable to start Appium driver",
                    e
            );
        }
    }

    public static AndroidDriver get() {
        return DRIVER.get();
    }

    public static void stop() {
        if (get() != null) {
            get().quit();
            DRIVER.remove();
        }
    }
}