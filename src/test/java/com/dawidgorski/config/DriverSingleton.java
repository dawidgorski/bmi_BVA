package com.dawidgorski.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;


public final class DriverSingleton {

    private static WebDriver instance;

    private DriverSingleton() {
    }

    public static WebDriver getInstance() {
        if (instance == null) {
            instance = WebDriverManager.firefoxdriver().create();
        }
        return instance;
    }
}
