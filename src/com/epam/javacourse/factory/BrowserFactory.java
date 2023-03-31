package com.epam.javacourse.factory;

public class BrowserFactory {

    public Browser create(String browserName) {
        switch (browserName) {
            case "chrome": return new Chrome();
            case "firefox": return new Firefox();
            default: {
                System.err.println("The browser i not supported");
                return null;
            }
        }
    }
}
