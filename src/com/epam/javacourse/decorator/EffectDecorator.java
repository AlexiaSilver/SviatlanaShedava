package com.epam.javacourse.decorator;

public abstract class EffectDecorator implements Drawable {

    protected Drawable figure;

    public EffectDecorator(Drawable figure) {
        this.figure = figure;
    }

    @Override
    public void draw() {
        figure.draw();
    }
}
