package com.epam.javacourse.factory;

public class Chrome extends Browser {
    @Override
    public void configure() {
        System.out.println("Chrome is ready to be used");
    }
}
