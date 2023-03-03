package com.example.graphics2dwidgetdemo;

import android.graphics.Canvas;

public class Circle extends ClosedShapeWithCenter{
    private int radius;

    public Circle(int lineWidth, int lineColor, int fillColor, int centerX, int centerY, int radius) {
        super(lineWidth, lineColor, fillColor, centerX, centerY);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" + super.toString() +
                "radius=" + radius +
                '}';
    }

    public void draw(Canvas canvas){
        canvas.drawCircle(centerX, centerY, radius, fillPaint);
        canvas.drawCircle(centerX, centerY, radius, strokePaint);
    }
}
