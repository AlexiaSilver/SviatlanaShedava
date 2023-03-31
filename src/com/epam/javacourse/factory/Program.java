package com.epam.javacourse.factory;

public class Program {
    public static void main(String[] args) {
        Browser browser = new BrowserFactory().create("chrome");

        browser.configure();

        Browser browserReopen = new BrowserFactory().create("firefox");

        browserReopen.configure();
    }
}
