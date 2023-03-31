package com.epam.javacourse.factory;

public class Firefox extends Browser{
    @Override
    public void configure() {
        System.out.println("Firefox is ready");
    }
}
